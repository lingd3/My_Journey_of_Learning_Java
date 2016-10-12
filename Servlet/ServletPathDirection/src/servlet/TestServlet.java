package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */

public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//请求重定向方式跳转到test.jsp，当前路径是ServletPathDirection/servlet/
		//response.sendRedirect("test.jsp");
		//使用request.getContextPath获得上下文对象
		//response.sendRedirect(request.getContextPath()+"/test.jsp");
		
		//使用服务器内部跳转，这里的斜线表示项目的根目录
		//request.getRequestDispatcher("/test.jsp").forward(request, response);
		request.getRequestDispatcher("../test.jsp").forward(request, response);
	}

}
