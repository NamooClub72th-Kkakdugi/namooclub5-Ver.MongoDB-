package com.namoo.club.dao;

import java.util.List;

import dom.entity.ClubManager;
import dom.entity.ClubMember;
import dom.entity.CommunityManager;
import dom.entity.CommunityMember;

public interface MemberDao {
	//
	//community
	void addCommunityManager(CommunityManager comManager);
	void addCommunityMember(CommunityMember comMember);
	CommunityMember readCommunityMember(int comNo, String email);
	CommunityManager readCommunityManager(int comNo);
	List<CommunityMember> readAllCommunityMember(int comNo);
	void deleteCommunityMember(int comNo, String email);
	void updateCommunityManager(CommunityManager comManager);
	
	//club
	void addClubMember(ClubMember clubMember);
	void addClubManager(ClubManager clubManager);
	void deleteClubMember(int clubNo, String email);
	void deleteClubManager(int clubNo, String email);
	void updateClubManager(ClubManager clubManager);
	List<ClubMember> readAllClubMembers(int clubNo);
	List<ClubManager> readAllClubManagers(int clubNo);
	ClubMember readClubMember(int clubNo, String email); 
	ClubManager readClubManager(int clubNo, String email);
	ClubManager readClubKingManager(int clubNo);
}
