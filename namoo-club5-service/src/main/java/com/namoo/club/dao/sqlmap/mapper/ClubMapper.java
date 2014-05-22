package com.namoo.club.dao.sqlmap.mapper;

import java.util.List;

import dom.entity.Club;

public interface ClubMapper {
	//
	List<Club> selectAllClubsByComNo(int comNo);
	List<Club> selectAllClubs();
	Club selectClub(int clubNo);
	void insertClub(Club club);
	void updateClub(Club club);
	void deleteClub(int clubNo);
}
