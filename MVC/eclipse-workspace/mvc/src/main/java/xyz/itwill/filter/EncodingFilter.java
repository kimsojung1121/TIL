package xyz.itwill.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//���� Ŭ���� : Ŭ���̾�Ʈ�� Ư�� �����α׷� ��û�� ���� ó�� �� ��û������ �����ϰų�
//���� �� ���������� �����ϱ� ���� Ŭ���� - Filter �������̽��� ��ӹ޾� �ۼ�

//Ŭ���̾�Ʈ�� ��� �����α׷� ��û�� ���� ��û������ ���ް� ĳ���ͼ��� �����ϴ� ���� Ŭ����
// => @WebFilter ������̼� �Ǵ� web.xml ������ filter ������Ʈ�� �̿��Ͽ� ���� Ŭ������ ���۵ǵ��� ����
public class EncodingFilter implements Filter {
	//������ ĳ���ͼ��� ���ڵ��� �����ϱ� ���� �ʵ�
	private String encoding;
	
	//���� Ŭ������ �ν��Ͻ��� ������ �� ���� ���� �ѹ��� ȣ��Ǵ� �޼ҵ� - �ʱ�ȭ �ۼ�
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//encoding="utf-8";
		
		//web.xml ������ init-param ������Ʈ�� ������ ���� ��ȯ�޾� �ʵ忡 ����
		encoding=filterConfig.getInitParameter("encoding");
	}
	
	//Ŭ���̾�Ʈ ��û�� ���� ���۵� �����α׷��� ���� �� �Ǵ� �Ŀ� �۾��� ����� �ۼ��ϴ� �޼ҵ�
	// => Ŭ���̾�Ʈ���� �������� ��û������ �����ϰų� Ŭ���̾�Ʈ���� ���޵� ���������� �����ϴ� ��� ����
	// => Ŭ���̾�Ʈ ��û���� �ڵ����� �ݺ� ȣ��Ǵ� �޼ҵ�
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//Ŭ���̾�Ʈ���� �������� ��û���� ���� - ���ް��� ���� ĳ���ͼ� ����
		if(request.getCharacterEncoding()==null || 
				!request.getCharacterEncoding().equalsIgnoreCase(encoding)) {
			request.setCharacterEncoding(encoding);
		}
		
		//Ŭ���̾�Ʈ ��û�� ó���ϱ� ���� �����α׷��� �����Ͽ� ����ǵ��� ����
		chain.doFilter(request, response);//��û �����α׷� ����
		
		//Ŭ���̾�Ʈ���� ����� �������� ����
	}

}
