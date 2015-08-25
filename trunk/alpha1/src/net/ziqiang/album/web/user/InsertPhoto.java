package net.ziqiang.album.web.user;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;

import java.io.IOException;

import com.jspsmart.upload.*;

import com.littleqworks.commons.util.DateTimeUtils;
import com.littleqworks.commons.file.util.FileUtils;

import net.ziqiang.album.domain.album.UserInfo;
import net.ziqiang.album.domain.album.Album;
import net.ziqiang.album.domain.album.Photo;
import net.ziqiang.album.service.AlbumService;
import net.ziqiang.album.service.ServiceFactory;
import net.ziqiang.album.service.PhotoService;

public class InsertPhoto extends HttpServlet{
	private static final long serialVersionUID=0L;
	private ServletConfig servletConfig=null;
	private String sessionUserInfo=null;
	private String successView=null;
	private String failureView=null;
	private String uploadPath=null;
	private long maxFileSize=0l;
	private String allowedFilesList=null;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		/**
		 * 通过ServletConfig对象获取web.xml中初始化参数
		 */
		sessionUserInfo=servletConfig.getInitParameter("sessionUserInfo");
		uploadPath=servletConfig.getInitParameter("uploadPath");
		maxFileSize=Long.parseLong(servletConfig.getInitParameter("maxFileSize"));
		allowedFilesList=servletConfig.getInitParameter("allowedFilesList");
		successView=request.getContextPath()+servletConfig.getInitParameter("successView");
		failureView=request.getContextPath()+servletConfig.getInitParameter("failureView");
		
		/**
		 * jspsmart组件使用，上传照片
		 */
		
		
		//创建SmartUpload对象
		SmartUpload smartUpload=new SmartUpload();
		//初始化，以ServletConfig,HttpServletRequest,HttpServletResponse对象作为参数
		
		smartUpload.initialize(servletConfig,request,response);
		//声明限制上传文件的大小
		
		smartUpload.setMaxFileSize(maxFileSize);
		//设定允许上传的照片的文件类型
		smartUpload.setAllowedFilesList(allowedFilesList);
		try{
		//依据form内容开始上传
		smartUpload.upload();
		//存储到指定位置
			smartUpload.save(uploadPath);
		}catch(Exception e){
			response.sendRedirect(failureView);
		}
		
		/**
		 * 获取参数，并进行数据库操作
		 */
		
		String fileName=null;
		String address=null;
		SmartFile myFile=smartUpload.getFiles().getFile(0);
		if(!myFile.isMissing()){
			 fileName=System.currentTimeMillis()+myFile.getFileName().hashCode()+"."+FileUtils.getFileNameSuffix(myFile.getFileName());
			 address=uploadPath+fileName;
		}
		//只能用SmartRequest获取参数，而Request对象无法获取，因为form传送的MIME类型是multipart/form-data
		SmartRequest smartRequest=smartUpload.getRequest();
		String successMsg=null;
		String albumName=smartRequest.getParameter("albumName");
		String photoName=smartRequest.getParameter("photoName");
		String description=smartRequest.getParameter("contents");
		String uploadTime=DateTimeUtils.getTimestamp();
		
		HttpSession session=request.getSession();
		UserInfo userInfo=(UserInfo)session.getAttribute(sessionUserInfo);
		int userId=userInfo.getUserId();
		AlbumService albumService=ServiceFactory.getAlbumService();
		Album album=albumService.getAlbumByNameUserId(albumName,userId);
		
		//设置photo的属性值
		Photo photo=new Photo();
		photo.setAlbumId(album.getAlbumId());
		photo.setDescription(description);
		photo.setPhotoName(photoName);
		photo.setCommentNum(0);
		photo.setHit(0);
		photo.setStatus(0);//0为未审核，1为已审核，2为推荐精品
		photo.setUploadTime(uploadTime);
		photo.setAddress(address);
		
		PhotoService photoService=ServiceFactory.getPhotoService();
		int photoNum=album.getPhotoNum();
		int albumId=album.getAlbumId();
		String updateTime=album.getUpdateTime();
		updateTime=DateTimeUtils.getTimestamp();
		photoNum=photoNum+1;
		
		if(photoService.insertPhoto(photo)&&albumService.updateAlbumPhotoNum(photoNum, albumId)&&albumService.updateAlbumUpdateTime(updateTime, albumId)){
			successMsg="upload_success";
			response.sendRedirect(successView+"?successMsg="+successMsg+"&albumId="+albumId);
			return;
		}
		else{
			response.sendRedirect(failureView);
			return;
		}	
	}
	
	public void init(ServletConfig servletConfig)throws ServletException{
		this.servletConfig=servletConfig;
	}
}
