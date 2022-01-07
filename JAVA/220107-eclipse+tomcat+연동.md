### Tomcat 톰캣

- 서블릿을 구동하기 위한 서블릿 컨테이너
> Servlet : Dynamic Web Page를 만들 때 사용되는 자바 기반의 웹 애플리케이션 프로그래밍 기술

### 설치
- [Tomcat Site](https://tomcat.apache.org/)
> 가장 최신 버전보다는 1~2단계 낮은 버전 사용(검증된 버전 사용)

- zip파일 다운로드
  - 64-bit Windows.zip

- 설치 폴더 생성
  - C:\Project\

- zip 파일 압축 해제 후 생성한 폴더에 복사

### 톰캣 폴더 구조
- **bin** : 톰캣 실행과 관련된 배치 파일이나 스크립트 파일
- **conf** : 톰캣 서버 환경 설정 파일
- **lib** : 톰캣 서버 자바 라이브러리 파일
- **logs** : 톰캣 서버의 실행 상태를 기록한 로그 파일
- **temp** : 서버 실행 중에서 사용하는 임시 폴더
- **webapps** : 웹 애플리케이션 배치 폴더
- **work** : JSP를 자바 서블릿 소스로 변환한 파일

### 실행
- \bin\startup.bat 실행
- Server startup ~ 문구 뜨면 정상 구동
  - 기본 포트번호 확인하기
    - 8080

### 테스트
- https://localhost:8080 접속 시 톰캣 페이지 출력되면 정상 구동

----


### eclipse 연동

### 이클립스에 톰캣 서버 정보 등록
- 톰캣 webapps 폴더에 웹 애플리케이션 복사
- 서버 shutdown 및 startup 수행

### 이클립스 WTP(Web Tools Platform) 플러그인
- 톰캣 서버 시작 및 종료 기능 제공
- webapps에 웹 애플리케이션을 복사하지 않고 사용

### 이클립스에 톰캣 서버 정보 등록
- `Window` > `Preference` > `Server` > `Runtime Environments` > `Add`
- 버전에 맞는 톰캣 선택 후 `Next`
  - Apache Tomcat v7.0
- `Browse` > 위에서 압축 해제한 톰캣 폴더 경로 입력
- `OK`

### 이클립스 톰캣 실행환경 구성하기
- `Servers` > No servers are available. ~ 클릭 후 연결
- 완료되면 Project Explorer 뷰에서 Servers 프로젝트 아래 톰캣 폴더 확인 가능
  - 해당 폴더에는 conf 폴더의 설정 파일들이 있음

