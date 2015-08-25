<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<%@page import="net.ziqiang.album.domain.album.Album"%>
<%@ taglib uri="http://fckeditor.net/tags-fckeditor" prefix="FCK" %> 
<%@ page import="net.ziqiang.album.service.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>上传照片</title>
</head>
<body>
	<div id="link">
		<a href="albumList.jsp">返回相册列表</a>
	</div>
<%
	String successMsg=request.getParameter("successMsg");
	String stringAlbumId=request.getParameter("albumId");
	Album album=null;
	boolean flag=false;
	if(stringAlbumId!=null&&successMsg!=null){
		flag=true;
		int albumId=Integer.parseInt(stringAlbumId);
		AlbumService albumService=ServiceFactory.getAlbumService();
		album=albumService.getAlbumById(albumId);
	}
	
%>
	<div id="container">
		<form action="<%=request.getContextPath() %>/addPhoto.do" method="post" enctype="multipart/form-data">
			<div id="albumName">
				<label for="albumName">相册名</label>
				<input type="text" name="albumName" value=""/>
			</div>
			<div id="photoName">
				<label for="photoName">照片名</label>
				<input type="text" name="photoName" value=""/>
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
			<div id="upload">
				<label for="photoFile">图片上传</label>
				<input type="file" name="photoFile"/>
			</div>
			<div id="remind">
				图片大小不能超过2M，图片类型只能为jpg,jpeg,bmp,gif
			</div>
			<div id="button">
				<input type="submit" value="确认" name="confirm"/>
				<input type="reset" value="重置" name="reset"/>
			</div>
			<div id="successMsg">
				<font color="red"><%if(flag)out.println("上传文件成功，你可以继续上传，或者返回该相册首页");
					out.println();
				%>
				<a href="album.jsp?albumId=<%if(flag)out.println(album.getAlbumId());%>"><%if(flag)out.println(album.getAlbumName());%></a>
					
				</font>
			</div>
		</form>
	</div>
</body>
</html>