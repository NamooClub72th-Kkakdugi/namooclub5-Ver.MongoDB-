package com.namoo.club.dao.sqlmap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.namoo.club.dao.CommunityDao;
import com.namoo.club.dao.sqlmap.mapper.CommunityMapper;

import dom.entity.ClubCategory;
import dom.entity.Community;

@Repository
public class CommunityDaoSqlMap implements CommunityDao {
	
	@Autowired
	private CommunityMapper communityMapper;
	
	@Override
	public List<Community> readAllCommunities() {
		// 
		List<Community> communities	= communityMapper.selectAllCommunities();
		return communities;
	}

	@Override
	public Community readCommunity(int comNo) {
		// 
		Community community = communityMapper.selectCommunity(comNo);
		return community;
	}

	@Override
	public int createCommunity(Community community) {
		//
		communityMapper.insertCommunity(community);
		return community.getComNo();
	}

	@Override
	public void updateCommunity(Community community) {
		//
		communityMapper.updateCommunity(community);
	}

	@Override
	public void deleteCommunity(int comNo) {
		// 
		communityMapper.deleteCommunity(comNo);

	}

	@Override
	public List<ClubCategory> readAllCategories(int comNo) {
		//
		List<ClubCategory> categories = communityMapper.selectAllCategories(comNo);
		return categories;
	}

	@Override
	public void createClubCategory(ClubCategory category) {
		//
		communityMapper.insertClubCategory(category);
	}

	@Override
	public void deleteAllClubCategory(int comNo) {
		//
		communityMapper.deleteAllCategories(comNo);
	}

}
