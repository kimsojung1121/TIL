package xyz.itwill.dto;

/*
�̸�              ��?       ����            
--------------- -------- ------------- 
COMMENT_NO      NOT NULL NUMBER        
COMMENT_ID               VARCHAR2(20)  
COMMENT_CONTENT          VARCHAR2(100) 
COMMENT_DATE             DATE          
*/

//���̺��� �÷���� ������� ������ �ʵ�� �ۼ�
public class MyComment2 {	
	private int no;
	private String id;
	private String content;
	private String date;
	
	public MyComment2() {
		// TODO Auto-generated constructor stub
	}

	public MyComment2(int no, String id, String content, String date) {
		super();
		this.no = no;
		this.id = id;
		this.content = content;
		this.date = date;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
