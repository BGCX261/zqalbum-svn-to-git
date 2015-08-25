package net.ziqiang.album.service;

import net.ziqiang.album.dao.ibatis.CommonDaoGenericImpl;
import net.ziqiang.album.domain.album.*;
import java.util.HashMap;

public class UserInfoService {
	private CommonDaoGenericImpl commonDao;

	public CommonDaoGenericImpl getCommonDao() {
		return commonDao;
	}

	public void setCommonDao(CommonDaoGenericImpl commonDao) {
		this.commonDao = commonDao;
	}
	
	public boolean insertUserInfo(UserInfo userInfo){
		return commonDao.insertByParameter(userInfo,"insertUserInfo");
	}
	public boolean updateUserInfo(UserInfo userInfo){
		return commonDao.updateByParameter(userInfo,"updateUserInfo");
	}
	public boolean updateUserInfoAlbumNum(int albumNum,int userId){
		HashMap<String,Integer> hashmap=new HashMap<String,Integer>();
		hashmap.put("albumNum",albumNum);
		hashmap.put("userId",userId);
		return commonDao.updateByParameter(hashmap,"updateUserInfoAlbumNum");
	}
	public boolean updateUserInfoRank(int rank,int userId){
		HashMap<String,Integer> hashmap=new HashMap<String,Integer>();
		hashmap.put("rank",rank);
		hashmap.put("userId",userId);
		return commonDao.updateByParameter(hashmap,"updateUserInfoRank");
	}
	public boolean deleteUserInfoById(int userId){
		return commonDao.deleteByParameter(userId,"deleteUserInfoById");
	}
	
	public UserInfo getUserInfoById(int userId){
		return commonDao.getByParameter(userId,"getUserInfoById");
	}
	public UserInfo getUserInfoByUserName(String userName){
		return commonDao.getByParameter(userName,"getUserInfoByUserName");
	}
	public UserInfo getUserInfoByRank(int rank){
		return commonDao.getByParameter(rank,"getUserInfoByRank");
	}
	
}
