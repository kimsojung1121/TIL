package xyz.itwill.custom;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

//�±� �Ӽ��� �±� ������ �ִ� Ŀ���� �±��� �±� Ŭ����
public class HelloBodyTag extends TagSupport {
	private static final long serialVersionUID = 1L;

	//�±� �Ӽ����� �����ϱ� ���� �ʵ�
	// => �±� �Ӽ��� �ʼ��� ������ ��� ������ ����
	private boolean test;

	public boolean isTest() {
		return test;
	}

	public void setTest(boolean test) {
		this.test = test;
	}
	
	@Override
	public int doStartTag() throws JspException {
		try {
			if(test) {
				pageContext.getOut().print("<h3>");
			} else {
				pageContext.getOut().print("<p>");
			}
		} catch (IOException e) {
			throw new JspException(e.getMessage());
		}
		//�±� ������ �����Ͽ� Ŭ���̾�Ʈ���� ����
		return EVAL_BODY_INCLUDE;
	}
	
	@Override
	public int doEndTag() throws JspException {
		try {
			if(test) {
				pageContext.getOut().println("��, �ȳ��ϼ���.</h3>");
			} else {
				pageContext.getOut().println("��, �ȳ��ϼ���.</p>");
			}
		} catch (IOException e) {
			throw new JspException(e.getMessage());
		}
		return EVAL_PAGE;
	}
}











