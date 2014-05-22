package com.namoo.club.dao;

import java.util.List;

import dom.entity.Club;

public interface ClubDao {
	//
	List<Club> readAllClubsByComNo(int comNo);
	List<Club> readAllClubs();
	Club readClub(int clubNo);
	int createClub(Club club);
	void updateClub(Club club);
	void deleteClub(int clubNo);
}
