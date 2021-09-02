package xyz.itwill.dto;

import java.util.List;

//MYCOMMENT 테이블과 MYREPLY 테이블, MYUSER 테이블의 검색결과를 저장하기 위한 클래스
public class MyCommentReplyUser {
	private int commentNo;
	
	//MYCOMMENT 테이블의 검색결과를 저장하기 위한 필드 - 검색행 : 1개
	private MyComment1 comment;
	
	//MYUSER 테이블의 검색결과를 저장하기 위한 필드 - 검색행 : 1개
	private MyUser user;
	
	//MYREPLY 테이블의 검색결과를 저장하기 위한 필드 - 검색행 : 0개 이상
	// => 댓글정보(MyReply)와 회원정보(MyUser)를 저장하는 클래스(MyReplyUser)를 요소로 설정
	private List<MyReplyUser> replies;
	
	public MyCommentReplyUser() {
		// TODO Auto-generated constructor stub
	}
	
	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public MyComment1 getComment() {
		return comment;
	}

	public void setComment(MyComment1 comment) {
		this.comment = comment;
	}

	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}

	public List<MyReplyUser> getReplies() {
		return replies;
	}

	public void setReplies(List<MyReplyUser> replies) {
		this.replies = replies;
	}
}
