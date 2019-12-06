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

public class updateServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public updateServlet() {
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
		 
//		response.setContentType("text/html;charset=utf-8");
//		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String value=(String) request.getParameter("submition");
		System.out.println("value is "+value);
		HttpSession session=request.getSession(); 

		if(value.equals("重置")){
			String logname=request.getParameter("logname");
			String utype=request.getParameter("utype");
			String newpsw1=request.getParameter("newpsw1");
			String newpsw2=request.getParameter("newpsw2");
			int same=0;
			if(newpsw1.equals(newpsw2)){
				UpdateOp update=new UpdateOp();
				same=update.resetPsw(logname, utype, newpsw1);
				if(same==1){response.sendRedirect("updatesuccess.jsp");}
				else{
					System.out.println("reset faild");
					}
				}
			else{
				request.setAttribute("same", same);
				getServletContext().getRequestDispatcher("/updatepsw.jsp").forward(request, response);
			}
			}
		else if(value.equals("修改信息")){
			System.out.println("修改信息  is running");
			User user=new User();
			user=(User)session.getAttribute("user");
			System.out.println("logname is"+user.getLogname());
			request.setAttribute("user",user);
			getServletContext().getRequestDispatcher("/update.jsp").forward(request, response);
		}
		else if(value.equals("提交修改")){
			User user=new User();
			user=(User)session.getAttribute("user");
			UpdateOp update=new UpdateOp();
			String logname=request.getParameter("logname");
			String realname=request.getParameter("realname");
			String email=request.getParameter("email");
			String gender=request.getParameter("gender");
			String uaddress=request.getParameter("uaddress");
			String phone=request.getParameter("phone");
			String problem=request.getParameter("problem");
			String answer=request.getParameter("answer");
			String province=request.getParameter("province");
			String education=request.getParameter("education");
			String hobbies=request.getParameter("hobbies");
			String selfintro=request.getParameter("selfintro");
			User user2=new User();
			user2.setLogname(logname);
			user2.setRealname(realname);
			user2.setEmail(email);
			user2.setPasswd(user.getPasswd());
			if(gender==null)
				user2.setGender(user.getGender());
			else
				user2.setGender(gender);
			user2.setUaddress(uaddress);
			user2.setPhone(phone);
			user2.setProblem(problem);
			if(answer==null)
				user2.setAnswer(user.getAnswer());
			else user2.setAnswer(answer);
			user2.setProvince(province);
			user2.setEducation(education);
			user2.setHobbies(hobbies);
			user2.setSelfintro(selfintro);
			user2.setUtype(user.getUtype());
			int flag=update.updateData(user,user2);
			if(flag==1){
				session.setAttribute("user", user2);
				out.print("修改成功");
				getServletContext().getRequestDispatcher("/personal.jsp").forward(request, response);
			}
		}
		else if (value.equals("退出登录")){
			out.println("退出成功");
			User user=new User();
			user=(User)session.getAttribute("user");
			user=null;
			session.setAttribute("user", user);
			response.sendRedirect("index.jsp");
		}

		else {System.out.println("error");}
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
