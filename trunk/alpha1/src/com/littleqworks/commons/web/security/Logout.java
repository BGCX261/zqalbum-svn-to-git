/*
* 版权所有 (C) 2000-2007 谭孟泷 <TanMenglong@gmail.com>
* 
* 此代码遵循Mozilla Public Licene1.1协议发布，具体协议条款请参照以下地址
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
