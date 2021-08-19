package xyz.itwill.dto;

/*
create table ajax_comment(num number primary key, writer varchar2(50),content varchar2(500),write_date date);
create sequence ajax_comment_seq;
*/

public class AjaxCommentDTO {
	private int num;
	private String writer;
	private String content;
	private String writeDate;

	public AjaxCommentDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
}
