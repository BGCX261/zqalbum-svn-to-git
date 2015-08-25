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
	 * ����Ȩ�ޱ�(user_auth)��ָ���û�ID���������
	 * @param id �û�ID
	 * @return
	 */
	public UserAuth getUserAuthById(int id) throws DataAccessException{
		return (UserAuth)commonDao.getObjectByInt(id,"getUserAuthById");
	}
	
	/**
	 * ����Ȩ�ޱ�(user_auth)��ָ���û������������
	 * @param username �û���
	 * @return
	 */
	public UserAuth getUserAuthByUserName(String username) throws DataAccessException{
		return (UserAuth)commonDao.getObjectByString(username,"getUserAuthByUserName");
	}
	
	/**
	 * ����Ȩ�ޱ�(user_auth)��ָ���û�����id
	 * @param username �û���
	 * @return
	 */
	public int getUserAuthIdByUserName(String username) throws DataAccessException{
		return commonDao.getIntByString(username,"getUserAuthIdByUserName");
	}
	
	/**
	 * ��DWR�����û����Ƿ����
	 * @param username �������û���
	 * @return ������ڣ�����1����������ڣ�����0
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
