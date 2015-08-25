<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<%@ page import="net.ziqiang.album.service.*" %>
<%@ page import="net.ziqiang.album.domain.album.Album"%>    
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title></title>
</head>
<body>
<%
	String stringId=request.getParameter("albumId");
	int albumId=(stringId==null)?-1:Integer.parseInt(stringId);
	AlbumService albumService=ServiceFactory.getAlbumService();
	Album album=albumService.getAlbumById(albumId);
%>
	<h3>您确认要删除<%=album.getAlbumName() %>吗?</h3>
	<a href="<%=request.getContextPath()%>/deleteAlbum.do?albumId=<%=album.getAlbumName()%>">确认</a>
	<a href="album.jsp?albumId=<%=album.getAlbumId() %>">取消</a>
	
		
</body>
</html>