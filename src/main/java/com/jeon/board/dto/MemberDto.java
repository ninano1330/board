package com.jeon.board.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class MemberDto {
	private int memberNo;
	
	@NotBlank(message = "아이디를 입력해주세요.")
	private String memberId;
	
	@NotNull(message = "비밀번호를 입력해주세요.")
	private String memberPw;
	
	@NotBlank(message = "이름을 입력해주세요.")
	private String memberName;
	
	private Date memberJoinDate;
	private int memberGrade;
	private String memberPhone;
	private String memberEmail;
	
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPwd) {
		this.memberPw = memberPwd;
	}
	public Date getMemberJoinDate() {
		return memberJoinDate;
	}
	public void setMemberJoinDate(Date memberJoinDate) {
		this.memberJoinDate = memberJoinDate;
	}
	public int getMemberGrade() {
		return memberGrade;
	}
	public void setMemberGrade(int memberGrade) {
		this.memberGrade = memberGrade;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	@Override
	public String toString() {
		return "MemberDto [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPw=" + memberPw + ", memberName="
				+ memberName + ", memberJoinDate=" + memberJoinDate + ", memberGrade=" + memberGrade + ", memberPhone="
				+ memberPhone + ", memberEmail=" + memberEmail + "]";
	}
	
	
}
