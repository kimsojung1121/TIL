package xyz.itwill.mapper;

import java.util.List;
import java.util.Map;

import xyz.itwill.dto.MyHewon;

public interface MyHewonMapper {
	int insertHewon(MyHewon hewon);
	List<MyHewon> selectHewonList();
	List<MyHewon> selectDiscriminatorHewonList();
	List<MyHewon> selectStateHewonList(int state);
	String selectBeanHewonId(MyHewon hewon);
	//Map �������̽��� ���׸��� ��Ű : String, �ʰ� : Object �����Ͽ� ���
	String selectMapHewonId(Map<String, Object> map);
}

