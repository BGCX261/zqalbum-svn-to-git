package net.ziqiang.album.domain.album;

public class UserInfo {
	private int userId;
	private String userName;
	private int albumNum;
	private int rank;
	private String privilege;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAlbumNum() {
		return albumNum;
	}
	public void setAlbumNum(int albumNum) {
		this.albumNum = albumNum;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
	
	

}
