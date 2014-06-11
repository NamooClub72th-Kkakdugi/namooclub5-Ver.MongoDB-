package com.namoo.club.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;

import dom.entity.SocialPerson;
import com.namoo.club.shared.BaseMongoTestCase;

@UsingDataSet(locations="/com/namoo/club/dao/users.json", loadStrategy=LoadStrategyEnum.CLEAN_INSERT)
public class UserDaoTest extends BaseMongoTestCase{
	//
	@Autowired
	private UserDao dao;
	
	@Test
	public void testReadAllUsers() {
		//
		assertEquals(3, dao.readAllUsers().size());
	}

	@Test
	public void testCreateUser() {
		//
		SocialPerson user = new SocialPerson("abcd", "abcd@a.a", "abcd");
		dao.createUser(user);
		
		//검증
		user = dao.readUser("abcd@a.a");
		assertEquals("abcd", user.getPassword());
		assertEquals("abcd", user.getName());
		assertEquals("abcd@a.a", user.getEmail());
	}

	@Test
	public void testUpdateUser() {
		//
		SocialPerson user = dao.readUser("ekdgml");
		user.setPassword("asdfasdf");
		dao.updateUser(user);
		//검증
		user = dao.readUser("ekdgml");
		assertEquals("asdfasdf", user.getPassword());
	}

}
