package com.myspring.spring.member;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/member")
public class MemberController {
	private MemberService memberService;

	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	// 멤버 등록
	@PostMapping(value = "/insert")
	public ResponseEntity<?> insertMember(@RequestBody MemberVO member) {
		memberService.insertMember(member);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(value="/updateMember")
	public ResponseEntity<?> updateMember(@RequestBody MemberVO member){
		return memberService.updateMember(member); 
	}
	

	// 전체 멤버 조회
	@GetMapping(value = "/getMemberAll")
	public ResponseEntity<?> getMemberAll(@Param("page") int page, @Param("perPage") int perPage) {
		return memberService.getMemberAll(page, perPage);
	}

	// 멤버 조회
	@GetMapping(value = "/getMembers")
	public ResponseEntity<?> getMembers(@RequestParam("condition") String condition,
			@RequestParam("param") Object param) {
		return memberService.getMembers(condition, param);
	}

}
