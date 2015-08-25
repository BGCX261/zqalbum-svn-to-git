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
		 * ͨ��ServletConfig�����ȡweb.xml�г�ʼ������
		 */
		sessionUserInfo=servletConfig.getInitParameter("sessionUserInfo");
		uploadPath=servletConfig.getInitParameter("uploadPath");
		maxFileSize=Long.parseLong(servletConfig.getInitParameter("maxFileSize"));
		allowedFilesList=servletConfig.getInitParameter("allowedFilesList");
		successView=request.getContextPath()+servletConfig.getInitParameter("successView");
		failureView=request.getContextPath()+servletConfig.getInitParameter("failureView");
		
		/**
		 * jspsmart���ʹ�ã��ϴ���Ƭ
		 */
		
		
		//����SmartUpload����
		SmartUpload smartUpload=new SmartUpload();
		//��ʼ������ServletConfig,HttpServletRequest,HttpServletResponse������Ϊ����
		
		smartUpload.initialize(servletConfig,request,response);
		//���������ϴ��ļ��Ĵ�С
		
		smartUpload.setMaxFileSize(maxFileSize);
		//�趨�����ϴ�����Ƭ���ļ�����
		smartUpload.setAllowedFilesList(allowedFilesList);
		try{
		//����form���ݿ�ʼ�ϴ�
		smartUpload.upload();
		//�洢��ָ��λ��
			smartUpload.save(uploadPath);
		}catch(Exception e){
			response.sendRedirect(failureView);
		}
		
		/**
		 * ��ȡ���������������ݿ����
		 */
		
		String fileName=null;
		String address=null;
		SmartFile myFile=smartUpload.getFiles().getFile(0);
		if(!myFile.isMissing()){
			 fileName=System.currentTimeMillis()+myFile.getFileName().hashCode()+"."+FileUtils.getFileNameSuffix(myFile.getFileName());
			 address=uploadPath+fileName;
		}
		//ֻ����SmartRequest��ȡ��������Request�����޷���ȡ����Ϊform���͵�MIME������multipart/form-data
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
		
		//����photo������ֵ
		Photo photo=new Photo();
		photo.setAlbumId(album.getAlbumId());
		photo.setDescription(description);
		photo.setPhotoName(photoName);
		photo.setCommentNum(0);
		photo.setHit(0);
		photo.setStatus(0);//0Ϊδ��ˣ�1Ϊ����ˣ�2Ϊ�Ƽ���Ʒ
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
