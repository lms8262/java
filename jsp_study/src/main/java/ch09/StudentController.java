package ch09;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

@WebServlet("/studentControl")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentDAO dao;

	public StudentController() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// model 역할을 하는 클래스의 객체를 생성(딱 한번만 객체를 생성한다)
		dao = new StudentDAO();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // request 객체에 담겨있는 한글 깨짐 방지
		String action = request.getParameter("action");
		String view = "";

		if (action == null) {
			getServletContext().getRequestDispatcher("/studentControl?action=list").forward(request, response);
		} else {
			switch (action) {
			case "list":
				view = list(request, response);
				break;
			case "insert":
				view = insert(request, response);
				break;
			}
			getServletContext().getRequestDispatcher("/ch09/" + view).forward(request, response);
		}
	}

	public String list(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("students", dao.getAll());
		return "studentInfo.jsp";
	}
	
	public String insert(HttpServletRequest request, HttpServletResponse response) {
		// DAO에 있는 insert 메소드를 호출해야 한다.
		Student s = new Student();
		
		try {
			// 객체의 필드명 = parameter의 name이 같아야 한다.
			BeanUtils.populate(s, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		s.setUsername(request.getParameter("username"));
		s.setEmail(request.getParameter("email"));
		s.setUniv(request.getParameter("univ"));
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = (Date) formatter.parse((request.getParameter("birth")));
		s.setBirth(date);
		*/
		
		dao.insert(s);
		return "studentInfo.jsp";
	}

}
