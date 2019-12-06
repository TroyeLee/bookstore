<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page  import="user.*" %>
<%@ page  import="bean.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'bookadd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="style1.css">

  </head>
  
  <body>
  <c:if test="${sessionScope.user!=null}"> 
  <c:if test="${sessionScope.user.utype=='1'}">
  <%getServletContext().getRequestDispatcher("/404.jsp").forward(request, response); %>>
  </c:if>
  <c:if test="${sessionScope.user.utype=='2'}">
  <% 
  		BtypeOp btop=new BtypeOp();
  		Booktype booktypeL=new Booktype();
  		booktypeL=btop.getbtype();
  		session.setAttribute("booktypeL",booktypeL);
  		Book book=new Book();
  		String id=request.getParameter("id");
  		if(id==null)
  			book=(Book)session.getAttribute("book");
  		else book=new BookOp().getBook(id);
  		request.setAttribute("book",book);
   %>
<header class="navbar-wrapper">
	<div class="navbar navbar-black">
		<div class="container cl">
			<a class="logo navbar-logo f-l mr-10 hidden-xs" href="index.jsp">书店</a>
			<nav class="nav navbar-nav nav-collapse" role="navigation" id="Hui-navbar">
				<ul class="cl">
					<li><a href="index.jsp">首页</a></li>
					<li><a href="showorders.jsp">购物车</a></li>
					<li><a href="personal.jsp">个人中心</a></li>
                    <c:if test="${sessionScope.user == null }">
      					<li><a href="login.jsp">登录</a></li>
                    	<li><a href="register.jsp">注册</a></li>
                    </c:if>
                    <c:if test="${sessionScope.user != null }">
                    	<c:if test="${sessionScope.user.utype=='2' }">
                    		<li class="current"><a href="showallbook.jsp">管理所有书籍</a></li>
                        </c:if>
                    </c:if>
				</ul>
			</nav>
		</div>
	</div>
  </header>
    <form action="BookaddServlet" method="post">
    <table>
      <tr>
        <td>新书上架</td>
      </tr>
      <tr>
        <td>书籍名称</td><%--1 --%>
        <td><input type="text" name="bname" value="${book.bname }"> </td>
        <c:if test="${requestScope.falg==3 }"><td>书籍名不能为空</td></c:if>
      </tr>

      <tr>
        <td><p>书籍类型:</td><%--2 --%>
        <td> 
        <select name="btype">
        		<option value="${book.btype}">${book.btype }</option>
        		<c:forEach items="${sessionScope.booktypeL.booktype}" var="booktype">
  				<option value="${booktype }"  >${booktype }</option>
  				</c:forEach>
			</select>
			</td>
        	
        
      </tr>
      <tr>
        <td><p>作者</td><%--3 --%>
        <td><input type="text" name="autho" value="${book.autho }">
	    </td>
	    <c:if test="${requestScope.falg==3 }"><td>作者不能为空</td></c:if>
      </tr>
      <tr>
        <td>出版社</td><%--4 --%>
        <td><input type="text" name="press" value="${book.press }"></td>
	    <c:if test="${requestScope.falg==3 }"><td>出版社不能为空</td></c:if>
      </tr>
      <tr>
        <td>书籍单价</td><%--6 --%>
        <td><input type="text" name="Sprice" value="${book.price }"></td>
        <c:if test="${requestScope.falg==3 }"><td>书籍单价不能为空</td></c:if>
      </tr>
      <tr>
        <td>上架库存</td><%--7 --%>
        <td><input type="text" name="Srepertory" value="${book.repertory }"></td>
        <c:if test="${requestScope.falg==3 }"><td>库存不能为空</td></c:if>
      </tr>
      <tr>
        <td>书籍简介</td><%--9 --%>
        <td><textarea name="intro" rows="5" cols="40">${book.intro }</textarea></td>
        <c:if test="${requestScope.falg==3 }"><td>简介不能为空</td></c:if>
      </tr>
      <tr>
        <td><input type="submit" name="submition" value="提交修改"></td>
        <td><input type="button" value="取消" onclick="window.location.href='index.jsp'" /></td>
      </tr>
    
    </table>
    
    </form>
    </c:if>
    </c:if>
    <c:if test="${sessionScope.user==null }">您还没有登录，请先<a href="login.jsp">登录</a> </c:if>
        <footer class="footer mt-20">
	<div class="container-fluid">
		<nav> <a href="#" target="_blank">关于我们</a> <span class="pipe">|</span> <a href="#" target="_blank">联系我们</a> <span class="pipe">|</span> <a href="#" target="_blank">法律声明</a> </nav>
		<p>Copyright &copy;2018 BookStore.LICHAOWEI <br>
			<a href="#" target="_blank" rel="nofollow">京ICP备0000000号</a><br>
		</p>
	</div>
	</footer>
  </body>
</html>
