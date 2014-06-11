package com.namoo.club.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import com.namoo.club.shared.BaseMongoTestCase;

import dom.entity.ClubManager;
import dom.entity.ClubMember;
import dom.entity.CommunityManager;
import dom.entity.CommunityMember;
import dom.entity.SocialPerson;

@UsingDataSet(locations="/com/namoo/club/dao/clubs.json", loadStrategy=LoadStrategyEnum.CLEAN_INSERT)
public class MemberDaoTest extends BaseMongoTestCase{
	//
	@Autowired
	private MemberDao dao;
	@Autowired
	private UserDao userDao;

	//-------------------------------------------------------------------------
	@Test
	public void testAddCommunityManager() {
		//
		CommunityManager comManager = new CommunityManager(2, new SocialPerson("wntjd@naver.com", "이주성"));
		dao.addCommunityManager(comManager);
		//검증
		CommunityManager manager = dao.readCommunityManager(2);
		assertEquals("wntjd@naver.com",manager.getEmail());
		assertEquals("이주성", manager.getName());
	}

	@Test
	public void testAddCommunityMember() {
		//
		CommunityMember comMember = new CommunityMember(1, new SocialPerson("ekdgml@naver.com", "박상희"));
		dao.addCommunityMember(comMember);
		//검증
		assertEquals("ekdgml@naver.com", dao.readCommunityMember(1, "ekdgml@naver.com").getEmail());
		assertEquals("박상희", dao.readCommunityMember(1, "ekdgml@naver.com").getName());
	}

	@Test
	public void testReadCommunityMember() {
		//
		CommunityMember comMember = dao.readCommunityMember(1, "wntjd@naver.com");
		//검증
		assertEquals("1234", comMember.getRolePerson().getPassword());
		assertEquals("이주성", comMember.getName());
	}

	@Test
	public void testReadCommunityManager() {
		//
		CommunityManager comManager = dao.readCommunityManager(1);
		//검증
		assertEquals("이주성", comManager.getName());
	}

	@Test
	public void testReadAllCommunityMember() {
		//
		assertEquals(1, dao.readAllCommunityMember(1).size());
	}

	@Test
	public void testDeleteCommuninyMember() {
		//
		dao.deleteCommunityMember(1, "hong@naver.com");
		assertEquals(1, dao.readAllCommunityMember(1).size());
	}
	
	@Test
	public void testUpdateCommunityManager() {
		//
		SocialPerson user = userDao.readUser("ekdgml@naver.com");
		CommunityManager comManager = new CommunityManager(1, user);
		dao.updateCommunityManager(comManager);
		
		//assertion
		assertEquals("ekdgml@naver.com", dao.readCommunityManager(1).getEmail());
		assertEquals("박상희", dao.readCommunityManager(1).getName());
	}

	@Test
	public void testAddClubMember() {
		//
		ClubMember clubMember = new ClubMember(2, new SocialPerson("wntjd@naver.com", "이주성"));
		dao.addClubMember(clubMember);
		//검증
		clubMember = dao.readClubMember(2, "wntjd@naver.com");
		assertEquals("이주성", clubMember.getName());
	}

	@Test
	public void testAddClubManager() {
		//
		ClubManager clubManager = new ClubManager(2, new SocialPerson("wntjd@naver.com", "이주성"), false);
		dao.addClubManager(clubManager);
		//검증
		assertEquals("이주성", dao.readClubManager(2, "wntjd@naver.com").getName());
	}

	@Test
	public void testAddClubManager_ForKing() {
		//
		ClubManager clubKingManager = new ClubManager(2, new SocialPerson("wntjd@naver.com", "이주성"), true);
		dao.addClubManager(clubKingManager);
		//검증
		assertEquals("이주성", dao.readClubKingManager(2).getName());
	}

	@Test
	public void testDeleteClubMember() {
		//
		dao.readAllClubMembers(1);
		dao.deleteClubMember(1, "wntjd@naver.com");
		//검증
		assertEquals(2, dao.readAllClubMembers(1).size());
	}

	@Test
	public void testDeleteClubManager() {
		//
		dao.deleteClubManager(1, "hong@naver.com");
		//검증
		assertEquals(1, dao.readAllClubManagers(1).size());
	}

	@Test
	public void testReadAllClubMembers() {
		//
		List<ClubMember> results = dao.readAllClubMembers(1);
		assertEquals(3, results.size());
	}

	@Test
	public void testReadAllClubManagers() {
		//
		assertEquals(2, dao.readAllClubManagers(1).size());
	}

	@Test
	public void testReadClubMember() {
		//
		ClubMember clubMember = dao.readClubMember(1, "ekdgml@naver.com");
		assertEquals("박상희", clubMember.getName());
	}

	@Test
	public void testReadClubManager() {
		//
		ClubManager clubManager = dao.readClubManager(1, "hong@naver.com");
		assertEquals("홍길동", clubManager.getName());
	}

	@Test
	public void testReadClubKingManager() {
		//
		ClubManager clubKingManager = dao.readClubKingManager(1);
		assertEquals("박상희", clubKingManager.getName());
	}

}
