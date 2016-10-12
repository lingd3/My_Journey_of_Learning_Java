package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet2 extends HttpServlet {

	public TestServlet2() {
		System.out.println("TestServlet2构造方法被执行...");
	}
	
	public void destroy() {
		System.out.println("TestServlet2销毁方法被执行...");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TestServlet2的doGet()方法被执行...");
		response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.print("<h1>您好，我是TestServlet2</h1>");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TestServlet2的doPost()方法被执行...");
		doGet(request, response); //让daPost()执行与doGet()相同的操作
	}
	
	public void init() throws ServletException {
		System.out.println("TestServlet2的初始化方法被执行...");
	}

}
