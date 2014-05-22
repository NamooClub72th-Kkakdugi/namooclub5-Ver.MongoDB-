package com.namoo.club.dao.sqlmap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.namoo.club.dao.UserDao;
import com.namoo.club.dao.sqlmap.mapper.UserMapper;

import dom.entity.SocialPerson;

@Repository
public class UserDaoSqlMap implements UserDao {
	//
	@Autowired
	private UserMapper mapper;
	
	@Override
	public List<SocialPerson> readAllUsers() {
		//
		return mapper.selectAllUsers();
	}

	@Override
	public SocialPerson readUser(String email) {
		//
		return mapper.selectUser(email);
	}

	@Override
	public void createUser(SocialPerson user) {
		//
		mapper.insertUser(user);
	}

	@Override
	public void updateUser(SocialPerson user) {
		//
		mapper.updateUser(user);
	}

	@Override
	public void deleteUser(String email) {
		//
		mapper.deleteUser(email);
	}

}
