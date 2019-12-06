<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="pageutil.*"%>
<%@ page import="user.*"%>
<%@ page import="bean.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="style1.css">

  </head>
  
  <body>
  <header class="navbar-wrapper">
	<div class="navbar navbar-black">
		<div class="container cl">
			<a class="logo navbar-logo f-l mr-10 hidden-xs" href="index.jsp">书店</a>
			<nav class="nav navbar-nav nav-collapse" role="navigation" id="Hui-navbar">
				<ul class="cl">
					<li class="current"><a href="">首页</a></li>
					<li><a href="showorders.jsp">购物车</a></li>
					<li><a href="personal.jsp">个人中心</a></li>
                    <c:if test="${sessionScope.user == null }">
      					<li><a href="login.jsp">登录</a></li>
                    	<li><a href="register.jsp">注册</a></li>
                    </c:if>
                    <c:if test="${sessionScope.user != null }">
                    	<c:if test="${sessionScope.user.utype=='2' }">
                    		<li><a href="showallbook.jsp">管理所有书籍</a></li>
                        </c:if>
                    </c:if>
				</ul>
			</nav>
		</div>
	</div>
  </header>

    <br/><div >
		<form action="SearchbookServlet" method="post">
    		<input type="text" name="words" maxlength=10 /><input type="submit" name="搜索" value="搜索" />
		</form>
    </div>
    
    
    
    <div>
    <% 
    	Show show=new Show();
    	
    	int pageCount = 10;//显示每页记录数
    	
       	int totalCount=show.getCount();//页数获取总
       	
       	
       	int currentPage=1;//当前页
       	
       	String p=null;//
       	
       	if((p=request.getParameter("ppage"))!=null){
       	 	currentPage = Integer.parseInt(p);
       	}
       	
       	Page ppage = PageUtil.createPage(pageCount, totalCount, currentPage);
       	
       	ArrayList<Book> Blist=show.getBook(currentPage,pageCount);
       	
       	request.setAttribute("ppage",ppage);
       	session.setAttribute("Blist",Blist);
       	
         %>
         
       <table width="500" border="0">  
       <c:forEach items="${sessionScope.Blist}" var="book">
       	<tr>
       		<th scope="row">${book.bname }</th>
  	   		<td><a href='showintro.jsp?id=${book.id}'>查看详情</a></td>
  	   	</tr>
       </c:forEach>
  	   </table>
   
  
       <br>
  
       <a href="index.jsp?ppage=${requestScope.ppage.currentPage-1 }">上一页</a>
       <c:forEach begin="1" end="${requestScope.ppage.totalPage }"  var="p">
  	   <a href="index.jsp?ppage=${p }">${p }</a> 
       </c:forEach>
       <a href="index.jsp?ppage=${requestScope.ppage.currentPage+1 }">下一页</a>

    </div>
    
    <footer class="footer mt-20">
	<div class="container-fluid">
		<nav> <a href="#" target="_blank">关于我们</a> <span class="pipe">|</span> <a href="#" target="_blank">联系我们</a> <span class="pipe">|</span> <a href="#" target="_blank">法律声明</a> </nav>
		<p>Copyright &copy;2018 BookStore.LICHAOWEI <br>
			<a href="#" target="_blank" rel="nofollow">京ICP备0000000号</a><br>
		</p>
	</div>
	</footer>
  </body>
  
  <script type="text/javascript" src="../lib/jquery.min.js"></script> 
	<script type="text/javascript" src="../js/H-ui.js"></script> 
</html>
