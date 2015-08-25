package net.ziqiang.album.service;

import net.ziqiang.album.dao.ibatis.CommonDaoGenericImpl;
import net.ziqiang.album.domain.album.*;

public class CommentService {
	private CommonDaoGenericImpl commonDao;

	public CommonDaoGenericImpl getCommonDao() {
		return commonDao;
	}

	public void setCommonDao(CommonDaoGenericImpl commonDao) {
		this.commonDao = commonDao;
	}
	
	public boolean insertComment(Comment comment){
		return commonDao.insertByParameter(comment,"insertComment");
	}
	
	public boolean deleteComment(Comment comment){
		return commonDao.deleteByParameter(comment,"deleteComment");
	}
	
	public int getCommentCountByPhotoId(int photoId){
		return commonDao.getByParameter(photoId,"getCommentCountByPhotoId");
	}
	
	
}
