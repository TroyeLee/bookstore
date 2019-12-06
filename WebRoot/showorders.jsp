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
    
    <title>My JSP 'showorders.jsp' starting page</title>
    
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
					<li ><a href="index.jsp">首页</a></li>
					<li class="current"><a href="showorders.jsp">购物车</a></li>
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

    <br/>
    <c:if test="${sessionScope.user!=null }">
    <% 
    	User user=new User();
    	user=(User)session.getAttribute("user");
    	
    	Show show=new Show();
    	
    	int pageCount = 10;//显示每页记录数
    	
       	int totalCount=show.getCount2(user.getLogname());//获取订单数量
//       	System.out.println("here is running 0 totalCount is"+totalCount);
       	
       	
       	int currentPage=1;//当前页
       	
       	String p=null;//
       	
       	if((p=request.getParameter("ppage"))!=null){
       	 	currentPage = Integer.parseInt(p);
       	}
       	
       	Page ppage = PageUtil.createPage(pageCount, totalCount, currentPage);
       	
       	ArrayList<Orders> Olist=show.getOrders(currentPage,pageCount,user.getLogname());
       	request.setAttribute("totalCount",totalCount);
       	request.setAttribute("ppage",ppage);
       	session.setAttribute("Olist",Olist);
       	
         %>
         <c:if test="${ requestScope.totalCount == 0 }">

         <p>您的购物车，空空如也！赶紧去<a href="index.jsp">添加</a>吧！</p>
         </c:if>
         
      	 <c:if test="${ requestScope.totalCount > 0}">
      	 
      	 <table>
       		<c:forEach items="${sessionScope.Olist}" var="order">
       		<tr>
       			<td><a href="showintro.jsp?Oid=${order.oid }">${order.goods_names}</a></td>
      	 		<td>  ${order.goods_count}本</td>    
      	 		<td><a href="buy.jsp?Oid=${order.oid }&count=${order.goods_count}">结算</a></td>
      	 		<td>
      	 			<form action="AddtoshopServlet?Oid=${order.oid }" method="post">
      	 				<input type="submit" name="submition" value="删除订单">
      	 			</form>
      	 		</td>
			</tr>
       		</c:forEach>
       	</table>
       	
		<br>
			
  		<c:if test="${requestScope.ppage.totalPage>1 }">
			<a href="showorders.jsp?ppage=${requestScope.ppage.currentPage-1 }">上一页</a>
			<c:forEach begin="1" end="${requestScope.ppage.totalPage }"  var="p">
			<a href="showorders.jsp?ppage=${p }">${p }</a> 
			</c:forEach>
			<a href="showorders.jsp?ppage=${requestScope.ppage.currentPage+1 }">下一页</a>
		</c:if>
			
		</c:if>
	</c:if>
	<c:if test="${sessionScope.user==null }">您尚未登录，请先<a href="login.jsp">登录</a>!</c:if>
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
	function funurl(ourl){
		var nurl=encodeURL(encodeURL(ourl));
		if(nurl){
			 window.location.href="nurl";
		}
	}
</script>
</html>
