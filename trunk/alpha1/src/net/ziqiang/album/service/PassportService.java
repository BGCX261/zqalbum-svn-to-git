package net.ziqiang.album.service;

import net.ziqiang.album.dao.ibatis.CommonDaoImpl;
import net.ziqiang.album.domain.passport.*;
import org.springframework.dao.DataAccessException;

public class PassportService {
	private CommonDaoImpl commonDao;

	public CommonDaoImpl getCommonDao() {
		return commonDao;
	}

	public void setCommonDao(CommonDaoImpl commonDao) {
		this.commonDao = commonDao;
	}
	
	/**
	 * 返回权限表(user_auth)中指定用户ID的领域对象
	 * @param id 用户ID
	 * @return
	 */
	public UserAuth getUserAuthById(int id) throws DataAccessException{
		return (UserAuth)commonDao.getObjectByInt(id,"getUserAuthById");
	}
	
	/**
	 * 返回权限表(user_auth)中指定用户名的领域对象
	 * @param username 用户名
	 * @return
	 */
	public UserAuth getUserAuthByUserName(String username) throws DataAccessException{
		return (UserAuth)commonDao.getObjectByString(username,"getUserAuthByUserName");
	}
	
	/**
	 * 返回权限表(user_auth)中指定用户名的id
	 * @param username 用户名
	 * @return
	 */
	public int getUserAuthIdByUserName(String username) throws DataAccessException{
		return commonDao.getIntByString(username,"getUserAuthIdByUserName");
	}
	
	/**
	 * 给DWR返回用户名是否存在
	 * @param username 待检测的用户名
	 * @return 如果存在，返回1；如果不存在，返回0
	 */
	public boolean isUserNameExistWithDWR(String username) throws DataAccessException{
		boolean isExist=false;
		UserAuth userAuth=(UserAuth)commonDao.getObjectByString(username,"getUserAuthByUserName");
		if(userAuth!=null){
			isExist=true;
		}
		return isExist;
	}
	
}
