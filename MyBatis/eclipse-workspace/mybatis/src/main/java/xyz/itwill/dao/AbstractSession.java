package xyz.itwill.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//SqlSessionFactory �ν��Ͻ��� �����Ͽ� ��ȯ�ϴ� ����� �����ϴ� Ŭ����
// => ���۸� ����ϴ� DAO Ŭ������ ��� �޾ƾ� �Ǵ� �θ�Ŭ����
// => ����� �������� �ۼ��� Ŭ�����̹Ƿ� �߻�Ŭ������ �����ϴ� ���� ����
public abstract class AbstractSession {
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		String resource="mybatis-config.xml";
		InputStream inputStream=null;
		try {
			inputStream=Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	protected SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}








