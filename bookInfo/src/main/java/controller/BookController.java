package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import DAO.BookDAO;
import DTO.Book;

@WebServlet("/")
@MultipartConfig(maxFileSize = 1024 * 1024 * 2, location = "c:/Temp/img")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDAO dao; // model
	private ServletContext ctx; // 페이지 이동, forward를 위해 사용

	public BookController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = new BookDAO();
		ctx = getServletContext();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 한글깨짐 방지
		String command = request.getServletPath(); // 경로 가져오기
		String site = null;

		switch (command) {
		case "/list":
			site = getList(request);
			break;
		case "/comicList":
			site = getComicList(request);
			break;
		case "/novelList":
			site = getNovelList(request);
			break;
		case "/etcList":
			site = getEtcList(request);
			break;
		case "/write":
			site = "write.jsp";
			break;
		case "/insert":
			site = insertBook(request);
			break;
		case "/view":
			site = getView(request);
			break;
		case "/edit":
			site = getViewForEdit(request);
			break;
		case "/update":
			site = updateBook(request);
			break;
		case "/delete":
			site = deleteBook(request);
			break;
		}

		if (site.startsWith("redirect:/")) { // redirect
			String rview = site.substring("redirect:/".length());
			response.sendRedirect(rview); // 페이지 이동
		} else { // forward
			ctx.getRequestDispatcher("/" + site).forward(request, response);
		}
	}

	public String getList(HttpServletRequest request) {
		ArrayList<Book> list;
		String listCategory = request.getParameter("listCategory");

		try {
			if (listCategory != null) {
				if (listCategory.equals("comic")) {
					list = dao.getComicList();
				} else if (listCategory.equals("novel")) {
					list = dao.getNovelList();
				} else if (listCategory.equals("etc")) {
					list = dao.getEtcList();
				} else {
					list = dao.getList();
				}
			} else {
				list = dao.getList();
			}
			request.setAttribute("bookList", list);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("도서 목록 생성 과정에서 문제 발생");
			request.setAttribute("error", "도서 목록 생성 과정에서 문제가 발생했습니다.");
		}

		return "index.jsp";
	}

	public String getComicList(HttpServletRequest request) {
		ArrayList<Book> list;

		try {
			list = dao.getComicList();
			request.setAttribute("bookList", list);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("도서 목록 생성 과정에서 문제 발생");
			request.setAttribute("error", "도서 목록 생성 과정에서 문제가 발생했습니다.");
		}

		return "index.jsp";
	}

	public String getNovelList(HttpServletRequest request) {
		ArrayList<Book> list;

		try {
			list = dao.getNovelList();
			request.setAttribute("bookList", list);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("도서 목록 생성 과정에서 문제 발생");
			request.setAttribute("error", "도서 목록 생성 과정에서 문제가 발생했습니다.");
		}

		return "index.jsp";
	}

	public String getEtcList(HttpServletRequest request) {
		ArrayList<Book> list;

		try {
			list = dao.getEtcList();
			request.setAttribute("bookList", list);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("도서 목록 생성 과정에서 문제 발생");
			request.setAttribute("error", "도서 목록 생성 과정에서 문제가 발생했습니다.");
		}

		return "index.jsp";
	}

	public String getView(HttpServletRequest request) {
		int book_no = Integer.parseInt(request.getParameter("book_no"));

		try {
			Book b = dao.getView(book_no);

			request.setAttribute("book", b);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("도서 상세정보를 가져오는 과정에서 문제 발생");
			request.setAttribute("error", "도서 상세정보를 정상적으로 가져오지 못했습니다.");
		}

		return "view.jsp";
	}

	public String insertBook(HttpServletRequest request) {
		Book b = new Book();

		try {
			BeanUtils.populate(b, request.getParameterMap());

			Part part = request.getPart("file");
			String fileName = getFilename(part);

			if (fileName != null && !fileName.isEmpty()) {
				part.write(fileName);
				b.setImg("/img/" + fileName);
			}

			dao.insertBook(b);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("도서 정보 등록 과정에서 문제 발생");

			try {
				String encodeName = URLEncoder.encode("도서 정보가 정상적으로 등록되지 않았습니다.", "UTF-8");
				return "redirect:/list?error=" + encodeName;
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}

		return "redirect:/list";
	}

	public String getViewForEdit(HttpServletRequest request) {
		int book_no = Integer.parseInt(request.getParameter("book_no"));

		try {
			Book b = dao.getView(book_no);
			request.setAttribute("book", b);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("도서 상세정보를 가져오는 과정에서 문제 발생");
			request.setAttribute("error", "도서 상세정보를 정상적으로 가져오지 못했습니다.");
		}

		return "edit.jsp";
	}

	public String updateBook(HttpServletRequest request) {
		Book b = new Book();

		try {
			BeanUtils.populate(b, request.getParameterMap());

			Part part = request.getPart("file");
			String fileName = getFilename(part);

			if (fileName != null && !fileName.isEmpty()) {
				part.write(fileName);
				b.setImg("/img/" + fileName);
			}

			dao.updateBook(b);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("도서 정보 수정 과정에서 문제 발생");

			try {
				String encodeName = URLEncoder.encode("도서 정보가 정상적으로 수정되지 않았습니다.", "UTF-8");
				return "redirect:/view?book_no=" + b.getBook_no() + "&error=" + encodeName;
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}

		return "redirect:/view?book_no=" + b.getBook_no();
	}

	public String deleteBook(HttpServletRequest request) {
		int book_no = Integer.parseInt(request.getParameter("book_no"));

		try {
			dao.deleteBook(book_no);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("도서 정보 삭제 과정에서 문제 발생");

			try {
				String encodeName = URLEncoder.encode("도서 정보가 정상적으로 삭제되지 않았습니다.", "UTF-8");
				return "redirect:/list?error=" + encodeName;
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}

		return "redirect:/list";
	}

	// 파일 이름 추출
	private String getFilename(Part part) {
		String fileName = null;
		String header = part.getHeader("content-disposition");

		int start = header.indexOf("filename=");
		fileName = header.substring(start + 10, header.length() - 1);

		return fileName;
	}
}
