<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page  import="user.*" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'personal.jsp' starting page</title>
    
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
					<li><a href="index.jsp">首页</a></li>
					<li><a href="showorders.jsp">购物车</a></li>
					<li class="current"><a href="personal.jsp">个人中心</a></li>
                    <c:if test="${sessionScope.user == null }">
      					<li ><a href="login.jsp">登录</a></li>
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
<div>
<c:if test="${sessionScope.user!=null }">
  <form action="./updateServlet" method="post">
  
   <table>
   	<tr>
   		<th colspan="2"><h3> ${ sessionScope.user.logname }    的个人主页</h3></th>
	  </tr>
   	<tr>
   		<td><p>真实姓名</p></td> 
   		<td>${ sessionScope.user.realname }</td>
   	</tr>
   	<tr>
   		<td><p>邮箱地址</p></td><td>${ sessionScope.user.email }</td>
   	</tr>
   	<tr>
   		<td><p>性别 </p></td>
        <td>${ sessionScope.user.gender }</td>
    </tr>
	<tr><td><p>地址</p></td>
        <td>${ sessionScope.user.uaddress }</td>
     </tr>
   	<tr>
   		<td><p>联系电话</p></td>
        <td>  ${ sessionScope.user.phone }</td>
    </tr>
   	<tr>
    	<td><p>密码问题</p></td>
        <td>  ${ sessionScope.user.problem }</td>
    </tr>
   	<tr>
    	<td><p>所属省份</p></td>
        <td>  ${ sessionScope.user.province }</td>
    </tr>
   	<tr>
    	<td><p>教育程度</p></td>
        <td>  ${ sessionScope.user.education }</td>
    </tr>
   	<tr>
    	<td><p>兴趣爱好</p></td>
        <td>  ${ sessionScope.user.hobbies }</td>
    </tr>
   	<tr>
    	<td><p>个人简介</p></td>
        <td>  ${ sessionScope.user.selfintro }</td>
    </tr>
   	<tr>
    	<td><p>用户类型</p></td>
        <td>
        	<c:if test="${sessionScope.user.utype=='1'}">用户</c:if> <c:if test="${sessionScope.user.utype=='2'}">管理员</c:if>
        </td>
    </tr>
   </table>
   

   <br/>
   <br/>
   <input type="submit" name="submition" value="修改信息" /> 
   <input type="submit" value="退出登录" name="submition"  />
   <c:if test="${sessionScope.user.utype=='2'}">
   <input type="button"  value="新书上架" onclick="window.location.href='bookadd.jsp'" />
   <input type="button"  value="查看书本信息" onclick="window.location.href='showallbook.jsp'" />
   
   </c:if>

  </form>
</c:if>
</div>
 <c:if test="${sessionScope.user==null }">请先<a href="login.jsp">登录</a></c:if>
 
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
