package ch05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/hello") // 경로
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HelloWorld() {
		super(); // HttpServlet 의 생성자가 실행이 된다.
	}

	// request 받을때 get 방식으로 주는 데이터를 받는다.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// req: request 정보(중요. 클라이언트로부터 받아온 정보가 있다)
				System.out.println(req.getRequestURI());
		// resp: response 정보(중요. 서버가 클라이언트에게 응답해주기 위해서 필요하다. => 응답 데이터가 존재)
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		out.append("<doctype html>"+""
				+ "<html>"
				+"<head>"
				+"<title>hello</title>"
				+"<head>"
				+"<body>")
		.append("<h2>hello!</h2><hr>")
		.append("현재 날짜와 시간은: " + java.time.LocalDateTime.now())
		.append("</body></html>");
	}

	// request 받을때 post 방식으로 주는 데이터를 받는다.
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		doGet(req, resp);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
	}
	
}
