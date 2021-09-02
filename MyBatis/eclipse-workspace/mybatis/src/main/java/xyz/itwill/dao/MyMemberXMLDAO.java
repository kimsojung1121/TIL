package xyz.itwill.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import xyz.itwill.dto.MyMember;

//XML ���� ���Ͽ� ��ϵ� SQL ����� �����޾� �ۼ��� DAO Ŭ����
public class MyMemberXMLDAO {
	private static MyMemberXMLDAO _dao;
	
	private MyMemberXMLDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new MyMemberXMLDAO();
	}
	
	public static MyMemberXMLDAO getDAO() {
		return _dao;
	}
	
	private SqlSessionFactory getSqlSessionFactory() {
		String resource="mybatis-config.xml";
		InputStream inputStream=null;
		try {
			inputStream=Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	//ȸ�������� ���޹޾� MYMEMBER ���̺� ���� �����ϰ� �������� ������ ��ȯ�ϴ� �޼ҵ�
	public int insertMember(MyMember member) {
		SqlSession sqlSession=getSqlSessionFactory().openSession();
		try {
			//SqlSession.insert(String elementId, Object parameterValue) : INSERT ����� ��ϵ�
			//������Ʈ�� SQL ����� �����޾� ���� �� �������� ������ ��ȯ�ϴ� �޼ҵ�
			// => elementId : SQL ����� ��ϵ� ������Ʈ�� �ĺ��ڸ� ���޹޾� ����
			// => parameterValue : SQL ��ɿ� �ʿ��� ���� ����� ���� �Ǵ� �ν��Ͻ��� ���޹޾� ����
			int rows=sqlSession.insert("xyz.itwill.mapper.MyMemberXMLMapper.insertMember", member);
			
			//mybatis �����ӿ�ũ�� �⺻������ AutoCommit ����� ��Ȱ��ȭ ó���ϰ� SQL  ����� �����Ͽ� ����
			// => DML ����� �����Ͽ� ������ ��� �ݵ�� TCL ���� �޼ҵ� ȣ��
			//SqlSession.commit() : Ʈ������ ���� ���(COMMIT)�� �����Ͽ� �����ϴ� �޼ҵ�
			//SqlSession.rollback() : Ʈ������ ��� ���(ROLLBACK)�� �����Ͽ� �����ϴ� �޼ҵ�
			if(rows>0) sqlSession.commit();
			else sqlSession.rollback();

			return rows;
		} finally {
			sqlSession.close();
		}
	}

	//ȸ�������� ���޹޾� MYMEMBER ���̺� ����� ȸ�������� �����ϰ� �������� ������ ��ȯ�ϴ� �޼ҵ�
	public int updateMember(MyMember member) {
		//SqlSessionFactory.openSession(boolean autoCommit) : SqlSession �ν��Ͻ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
		// => false : AutoCommit ��� ��Ȱ��ȭ(�⺻), true : AutoCommit ��� Ȱ��ȭ 
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			//SqlSession.update(String elementId, Object parameterValue) : UPDATE ����� ��ϵ�
			//������Ʈ�� SQL ����� �����޾� ���� �� �������� ������ ��ȯ�ϴ� �޼ҵ�
			return sqlSession.update("xyz.itwill.mapper.MyMemberXMLMapper.updateMember", member);
		} finally {
			sqlSession.close();
		}
	}

	//���̵� ���޹޾� MYMEMBER ���̺� ����� ȸ�������� �����ϰ� �������� ������ ��ȯ�ϴ� �޼ҵ�
	public int deleteMember(String id) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			//SqlSession.delete(String elementId, Object parameterValue) : DELETE ����� ��ϵ�
			//������Ʈ�� SQL ����� �����޾� ���� �� �������� ������ ��ȯ�ϴ� �޼ҵ�
			return sqlSession.delete("xyz.itwill.mapper.MyMemberXMLMapper.deleteMember", id);
		} finally {
			sqlSession.close();
		}
	}
	
	//���̵� ���޹޾� MYMEMBER ���̺� ����� ȸ�������� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	public MyMember selectMyMember(String id) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			//SqlSession.selectOne(String elementId, Object parameterValue) : SELECT �����
			//��ϵ� ������Ʈ�� SQL ����� �����޾� ���� �� �ϳ��� �˻������ ������ 
			//Java �ڷ����� �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
			return sqlSession.selectOne("xyz.itwill.mapper.MyMemberXMLMapper.selectMember", id);
		} finally {
			sqlSession.close();
		}
	}
	
	//MYMEMBER ���̺� ����� ��� ȸ�������� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	public List<MyMember> selectMemberList() {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			//SqlSession.selectList(String elementId, Object parameterValue) : SELECT �����
			//��ϵ� ������Ʈ�� SQL ����� �����޾� ���� �� �������� �˻������ ������ 
			//Java �ڷ����� �ν��Ͻ��� ��ҷ� ����� List �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
			return sqlSession.selectList("xyz.itwill.mapper.MyMemberXMLMapper.selectMemberList");
		} finally {
			sqlSession.close();
		}
	}
}
