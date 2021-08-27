package xyz.itwill.custom;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

//Ŀ���� �±�(Custom Tag) : JSP �������� ����ϱ� ���� �����ڰ� ���� ���� �±�
// => �±� Ŭ���� �ۼ� > TLD ���Ͽ� Ŀ���� �±� ��� > JSP �������� Ŀ���� �±� ���

//�±� Ŭ���� : JSP ������ Ŀ���� �±� ���� ȣ��� �޼ҵ尡 ����� Ŭ����
// => TagSupport, BodyTagSupport, SimpleTagSupport Ŭ���� �� �ϳ��� ��ӹ޾� �ۼ�
// => Ŀ���� �±� ���� ȣ��Ǵ� �޼ҵ�� �θ�Ŭ������ �޼ҵ带 �������̵� �����Ͽ� �ۼ�

//�±� �Ӽ��� �±� ������ ���� Ŀ���� �±��� �±� Ŭ����
public class HelloTag extends TagSupport {
	private static final long serialVersionUID = 1L;

	//JSP �������� Ŀ���� �±׸� ����� ��� �±� Ŭ������ �ν��Ͻ��� �����ϱ� ���� �ڵ� ȣ�� - 1��
	public HelloTag() {
		//System.out.println("[����]HelloTag Ŭ������ ������ ȣ�� - �ν��Ͻ� ����");
	}
	
	//JSP �������� Ŀ���� �±��� �����±� ���� �ڵ� ȣ��Ǵ� �޼ҵ�
	@Override
	public int doStartTag() throws JspException {
		//System.out.println("[����]HelloTag Ŭ������ doStartTag() �޼ҵ� ȣ��");
		try {
			//�θ�Ŭ����(TagSupport)���� �����Ǵ� pageContext �ν��Ͻ��� �����α׷� �ۼ���
			//�ʿ��� �ν��Ͻ��� �����޾� ���
			//pageContext.getOut() : �������� �����ϱ� ���� ��½�Ʈ���� ��ȯ�ϴ� �޼ҵ�
			// => ��½�Ʈ���� �޼ҵ带 ȣ���Ͽ� Ŭ���̾�Ʈ���� HTML ����
			pageContext.getOut().println("<div>�ȳ��ϼ���.</div>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//doStartTag �޼ҵ��� ��ȯ��(���) : SKIP_BODY, EVAL_BODY_INCLUDE, EVAL_BODY_AGAIN
		// => SKIP_BODY : �±׳����� Ŭ���̾�Ʈ���� �������� ���� ��� ����ϴ� ��ȯ��
		// => EVAL_BODY_INCLUDE : �±׳����� Ŭ���̾�Ʈ���� ������ ����ϴ� ��ȯ��(�⺻)
		// => EVAL_BODY_AGAIN : �±׳����� Ŭ���̾�Ʈ���� �ٽ� �ѹ� ������ ��� ����ϴ� ��ȯ��
		return SKIP_BODY;
	}
	
	//JSP �������� Ŀ���� �±��� �±׳��� ������ �ڵ� ȣ��Ǵ� �޼ҵ�
	@Override
	public int doAfterBody() throws JspException {
		//System.out.println("[����]HelloTag Ŭ������ doAfterBody() �޼ҵ� ȣ��");
		return super.doAfterBody();
	}
	
	//JSP �������� Ŀ���� �±��� �����±� ���� �ڵ� ȣ��Ǵ� �޼ҵ�
	@Override
	public int doEndTag() throws JspException {
		//System.out.println("[����]HelloTag Ŭ������ doEndTag() �޼ҵ� ȣ��");
		//doEndTag �޼ҵ��� ��ȯ��(���) : SKIP_PAGE, EVAL_PAGE
		// => SKIP_PAGE : �±� ���� �� JSP ������ ������ �����ϴ� ��ȯ��
		// => EVAL_PAGE : �±� ���� �� JSP ������ ��� ó���ϴ� ��ȯ��(�⺻)
		return EVAL_PAGE;
	}
}
















