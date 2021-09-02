package xyz.itwill.dto;

import java.io.Serializable;

/*
MYCOMMENT ���̺� : �Խñ��� �����ϱ� ���� ���̺�
 => �۹�ȣ(COMMENT_NO), �ۼ��� - ���̵�(COMMENT_ID), �۳���(COMMENT_CONTENT), �ۼ���(COMMENT_DATE) 
create table mycomment(comment_no number primary key, comment_id varchar2(20)
    ,comment_content varchar2(100), comment_date date);

//MYCOMMENT ���̺��� �۹�ȣ(COMMENT_NO)�� ����� �ڵ� �������� �����ϴ� ������ ��ü    
create sequence mycomment_seq;    

�̸�              ��?       ����            
--------------- -------- ------------- 
COMMENT_NO      NOT NULL NUMBER        
COMMENT_ID               VARCHAR2(20)  
COMMENT_CONTENT          VARCHAR2(100) 
COMMENT_DATE             DATE          
*/

public class MyComment1 implements Serializable {
	private static final long serialVersionUID = 1L;

	private int commentNo;
	private String commentId;
	private String commentContent;
	private String commentDate;
	
	public MyComment1() {
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
}








