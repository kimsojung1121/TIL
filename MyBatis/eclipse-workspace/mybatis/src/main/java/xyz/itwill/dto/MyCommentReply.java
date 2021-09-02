package xyz.itwill.dto;

import java.util.List;

//MYCOMMENT ���̺�� MYREPLY ���̺��� �˻������ �����ϱ� ���� Ŭ����
// => 1:N ������ ���� �˻������ �����ϱ� ���� Ŭ����
public class MyCommentReply {
	//MYCOMMENT ���̺��� �˻������ �����ϱ� ���� �ʵ� - �˻��� : 1��
	private int commentNo;
	private String commentId;
	private String commentContent;
	private String commentDate;

	//MYREPLY ���̺��� �˻������ �����ϱ� ���� �ʵ� - �˻��� : 0�� �̻�
	// => �Խñۿ� ���� ��۸���� �����ϱ� ���� List �ڷ������� �ʵ� ���� - ���԰���
	private List<MyReply> replies;
	
	public MyCommentReply() {
		// TODO Auto-generated constructor stub
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	public List<MyReply> getReplies() {
		return replies;
	}

	public void setReplies(List<MyReply> replies) {
		this.replies = replies;
	}
}
