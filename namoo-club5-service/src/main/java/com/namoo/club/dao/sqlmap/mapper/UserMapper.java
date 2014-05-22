package com.namoo.club.dao.sqlmap.mapper;

import java.util.List;

import dom.entity.SocialPerson;

public interface UserMapper {
	//
	void insertUser(SocialPerson user);
	List<SocialPerson> selectAllUsers();
	SocialPerson selectUser(String email);
	void updateUser(SocialPerson user);
	void deleteUser(String email);
}
