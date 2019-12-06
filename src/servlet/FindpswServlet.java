package servlet;

import java.io.IOException;
import bean.*;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindpswServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public FindpswServlet() {
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
        
//		response.setContentType("text/html;charset=utf-8");
//		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		String value=(String) request.getParameter("submition");
//		System.out.println(value);

		
		FindOp find=new FindOp();
		if(value.equals("Ã·Ωª")){
			String logname=request.getParameter("logname");
			String utype=request.getParameter("utype");
			String problem=find.getProblem(logname,utype);
		
//			 System.out.println(problem);
			 
			request.setAttribute("problem", problem);
			getServletContext().getRequestDispatcher("/findpsw2.jsp").forward(request, response);
		}
		else if(value.equals("’“ªÿ")){
			String logname=(String)request.getParameter("logname");
			String problem=request.getParameter("problem");
			String utype=(String)request.getParameter("utype");
			String answer=request.getParameter("answer");
//			System.out.println("utype="+utype);
//			System.out.println("logname="+logname);
			System.out.println("problem is "+problem);
			int flag=find.chkAnswer(logname, utype, answer);
			request.setAttribute("flag", flag);
			if(flag==1){
//				System.out.println("f=1 here is go");
				getServletContext().getRequestDispatcher("/updatepsw.jsp").forward(request, response);
				}
			else if(flag==2){
				
				request.setAttribute("problem", problem);
//				System.out.println("f=2 here is go");
				getServletContext().getRequestDispatcher("/findpsw2.jsp").forward(request, response);
			}
//			System.out.println("f!=1&&2 here is go");
			
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
