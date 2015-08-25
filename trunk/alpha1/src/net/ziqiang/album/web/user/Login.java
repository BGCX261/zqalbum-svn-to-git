package net.ziqiang.album.web.user;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import net.ziqiang.album.domain.album.UserInfo;
import net.ziqiang.album.domain.passport.UserAuth;
import net.ziqiang.album.service.*;

public class Login extends HttpServlet{
	private static final long serialVersionUID=0L;
	private ServletConfig servletConfig=null;
	private String successView=null;
	private String failureView=null;
	private String sessionUserInfo=null;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		successView=request.getContextPath()+servletConfig.getInitParameter("successView");
		failureView=request.getContextPath()+servletConfig.getInitParameter("failureView");
		sessionUserInfo=servletConfig.getInitParameter("sessionUserInfo");
		
		HttpSession session=request.getSession();
		UserInfoService userInfoService=ServiceFactory.getUserInfoService();
		PassportService passportService=PassportServiceFactory.getPassportService();
		
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		String emptyNameErr;
		String emptyPasswordErr;
		String wrongUserNameErr;
		String wrongPasswordErr;
		//验证用户名是否为空
		if(userName==null){
			emptyNameErr="emptyUserName";
			request.setAttribute("err",emptyNameErr);
			response.sendRedirect(failureView+"?err="+emptyNameErr);
			return;
		}
		//验证密码是否为空
		if(password==null){
			emptyPasswordErr="emptyPassword";
			request.setAttribute("err",emptyPasswordErr);
			response.sendRedirect(failureView+"?err="+emptyPasswordErr);
			return;
		}
		//通过用户名获取userAuth
		UserAuth userAuth=passportService.getUserAuthByUserName(userName);
		//先验证是否存在该用户
		if(userAuth==null){
			wrongUserNameErr="wrongUserName";
			request.setAttribute("err",wrongUserNameErr);
			response.sendRedirect(failureView+"?err="+wrongUserNameErr);
			return;
		}
		//如果存在用户，再验证密码，如果密码通过则进一步验证,否则转到登录页面
		if(userAuth.getPassword().equals(password)){
			//通过userAuth获取的用户名来获取用户信息userInfo
			UserInfo userInfo=userInfoService.getUserInfoByUserName(userAuth.getUsername());
			//如果用户第一次登录，即数据表userInfo中还不存在该用户信息，则将信息插入
			if(userInfo==null){
				//根据userAuth设置userInfo
				userInfo=new UserInfo();
				userInfo.setAlbumNum(0);
				userInfo.setRank(0);
				userInfo.setPrivilege(userAuth.getPrivilege());
				userInfo.setUserName(userAuth.getUsername());
				userInfo.setUserId(userAuth.getUserId());
				//将userInfo插入数据库
				userInfoService.insertUserInfo(userInfo);
				//将userInfo存在session中，供以后使用
				session.setAttribute(sessionUserInfo,userInfo);
				response.sendRedirect(successView);
				return;
			}
			else{
				session.setAttribute(sessionUserInfo,userInfo);
				response.sendRedirect(successView);
				return;
			}
		}
		else{
			wrongPasswordErr="wrongPassword";
			request.setAttribute("err",wrongPasswordErr);
			response.sendRedirect(failureView+"?err="+wrongPasswordErr);
			return;	
		}
	}
	public void init(ServletConfig servletConfig) throws ServletException {
		this.servletConfig=servletConfig;
	}


}
