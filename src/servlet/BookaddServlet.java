package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.*;
import user.Book;

public class BookaddServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public BookaddServlet() {
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

//		response.setContentType("text/html; charset=utf-8");
//		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session=request.getSession();
		String value=request.getParameter("submition");
		if(value.equals("上架")){
//		String id=request.getParameter("id");
		String bname=request.getParameter("bname");
		String btype=request.getParameter("btype");
		String autho=request.getParameter("autho");
		String press=request.getParameter("press");
		String Sprice=request.getParameter("Sprice");
		String Srepertory=request.getParameter("Srepertory");
		String intro=request.getParameter("intro");
		
//		System.out.println("Sprice is "+Sprice);
//        System.out.println("bname is "+bname);
//        System.out.println("Srepertory is"+Srepertory);        System.out.println("id is "+id);
//        System.out.println("btype is "+btype);
        
		Date times = new Date(System.currentTimeMillis());
		BookOp bop=new BookOp();
		int flag=0;
		if(bname==null||btype==null||autho==null||press==null||Sprice==null||Srepertory==null||intro==null){ 
			flag=3;
//			request.setAttribute("flag", flag);
//			request.setAttribute("bname",bname);
//			request.setAttribute("btype",btype);
//			request.setAttribute("autho",autho);
//			request.setAttribute("press",press);
//			request.setAttribute("Sprice", Sprice);
//			request.setAttribute("Srepertory",Srepertory);
//			request.setAttribute("intro",intro);
			getServletContext().getRequestDispatcher("/updatebook.jsp").forward(request, response);
			
		}

		
		
		
		flag=bop.bookAdd( bname, btype, autho, press, Sprice, Srepertory, intro, times);
		if(flag==1){//添加成功
			response.sendRedirect("addsuccess.jsp");
			}
		else if(flag==2){//id已存在
//			request.setAttribute("id",id);
			request.setAttribute("bname",bname);
			request.setAttribute("btype",btype);
			request.setAttribute("autho",autho);
			request.setAttribute("press",press);
			request.setAttribute("Sprice",Sprice);
			request.setAttribute("Srepertory",Srepertory);
			request.setAttribute("intro",intro);
			request.setAttribute("flag", flag);
			getServletContext().getRequestDispatcher("/bookadd.jsp").forward(request, response);
		}
		else{//添加失败
			
		}
		}
		else if(value.equals("删除书本")){
			String id=request.getParameter("id");
			BookOp bop=new BookOp();
			int falg=bop.deleteBook(id);
			if (falg==1){
				getServletContext().getRequestDispatcher("/showallbook.jsp").forward(request, response);
				}
			
		}
		else if(value.equals("提交修改")){
			Book book=new Book();
			
			String bname=request.getParameter("bname");
			String btype=request.getParameter("btype");
			String autho=request.getParameter("autho");
			String press=request.getParameter("press");
			String Sprice=request.getParameter("Sprice");
			String Srepertory=request.getParameter("Srepertory");
			String intro=request.getParameter("intro");
			
			book=(Book)session.getAttribute("book");
//			System.out.println("Sprice is "+Sprice);
//	        System.out.println("bname is "+bname);
//	        System.out.println("Srepertory is"+Srepertory);        System.out.println("id is "+id);
//	        System.out.println("btype is "+btype);
	        
			BookOp bop=new BookOp();
			Book book2=new Book();
			
			book2=bop.updateBook( book, bname, btype, autho, press, Sprice, Srepertory, intro);
			if(book2!=null){//添加成功
				session.setAttribute("book", book2);
				response.sendRedirect("addsuccess.jsp");
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
