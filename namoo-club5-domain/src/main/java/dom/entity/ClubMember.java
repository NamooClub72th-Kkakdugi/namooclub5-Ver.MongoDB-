package dom.entity;


public class ClubMember {

	//private String uid;
	private int clubNo;
	private SocialPerson rolePerson;
	
	//--------------------------------------------------------------------------
	
	public ClubMember() {
		//
	}
	
	public ClubMember(int clubNo) {
		//
		this.clubNo = clubNo;
	}
	
	public ClubMember(int clubNo, SocialPerson rolePerson) {
		//
		this.clubNo = clubNo;
		this.rolePerson = rolePerson;
	}
	
	//---------------------------------------------------------------------------
	
	public String getName() {
		return rolePerson.getName();
	}
	
//	public String getUid() {
//		return uid;
//	}
//
//	public void setUid(String uid) {
//		this.uid = uid;
//	}

	public String getEmail() {
		return rolePerson.getEmail();
	}

	public int getClubNo() {
		return clubNo;
	}

	public void setClubNo(int clubNo) {
		this.clubNo = clubNo;
	}

	public SocialPerson getRolePerson() {
		return rolePerson;
	}

	public void setRolePerson(SocialPerson rolePerson) {
		this.rolePerson = rolePerson;
	}
}
