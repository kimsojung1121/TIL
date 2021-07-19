package xyz.itwill.custom;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

//�±� Ŭ���� : JSP �������� Ŀ���� �±׸� ����� ��� �ν��Ͻ��� �����Ǿ� ����Ǵ� Ŭ����
// => TagSupport Ŭ������ ��ӹ޾� �ۼ�
public class CustomTag extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Ŀ���� �±��� �����±� ��� �� �ڵ� ȣ��Ǵ� �޼ҵ�
	@Override
	public int doStartTag() throws JspException {
		try {
			pageContext.getOut().println("<h3>Ŀ���� �±� ���</h3>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}
	
	//Ŀ���� �±��� �����±� ��� �� �ڵ� ȣ��Ǵ� �޼ҵ�
	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return super.doEndTag();
	}
	
}
