package net.ziqiang.album.service;

import net.ziqiang.album.dao.ibatis.CommonDaoGenericImpl;
import net.ziqiang.album.domain.album.Photo;
import java.util.HashMap;
import java.util.List;

public class PhotoService {
	private CommonDaoGenericImpl commonDao;

	public CommonDaoGenericImpl getCommonDao() {
		return commonDao;
	}

	public void setCommonDao(CommonDaoGenericImpl commonDao) {
		this.commonDao = commonDao;
	}
	public boolean insertPhoto(Photo photo){
		return commonDao.insertByParameter(photo,"insertPhoto");
	}
	public boolean updatePhoto(Photo photo){
		return commonDao.updateByParameter(photo,"updatePhoto");
	}
	public boolean updatePhotoDescription(String description,int photoId){
		HashMap<String,Object> hashmap=new HashMap<String,Object>();
		hashmap.put("description",description);
		hashmap.put("photoId",photoId);
		return commonDao.updateByParameter(hashmap,"updatePhotoDescription");
	}
	public boolean updatePhotoStatus(int status,int photoId){
		HashMap<String,Integer> hashmap=new HashMap<String,Integer>();
		hashmap.put("status",status);
		hashmap.put("photoId",photoId);
		return commonDao.updateByParameter(hashmap,"updatePhotoStatus");
	}
	public boolean updatePhotoHit(int hit,int photoId){
		HashMap<String,Integer> hashmap=new HashMap<String,Integer>();
		hashmap.put("hit",hit);
		hashmap.put("photoId",photoId);
		return commonDao.updateByParameter(hashmap,"updatePhotoStatus");
	}
	public boolean updatePhotoName(String photoName,int photoId){
		HashMap<String,Object> hashmap=new HashMap<String,Object>();
		hashmap.put("photoName",photoName);
		hashmap.put("photoId",photoId);
		return commonDao.updateByParameter(hashmap,"updatePhotoName");
	}
	public boolean deletePhotoById(int photoId){
		return commonDao.deleteByParameter(photoId,"deletePhotoById");
	}
	public Photo getPhotoById(int photoId){
		return commonDao.getByParameter(photoId,"getPhotoById");
	}
	public Photo getPhotoByPhotoName(String photoName){
		return commonDao.getByParameter(photoName,"getPhotoByPhotoName");
	}
	public List<Photo> getPhotosByAlbumId(int albumId){
		return commonDao.getListByParameter(albumId,"getPhotosByAlbumId");
	}
	public List<Photo> getPhotosByHit(int count){
		return commonDao.getListByParameter(count,"getPhotosByHit");
	}
	public List<Photo> getPhotosByUploadTime(int startTime,int endTime){
		HashMap<String,Integer> hashmap=new HashMap<String,Integer>();
		hashmap.put("startTime",startTime);
		hashmap.put("endTime",endTime);
		return commonDao.getListByParameter(hashmap,"getPhotosByUploadTime");
	}
	public List<Photo> getPhotosByAlbumIdStatus(int albumId,int status,int offset,int count){
		HashMap<String,Integer> hashmap=new HashMap<String,Integer>();
		hashmap.put("albumId",albumId);
		hashmap.put("status",status);
		hashmap.put("offset",offset);
		hashmap.put("count",count);
		return commonDao.getListByParameter(hashmap,"getPhotosByAlbumIdStatus");
	}
	public int getPhotoCount(int albumId,int status){
		HashMap<String,Integer> hashmap=new HashMap<String,Integer>();
		hashmap.put("albumId",albumId);
		hashmap.put("status",status);
		return commonDao.getByParameter(hashmap,"getPhotoCount");
	}
	
	
}
