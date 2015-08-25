package net.ziqiang.album.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceFactory {
	private static CommentService commentService;
	private static UserInfoService userInfoService;
	private static AlbumService albumService;
	private static AlbumCategoryService albumCategoryService;
	private static PhotoService photoService;
	
	public static CommentService getCommentService(){
		ApplicationContext ac=new ClassPathXmlApplicationContext(new String[]{"/net/ziqiang/album/dao/ibatis/album/conf/album-dao.xml"});
		commentService=(CommentService)ac.getBean("commentService");
		return commentService;
	}
	
	public static UserInfoService getUserInfoService(){
		ApplicationContext ac=new ClassPathXmlApplicationContext(new String[]{"/net/ziqiang/album/dao/ibatis/album/conf/album-dao.xml"});
		userInfoService=(UserInfoService)ac.getBean("userInfoService");
		return userInfoService;
	}
	
	public static AlbumService getAlbumService(){
		ApplicationContext ac=new ClassPathXmlApplicationContext(new String[]{"/net/ziqiang/album/dao/ibatis/album/conf/album-dao.xml"});
		albumService=(AlbumService)ac.getBean("albumService");
		return albumService;
	}
	
	public static AlbumCategoryService getAlbumCategoryService(){
		ApplicationContext ac=new ClassPathXmlApplicationContext(new String[]{"/net/ziqiang/album/dao/ibatis/album/conf/album-dao.xml"});
		albumCategoryService=(AlbumCategoryService)ac.getBean("albumCategoryService");
		return albumCategoryService;
	}
	
	public static PhotoService getPhotoService(){
		ApplicationContext ac=new ClassPathXmlApplicationContext(new String[]{"/net/ziqiang/album/dao/ibatis/album/conf/album-dao.xml"});
		photoService=(PhotoService)ac.getBean("photoService");
		return photoService;
	}
}
