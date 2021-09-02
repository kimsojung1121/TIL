package xyz.itwill.dto;

import java.util.List;

//MYCOMMENT ���̺�� MYREPLY ���̺�, MYUSER ���̺��� �˻������ �����ϱ� ���� Ŭ����
public class MyCommentReplyUser {
	private int commentNo;
	
	//MYCOMMENT ���̺��� �˻������ �����ϱ� ���� �ʵ� - �˻��� : 1��
	private MyComment1 comment;
	
	//MYUSER ���̺��� �˻������ �����ϱ� ���� �ʵ� - �˻��� : 1��
	private MyUser user;
	
	//MYREPLY ���̺��� �˻������ �����ϱ� ���� �ʵ� - �˻��� : 0�� �̻�
	// => �������(MyReply)�� ȸ������(MyUser)�� �����ϴ� Ŭ����(MyReplyUser)�� ��ҷ� ����
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
