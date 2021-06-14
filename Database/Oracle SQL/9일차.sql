--반복문 : 명령을 반복적으로 실행하기 위한 구문
SET SERVEROUT ON;

--BASIC LOOP : 무한반복 - 선택문을 이용하여 EXIT 명령으로 반복문 종료
--형식)LOOP 명령; 명령;... END LOOP;

--1~5 범위의 숫자값을 출력하는 PL/SQL 작성
DECLARE
    I NUMBER(1) := 1;
BEGIN
    LOOP
        DBMS_OUTPUT.PUT_LINE(I);
        I := I + 1;
        IF I > 5 THEN
            EXIT;
        END IF;
    END LOOP;
END;
/
    
--FOR LOOP : 반복횟수가 정해져 있는 경우 사용하는 반복문    
--형식)FOR INDEX_COUNTER IN [REVERSE] LOWER_BOUND..HIGH_BOUND LOOP 명령;명령;... END LOOP;

--1~10 범위의 정수들의 합계를 계산하여 출력하는 PL/SQL 작성
DECLARE
    TOT NUMBER(2) := 0;
BEGIN
    /* FOR LOOP 구문의 변수(INDEX_COUNTER)는 반복문에서만 사용 가능 */
    FOR I IN 1..10 LOOP
        TOT := TOT + I;
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE('1~10 범위의 정수들의 합계 = '||TOT);
END;
/
    
--FOR LOOP 구문을 이용하여 테이블의 다중 검색행에 대한 반복 처리 - 내부적 커서(CURSOR) 이용
--형식)FOR RECODE_VARIABLE IN (SELECT 검색대상,... FROM 테이블명 [WHERE 조건식]) LOOP 명령;명령;... END LOOP;

--EMP 테이블의 모든 사원을 검색하여 사원번호와 사원이름을 출력하는 PL/SQL 작성
BEGIN
    /* 검색행을 하나씩 전달받아 저장하는 레코드 변수 - FOR 구문에서만 사용 가능 */
    FOR VEMP IN (SELECT EMPNO,ENAME FROM EMP) LOOP
        DBMS_OUTPUT.PUT_LINE('사원번호 = '||VEMP.EMPNO||', 사원이름 = '||VEMP.ENAME);
    END LOOP;
END;
/

--커서(CURSOR) : 테이블의 검색행을 저장하여 처리하기 위한 기능을 제공
--1.묵시적 커서 : 검색 결과가 단일행인 경우를 처리하기 위한 커서
--2.명시적 커서 : 검색 결과가 다중행인 경우를 처리하기 위한 커서

--명시적 커서의 선언 및 사용방법
--형식)DECLARE 
--         CURSOR 커서명 IS SELECT 검색대상,... FROM 테이블명 [WHERE 조건식]
--    BEGIN 
--         OPEN 커서명;
--         FETCH 커서명 INTO 변수명,변수명,...;
--         CLOSE 커서명;

--DEPT 테이블에 저장된 모든 부서정보를 검색하여 화면에 출력하는 PL/SQL 작성
DECLARE
    /* 커서 선언 및 검색 결과 저장 */
    CURSOR C IS SELECT * FROM DEPT;
    /* 레코드 변수 선언 */
    VDEPT DEPT%ROWTYPE;
BEGIN
    /* 커서 열기 : 첫번째 검색행을 제공받기 위해 커서위치 이동 */
    OPEN C;

    /* 커서에 저장된 다중 검색행을 반복 처리 */
    LOOP
        /* 커서위치의 검색행에 대한 컬럼값을 제공받아 변수에 저장 */
        /* >> 커서위치의 검색행을 제공받은 후 커서위치는 다음행으로 자동 이동 */
        FETCH C INTO VDEPT;
        /* 커서위치에 검색행이 더이상 존재하지 않는 경우 반복문 종료 */
        EXIT WHEN C%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('부서번호 = '||VDEPT.DEPTNO||', 부서이름 = '||VDEPT.DNAME||', 부서위치 = '||VDEPT.LOC);
    END LOOP;
    
    /* 커서 닫기 */
    CLOSE C;
