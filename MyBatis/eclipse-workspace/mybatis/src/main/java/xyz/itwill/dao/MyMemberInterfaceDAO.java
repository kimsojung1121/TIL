package xyz.itwill.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import xyz.itwill.dto.MyMember;
import xyz.itwill.mapper.MyMemberInterfaceMapper;

public class MyMemberInterfaceDAO {
	private static MyMemberInterfaceDAO _dao;
	
	private MyMemberInterfaceDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new MyMemberInterfaceDAO();
	}
	
	public static MyMemberInterfaceDAO getDAO() {
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
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			//SqlSession.getMapper(Class<T> clazz) : �޸𸮿� ����� �������̽�(Interface ����)��
			//���޹޾� Mapper �ν��Ͻ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
			// => Mapper �ν��Ͻ��� �߻�޼ҵ带 ȣ���Ͽ� ��ϵ� SQL ����� �����޾� DBMS ������
			//�����Ͽ� �����ϰ� �������� Java �ڷ����� �ν��Ͻ��� �����Ͽ� ��ȯ
			return sqlSession.getMapper(MyMemberInterfaceMapper.class).insertMember(member);
		} finally {
			sqlSession.close();
		}
	}

	//ȸ�������� ���޹޾� MYMEMBER ���̺� ����� ȸ�������� �����ϰ� �������� ������ ��ȯ�ϴ� �޼ҵ�
	public int updateMember(MyMember member) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyMemberInterfaceMapper.class).updateMember(member);
		} finally {
			sqlSession.close();
		}
	}

	//���̵� ���޹޾� MYMEMBER ���̺� ����� ȸ�������� �����ϰ� �������� ������ ��ȯ�ϴ� �޼ҵ�
	public int deleteMember(String id) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyMemberInterfaceMapper.class).deleteMember(id);
		} finally {
			sqlSession.close();
		}
	}
	
	//���̵� ���޹޾� MYMEMBER ���̺� ����� ȸ�������� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	public MyMember selectMyMember(String id) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyMemberInterfaceMapper.class).selectMember(id);
		} finally {
			sqlSession.close();
		}
	}
	
	//MYMEMBER ���̺� ����� ��� ȸ�������� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	public List<MyMember> selectMemberList() {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyMemberInterfaceMapper.class).selectMemberList();
		} finally {
			sqlSession.close();
		}
	}
}
