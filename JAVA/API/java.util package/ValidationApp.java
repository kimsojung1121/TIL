package xyz.itwill.util;

import java.util.Scanner;
//import java.util.regex.Matcher;
import java.util.regex.Pattern;

//정규표현식(Regular Expression) : Meta 문자, Escape 문자 등을 이용하여 일정한 규칙의 문자열을 표현하는 방법
/*
^문자 : 문자(열)로 시작됨을 의미
문자$ : 문자(열)로 종료됨을 의미
. : 임의의 문자 하나를 의미(\ 문자 표현 불가능)
[믄자1문자2문자3] : 나열된 문자들 중 하나를 의미
[^문자1문자2문자3] : 나열된 문자들이 아닌 문자들 중 하나를 의미
[문자1-문자2] : 문자1부터 문자2 범위의 문자 중 하나를 의미
[문자열|문자열|문자열|] : 나열된 문자열들 중 하나를 의미
문자열+ : 문자열이 1번 이상 반복됨을 의미
문자열* : 문자열이 0번 이상 반복됨을 의미
문자열? : 문자열이 0번 또는 1번 존재함을 의미
문자열{숫자} : 문자열이 숫자만큼 반복됨을 의미
문자열{숫자1,숫자2} : 문자열이 숫자1부터 숫자2만큼 반복됨을 의미
(?!)문자열 : 문자열에서 대소문자를 구분하지 않음을 의미
(?=)문자열 : 문자열을 반드시 포함하고 있음을 의미
(?!문자열) : 문자열을 반드시 포함하고 있지 않음을 의미

\s : 공백이 존재하는 문자열을 의미
\S : 공백이 존재하지 않는 문자열을 의미
\w : 영문자, 숫자, 특수문자(_)의 문자로만 구성된 문자열을 의미
\W : 영문자, 숫자, 특수문자(_)의 문자를 제외한 문자들로 구성된 문자열을 의미
\d : 숫자 형태의 문자로만 구성된 문자열을 의미
\D : 숫자 형태의 문자를 제외한 문자들로 구성된 문자열을 의미
\메타문자 : 메타문자를 일반문자로 표현
*/
//키보드로 입력된 문자열에 대해 검증 프로그램을 작성하세요.
// => 형식에 맞지 않은 문자열을 입력할 경우 프로그램 종료 - 유효성 검사
public class ValidationApp {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);

/*		
		System.out.print("아이디 입력 >> ");
		String id=scanner.nextLine();
		
		//입력값 존재에 대한 검증 - 연산자 또는 메소드를 이용한 유효성 검사
		if(id==null || id.equals("")) {
			System.out.println("[에러]아이디를 반드시 입력해 주세요.");
			System.exit(0);
		}
		
		//입력값 형식에 대한 검증 - 정규 표현식을 이용한 유효성 검사
		//아이디 입력규칙 - 영문자로 시작되며 영문자,숫자,특수문자(_)의 조합으로 6~20 범위의 문자로 표현
		//java.util.regex.Pattern : 정규 표현식을 저장하기 위한 클래스
		//Pattern.matches(String regex, CharSequence input) : 정규 표현식과 입력값을
		//전달받아 입력값에 대한 규칙을 비교하여 결과를 반환하는 메소드 
		// => false : 불일치, true : 일치
//		if(!Pattern.matches("^[a-zA-Z][a-zA-Z0-9_] {5,19}$", id)) {
//			System.out.println("[에러]입력한 아이디는 형식에 맞지 않습니다.");
//			System.exit(0);
//		}
		

		//Pattern.compile(String regex) : 정규 표현식을 전달받아 Pattern 인스턴스에 저장하여 반환하는 메소드
		Pattern idPattern=Pattern.compile("^[a-zA-Z]\\w{5,19}$");
		
		//java.util.regex.Matcher : 정규표현식과 비교 문자열을 저장하기 위한 클래스
		// => 정규 표현식과 문자열을 비교하는 기능 외 변경 또는 삭제 처리하는 기능 제공 - 폭넓게 정규표현식 활용 가능
		//Pattern.matcher(CharSequence input) : Pattern 인스턴스에 저장된 정규 표현식에
		//비교 문자열을 제공받아 저장한 Matcher 인스턴스를 반환하는 메소드
		Matcher idMatcher=idPattern.matcher(id);
		
		//Matcher.matches() : Matcher 인스턴스에 저장된 정규 표현식과 문자열에 대한 규칙을 
		//비교하여 결과를 반환하는 메소드
		// => false : 불일치, true : 일치
		if(!idMatcher.matches()) {
			System.out.println("[에러]입력한 아이디는 형식에 맞지 않습니다.");
			System.exit(0);
		}
		
		System.out.println("[메세지]형식에 맞는 아이디가 입력되었습니다.");
		scanner.close();
*/
		
		
/*		
		System.out.print("비밀번호 입력 >> ");
		String password=scanner.nextLine();
		
		if(password==null || password.equals("")) {
			System.out.println("[에러]비밀번호를 반드시 입력해 주세요.");
			System.exit(0);
		}
		
		//비밀번호 규칙 - 영문자, 숫자, 특수문자를 반드시 1개 이상 포함하여 8~30 범위의 문자로 표현
		String passwordReg="^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*_-]){8,30}$";
		if(!Pattern.matches(passwordReg, password)) {
			System.out.println("[에러]입력한 비밀번호는 형식에 맞지 않습니다.");
			System.exit(0);
		}
		System.out.println("[메세지]형식에 맞는 비밀번호가 입력되었습니다.");
*/
		
		System.out.print("이메일 입력 >> ");
		String email=scanner.nextLine();
		
		if(email==null || email.equals("")) {
			System.out.println("[에러]이메일을 반드시 입력해 주세요.");
			System.exit(0);
		}
		
		//이메일 규칙 - [사용자명@도메인명] 형식의 문자열로 표현
		String emailReg="^([a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+)*$";
		if(!Pattern.matches(emailReg, email)) {
			System.out.println("[에러]입력한 이메일은 형식에 맞지 않습니다.");
			System.exit(0);
		}
		System.out.println("[메세지]형식에 맞는 이메일이 입력되었습니다.");
		
		scanner.close();
	}
}