END;
/

--DEPT 테이블에 저장된 모든 부서정보를 검색하여 화면에 출력하는 PL/SQL 작성
DECLARE
    CURSOR C IS SELECT * FROM DEPT;
    VDEPT DEPT%ROWTYPE;
BEGIN
    /* FOR LOOP를 이용하면 커서에 대한 OPEN,FETCH,CLOSE 구문을 사용하지 않아도 자동 처리  */
    FOR VDEPT IN C LOOP
        DBMS_OUTPUT.PUT_LINE('부서번호 = '||VDEPT.DEPTNO||', 부서이름 = '||VDEPT.DNAME||', 부서위치 = '||VDEPT.LOC);
    END LOOP;
END;
/
 
--DEPT 테이블에 저장된 모든 부서정보를 검색하여 화면에 출력하는 PL/SQL 작성
BEGIN
    /* CURSOR 대신 서브쿼리를 사용하여 검색결과를 제공받아 반복 처리 - 내부적 커서 사용  */
    FOR VDEPT IN (SELECT * FROM DEPT) LOOP
        DBMS_OUTPUT.PUT_LINE('부서번호 = '||VDEPT.DEPTNO||', 부서이름 = '||VDEPT.DNAME||', 부서위치 = '||VDEPT.LOC);
    END LOOP;
END;
/

--WHILE LOOP : 반복횟수가 정해져 있지 않을 경우 사용하는 반복문
--형식)WHILE 조건식 LOOP 명령;명령;... END LOOP;

--1~10 범위의 정수들의 합계를 계산하여 출력하는 PL/SQL 작성
DECLARE
    I NUMBER(2) := 1;
    TOT NUMBER(2) := 0;
BEGIN
    WHILE I <= 10 LOOP
        TOT := TOT + I;
        I := I + 1;
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE('1~10 범위의 정수들의 합계 = '||TOT);
END;
/

--저장 프로시저(STORED PROCEDURE) : PL/SQL 프로시저에 이름을 부여하여 저장하고 필요한 경우 호출하여 사용하는 기능을 제공

--저장 프로시저 생성
--형식)CREATE [OR REPLACE] PROCEDURE 프로시저명[(매개변수 [MODE] 자료형,매개변수 [MODE] 자료형,...)]
--     IS [변수선언부] BEGIN 명령;명령;... END; 

--EMP2 테이블에 저장된 모든 행을 삭제하는 저장 프로시저 생성
CREATE OR REPLACE PROCEDURE DELETE_ALL_EMP2 IS
BEGIN
    DELETE FROM EMP2;
    COMMIT;
END;
/
    
--저장 프로시저 확인 - USER_SOURCE : 저장 프로시저와 저장 함수의 정보를 제공하는 딕셔너리
SELECT NAME,TEXT FROM USER_SOURCE WHERE NAME='DELETE_ALL_EMP2';

--저장 프로시저 호출
--형식)EXECUTE 프로시저[({값|변수},{값|변수},...)]

--DELETE_ALL_EMP2 프로시저 호출
SELECT * FROM EMP2;
EXECUTE DELETE_ALL_EMP2;
SELECT * FROM EMP2;

--저장 프로시저 생성시 컴파일 에러가 발생된 경우 컴파일 로그 확인
SHOW ERROR;

--저장 프로시저 삭제
--형식)DROP PROCEDURE 프로시저명

--DELETE_ALL_EMP2 저장 프로시저 삭제
DROP PROCEDURE DELETE_ALL_EMP2;
SELECT NAME,TEXT FROM USER_SOURCE WHERE NAME='DELETE_ALL_EMP2';

--매개변수 모드(MODE)
--1.IN : 외부값을 저장 프로시저에 전달받아 PL/SQL에서 사용할 목적의 매개변수 - 값을 전달받아 저장
--2.OUT : PL/SQL 실행 결과값을 저장 프로시저 외부에 전달할 목적의 매개변수 - 변수를 전달받아 저장
--3.INOUT : IN 모드와 OUT 모드를 모두 제공하는 매개변수

