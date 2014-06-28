package tn.edu.esprit.cinfo2.tunRecrute.service.dao.interfaces;

import java.util.List;

import tn.edu.esprit.cinfo2.tunRecrute.domain.Member;

public interface IMember {

	public boolean addMember(Member member);

	public boolean deleteMember(int id);

	public boolean updateMember(int id, Member member);
	
	public List<Member> findAll();
	
	public Member findMemberById(int id);
}
