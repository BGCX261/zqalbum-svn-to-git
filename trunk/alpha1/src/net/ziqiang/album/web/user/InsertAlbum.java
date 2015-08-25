package net.ziqiang.album.web.user;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;

import java.io.IOException;

import net.ziqiang.album.domain.album.Album;
import net.ziqiang.album.domain.album.UserInfo;
import net.ziqiang.album.service.AlbumService;
import net.ziqiang.album.service.ServiceFactory;
import net.ziqiang.album.service.UserInfoService;

import com.littleqworks.commons.util.DateTimeUtils;

public class InsertAlbum extends HttpServlet {
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
		String createTime=DateTimeUtils.getTimestamp();
		String updateTime=createTime;
		
		HttpSession session=request.getSession();
		UserInfo userInfo=(UserInfo)session.getAttribute(sessionUserInfo);
		int userId=userInfo.getUserId();
		
		Album album=new Album();
		album.setUserId(userId);
		album.setAlbumName(albumName);
		album.setCategoryId(categoryId);
		album.setCreateTime(createTime);
		album.setDescription(description);
		album.setPhotoNum(0);
		album.setUpdateTime(updateTime);
		
		AlbumService albumService=ServiceFactory.getAlbumService();
		UserInfoService userInfoService=ServiceFactory.getUserInfoService();
		int albumNum=userInfo.getAlbumNum();
		albumNum=albumNum+1;
		if(albumService.insertAlbum(album)&&userInfoService.updateUserInfoAlbumNum(albumNum, userId)){
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
