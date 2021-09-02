package xyz.itwill.dto;

/*
MYREPLY ���̺� : �Խñۿ� ���� ����� �����ϱ� ���� ���̺�
// => ��۹�ȣ(REPLY_NO), �ۼ��� - ���̵�(REPLY_ID), ��۳���(REPLY_CONTENT), �ۼ���(REPLY_DATE), �Խñ۹�ȣ(REPLY_COMMENT_NO)
create table myreply(reply_no number primary key, reply_id varchar2(20)
    , reply_content varchar2(100), reply_date date, reply_comment_no number);

//MYREPLY ���̺��� �۹�ȣ(REPLY_NO)�� ����� �ڵ� �������� �����ϴ� ������ ��ü    
create sequence myreply_seq;

�̸�               ��?       ����            
---------------- -------- ------------- 
REPLY_NO         NOT NULL NUMBER        
REPLY_ID                  VARCHAR2(20)  
REPLY_CONTENT             VARCHAR2(100) 
REPLY_DATE                DATE          
REPLY_COMMENT_NO          NUMBER       
*/

public class MyReply {
	private int replyNo;
	private String replyId;
	private String replyContent;
	private String replyDate;
	private int replyCommentNo;
	
	public MyReply() {
		// TODO Auto-generated constructor stub
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public String getReplyId() {
		return replyId;
	}

	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}

	public int getReplyCommentNo() {
		return replyCommentNo;
	}

	public void setReplyCommentNo(int replyCommentNo) {
		this.replyCommentNo = replyCommentNo;
	}
}
