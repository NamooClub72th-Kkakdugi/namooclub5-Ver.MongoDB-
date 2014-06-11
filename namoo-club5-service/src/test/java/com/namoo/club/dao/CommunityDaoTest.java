package com.namoo.club.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import com.namoo.club.shared.BaseMongoTestCase;

import dom.entity.ClubCategory;
import dom.entity.Community;

@UsingDataSet(locations="/com/namoo/club/dao/communities.json", loadStrategy=LoadStrategyEnum.CLEAN_INSERT)
public class CommunityDaoTest extends BaseMongoTestCase{
	//
	@Autowired
	private CommunityDao dao;
	
	//-------------------------------------------
	@Test
	public void testReadAllCommunities() {
		//
		assertEquals(2, dao.readAllCommunities().size());
	}
	@Test
	public void testCreateCommunity() {
		//
		Community community = new Community();
		community.setName("test");
		community.setDescription("testDes");
		int comNo = dao.createCommunity(community);
		
		//검증
		community = dao.readCommunity(comNo);
		assertEquals("test", community.getName());
		assertEquals("testDes", community.getDescription());
	}

	@Test
	public void testUpdateCommunity() {
		//
		Community community = dao.readCommunity(1);
		community.setName("com1_test");
		community.setDescription("com1_des_test");
		dao.updateCommunity(community);
		
		//검증
		community = dao.readCommunity(1);
		assertEquals("com1_test", community.getName());
		assertEquals("com1_des_test", community.getDescription());
	}
	
	@Test
	public void testDeleteCommunity() {
		//
		dao.deleteCommunity(2);
		//검증
		assertEquals(1, dao.readAllCommunities().size());
	}
	
	
	@Test
	public void testReadAllCategories() {
		//
		assertEquals(2, dao.readAllCategories(1).size());
	}
	
	@Test
	public void testCreateClubCategory() {
		//
		List<ClubCategory> categories = new ArrayList<ClubCategory>();
		for(int i = 1; i < 7 ; i++) {
			ClubCategory category = new ClubCategory(i, 2, "category"+i);
			categories.add(category);
		}
		//ClubCategory category = new ClubCategory(2, 2, "category2");
		dao.insertClubCategory(categories);
		//검증
		assertEquals(6, dao.readAllCategories(2).size());
	}
	
//	@Test
//	public void testDeleteAllClubCategory() {
//		//
//		dao.deleteAllClubCategory(2);
//		assertEquals(0, dao.readAllCategories(2).size());
//	}
}
