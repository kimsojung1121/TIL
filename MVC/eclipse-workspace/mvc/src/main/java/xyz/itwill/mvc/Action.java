package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//��� �� Ŭ������ �ݵ�� ��� �޾ƾ� �Ǵ� �������̽�
// => �� Ŭ������ ��û ó�� �޼ҵ忡 �ۼ� ��Ģ ����
// => �޼ҵ� ȣ���� ���Ǽ� �� ���������� ȿ���� ����
//��û ó���޼ҵ�� HttpServletRequst �ν��Ͻ��� HttpServletResponse �ν��Ͻ��� �Ű�������
//���޹޾� ��û�� ���� ó���۾��� �����ϰ� �� ���� ����(�̵� ���� ����)�� ��ȯ�ϵ��� �ۼ�
public interface Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException;
}