--사원번호를 매개변수로 전달받아 EMP 테이블에서 전달받은 사원번호에 대한 사원의 사원이름,업무,급여를 검색하여
--매개변수에 저장해 외부에 제공하는 저장 프로시저 생성
CREATE OR REPLACE PROCEDURE SELECT_EMPNO(VEMPNO IN EMP.EMPNO%TYPE, VENAME OUT EMP.ENAME%TYPE
    , VJOB OUT EMP.JOB%TYPE, VSAL OUT EMP.SAL%TYPE) IS
BEGIN
    SELECT ENAME,JOB,SAL INTO VENAME,VJOB,VSAL FROM EMP WHERE EMPNO=VEMPNO;
END;
/
    
--OUT 매개변수에 의해 제공되는 값을 저장하기 위한 바인딩 변수 선언
--바인딩 변수 : 현재 접속 세션에서만 사용할 수 있는 변수
--형식)VARIABLE 변수명 자료형
VARIABLE VAR_ENAME VARCHAR2(15);
VARIABLE VAR_JOB VARCHAR2(20);
VARIABLE VAR_SAL NUMBER;

--SELECT_EMPNO 저장 프로시저 호출 : IN 매개변수에는 값을 전달하고 OUT 매개변수에는 바인딩 변수를 전달하여 호출
--바인딩 변수에 값을 저장할 경우 변수명 앞에 :를 붙여 사용
EXECUTE SELECT_EMPNO(7788, :VAR_ENAME, :VAR_JOB, :VAR_SAL);

--바인딩 변수에 저장된 값 출력
--형식)PRINT 바인딩변수명
PRINT VAR_ENAME;
PRINT VAR_JOB;
PRINT VAR_SAL;

--저장 함수(STORED FUNCTION) : 저장 프로시저와 유사한 기능을 제공하지만 반드시 값 반환

--저장 함수 생성
--형식)CREATE [OR REPLACE] FUNCTION 저장함수명[(매개변수 [MODE] 자료형,매개변수 [MODE] 자료형,...)]
--     RETURN 자료형 IS [변수선언부] BEGIN 명령;명령;... RETURN 대상; END; 

--사원번호를 전달받아 EMP 테이블에서 해당 사원번호에 대한 사원 급여의 200% 연산 결과값을 반환하는 저장 함수 생성
CREATE OR REPLACE FUNCTION CAL_SAL(VEMPNO IN EMP.EMPNO%TYPE) RETURN NUMBER IS 
    VSAL NUMBER(7,2);
BEGIN
    SELECT SAL INTO VSAL FROM EMP WHERE EMPNO=VEMPNO;
    RETURN (VSAL*2.0);
END;
/

--저장 함수 확인
SELECT NAME,TEXT FROM USER_SOURCE WHERE NAME='CAL_SAL';

--반환값을 저장하기 위한 바인딩 변수 선언
VARIABLE VAR_SAL NUMBER;

--저장 함수 호출 : 함수의 반환값을 바인딩 변수에 저장
EXECUTE :VAR_SAL := CAL_SAL(7788);

--바인딩 변수에 저장된 값 출력
PRINT VAR_SAL;

--저장 함수는 SQL 명령에 포함하여 사용 가능
SELECT EMPNO,ENAME,SAL,CAL_SAL(EMPNO) "특별수당" FROM EMP;

--저장 함수 삭제
--형식)DROP FUNCTION 저장함수명

--CAL_SAL 저장 함수 삭제
DROP FUNCTION CAL_SAL;
SELECT NAME,TEXT FROM USER_SOURCE WHERE NAME='CAL_SAL';

--트리거(TRIGGER) : 특정 SQL 명령이 실행될 경우 PL/SQL 프로시저를 이용하여 자동 실행되는 기능 제공 

