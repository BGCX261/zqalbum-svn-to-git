package net.ziqiang.album.service;

import net.ziqiang.album.dao.ibatis.CommonDaoGenericImpl;
import net.ziqiang.album.domain.album.Album;
import java.util.HashMap;
import java.util.List;

public class AlbumService {
	private CommonDaoGenericImpl commonDao;

	public CommonDaoGenericImpl getCommonDao() {
		return commonDao;
	}

	public void setCommonDao(CommonDaoGenericImpl commonDao) {
		this.commonDao = commonDao;
	}
	
	public boolean insertAlbum(Album album){
		return commonDao.insertByParameter(album,"insertAlbum");
	}
	public boolean updateAlbum(Album album){
		return commonDao.updateByParameter(album,"updateAlbum");
	}
	public boolean updateAlbumName(String albumName,int albumId){
		HashMap<String,Object> hashmap=new HashMap<String,Object>();
		hashmap.put("albumName",albumName);
		hashmap.put("albumId",albumId);
		return commonDao.updateByParameter(hashmap,"updateAlbumName");
	}
	public boolean updateAlbumUpdateTime(String updateTime,int albumId){
		HashMap<String,Object> hashmap=new HashMap<String,Object>();
		hashmap.put("updateTime",updateTime);
		hashmap.put("albumId",albumId);
		return commonDao.updateByParameter(hashmap,"updateAlbumUpdateTime");
	}
	public boolean updateAlbumPhotoNum(int photoNum,int albumId){
		HashMap<String,Integer> hashmap=new HashMap<String,Integer>();
		hashmap.put("photoNum",photoNum);
		hashmap.put("albumId",albumId);
		return commonDao.updateByParameter(hashmap,"updateAlbumPhotoNum");
	}
	public boolean updateAlbumCategoryId(int categoryId,int albumId){
		HashMap<String,Integer> hashmap=new HashMap<String,Integer>();
		hashmap.put("categoryId",categoryId);
		hashmap.put("albumId",albumId);
		return commonDao.updateByParameter(hashmap,"updateAlbumCategoryId");
	}
	public boolean updateAlbumDescription(String description,int albumId){
		HashMap<String,Object> hashmap=new HashMap<String,Object>();
		hashmap.put("description",description);
		hashmap.put("albumId",albumId);
		return commonDao.updateByParameter(hashmap,"updateAlbumDescription");
	}
	public boolean deleteAlbumById(int albumId){
		return commonDao.deleteByParameter(albumId,"deleteAlbumById");
	}
	
	public List<Album> getAlbums(){
		return commonDao.getList("getAlbums");
	}
	public Album getAlbumById(int albumId){
		return commonDao.getByParameter(albumId,"getAlbumById");
	}
	public Album getAlbumByName(String albumName){
		return commonDao.getByParameter(albumName,"getAlbumByName");
	}
	public Album getAlbumByNameUserId(String albumName,int userId){
		HashMap<String,Object> hashmap=new HashMap<String,Object>();
		hashmap.put("albumName",albumName);
		hashmap.put("userId",userId);
		return commonDao.getByParameter(hashmap,"getAlbumByNameUserId");
	}
	public List<Album> getAlbumsByCategoryId(int categoryId,int offset,int count){
		HashMap<String,Integer> hashmap=new HashMap<String,Integer>();
		hashmap.put("categoryId",categoryId);
		hashmap.put("offset",offset);
		hashmap.put("count",count);
		return commonDao.getListByParameter(hashmap,"getAlbumsByCategoryId");
	}
	public List<Album> getAlbumsByUserId(int userId){
		return commonDao.getListByParameter(userId,"getAlbumsByUserId");
	}
	public List<Album> getAlbumsByCreateTime(int startTime,int endTime){
		HashMap<String,Integer> hashmap=new HashMap<String,Integer>();
		hashmap.put("startTime",startTime);
		hashmap.put("endTime",endTime);
		return commonDao.getListByParameter(hashmap,"getAlbumsByCreateTime");
	}
	public int getAlbumCountByCategoryId(int categoryId){
		return commonDao.getByParameter(categoryId,"getAlbumCountByCategoryId");
	}
	public int getAlbumCountByUserId(int userId){
		return commonDao.getByParameter(userId,"getAlbumCountByUserId");
	}

}
