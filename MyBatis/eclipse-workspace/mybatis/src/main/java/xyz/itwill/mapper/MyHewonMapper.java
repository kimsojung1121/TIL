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
	//Map 인터페이스의 제네릭은 맵키 : String, 맵값 : Object 설정하여 사용
	String selectMapHewonId(Map<String, Object> map);
}

