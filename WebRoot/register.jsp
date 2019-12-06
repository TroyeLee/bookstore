<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
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
					<li><a href="personal.jsp">个人中心</a></li>
                    <c:if test="${sessionScope.user == null }">
      					<li><a href="login.jsp">登录</a></li>
                    	<li class="current"><a href="register.jsp">注册</a></li>
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
  <div >
    <form action="RegidterServlet" method="post">
    <table border="1" cellpadding="2" cellspacing="1">
      <tr>
        <th>新成员注册</th>
      </tr>
      <tr>
        <td>登录名</td><%--1 --%>
        <td><input type="text" name="logname" value="${requestScope.logname }" maxlength=16 >
	    </td>
	    <c:if test="${requestScope.flag==1 }"><td>登录名不能为空</td></c:if>
      </tr>
      <tr>
        <td><p>密码 :</td><%--2 --%>
        <td> <input type="password" name="passwd1" value="${requestScope.passwd1}" maxlength=50></td>
        <c:if test="${requestScope.flag==1 }"><td>密码不能为空</td></c:if>
      </tr>
      <tr>
        <td><p>确认密码 :</td><%--2 --%>
        <td> <input type="password" name="passwd2" maxlength=50></td>
        <c:if test="${requestScope.pas==1 }"><td>密码不一致请重新输入</td></c:if>
      </tr>
      <tr>
        <td><p>真实姓名</td><%--3 --%>
        <td><input type="text" name="realname" value="${requestScope.realname}" maxlength=10></td>
        <c:if test="${requestScope.flag==1 }"><td>名字不能为空</td></c:if>
      </tr>
      <tr>
        <td>邮箱</td><%--4 --%>
        <td><input type="text" name="email" value="${requestScope.email}" maxlength=20 >
	    </td>
	    <c:if test="${requestScope.flag==1 }"><td>邮箱不能为空</td></c:if>
      </tr>
      <tr>
        <td>性别</td><%--5 --%>
        <td><input type="radio" name="gender" value="男">男 <input type="radio" name="gender" id="女">女
	    </td>
	    <c:if test="${requestScope.flag==1 }"><td>性别不能为空</td></c:if>
      </tr>
      <tr>
        <td>地址</td><%--6 --%>
        <td><input type="text" name="uaddress" value="${requestScope.uaddress}" maxlength=100 >
	    </td>
	    <c:if test="${requestScope.flag==1 }"><td>地址不能为空</td></c:if>
      </tr>
      <tr>
        <td>电话</td><%--7 --%>
        <td><input type="text" name="phone" value="${requestScope.phone}" maxlength=11 >
	    </td>
	    <c:if test="${requestScope.flag==1 }"><td>电话不能为空</td></c:if>
      </tr>
      <tr>
        <td>密码召回问题</td><%--8 --%>
        <td><input type="text" name="problem" value="${requestScope.problem}" maxlength=40>
	    </td>
	    <c:if test="${requestScope.flag==1 }"><td>问题不能为空</td></c:if>
      </tr>
      <tr>
        <td>密码问题答案</td><%--9 --%>
        <td><input type="text" name="answer" value="${requestScope.answer}" maxlength=40>
	    </td>
	    <c:if test="${requestScope.flag==1 }"><td>答案不能为空</td></c:if>
      </tr>
      <tr>
        <td>省分</td><%--10 --%>
        <td><input type="text" name="province" value="${requestScope.province}" maxlength=20 >
	    </td>
      </tr>
      <tr>
        <td>教育程度</td><%--11 --%>
        <td><input type="text" name="education" value="${requestScope.education}" maxlength=10 >
	    </td>
      </tr>
      <tr>
        <td>兴趣爱好</td><%--12 --%>
        <td><textarea  name="hobbies" rows="5" cols="40" onKeyUp="if(this.value.length>100)this.value=this.value.substr(0,100)"  >${requestScope.hobbies}</textarea>
	    </td>
      </tr>
      <tr>
        <td>自我介绍</td><%--13 --%>
        <td><textarea  name="selfintro" rows="5" cols="40" onKeyUp="if(this.value.length>100)this.value=this.value.substr(0,100)" >${requestScope.selfintro }</textarea>
	    </td>
      </tr>
      <tr>
        <td>类型</td><%--14 --%>
        <td><input type="radio" name="utype" value="1">用户  <input type="radio" name="utype" value="2">管理员
	    </td>
	    <c:if test="${requestScope.flag==1 }"><td>类型不能为空</td></c:if>
      </tr>
      <tr>
        <td><input type="submit" value="注册"></td>
        <td><input type="button" value="退出" onclick="window.location.href='index.jsp'" ></td>
      </tr>
    
    </table>
    
    </form>
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
</html>
