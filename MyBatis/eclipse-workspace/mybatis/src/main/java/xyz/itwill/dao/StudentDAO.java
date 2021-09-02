package xyz.itwill.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import xyz.itwill.dto.Student;

public class StudentDAO {
	private static StudentDAO _dao;
	
	private StudentDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new StudentDAO();
	}
	
	public static StudentDAO getDAO() {
		return _dao;
	}
	
	//SqlSessionFactory 인스턴스를 생성하여 반환하는 메소드
	// => mybatis 환경설정파일을 읽어 SqlSessionFactory 인스턴스 생성
	//SqlSessionFactory : SqlSession 인스턴스를 생성하여 제공하는 인스턴스
	private SqlSessionFactory getSqlSessionFactory() {
		//mybatis 환경설정파일의 경로는 파일 시스템 형식으로 표현
		//String resource="xyz/itwill/dao/mybatis-config.xml";
		String resource="mybatis-config.xml";
		
		InputStream inputStream=null;
		try {
			//mybatis 환경설정파일을 읽기 위한 입력스트림을 생성하여 저장
			//Resources.getResourceAsStream(String resource) : 프로젝트에 존재하는 리소스 
			//파일(XML)의 경로를 제공받아 입력스트림 생성하여 반환하는 메소드
			inputStream=Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		
		//SqlSessionFactoryBuilder : SqlSessionFactory 인스턴스를 생성하는 기능을 제공하는 메소드
		//SqlSessionFactoryBuilder.build(InputStream inputStream) : mybatis 환경설정파일의 정보를
		//입력스트림을 이용하여 제공받아 SqlSessionFactory 인스턴스를 생성하여 반환하는 메소드
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 반환하는 메소드
	public List<Student> selectStudentList() {
		//SqlSessionFactory.openSession() : SqlSession 인스턴스를 생성하여 반환하는 메소드
		//SqlSession : 맵퍼 파일에 등록된 SQL 명령을 얻어와 DBMS 서버에 전달하여 실행하고
		//SQL 명령의 실행결과를 Java 자료형의 결과로 자동 매핑하여 반환하는 인스턴스
		SqlSession sqlSession=getSqlSessionFactory().openSession();
		try {
			//SqlSession.selectList(String elementId) : 맵퍼 파일에 등록된 SELECT 명령을 제공받아
			//DBMS 서버에 전달하여 실행하고 검색결과를 매핑하여 List 인스턴스로 반환하는 메소드
			//elementId : 맵퍼 파일의 mapper 엘리먼트의 namespace 속성값과 select 엘리먼트의 
			//id 속성값을 이용하여 맵퍼 파일의 등록된 SQL 명령을 제공받아 사용 
			return sqlSession.selectList("xyz.itwill.mapper.StudentMapper.selectStudentList");
		} finally {
			//SqlSession.close() : SqlSession 인스턴스를 제거하는 메소드
			sqlSession.close();
		}
	}
}















