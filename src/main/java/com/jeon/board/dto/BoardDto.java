package com.jeon.board.dto;

import java.util.Date;

public class BoardDto {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private int memberNo;
	private Date boardCreateDate;
	private Date boardUpdateDate;
	private MemberDto memberDto = new MemberDto();

	public MemberDto getMemberDto() {
		return memberDto;
	}
	public void setMemberDto(MemberDto memberDto) {
		this.memberDto = memberDto;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public int getmemberNo() {
		return memberNo;
	}
	public void setmemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public Date getBoardCreateDate() {
		return boardCreateDate;
	}
	public void setBoardCreateDate(Date boardCreateDate) {
		this.boardCreateDate = boardCreateDate;
	}
	public Date getBoardUpdateDate() {
		return boardUpdateDate;
	}
	public void setBoardUpdateDate(Date boardUpdateDate) {
		this.boardUpdateDate = boardUpdateDate;
	}
	
	@Override
	public String toString() {
		return "[boardNo : " + boardNo + " ]";
	}
}
