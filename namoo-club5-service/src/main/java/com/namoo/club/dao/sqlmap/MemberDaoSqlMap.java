package com.namoo.club.dao.sqlmap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.namoo.club.dao.MemberDao;
import com.namoo.club.dao.sqlmap.mapper.MemberMapper;

import dom.entity.ClubManager;
import dom.entity.ClubMember;
import dom.entity.CommunityManager;
import dom.entity.CommunityMember;

@Repository
public class MemberDaoSqlMap implements MemberDao {
	//
	@Autowired
	private MemberMapper mapper;
	
	@Override
	public void addCommunityManager(CommunityManager comManager) {
		//
		mapper.insertCommunityManager(comManager);
	}

	@Override
	public void addCommunityMember(CommunityMember comMember) {
		//
		mapper.insertCommunityMember(comMember);
	}

	@Override
	public CommunityMember readCommunityMember(int comNo, String email) {
		//
		return mapper.selectCommunityMember(comNo, email);
	}

	@Override
	public CommunityManager readCommunityManager(int comNo) {
		//
		return mapper.selectCommunityManager(comNo);
	}

	@Override
	public List<CommunityMember> readAllCommunityMember(int comNo) {
		//
		return mapper.selectAllCommunityMembers(comNo);
	}

	@Override
	public void deleteAllComMember(int comNo) {
		//
		mapper.deleteAllCommunityMembers(comNo);
	}

	@Override
	public void deleteCommuninyMember(int comNo, String email) {
		//
		mapper.delteCommunityMember(comNo, email);
	}

	@Override
	public void deleteCommunityManager(int comNo) {
		//
		mapper.delteCommunityManager(comNo);
	}

	@Override
	public void addClubMember(ClubMember clubMember) {
		//
		mapper.insertClubMember(clubMember);
	}

	@Override
	public void addClubManager(ClubManager clubManager) {
		//
		mapper.insertClubManager(clubManager);
	}

	@Override
	public void deleteAllClubMember(int clubNo) {
		//
		mapper.delteAllClubMembers(clubNo);
	}

	@Override
	public void deleteAllClubManager(int clubNo) {
		//
		mapper.delteAllClubManagers(clubNo);
	}

	@Override
	public void deleteClubMember(int clubNo, String email) {
		//
		mapper.deleteClubMember(clubNo, email);
	}

	@Override
	public void deleteClubManager(int clubNo, String email) {
		//
		mapper.deleteClubManager(clubNo, email);
	}

	@Override
	public void deleteClubKingManager(int clubNo) {
		//
		mapper.deleteClubKingManager(clubNo);
	}

	@Override
	public List<ClubMember> readAllClubMembers(int clubNo) {
		//
		return mapper.selectAllClubMembers(clubNo);
	}

	@Override
	public List<ClubManager> readAllClubManagers(int clubNo) {
		//
		return mapper.selectAllClubManagers(clubNo);
	}

	@Override
	public ClubMember readClubMember(int clubNo, String email) {
		//
		return mapper.selectClubMember(clubNo, email);
	}

	@Override
	public ClubManager readClubManager(int clubNo, String email) {
		//
		return mapper.selectClubManager(clubNo, email);
	}

	@Override
	public ClubManager readClubKingManager(int clubNo) {
		//
		return mapper.selectClubKingManager(clubNo);
	}

}
