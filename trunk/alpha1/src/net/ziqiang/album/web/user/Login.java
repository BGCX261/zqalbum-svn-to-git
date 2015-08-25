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
		//��֤�û����Ƿ�Ϊ��
		if(userName==null){
			emptyNameErr="emptyUserName";
			request.setAttribute("err",emptyNameErr);
			response.sendRedirect(failureView+"?err="+emptyNameErr);
			return;
		}
		//��֤�����Ƿ�Ϊ��
		if(password==null){
			emptyPasswordErr="emptyPassword";
			request.setAttribute("err",emptyPasswordErr);
			response.sendRedirect(failureView+"?err="+emptyPasswordErr);
			return;
		}
		//ͨ���û�����ȡuserAuth
		UserAuth userAuth=passportService.getUserAuthByUserName(userName);
		//����֤�Ƿ���ڸ��û�
		if(userAuth==null){
			wrongUserNameErr="wrongUserName";
			request.setAttribute("err",wrongUserNameErr);
			response.sendRedirect(failureView+"?err="+wrongUserNameErr);
			return;
		}
		//��������û�������֤���룬�������ͨ�����һ����֤,����ת����¼ҳ��
		if(userAuth.getPassword().equals(password)){
			//ͨ��userAuth��ȡ���û�������ȡ�û���ϢuserInfo
			UserInfo userInfo=userInfoService.getUserInfoByUserName(userAuth.getUsername());
			//����û���һ�ε�¼�������ݱ�userInfo�л������ڸ��û���Ϣ������Ϣ����
			if(userInfo==null){
				//����userAuth����userInfo
				userInfo=new UserInfo();
				userInfo.setAlbumNum(0);
				userInfo.setRank(0);
				userInfo.setPrivilege(userAuth.getPrivilege());
				userInfo.setUserName(userAuth.getUsername());
				userInfo.setUserId(userAuth.getUserId());
				//��userInfo�������ݿ�
				userInfoService.insertUserInfo(userInfo);
				//��userInfo����session�У����Ժ�ʹ��
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
