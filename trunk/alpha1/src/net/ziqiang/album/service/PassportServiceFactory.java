package net.ziqiang.album.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PassportServiceFactory {
	private static PassportService passportService;
	
	/**
	 * 使用工厂模式获得passportService
	 * @return passportService
	 */
	
	public static PassportService getPassportService(){
		ApplicationContext ac=new ClassPathXmlApplicationContext(new String[]{"/net/ziqiang/album/dao/ibatis/passport/conf/passport-dao.xml"});
		passportService=(PassportService)ac.getBean("passportService");
		return passportService;
	}
	
	//main方法测试
	/*public static void main(String[] argv){
		ApplicationContext ac=new ClassPathXmlApplicationContext(
				new String[]{"/net/ziqiang/comic/dao/ibatis/passport/conf/passport-dao.xml"});
		passportService=(PassportService)ac.getBean("passportService");
		System.out.println(passportService.getUserAuthIdByUsername("admin"));//测试getUserAuthByUsername
		System.out.println(passportService.isUserNameExistWithDWR("yeshiquan"));//测试isUserNameExistWithDWR
	}*/

}
