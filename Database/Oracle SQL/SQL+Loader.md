#### 준비물~
- db에 넣고자 하는 데이터가 있는 엑셀파일
- 데이터 없이 형식만 정해진 빈 테이블
  - 테이블 형식 만드는 게 귀찮을 땐. . . 원래 있던 거에서 대충 조작해서 가져온다!
  ```sql
  CREATE TABLE [new 테이블명]
  AS 
  (
  SELECT NO,NAM,TRIM(IHIDNO) AS IHIDNO FROM [기존 테이블명]
  );
  ````

-----
#### 1. 엑셀 파일에서 `파일` - `다른 이름으로 저장` - `찾아보기` 후 파일 형식 **텍스트 (탭으로 분리)(*.txt)** 로 변경 후 저장
  - 열이름 삭제
  - 엑셀 순서를 지켜야 되는 경우엔 일련번호 생성해서 같이 저장
  - 오늘 날짜로 저장함 **0706.txt**
#### 2. **0706.txt** 파일 공백 -> `|` 모두 바꾸기
  - 1111111|홍길동|111111-1111111 처럼 되도록
#### 3. CTL 파일 작성
```cmd
LOAD DATA
INFILE '[C:\경로]'        
APPEND                                             -- 테이블의 내용을 모두 삭제한 후에 입력D
INTO TABLE "[new 테이블명]"                         -- 데이터 형식 만들어 둔 테이블 명
fields terminated by '|'                           -- |를 기준으로 구분한다. 
trailing nullcols
(
 NO			
 , NAM
 , IHIDNO
)
```
  - **export.ctl** 로 저장

#### 4. `cmd` - 파일 저장된 경로로 이동
```cmd
sqlldr userid=[아이디명]/[비밀번호]@[IP주소] control='C:\export.ctl'     log='C:\export.log'     bad='C:\export.bad'
```
- 데이터가 제대로 들어가면 `export.log` 파일이 생성되고, 실패하면 `export.bad` 파일이 생성된다.

----
- 대용량 데이터를 넣어야 할 때 유용하다.
- csv 파일 or txt 파일로 생성 가능.
