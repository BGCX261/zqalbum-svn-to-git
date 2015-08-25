package net.ziqiang.album.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PassportServiceFactory {
	private static PassportService passportService;
	
	/**
	 * ʹ�ù���ģʽ���passportService
	 * @return passportService
	 */
	
	public static PassportService getPassportService(){
		ApplicationContext ac=new ClassPathXmlApplicationContext(new String[]{"/net/ziqiang/album/dao/ibatis/passport/conf/passport-dao.xml"});
		passportService=(PassportService)ac.getBean("passportService");
		return passportService;
	}
	
	//main��������
	/*public static void main(String[] argv){
		ApplicationContext ac=new ClassPathXmlApplicationContext(
				new String[]{"/net/ziqiang/comic/dao/ibatis/passport/conf/passport-dao.xml"});
		passportService=(PassportService)ac.getBean("passportService");
		System.out.println(passportService.getUserAuthIdByUsername("admin"));//����getUserAuthByUsername
		System.out.println(passportService.isUserNameExistWithDWR("yeshiquan"));//����isUserNameExistWithDWR
	}*/

}
