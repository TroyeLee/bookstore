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

public class BuyServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public BuyServlet() {
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

		doPost(request,response);
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		HttpSession session=request.getSession();
		
//		String flag=(String)session.getAttribute("flag");
		String flag=request.getParameter("flag");
//		System.out.println("here is running 0 flag is "+flag);
		String t=request.getParameter("t");
		if(flag.equals("0")){
//			out.println("asdfasdf");
			out.println("<form action='BuyServlet?flag=1' method='post'>");
			out.println("请输入密码：<input type='password' name='spasswd'>");
			if(t!=null){out.println("密码错误");}
			out.print("<br/><input type='submit' value=' 确认 '> ");
			out.println("<input type='button' name='取消' value='取消' onclick='window.location.href('showorders.jsp')'>");
//			out.println("<% String flag=(String)session.get %>");
			out.println("</form>");
			
		}
		
		if(flag.equals("1")){

			System.out.println("here is running ? flag is "+flag);
			User user=new User();
			Book book=new Book();
	    
			user=(User)session.getAttribute("user");
			book=(Book)session.getAttribute("book");
			
			String Oid=(String)session.getAttribute("Oid");
			
			System.out.println("here is running 1 lognames is "+user.getLogname()+" bname is "+book.getBname());
			if(!request.getParameter("spasswd").equals(user.getPasswd())){
//				flag="0";
//				session.setAttribute("flag", flag);
				getServletContext().getRequestDispatcher("/BuyServlet?flag=0&t=0").forward(request, response);
	    	
			}
			else{
				int count=(int)session.getAttribute("count");
				OrdersOp oop=new OrdersOp();
				BookOp bop=new BookOp();
				int f=oop.deleteOrders(Oid);
				int l=bop.reduceRepertory(book,count);
//				System.out.println("here is runnin 2 f is "+f+" l is "+l);
				if (f==0||l==0){
					out.println("404，购买失败");
				}
				if (f==1&&l==1){
					out.println("<h3><a href=\"login.jsp\">首页</a></h3>");
					out.println("<a href=\"personal.jsp\">个人中心</a><br/>");
					out.println("购买成功，<a href=\"showorders.jsp\">返回购物车</a>");
	    	
				}

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
