package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Member;
import com.example.service.MemberService;

@RestController
@RequestMapping(value="/member")
public class MemberController 
{

	@Autowired
	private MemberService memberService;
	
	@GetMapping
	public List<Member> getAllMembers()
	{
		return memberService.getAllMembers();
	}
	
	@GetMapping("/{id}")
	public Member getMemberById(@PathVariable(name = "id") int id)
	{
		return memberService.getMemberById(id);
	}
	
	@PostMapping("/addnewMember")
	public Member addnewMember(@RequestBody Member member)
	{
		return memberService.addnewMember(member);
	}

	@PutMapping("/{id}")
	public Member updateMember(@PathVariable(name = "id") int id,@RequestBody Member member)
	{
		return memberService.updateMember(id, member);
	}
	
	@DeleteMapping("/{id}")
	public String deleteMember(@PathVariable(name = "id") int id)
	{
		return memberService.deleteMember(id);
	}
}
