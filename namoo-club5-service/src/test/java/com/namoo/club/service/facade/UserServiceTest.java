package com.namoo.club.service.facade;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import com.namoo.club.shared.BaseMongoTestCase;

import dom.entity.SocialPerson;

@UsingDataSet(locations="/com/namoo/club/service/facade/users.json", loadStrategy=LoadStrategyEnum.CLEAN_INSERT)
public class UserServiceTest extends BaseMongoTestCase{
	//
	@Autowired
	private UserService service;
	
	//-------------------------------------------------------------------------
	@Test
	public void testLoginAsTowner() {
		boolean login = service.loginAsTowner("ekdgml@naver.com", "asdf");
//		boolean login2 = service.loginAsTowner("wntjd", "qwer");
		
		assertEquals(true, login);
//		assertEquals(true, login2);
	}

	@Test
	public void testRegistTowner() {
		//
		service.registTowner("박상희2", "ekdgml2", "asdf2");
		
		SocialPerson user = service.findTowner("ekdgml2");
		assertEquals("asdf2", user.getPassword());
		assertEquals("박상희2", user.getName());
		assertEquals("ekdgml2", user.getEmail());
	}

	@Test
	public void testFindAllTowner() {
		//
		List<SocialPerson> users = service.findAllTowner();
		
		assertEquals(3, users.size());
	}
}
