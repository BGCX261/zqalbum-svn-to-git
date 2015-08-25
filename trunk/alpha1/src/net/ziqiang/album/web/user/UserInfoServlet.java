package net.ziqiang.album.web.user;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;

import java.io.IOException;

import net.ziqiang.album.domain.album.UserInfo;

public class UserInfoServlet extends HttpServlet{
	private static final long serialVersionUID=0L;
	private String sessionUserInfo=null;
	private String successView=null;
	private String failureView=null;
	private ServletConfig servletConfig=null;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		sessionUserInfo=servletConfig.getInitParameter("sessionUserInfo");
		successView=request.getContextPath()+servletConfig.getInitParameter("successView");
		failureView=request.getContextPath()+servletConfig.getInitParameter("failureView");
		
		HttpSession session=request.getSession();
		UserInfo userInfo=(UserInfo)session.getAttribute(sessionUserInfo);
		int albumNum=userInfo.getAlbumNum();
		
		if(albumNum>0){
			response.sendRedirect(successView);
			return;
		}
		else{
			response.sendRedirect(failureView);
			return;
		}
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		sessionUserInfo=servletConfig.getInitParameter("sessionUserInfo");
		successView=request.getContextPath()+servletConfig.getInitParameter("successView");
		failureView=request.getContextPath()+servletConfig.getInitParameter("failureView");
		
		HttpSession session=request.getSession();
		UserInfo userInfo=(UserInfo)session.getAttribute(sessionUserInfo);
		int albumNum=userInfo.getAlbumNum();
		
		if(albumNum>0){
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
