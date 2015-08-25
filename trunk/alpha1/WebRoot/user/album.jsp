<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<%@ page import="net.ziqiang.album.service.*" %>
<%@ page import="net.ziqiang.album.domain.album.Album"%>
<%@ page import="net.ziqiang.album.domain.album.AlbumCategory"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>Insert title here</title>
</head>
<body>
<div id="link">
	<a href="createAlbum.jsp">创建新相册</a>
	<a href="albumList.jsp">返回相册列表</a>
</div>
<% 
	String albumId=request.getParameter("albumId");
	boolean flag=false;
	Album album=null;
	AlbumCategory albumCategory=null;
	if(albumId!=null){
		flag=true;
		AlbumService albumService=ServiceFactory.getAlbumService();
		AlbumCategoryService albumCategoryService=ServiceFactory.getAlbumCategoryService();
		album=albumService.getAlbumById(Integer.parseInt(albumId));
		int categoryId=album.getCategoryId();
		albumCategory=albumCategoryService.getAlbumCategoryById(categoryId);
		
	}
%>
	<table>
		<tr>
			<td><img src="<%=request.getContextPath()%>/image/NoPhoto.bmp"/><a href="photoList.jsp?albumId=<%if(flag)out.println(album.getAlbumId()); %>"></a></td>
			<td>
				<table>
					<tr>
						<td>相册名</td>
						<td><%if(flag)out.println(album.getAlbumName()); %></td>
					</tr>
					<tr>
						<td>类别</td>
						<td><%if(flag)out.println(albumCategory.getName()); %></td>
					</tr>
					<tr>
						<td>照片数</td>
						<td><%if(flag)out.println(album.getPhotoNum()); %></td>
					</tr>
					<tr>
						<td>创建时间</td>
						<td><%if(flag)out.println(album.getCreateTime()); %></td>
					</tr>
					<tr>
						<td>更新时间</td>
						<td><%if(flag)out.println(album.getUpdateTime()); %></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<a href="editAlbum.jsp?albumId=<%if(flag)out.println(album.getAlbumId()); %>">编辑相册</a>
	<a href="deleteAlbum.jsp?albumId=<%if(flag)out.println(album.getAlbumId()); %>">删除相册</a>
	<a href="addPhoto.jsp">上传照片</a>
</body>
</html>