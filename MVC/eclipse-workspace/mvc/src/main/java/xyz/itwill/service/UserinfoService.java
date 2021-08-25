package xyz.itwill.service;

import java.sql.SQLException;
import java.util.List;

import xyz.itwill.dao.UserinfoModelTwoDAO;
import xyz.itwill.dto.UserinfoDTO;
import xyz.itwill.exception.ExistsUserinfoException;
import xyz.itwill.exception.PasswordMissMatchException;
import xyz.itwill.exception.UserinfoNotFoundException;

//Service Ŭ���� : �� Ŭ������ ��û ó�� �޼ҵ忡�� ó�� ����� �����ϱ� ���� Ŭ����
// => ���۳�Ʈ Ŭ���� - ���� ���α׷�(���)
// => DAO Ŭ������ �޼ҵ带 ȣ���Ͽ� �����α׷����� ��û�� ó�� ����� �޼ҵ�� ����
public class UserinfoService {
	private static UserinfoService _service;
	
	private UserinfoService() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_service=new UserinfoService();
	}
	
	public static UserinfoService getService() {
		return _service;
	}
	
	//ȸ�������� ���޹޾� USERINFO ���̺� �����ϴ� �޼ҵ�
	// => ���޹��� ȸ�������� ���̵� USERINFO ���̺� ����� ���� ȸ�������� ���̵��
	//    �ߺ��� ��� ������ ���� �߻� 
	public void addUserinfo(UserinfoDTO userinfo) throws SQLException, ExistsUserinfoException {
		if(UserinfoModelTwoDAO.getDAO().selectUserinfo(userinfo.getUserid())!=null) {
			//���ܰ� �߻��� ��� �޼ҵ� ���� ����
			throw new ExistsUserinfoException("�̹� ������� ���̵� �Է� �Ͽ����ϴ�.");
		}
		UserinfoModelTwoDAO.getDAO().insertUserinfo(userinfo);
	}
	
	//ȸ�������� ���޹޾� USERINFO ���̺� ����� �ش� ȸ�������� �����ϴ� �޼ҵ�
	// => ���޹��� ȸ�������� USERINFO ���̺� ���� ��� ������ ���� �߻�
	public void modifyUserinfo(UserinfoDTO userinfo) throws SQLException, UserinfoNotFoundException {
		/*
		if(UserinfoModelTwoDAO.getDAO().selectUserinfo(userinfo.getUserid())==null) {
			throw new UserinfoNotFoundException("���̵��� ȸ�������� �������� �ʽ��ϴ�.");
		}
		*/
		getUserinfo(userinfo.getUserid());
		UserinfoModelTwoDAO.getDAO().updateUserinfo(userinfo);
	}
	
	//���̵� ���޹޾� USERINFO ���̺� ����� �ش� ���̵��� ȸ�������� �����ϴ� �޼ҵ�
	// => ���޹��� ���̵� USERINFO ���̺� ���� ��� ������ ���� �߻�
	public void removeUserinfo(String userid) throws SQLException, UserinfoNotFoundException {
		/*
		if(UserinfoModelTwoDAO.getDAO().selectUserinfo(userid)==null) {
			throw new UserinfoNotFoundException("���̵��� ȸ�������� �������� �ʽ��ϴ�.");
		}
		*/
		getUserinfo(userid);
		UserinfoModelTwoDAO.getDAO().deleteUserinfo(userid);
	}
	
	//���̵� ���޹޾� USERINFO ���̺� ����� �ش� ���̵��� ȸ�������� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	// => ���޹��� ���̵� USERINFO ���̺� ���� ��� ������ ���� �߻�
	public UserinfoDTO getUserinfo(String userid) throws SQLException, UserinfoNotFoundException {
		UserinfoDTO userinfo=UserinfoModelTwoDAO.getDAO().selectUserinfo(userid);
		if(userinfo==null) {
			throw new UserinfoNotFoundException("���̵��� ȸ�������� �������� �ʽ��ϴ�.");
		}
		return userinfo;
	}
	
	//USERINFO ���̺� ����� ��� ȸ�������� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	public List<UserinfoDTO> getUserinfoList() throws SQLException {
		return UserinfoModelTwoDAO.getDAO().selectUserinfoList();
	}
	
	//���̵�� ��й�ȣ�� ���޹޾� USERINFO ���̺� ����� ȸ�������� ���Ͽ� ���� ó���ϴ� �޼ҵ�
	// => ���� �߻� : ���� ����, ���� �̹߻� : ���� ���� 
	public void auth(String userid, String password) throws SQLException, UserinfoNotFoundException, PasswordMissMatchException {
		//���̵� ���� ���� ó��
		// => ���޵� ���̵� ���� ȸ�������� USERINFO ���̺� ���� ��� ������ ���� �߻� 
		// => ���̵� ���� ���� : UserinfoNotFoundException �߻�
		UserinfoDTO userinfo=getUserinfo(userid);
		
		//��й�ȣ�� ���� ���� ó��
		// => ���޵� ��й�ȣ�� �˻��� ȸ�������� ��й�ȣ ���� ���� ��� ������ ���� �߻� 
		// => ��й�ȣ ���� ���� : UserinfoNotFoundException �߻�
		if(!password.equals(userinfo.getPassword())) {
			throw new PasswordMissMatchException("�Էµ� ���̵� �߸� �Ǿ��ų� ��й�ȣ�� ���� �ʽ��ϴ�.");
		}
	}
}
