<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<%@ taglib uri="http://fckeditor.net/tags-fckeditor" prefix="FCK" %>
<%@ page import="net.ziqiang.album.service.*"%> 
<%@ page import="net.ziqiang.album.domain.album.AlbumCategory"%>
<%@page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>Insert title here</title>
</head>
<body>
<% 
	AlbumCategoryService albumCategoryService=ServiceFactory.getAlbumCategoryService(); 
	List<AlbumCategory> category=albumCategoryService.getAlbumCategorys();
%>
 <div id="container">
	<form action="<%=request.getContextPath() %>/createAlbum.do" method="post">
		<div id="albumName">
			<label for="albumName">相册名</label>
			<input name="albumName" type="text" value=""/>
		</div>
		<div id="categoryId">
			<label for="categoryId">类别</label>
			<select name="categoryId">
				<%for(AlbumCategory albumCategory:category){ %>
				<option value="<%=albumCategory.getCategoryId()%>"><%=albumCategory.getName() %></option>
				<%} %>
			</select>
		</div>
		<div id="description">
			<label for="fckeditor">描述</label>
			<FCK:editor id="contents" basePath="../fckeditor/" width ="600" height ="300"
                                imageBrowserURL="../fckeditor/editor/filemanager/browser/default/browser.html?Type=Image&Connector=connectors/jsp/connector"  
                                linkBrowserURL="../fckeditor/editor/filemanager/browser/default/browser.html?Connector=connectors/jsp/connector"  
                                flashBrowserURL="../fckeditor/editor/filemanager/browser/default/browser.html?Type=Flash&Connector=connectors/jsp/connector"  
                                imageUploadURL="../fckeditor/editor/filemanager/upload/simpleuploader?Type=Image"  
                                linkUploadURL="../fckeditor/editor/filemanager/upload/simpleuploader?Type=File"  
                                flashUploadURL="../fckeditor/editor/filemanager/upload/simpleuploader?Type=Flash">
            </FCK:editor>
		</div>
		<div id="button">
			<input type="submit" value="确认" name="confirm"/>
			<input type="reset" value="重置" name="reset"/>
		</div>
	</form>
 </div>
</body>
</html>