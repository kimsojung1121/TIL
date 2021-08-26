package xyz.itwill.custom;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

//태그 속성과 태그 내용이 있는 커스텀 태그의 태그 클래스
public class HelloBodyTag extends TagSupport {
	private static final long serialVersionUID = 1L;

	//태그 속성값을 저장하기 위한 필드
	// => 태그 속성을 필수로 설정한 경우 생략자 생략
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
		//태그 내용을 포함하여 클라이언트에게 전달
		return EVAL_BODY_INCLUDE;
	}
	
	@Override
	public int doEndTag() throws JspException {
		try {
			if(test) {
				pageContext.getOut().println("님, 안녕하세요.</h3>");
			} else {
				pageContext.getOut().println("님, 안녕하세요.</p>");
			}
		} catch (IOException e) {
			throw new JspException(e.getMessage());
		}
		return EVAL_PAGE;
	}
}











