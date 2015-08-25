/*
* 版权所有 (C) 2000-2007 谭孟泷 <TanMenglong@gmail.com>
* 
* 此代码遵循Mozilla Public Licene1.1协议发布，具体协议条款请参照以下地址
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.commons.web.security;

public class User {
	private String userName;
	private String privilege;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
}
