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
    
    <title>My JSP 'showintro.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="style1.css">

  </head>
  
  <body>
    <% 
    	String id=request.getParameter("id");
    	
    	BookOp bop=new BookOp();
    	Book book=new Book();
    	if(id!=null)
    	book=bop.getBook(id);
    	else {
    		String Oid=request.getParameter("Oid");
    		String bname=new OrdersOp().getBname(Oid);
    	 	book=bop.searchBook2(bname);
    	 }
    	session.setAttribute("book",book);
    	
     %>
     <header class="navbar-wrapper">
	<div class="navbar navbar-black">
		<div class="container cl">
			<a class="logo navbar-logo f-l mr-10 hidden-xs" href="index.jsp">书店</a>
			<nav class="nav navbar-nav nav-collapse" role="navigation" id="Hui-navbar">
				<ul class="cl">
					<li class="current"><a href="index.jsp">首页</a></li>
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
   		 <form action="SearchbookServlet" method="post">
    	<input type="text" name="words" maxlength=10 /><input type="submit" name="搜索" value="搜索" />
    	</form>
     <p>书名：${book.bname }
     <p>类型：${book.btype }
     <p>作者：${book.autho }
     <p>出版商：${book.press }
     <p>价格：${book.price }
     <p>库存：${book.repertory }
     <p>上架时间：${book.times }
     <p>简介：${book.intro}
     <c:if test="${sessionScope.user!=null }">             
     	<form action="AddtoshopServlet" method="post">
     		请选择数目<input type="text" value="1" name="Scount">
     		<input type="submit" name="submition" value="加入购物车">
     			<c:if test="${sessionScope.user.utype=='2' }">
     				<input type="button" onclick="window.location.href='updatebook.jsp?book=${book}'" value="修改书籍信息">
     			</c:if>
    	 </form>
     </c:if>
    <footer class="footer mt-20">
	<div class="container-fluid">
		<nav> <a href="#" target="_blank">关于我们</a> <span class="pipe">|</span> <a href="#" target="_blank">联系我们</a> <span class="pipe">|</span> <a href="#" target="_blank">法律声明</a> </nav>
		<p>Copyright &copy;2018 BookStore.LICHAOWEI <br>
			<a href="#" target="_blank" rel="nofollow">京ICP备0000000号</a><br>
		</p>
	</div>
	</footer>
  </body>
  
  <script language="javascript">
  </script>
</html>
