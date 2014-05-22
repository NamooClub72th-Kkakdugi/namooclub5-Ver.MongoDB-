package com.namoo.club.dao.sqlmap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.namoo.club.dao.ClubDao;
import com.namoo.club.dao.sqlmap.mapper.ClubMapper;

import dom.entity.Club;

@Repository
public class ClubDaoSqlMap implements ClubDao {

	@Autowired
	private ClubMapper clubMapper;
	
	@Override
	public List<Club> readAllClubsByComNo(int comNo) {
		// 
		List<Club> clubs = clubMapper.selectAllClubsByComNo(comNo);
		return clubs;
	}
	
	@Override
	public List<Club> readAllClubs() {
		// 
		List<Club> clubs = clubMapper.selectAllClubs();
		return clubs;
	}

	@Override
	public Club readClub(int clubNo) {
		// 
		Club club = clubMapper.selectClub(clubNo);
		return club;
	}

	@Override
	public int createClub(Club club) {
		// 
		clubMapper.insertClub(club);
		return club.getClubNo();
	}

	@Override
	public void updateClub(Club club) {
		// 
		clubMapper.updateClub(club);

	}

	@Override
	public void deleteClub(int clubNo) {
		// 
		clubMapper.deleteClub(clubNo);
	}
}
