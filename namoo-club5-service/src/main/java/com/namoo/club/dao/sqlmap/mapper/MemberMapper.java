package com.namoo.club.dao.sqlmap.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import dom.entity.ClubManager;
import dom.entity.ClubMember;
import dom.entity.CommunityManager;
import dom.entity.CommunityMember;

public interface MemberMapper {
	//
	//community
	void insertCommunityMember(CommunityMember comMember);
	void insertCommunityManager(CommunityManager comManager);
	
	CommunityMember selectCommunityMember(@Param("communityNo") int comNo, @Param("email") String email);
	CommunityManager selectCommunityManager(int communityNo);
	List<CommunityMember> selectAllCommunityMembers(int communityNo);
	
	void deleteAllCommunityMembers(int communityNo);
	void delteCommunityMember(@Param("communityNo") int comNo, @Param("email") String email);
	void delteCommunityManager(int comNo);
	
	//club
	void insertClubMember(ClubMember clubMember);
	void insertClubManager(ClubManager clubManager);
	
	List<ClubMember> selectAllClubMembers(int clubNo);
	List<ClubManager> selectAllClubManagers(int clubNo);
	ClubMember selectClubMember(@Param("clubNo") int clubNo, @Param("email") String email);
	ClubManager selectClubManager(@Param("clubNo") int clubNo, @Param("email") String email);
	ClubManager selectClubKingManager(int clubNo);
	
	void delteAllClubMembers(int clubNo);
	void delteAllClubManagers(int clubNo);
	void deleteClubMember(@Param("clubNo") int clubNo, @Param("email") String email);
	void deleteClubManager(@Param("clubNo") int clubNo, @Param("email") String email);
	void deleteClubKingManager(int clubNo);
}
