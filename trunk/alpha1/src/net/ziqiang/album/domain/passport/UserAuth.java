package net.ziqiang.album.domain.passport;
public class UserAuth {
	private int userId;
	private String username;
	private String password;
	private String lastLoginIpV4;
	private String lastLoginTimestamp;
	private String privilege;
	private int status;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLastLoginIpV4() {
		return lastLoginIpV4;
	}
	public void setLastLoginIpV4(String lastLoginIpV4) {
		this.lastLoginIpV4 = lastLoginIpV4;
	}
	public String getLastLoginTimestamp() {
		return lastLoginTimestamp;
	}
	public void setLastLoginTimestamp(String lastLoginTimestamp) {
		this.lastLoginTimestamp = lastLoginTimestamp;
	}
	public String getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
