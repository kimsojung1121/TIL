package xyz.itwill.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import xyz.itwill.dto.MyMember;

//mybatis �����ӿ�ũ������ �������̽��� �̿��Ͽ� ���� ���� �ۼ� ����
// => �߻�޼ҵ忡 ���� ������̼�(Mapper Anontation)�� ����Ͽ� SQL ��� ���
public interface MyMemberInterfaceMapper {
	//@Insert : INSERT ����� ����ϱ� ���� ������̼�
	//value �Ӽ� : �߻�޼ҵ忡 ��ϵ� SQL ����� �Ӽ������� ����
	// => �ٸ� �Ӽ��� ���� ��� �Ӽ����� ���� ����
	@Insert(value = "insert into mymember values(#{id},#{name},#{phone},#{email})")
	int insertMember(MyMember member);
	
	//@Update : UPDATE ����� ����ϱ� ���� ������̼�
	@Update("update mymember set name=#{name},phone=#{phone},email=#{email} where id=#{id}")
	int updateMember(MyMember member);
	
	//@Delete : DELETE ����� ����ϱ� ���� ������̼�
	@Delete("delete from mymember where id=#{id}")
	int deleteMember(String id);
	
	//@Select : SELECT ����� ����ϱ� ���� ������̼�
	@Select("select * from mymember where id=#{id}")
	MyMember selectMember(String id);
	
	@Select("select * from mymember order by id")
	List<MyMember> selectMemberList();
}
