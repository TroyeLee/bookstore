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
    
    <title>My JSP 'buy.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="style1.css">

  </head>
  
  <body>
    <%
    User user=new User();
    Book book=new Book();
    
    user=(User)session.getAttribute("user");
    String Oid=request.getParameter("Oid");
    String Scount=request.getParameter("count");
    String bname=new OrdersOp().getBname(Oid);
    book=new BookOp().searchBook2(bname);
    int count=Integer.parseInt(Scount);
    float price=book.getPrice();
    
    float totalprice=count*price;
    session.setAttribute("Oid",Oid);
    session.setAttribute("count",count);
    session.setAttribute("totalprice", totalprice);
    session.setAttribute("user", user);
    session.setAttribute("book", book);

    	
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
      					<li  class="current"><a href="login.jsp">登录</a></li>
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

   	<p>用户：<input type="text" value="${logname }" readonly />
   	<p>订单：
   	<table>
   		<tr>
   			<td>书籍名称：</td>
   			<td>${book.bname }</td>
   		</tr>
   		<tr>
   			<td>购买数量：</td>
   			<td>${count }</td>
   		</tr>
   		<tr>
   			<td>￥</td>
   			<td>${totalprice }</td>
   		</tr>
   		<tr>
   			<td> <input type="submit" name="提交订单" value="提交订单" onclick="firm()"> </td>
   			<td> <input type="button" onclick="window.location.href='showorders.jsp'" value="取消" ></td>
   		</tr>
   	</table>
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
    function firm(){
      if(confirm("您确定购买？")){
//        thejp.conblogs.comlocation.href="http//BuyServlet.java";
//          window.location.href="BuyServlet";
			window.location.href="BuyServlet?flag=0";
      }
      else{}
    
    }
  </script>
</html>
