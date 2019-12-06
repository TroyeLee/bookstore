package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.*;
import user.*;

public class AddtoshopServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public AddtoshopServlet() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		response.setContentType("text/html; utf-8");
		PrintWriter out = response.getWriter();
//		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		String value=request.getParameter("submition");
		System.out.println("here value is "+value);
		if(value.equals("加入购物车")){
			User user=new User();
			Book book=new Book();
			user=(User)session.getAttribute("user");
			book=(Book)session.getAttribute("book");
			String logname=user.getLogname();
			String bname=book.getBname();
			String Scount=request.getParameter("Scount");
			int count=Integer.parseInt(Scount);
			OrdersOp oop=new OrdersOp();
			int flag=oop.addOrders(logname,bname,count);
			if(flag==1){out.println("加入购物车成功！<a href="+"showorders.jsp"+">查看购物车");}
		}
		if(value.equals("修改书籍信息")){
			getServletContext().getRequestDispatcher("/updatebook.jsp").forward(request, response);
		}
		if(value.equals("删除订单")){
			out.println("here is running 0");
			OrdersOp oop =new OrdersOp();
			String Oid=request.getParameter("Oid");
			int flag=oop.deleteOrders(Oid);
			System.out.println("here is running 1 flag is"+flag);
			if(flag==1){
				response.sendRedirect("showorders.jsp");
			}
			if(flag==-1){
				out.println("删除失败");
			}
		}
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

}
