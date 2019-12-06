package servlet;


import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ChkLogin;
import user.*;

public class LoginServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public LoginServlet() {
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		response.setContentType("text/html; charset=utf-8");
//		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();



		  String utype=request.getParameter("utype");
		  String logname = request.getParameter("logname");
		  String passwd = request.getParameter("passwd");
		  session.setAttribute("logname", logname);
		 	ChkLogin ckl = new ChkLogin();
		 	
		 	int flag =ckl.Login(logname, passwd,utype);
		 	request.setAttribute("flag", flag);

			if( flag==1 ){
				User user=new User();
				user = ckl.getUser(logname,utype);
//				System.out.print(user.getLogname());
				session.setAttribute("user", user);
//				System.out.println(user.getUtype()+""+user.getUtype().length());
				getServletContext().getRequestDispatcher("/personal.jsp").forward(request, response);
		 	 }
		 	else{
		 		getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		 	}
		
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
