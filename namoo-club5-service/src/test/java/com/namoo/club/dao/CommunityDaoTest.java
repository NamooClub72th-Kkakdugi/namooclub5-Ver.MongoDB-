package com.namoo.club.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseSetup;

import dom.entity.ClubCategory;
import dom.entity.Community;

public class CommunityDaoTest extends DbCommonTest {
	//
	private static final String DATASET_XML="CommunityDaoTest_dataset.xml";
	
	@Autowired
	private CommunityDao dao;
	
	@Autowired
	private UserDao userDao;
	
	//-------------------------------------------
	@Test
	@DatabaseSetup(DATASET_XML)
	public void testReadAllCommunities() {
		//
		assertEquals(2, dao.readAllCommunities().size());
	}
	@Test
	@DatabaseSetup(DATASET_XML)
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
	@DatabaseSetup(DATASET_XML)
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
	@DatabaseSetup(DATASET_XML)
	public void testDeleteCommunity() {
		//
		dao.deleteCommunity(2);
		//검증
		assertEquals(1, dao.readAllCommunities().size());
	}
	
	
	@Test
	@DatabaseSetup(DATASET_XML)
	public void testReadAllCategories() {
		//
		assertEquals(2, dao.readAllCategories(1).size());
	}
	
	@Test
	@DatabaseSetup(DATASET_XML)
	public void testCreateClubCategory() {
		//
		ClubCategory category = new ClubCategory(2, 2, "category2");
		dao.createClubCategory(category);
		//검증
		assertEquals(2, dao.readAllCategories(2).size());
	}
	
	@Test
	@DatabaseSetup(DATASET_XML)
	public void testDeleteAllClubCategory() {
		//
		dao.deleteAllClubCategory(2);
		assertEquals(0, dao.readAllCategories(2).size());
	}
}
