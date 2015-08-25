package net.ziqiang.album.service;

import net.ziqiang.album.dao.ibatis.CommonDaoGenericImpl;
import net.ziqiang.album.domain.album.AlbumCategory;
import java.util.HashMap;
import java.util.List;

public class AlbumCategoryService {
	private CommonDaoGenericImpl commonDao;

	public CommonDaoGenericImpl getCommonDao() {
		return commonDao;
	}

	public void setCommonDao(CommonDaoGenericImpl commonDao) {
		this.commonDao = commonDao;
	}
	
	public boolean insertAlbumCategory(AlbumCategory albumCategory){
		return commonDao.insertByParameter(albumCategory,"insertAlbumCategory");
	}
	public boolean updateAlbumCategory(AlbumCategory albumCategory){
		return commonDao.updateByParameter(albumCategory,"updateAlbumCategory");
	}
	public boolean updateAlbumCategoryDescription(String description,int categoryId){
		HashMap<String,Object> hashmap=new HashMap<String,Object>();
		hashmap.put("description",description);
		hashmap.put("categoryId",categoryId);
		return commonDao.updateByParameter(hashmap,"updateAlbumCategoryDescription");
	}
	public boolean updateAlbumCategoryAlbumNum(int albumNum,int categoryId){
		HashMap<String,Integer> hashmap=new HashMap<String,Integer>();
		hashmap.put("albumNum",albumNum);
		hashmap.put("categoryId",categoryId);
		return commonDao.updateByParameter(hashmap,"updateAlbumCategoryAlbumNum");
	}
	public boolean deleteAlbumCategoryById(int categoryId){
		return commonDao.deleteByParameter(categoryId,"deleteAlbumCategoryById");
	}
	public AlbumCategory getAlbumCategoryById(int categoryId){
		return commonDao.getByParameter(categoryId,"getAlbumCategoryById");
	}
	public AlbumCategory getAlbumCategoryByName(String name){
		return commonDao.getByParameter(name,"getAlbumCategoryByName");
	}
	public List<AlbumCategory> getAlbumCategorys(){
		return commonDao.getList("getAlbumCategorys");
	}
	

}
