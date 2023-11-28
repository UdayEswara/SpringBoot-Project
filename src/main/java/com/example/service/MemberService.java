package com.example.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exceptions.NotFoundException;
import com.example.model.Member;
import com.example.repository.MemberRepository;

@Service
public class MemberService 
{

	@Autowired
	private MemberRepository memberRepository;
	
	public List<Member> getAllMembers()
	{
		return memberRepository.findAll();
	}
	
	public Member getMemberById(int id)
	{
		Member member = memberRepository.findById(id).orElseThrow(() -> new NotFoundException("Member id "+id+" does not exist."));
		return member;
	}
	
	public Member addnewMember(Member member)
	{
		member.setJoiningDate(new Date());
		return memberRepository.save(member);
	}
	
	public Member updateMember(int id,Member member)
	{
		Member memberDetails = memberRepository.findById(id).orElseThrow(() -> new NotFoundException("Member id "+id+" does not exist."));
		
		if(member.getName()!=null)
			memberDetails.setName(member.getName());
		if(member.getEmail()!=null)
			memberDetails.setEmail(member.getEmail());
		if(member.getContact()!=null)
			memberDetails.setContact(member.getContact());
		
		Member updateMember = memberRepository.save(memberDetails);
		
		return updateMember;
	}
	
	public String deleteMember(int id)
	{
		Member member = memberRepository.findById(id).orElseThrow(() -> new NotFoundException("Member id "+id+" does not exist."));
		String memberName = member.getName();
		memberRepository.delete(member);
		
		return memberName+" is deleted";
	}
	
}
