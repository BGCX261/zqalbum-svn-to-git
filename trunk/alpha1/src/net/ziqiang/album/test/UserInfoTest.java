package net.ziqiang.album.test;

import net.ziqiang.album.service.*;
import net.ziqiang.album.domain.album.*;

public class UserInfoTest {
	public static void main(String[] args){
		UserInfo userInfo=new UserInfo();
		userInfo.setUserName("¡ı«‡∑Â");
		userInfo.setAlbumNum(0);
		userInfo.setRank(0);
		userInfo.setPrivilege("read");
		if(ServiceFactory.getUserInfoService().insertUserInfo(userInfo)){
		System.out.println("success");
		}
		else{
			System.out.println("failure");
		}
	}
}
