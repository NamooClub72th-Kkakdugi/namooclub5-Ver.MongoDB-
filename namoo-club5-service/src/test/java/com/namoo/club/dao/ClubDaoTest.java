package com.namoo.club.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import com.namoo.club.shared.BaseMongoTestCase;

import dom.entity.Club;
import dom.entity.SocialPerson;

@UsingDataSet(locations="/com/namoo/club/dao/clubs.json", loadStrategy=LoadStrategyEnum.CLEAN_INSERT)
public class ClubDaoTest extends BaseMongoTestCase {
	//
	@Autowired
	private ClubDao dao;
	
	//-----------------------------------------
	@Test
	public void testReadAllClubs() {
		//
		assertEquals(4, dao.readAllClubsByComNo(1).size());
	}

	@Test
	public void testReadClub() {
		//
		Club club = dao.readClub(1);
		
		assertEquals(1, club.getCategoryNo());
		assertEquals("club1_des", club.getDescription());
		assertEquals("club1", club.getName());
	}

	@Test
	public void testCreateClub() {
		//
		Club club = new Club(1, 1, "club_5", "club_5_des", new SocialPerson("ekdgml", "박상희"));
		int clubNo = dao.createClub(club);
		//검증
		club = dao.readClub(clubNo);
		assertEquals(1, club.getCategoryNo());
		assertEquals(1, club.getComNo());
		assertEquals("club_5", club.getName());
		assertEquals("club_5_des", club.getDescription());
	}

	@Test
	public void testUpdateClub() {
		//
		Club club = dao.readClub(2);
		club.setName("club_2_test");
		club.setDescription("club_2_des_test");
		dao.updateClub(club);
		//검증
		club = dao.readClub(2);
		assertEquals("club_2_test", club.getName());
		assertEquals("club_2_des_test", club.getDescription());
	}

	@Test
	public void testDeleteClub() {
		//
		dao.deleteClub(1);
		assertEquals(3, dao.readAllClubsByComNo(1).size());
	}
}
