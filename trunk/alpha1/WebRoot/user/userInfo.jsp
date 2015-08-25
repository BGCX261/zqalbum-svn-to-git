<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ page import="net.ziqiang.album.domain.album.UserInfo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>Insert title here</title>
</head>
<body>
<%
	String sessionUserInfo="currentUser";
	session=request.getSession();
	UserInfo userInfo=(UserInfo)session.getAttribute(sessionUserInfo);	
%>
	<h2>欢迎登录</h2>
	<table>
		<tr>
			<td>帐号</td>
			<td><%=userInfo.getUserName() %></td>
		</tr>
		<tr>
			<td>相册数</td>
			<td><%=userInfo.getAlbumNum() %></td>
		</tr>
		<tr>
			<td>等级</td>
			<td><%=userInfo.getRank() %></td>
		</tr>
	</table>
	<a href="<%=request.getContextPath()%>/userInfo.do" target="_parent">进入相册列表</a>
	<a href="createAlbum.jsp" target="_parent">创建新相册</a>
	<a href="addPhoto.jsp" target="_parent">上传新照片</a>
</body>
</html>