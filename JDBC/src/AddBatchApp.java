package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

//다수의 행을 삽입하거나 변경하고자 할 경우 Batch 영역에 SQL 명령을 저장하여
//한번에 명령을 전달하여 실행하는 방법
//- 속도가 빠르고 하나의 PreparedStatement 인스턴스를 재활용하기 때문에 가독성이 높음
//- 테스트 상황에서 활용
//- AutoCommit 비활성화 권장
public class AddBatchApp {
	public static void main(String[] args) throws Exception {
		Connection con=ConnectionFactory.getConnection();
		
		String sql="INSERT INTO STUDENT VALUES(?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		
		pstmt.setInt(1, 4000);
		pstmt.setString(2, "장길산");
		pstmt.setString(3, "010-9856-4521");
		pstmt.setString(4, "서울시 도봉구");
		pstmt.setString(5, "2001-12-12");
		//PreparedStatement.addBatch() : SQL 명령을 Batch 영역에 추가하는 메소드
		pstmt.addBatch();//임시 메모리 영역
		
		pstmt.setInt(1, 5000);
		pstmt.setString(2, "홍경래");
		pstmt.setString(3, "010-5252-4463");
		pstmt.setString(4, "부산시 사하구");
		pstmt.setString(5, "1997-12-3");
		pstmt.addBatch();
		
		pstmt.setInt(1, 6000);
		pstmt.setString(2, "로빈후");
		pstmt.setString(3, "010-4875-3365");
		pstmt.setString(4, "서울시 도봉구");
		pstmt.setString(5, "2000-2-10");
		pstmt.addBatch();
		
		//PreparedStatement.executeBatch() : Batch 영역에 추가된 모든 SQL 명령을 접속된
		//DBMS 서버에 전달하여 실행하는 메소드 - int[] 반환
		pstmt.executeBatch();
		
		System.out.println("[메세지]SQL 명령에 대한 배치 작업 완료");
		
		ConnectionFactory.close(con, pstmt);
		
	}//end of main
}//end of class
