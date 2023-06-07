package ch08;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

@WebServlet("/rcontrol")
public class RegistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RegistDAO dao;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = new RegistDAO();
	}

	public RegistController() {
		super();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		String view = "";

		if (action == null) {
			getServletContext().getRequestDispatcher("/rcontrol?action=list").forward(request, response);
		} else {

			switch (action) {
			case "list":
				view = list(request, response);
				break;
			case "info":
				view = info(request, response);
				break;
			case "insert":
				view = insert(request, response);
				break;
			}
			getServletContext().getRequestDispatcher("/ch08/" + view).forward(request, response);
		}
	}

	private String list(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("regists", dao.findAll());
		return "registList.jsp";
	}

	private String info(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("r", dao.find(request.getParameter("id")));
		return "registInfo.jsp";
	}
	
	private String insert(HttpServletRequest request, HttpServletResponse response) {
		Regist r = new Regist();
		
		try {
			BeanUtils.populate(r, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		dao.insert(r);
		return "registList.jsp";
	}
}