--트리거 생성
--형식)CREATE [OR REPLACE] TRIGGER 트리거명 {BEFORE|AFTER} {INSERT|UPDATE|DELETE} ON 테이블명
--     [FOR EACH ROW] [WITH 조건식] BEGIN 명령;명령;... END;
--FOR EACH ROW : 생략된 경우 문장 레벨 트리거 생성하고 선언된 경우 행 레벨 트리거 생성
--문장 레벨 트리거 : 이벤트 DML 명령이 실행되면 트리거에 작성된 PL/SQL 프로시저가 한번만 실행 
--행 레벨 트리거 : 이벤트 DML 명령이 실행되면 트리거에 작성된 PL/SQL 프로시저가 행의 갯수만큼 실행 
--트리거 생성시 PL/SQL 프로시저에 TCL 명령 사용 불가능

--SAWON 테이블에서 사원정보가 삽입될 경우 명령 실행 후 메세지를 출력하는 트리거 생성
CREATE OR REPLACE TRIGGER SAWON_INSERT AFTER INSERT ON SAWON
BEGIN 
    DBMS_OUTPUT.PUT_LINE('새로운 사원이 입사 하였습니다.');
END;    
/

--트리거 확인 - USER_TRIGGERS : 트리거 정보를 제공하는 딕셔너리
SELECT * FROM USER_TRIGGERS;

--SAWON 테이블에 행 삽입 - INSERT 명령 실행 뒤 SAWON_INSERT 트리거 동작
SELECT * FROM SAWON;
INSERT INTO SAWON VALUES(3000,'전우치',10); 
SELECT * FROM SAWON;
COMMIT;

--EMP 테이블에 모든 사원의 사원번호,사원이름,급여,부서번호를 검색하여 EMP_TRI를 테이블을 생성하고 행 복사
CREATE TABLE EMP_TRI AS SELECT EMPNO,ENAME,SAL,DEPTNO FROM EMP;
SELECT * FROM EMP_TRI;

--EMP_HIS 테이블 생성 : 사원번호(숫자형),사원이름(문자형),사원상태(문자형)
CREATE TABLE EMP_HIS(NO NUMBER(4),NAME VARCHAR2(20),STATUS VARCHAR2(50));

--EMP_TRI 테이블에서 행을 삽입하거나 변경 또는 삭제한 경우 명령 실행 후 행 삽입, 변경 또는 삭제에 대한 이유를 
--EMP_HIS 테이블에 삽입하는 트리거 생성
CREATE OR REPLACE TRIGGER INSERT_EMP_HIS AFTER INSERT OR UPDATE OR DELETE ON EMP_TRI FOR EACH ROW
BEGIN
    /* NEW.컬럼명 : 삽입행 또는 변경행의 새로운 컬럼값 표현 */
    /* OLD.컬럼명 : 삭제행 또는 변경행의 기존 컬럼값 표현 */
    IF INSERTING THEN
        INSERT INTO EMP_HIS VALUES(:NEW.EMPNO, :NEW.ENAME, '입사');
    ELSIF UPDATING THEN
        IF :NEW.DEPTNO <> :OLD.DEPTNO THEN
            INSERT INTO EMP_HIS VALUES(:OLD.EMPNO, :OLD.ENAME, '부서이동');
        END IF;
    ELSIF DELETING THEN
        INSERT INTO EMP_HIS VALUES(:OLD.EMPNO, :OLD.ENAME, '퇴사');
    END IF;
END;
/

--트리거 확인
SELECT * FROM USER_TRIGGERS;

--INSERT_EMP_HIS 트리거 동작 확인 >> EMP_TRI 테이블에서 행에 대한 삽입,변경,삭제 명령 실행
SELECT * FROM EMP_TRI;
INSERT INTO EMP_TRI VALUES(5000,'PARK',2000,10);
SELECT * FROM EMP_TRI;
SELECT * FROM EMP_HIS;

UPDATE EMP_TRI SET DEPTNO=20 WHERE EMPNO=5000;
SELECT * FROM EMP_TRI;
SELECT * FROM EMP_HIS;
UPDATE EMP_TRI SET SAL=3000 WHERE EMPNO=5000;
SELECT * FROM EMP_TRI;
SELECT * FROM EMP_HIS;

DELETE FROM EMP_TRI;
SELECT * FROM EMP_TRI;
SELECT * FROM EMP_HIS;
