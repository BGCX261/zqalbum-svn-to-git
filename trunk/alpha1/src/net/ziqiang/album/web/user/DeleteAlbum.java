package net.ziqiang.album.web.user;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;

import java.io.IOException;

import net.ziqiang.album.service.AlbumService;
import net.ziqiang.album.service.ServiceFactory;

import com.littleqworks.commons.util.DateTimeUtils;

public class DeleteAlbum extends HttpServlet{
	private static final long serialVersionUID=0L;
	private String sessionUserInfo=null;
	private String successView=null;
	private String failureView=null;
	private ServletConfig servletConfig=null;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		sessionUserInfo=servletConfig.getInitParameter("sessionUserInfo");
		successView=request.getContextPath()+servletConfig.getInitParameter("successView");
		failureView=request.getContextPath()+servletConfig.getInitParameter("failureView");
		
		String albumName=request.getParameter("albumName");
		int categoryId=Integer.parseInt(request.getParameter("categoryId"));
		String description=request.getParameter("contents");
		String updateTime=DateTimeUtils.getTimestamp();
		String stringId=request.getParameter("albumId");
		int albumId=Integer.parseInt(stringId);
		
		AlbumService albumService=ServiceFactory.getAlbumService();
		
		if(albumService.updateAlbumDescription(description,albumId)&&albumService.updateAlbumName(albumName,albumId)&&albumService.updateAlbumUpdateTime(updateTime,albumId)&&albumService.updateAlbumCategoryId(categoryId,albumId)){
			response.sendRedirect(successView);
			return;
		}
		else{
			response.sendRedirect(failureView);
			return;
		}
		
		
	}
	public void init(ServletConfig servletConfig)throws ServletException{
		this.servletConfig=servletConfig;
	}
}
