package com.namoo.club.dao.sqlmap.mapper;

import java.util.List;

import dom.entity.ClubCategory;
import dom.entity.Community;

public interface CommunityMapper {
	//
	//Community
	void insertCommunity(Community community);
	List<Community> selectAllCommunities();
	Community selectCommunity(int comNo);
	void updateCommunity(Community community);
	void deleteCommunity(int comNo);
	
	//ClubCategory
	void insertClubCategory(ClubCategory category);
	List<ClubCategory> selectAllCategories(int comNo);
	void deleteAllCategories(int comNo);
}
