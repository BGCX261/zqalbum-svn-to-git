package net.ziqiang.album.test;

import net.ziqiang.album.service.*;
import net.ziqiang.album.domain.album.*;
import java.util.List;

public class AlbumCategoryTest {
	public static void main(String[] args){
		AlbumCategoryService albumCategoryService=ServiceFactory.getAlbumCategoryService();
		List<AlbumCategory> category=albumCategoryService.getAlbumCategorys();
		for(AlbumCategory albumCategory:category){
			System.out.println(albumCategory.getName());
		}
	}

}
