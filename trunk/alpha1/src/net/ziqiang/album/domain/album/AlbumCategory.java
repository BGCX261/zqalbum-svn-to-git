package net.ziqiang.album.domain.album;

public class AlbumCategory {
	private int categoryId;
	private String name;
	private String description;
	private int albumNum;
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAlbumNum() {
		return albumNum;
	}
	public void setAlbumNum(int albumNum) {
		this.albumNum = albumNum;
	}
	

}
