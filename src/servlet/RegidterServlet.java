package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.*;

public class RegidterServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public RegidterServlet() {
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

		  
		  String logname = request.getParameter("logname");//1
		  String passwd1 = request.getParameter("passwd1");//2
		  String passwd2 =request.getParameter("passwd2");
		  String realname = request.getParameter("realname");//3
		  String email = request.getParameter("email");//4
		  String gender = request.getParameter("gender");//5
		  String uaddress = request.getParameter("uaddress");//6
		  String phone = request.getParameter("phone");//7
		  String problem= request.getParameter("problem");//8
		  String answer = request.getParameter("answer");//9
		  String province = request.getParameter("province");//10
		  String education = request.getParameter("education");//11
		  String hobbies = request.getParameter("hobbies");//12
		  String selfintro = request.getParameter("selfintro");//13
		  String utype = request.getParameter("utype");//14
		  
		  String passwd=null;
		  if(!passwd1.equals(passwd2)){
			  int pas=1;
			  request.setAttribute("pas", pas);
			  request.setAttribute("logname",logname);
			  request.setAttribute("realname",realname);
			  request.setAttribute("passwd1",passwd1);
			  request.setAttribute("email",email);
			  request.setAttribute("uaddress",uaddress);
			  request.setAttribute("phone",phone);
			  request.setAttribute("problem",problem);
			  request.setAttribute("answer",answer);
			  request.setAttribute("province",province);
			  request.setAttribute("education",education);
			  request.setAttribute("hobbies",hobbies);
			  request.setAttribute("selfintro",selfintro);
			  getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
		  }
		  else passwd=passwd1;

		  String[] info={logname, realname, passwd,email,gender,uaddress,phone,problem,answer,province,education,hobbies,selfintro,utype};
		  int flag=0;

		  for(int i=0;i<9;i++){
			  if(info[i]==null) flag=1;
		  }
		  if(info[13]==null)flag=1;
		  request.setAttribute("flag", flag);
		  if(flag==1){
			  request.setAttribute("logname",logname);
			  request.setAttribute("realname",realname);
			  request.setAttribute("passwd1",passwd1);
			  request.setAttribute("email",email);
			  request.setAttribute("uaddress",uaddress);
			  request.setAttribute("phone",phone);
			  request.setAttribute("problem",problem);
			  request.setAttribute("answer",answer);
			  request.setAttribute("province",province);
			  request.setAttribute("education",education);
			  request.setAttribute("hobbies",hobbies);
			  request.setAttribute("selfintro",selfintro);
			  getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);;
		  }
		  if(flag==0){
			  Chkregister chkr = new Chkregister();

			  if( chkr.Register(info)==1 ){
				  response.sendRedirect("reg_success.jsp");
			  }
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
