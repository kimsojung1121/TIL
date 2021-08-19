package xyz.itwill.util;

public class Utility {
	//JSON 형식의 텍스트 데이타를 전달받아 자바스트립트 객체의 속성값으로 표현할 수 없는 
	//문자를 회피문자(Escape Character)로 변환하여 반환하는 메소드
	public static String toJSON(String source) {
		return source.replace("\\", "\\\\").replace("\"", "\\\"")
				.replace("\n", "\\n").replace("\r\n", "\\n");
	}
}
