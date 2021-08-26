package xyz.itwill.custom;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

//�±� �Ӽ��� ������ �±� ������ ���� Ŀ���� �±��� �±� Ŭ����
public class HelloMessageTag extends TagSupport {
	private static final long serialVersionUID = 1L;

	//�±� �Ӽ����� �����ϱ� ���� �ʵ� - �±� �Ӽ���� ������ �̸����� �ۼ�
	private String name;
	
	//�����ڴ� �ν��Ͻ� ������ �ʵ� �ʱ�ȭ �۾� - �ʵ尪 ����
	public HelloMessageTag() {
		//�±� �Ӽ��� ���� �⺻�� ���� - Ŀ���� �±� ���� �Ӽ� ���� ����
		// => �±� �Ӽ��� ������� ���� ��� �⺻������ ���� �Ӽ���
		// => �±� �Ӽ��� �ʼ��� ����� �⺻�� ���� ����
		name="ȫ�浿";
	}

	public String getName() {
		return name;
	}

	//Ŀ���� �±��� �Ӽ� ���� �Ӽ����� �Ű������� ���޹޾� �ʵ尪�� �����ϱ� ���� �ڵ� ȣ��
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int doStartTag() throws JspException {
		try {
			if(name.equals("ȫ�浿")) {
				pageContext.getOut().println("<h3>�����ڴ�, �ȳ��ϼ���.</h3>");
			} else {
				pageContext.getOut().println("<h3>"+name+"��, �ȳ��ϼ���.</h3>");
			} 
		} catch (IOException e) {
			//�������� ���� �޼����� �����ϱ� ����ϱ� ���� ������ ���� �߻�
			throw new JspException(e.getMessage());
		}
		return SKIP_BODY;
	}
	
	//doAfterBody() �޼ҵ� �Ǵ� doEndTag() �޼ҵ带 �������̵� �������� ������ �θ�Ŭ����
	//(TagSupport)�� �޼ҵ尡 �ڵ� ȣ�� 
	// => ����� ����� ���� ��� �޼ҵ带 �������̵� �������� ���
}









