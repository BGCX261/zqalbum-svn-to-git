/*
* ��Ȩ���� (C) 2000-2007 ̷���� <TanMenglong@gmail.com>
* 
* �˴�����ѭMozilla Public Licene1.1Э�鷢��������Э��������������µ�ַ
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.commons.web.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

public class Logout extends HttpServlet {
	private ServletConfig servletConfig=null;
	private String sessionAttributeName=null;
	private String logoutUrl=null;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		try{
			doPost(request,response);
		}catch(Exception e){
			
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		request.getSession().setAttribute(sessionAttributeName, null);
		response.sendRedirect(request.getContextPath()+logoutUrl);
	}

	public void init(ServletConfig servletConfig) throws ServletException{
		this.servletConfig=servletConfig;
		sessionAttributeName=servletConfig.getInitParameter("sessionAttributeName");
		logoutUrl=servletConfig.getInitParameter("logoutUrl");
	}

	public void destroy(){
		super.destroy();
	}
}
