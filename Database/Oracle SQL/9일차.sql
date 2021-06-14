--�ݺ��� : ����� �ݺ������� �����ϱ� ���� ����
SET SERVEROUT ON;

--BASIC LOOP : ���ѹݺ� - ���ù��� �̿��Ͽ� EXIT ������� �ݺ��� ����
--����)LOOP ���; ���;... END LOOP;

--1~5 ������ ���ڰ��� ����ϴ� PL/SQL �ۼ�
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
    
--FOR LOOP : �ݺ�Ƚ���� ������ �ִ� ��� ����ϴ� �ݺ���    
--����)FOR INDEX_COUNTER IN [REVERSE] LOWER_BOUND..HIGH_BOUND LOOP ���;���;... END LOOP;

--1~10 ������ �������� �հ踦 ����Ͽ� ����ϴ� PL/SQL �ۼ�
DECLARE
    TOT NUMBER(2) := 0;
BEGIN
    /* FOR LOOP ������ ����(INDEX_COUNTER)�� �ݺ��������� ��� ���� */
    FOR I IN 1..10 LOOP
        TOT := TOT + I;
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE('1~10 ������ �������� �հ� = '||TOT);
END;
/
    
--FOR LOOP ������ �̿��Ͽ� ���̺��� ���� �˻��࿡ ���� �ݺ� ó�� - ������ Ŀ��(CURSOR) �̿�
--����)FOR RECODE_VARIABLE IN (SELECT �˻����,... FROM ���̺�� [WHERE ���ǽ�]) LOOP ���;���;... END LOOP;

--EMP ���̺��� ��� ����� �˻��Ͽ� �����ȣ�� ����̸��� ����ϴ� PL/SQL �ۼ�
BEGIN
    /* �˻����� �ϳ��� ���޹޾� �����ϴ� ���ڵ� ���� - FOR ���������� ��� ���� */
    FOR VEMP IN (SELECT EMPNO,ENAME FROM EMP) LOOP
        DBMS_OUTPUT.PUT_LINE('�����ȣ = '||VEMP.EMPNO||', ����̸� = '||VEMP.ENAME);
    END LOOP;
END;
/

--Ŀ��(CURSOR) : ���̺��� �˻����� �����Ͽ� ó���ϱ� ���� ����� ����
--1.������ Ŀ�� : �˻� ����� �������� ��츦 ó���ϱ� ���� Ŀ��
--2.����� Ŀ�� : �˻� ����� �������� ��츦 ó���ϱ� ���� Ŀ��

--����� Ŀ���� ���� �� �����
--����)DECLARE 
--         CURSOR Ŀ���� IS SELECT �˻����,... FROM ���̺�� [WHERE ���ǽ�]
--    BEGIN 
--         OPEN Ŀ����;
--         FETCH Ŀ���� INTO ������,������,...;
--         CLOSE Ŀ����;

--DEPT ���̺� ����� ��� �μ������� �˻��Ͽ� ȭ�鿡 ����ϴ� PL/SQL �ۼ�
DECLARE
    /* Ŀ�� ���� �� �˻� ��� ���� */
    CURSOR C IS SELECT * FROM DEPT;
    /* ���ڵ� ���� ���� */
    VDEPT DEPT%ROWTYPE;
BEGIN
    /* Ŀ�� ���� : ù��° �˻����� �����ޱ� ���� Ŀ����ġ �̵� */
    OPEN C;

    /* Ŀ���� ����� ���� �˻����� �ݺ� ó�� */
    LOOP
        /* Ŀ����ġ�� �˻��࿡ ���� �÷����� �����޾� ������ ���� */
        /* >> Ŀ����ġ�� �˻����� �������� �� Ŀ����ġ�� ���������� �ڵ� �̵� */
        FETCH C INTO VDEPT;
        /* Ŀ����ġ�� �˻����� ���̻� �������� �ʴ� ��� �ݺ��� ���� */
        EXIT WHEN C%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('�μ���ȣ = '||VDEPT.DEPTNO||', �μ��̸� = '||VDEPT.DNAME||', �μ���ġ = '||VDEPT.LOC);
    END LOOP;
    
    /* Ŀ�� �ݱ� */
    CLOSE C;
END;
/

--DEPT ���̺� ����� ��� �μ������� �˻��Ͽ� ȭ�鿡 ����ϴ� PL/SQL �ۼ�
DECLARE
    CURSOR C IS SELECT * FROM DEPT;
    VDEPT DEPT%ROWTYPE;
BEGIN
    /* FOR LOOP�� �̿��ϸ� Ŀ���� ���� OPEN,FETCH,CLOSE ������ ������� �ʾƵ� �ڵ� ó��  */
    FOR VDEPT IN C LOOP
        DBMS_OUTPUT.PUT_LINE('�μ���ȣ = '||VDEPT.DEPTNO||', �μ��̸� = '||VDEPT.DNAME||', �μ���ġ = '||VDEPT.LOC);
    END LOOP;
END;
/
 
--DEPT ���̺� ����� ��� �μ������� �˻��Ͽ� ȭ�鿡 ����ϴ� PL/SQL �ۼ�
BEGIN
    /* CURSOR ��� ���������� ����Ͽ� �˻������ �����޾� �ݺ� ó�� - ������ Ŀ�� ���  */
    FOR VDEPT IN (SELECT * FROM DEPT) LOOP
        DBMS_OUTPUT.PUT_LINE('�μ���ȣ = '||VDEPT.DEPTNO||', �μ��̸� = '||VDEPT.DNAME||', �μ���ġ = '||VDEPT.LOC);
    END LOOP;
END;
/

--WHILE LOOP : �ݺ�Ƚ���� ������ ���� ���� ��� ����ϴ� �ݺ���
--����)WHILE ���ǽ� LOOP ���;���;... END LOOP;

--1~10 ������ �������� �հ踦 ����Ͽ� ����ϴ� PL/SQL �ۼ�
DECLARE
    I NUMBER(2) := 1;
    TOT NUMBER(2) := 0;
BEGIN
    WHILE I <= 10 LOOP
        TOT := TOT + I;
        I := I + 1;
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE('1~10 ������ �������� �հ� = '||TOT);
END;
/

--���� ���ν���(STORED PROCEDURE) : PL/SQL ���ν����� �̸��� �ο��Ͽ� �����ϰ� �ʿ��� ��� ȣ���Ͽ� ����ϴ� ����� ����

--���� ���ν��� ����
--����)CREATE [OR REPLACE] PROCEDURE ���ν�����[(�Ű����� [MODE] �ڷ���,�Ű����� [MODE] �ڷ���,...)]
--     IS [���������] BEGIN ���;���;... END; 

--EMP2 ���̺� ����� ��� ���� �����ϴ� ���� ���ν��� ����
CREATE OR REPLACE PROCEDURE DELETE_ALL_EMP2 IS
BEGIN
    DELETE FROM EMP2;
    COMMIT;
END;
/
    
--���� ���ν��� Ȯ�� - USER_SOURCE : ���� ���ν����� ���� �Լ��� ������ �����ϴ� ��ųʸ�
SELECT NAME,TEXT FROM USER_SOURCE WHERE NAME='DELETE_ALL_EMP2';

--���� ���ν��� ȣ��
--����)EXECUTE ���ν���[({��|����},{��|����},...)]

--DELETE_ALL_EMP2 ���ν��� ȣ��
SELECT * FROM EMP2;
EXECUTE DELETE_ALL_EMP2;
SELECT * FROM EMP2;

--���� ���ν��� ������ ������ ������ �߻��� ��� ������ �α� Ȯ��
SHOW ERROR;

--���� ���ν��� ����
--����)DROP PROCEDURE ���ν�����

--DELETE_ALL_EMP2 ���� ���ν��� ����
DROP PROCEDURE DELETE_ALL_EMP2;
SELECT NAME,TEXT FROM USER_SOURCE WHERE NAME='DELETE_ALL_EMP2';

--�Ű����� ���(MODE)
--1.IN : �ܺΰ��� ���� ���ν����� ���޹޾� PL/SQL���� ����� ������ �Ű����� - ���� ���޹޾� ����
--2.OUT : PL/SQL ���� ������� ���� ���ν��� �ܺο� ������ ������ �Ű����� - ������ ���޹޾� ����
--3.INOUT : IN ���� OUT ��带 ��� �����ϴ� �Ű�����

--�����ȣ�� �Ű������� ���޹޾� EMP ���̺��� ���޹��� �����ȣ�� ���� ����� ����̸�,����,�޿��� �˻��Ͽ�
--�Ű������� ������ �ܺο� �����ϴ� ���� ���ν��� ����
CREATE OR REPLACE PROCEDURE SELECT_EMPNO(VEMPNO IN EMP.EMPNO%TYPE, VENAME OUT EMP.ENAME%TYPE
    , VJOB OUT EMP.JOB%TYPE, VSAL OUT EMP.SAL%TYPE) IS
BEGIN
    SELECT ENAME,JOB,SAL INTO VENAME,VJOB,VSAL FROM EMP WHERE EMPNO=VEMPNO;
END;
/
    
--OUT �Ű������� ���� �����Ǵ� ���� �����ϱ� ���� ���ε� ���� ����
--���ε� ���� : ���� ���� ���ǿ����� ����� �� �ִ� ����
--����)VARIABLE ������ �ڷ���
VARIABLE VAR_ENAME VARCHAR2(15);
VARIABLE VAR_JOB VARCHAR2(20);
VARIABLE VAR_SAL NUMBER;

--SELECT_EMPNO ���� ���ν��� ȣ�� : IN �Ű��������� ���� �����ϰ� OUT �Ű��������� ���ε� ������ �����Ͽ� ȣ��
--���ε� ������ ���� ������ ��� ������ �տ� :�� �ٿ� ���
EXECUTE SELECT_EMPNO(7788, :VAR_ENAME, :VAR_JOB, :VAR_SAL);

--���ε� ������ ����� �� ���
--����)PRINT ���ε�������
PRINT VAR_ENAME;
PRINT VAR_JOB;
PRINT VAR_SAL;

--���� �Լ�(STORED FUNCTION) : ���� ���ν����� ������ ����� ���������� �ݵ�� �� ��ȯ

--���� �Լ� ����
--����)CREATE [OR REPLACE] FUNCTION �����Լ���[(�Ű����� [MODE] �ڷ���,�Ű����� [MODE] �ڷ���,...)]
--     RETURN �ڷ��� IS [���������] BEGIN ���;���;... RETURN ���; END; 

--�����ȣ�� ���޹޾� EMP ���̺��� �ش� �����ȣ�� ���� ��� �޿��� 200% ���� ������� ��ȯ�ϴ� ���� �Լ� ����
CREATE OR REPLACE FUNCTION CAL_SAL(VEMPNO IN EMP.EMPNO%TYPE) RETURN NUMBER IS 
    VSAL NUMBER(7,2);
BEGIN
    SELECT SAL INTO VSAL FROM EMP WHERE EMPNO=VEMPNO;
    RETURN (VSAL*2.0);
END;
/

--���� �Լ� Ȯ��
SELECT NAME,TEXT FROM USER_SOURCE WHERE NAME='CAL_SAL';

--��ȯ���� �����ϱ� ���� ���ε� ���� ����
VARIABLE VAR_SAL NUMBER;

--���� �Լ� ȣ�� : �Լ��� ��ȯ���� ���ε� ������ ����
EXECUTE :VAR_SAL := CAL_SAL(7788);

--���ε� ������ ����� �� ���
PRINT VAR_SAL;

--���� �Լ��� SQL ��ɿ� �����Ͽ� ��� ����
SELECT EMPNO,ENAME,SAL,CAL_SAL(EMPNO) "Ư������" FROM EMP;

--���� �Լ� ����
--����)DROP FUNCTION �����Լ���

--CAL_SAL ���� �Լ� ����
DROP FUNCTION CAL_SAL;
SELECT NAME,TEXT FROM USER_SOURCE WHERE NAME='CAL_SAL';

--Ʈ����(TRIGGER) : Ư�� SQL ����� ����� ��� PL/SQL ���ν����� �̿��Ͽ� �ڵ� ����Ǵ� ��� ���� 

--Ʈ���� ����
--����)CREATE [OR REPLACE] TRIGGER Ʈ���Ÿ� {BEFORE|AFTER} {INSERT|UPDATE|DELETE} ON ���̺��
--     [FOR EACH ROW] [WITH ���ǽ�] BEGIN ���;���;... END;
--FOR EACH ROW : ������ ��� ���� ���� Ʈ���� �����ϰ� ����� ��� �� ���� Ʈ���� ����
--���� ���� Ʈ���� : �̺�Ʈ DML ����� ����Ǹ� Ʈ���ſ� �ۼ��� PL/SQL ���ν����� �ѹ��� ���� 
--�� ���� Ʈ���� : �̺�Ʈ DML ����� ����Ǹ� Ʈ���ſ� �ۼ��� PL/SQL ���ν����� ���� ������ŭ ���� 
--Ʈ���� ������ PL/SQL ���ν����� TCL ��� ��� �Ұ���

--SAWON ���̺��� ��������� ���Ե� ��� ��� ���� �� �޼����� ����ϴ� Ʈ���� ����
CREATE OR REPLACE TRIGGER SAWON_INSERT AFTER INSERT ON SAWON
BEGIN 
    DBMS_OUTPUT.PUT_LINE('���ο� ����� �Ի� �Ͽ����ϴ�.');
END;    
/

--Ʈ���� Ȯ�� - USER_TRIGGERS : Ʈ���� ������ �����ϴ� ��ųʸ�
SELECT * FROM USER_TRIGGERS;

--SAWON ���̺� �� ���� - INSERT ��� ���� �� SAWON_INSERT Ʈ���� ����
SELECT * FROM SAWON;
INSERT INTO SAWON VALUES(3000,'����ġ',10); 
SELECT * FROM SAWON;
COMMIT;

--EMP ���̺� ��� ����� �����ȣ,����̸�,�޿�,�μ���ȣ�� �˻��Ͽ� EMP_TRI�� ���̺��� �����ϰ� �� ����
CREATE TABLE EMP_TRI AS SELECT EMPNO,ENAME,SAL,DEPTNO FROM EMP;
SELECT * FROM EMP_TRI;

--EMP_HIS ���̺� ���� : �����ȣ(������),����̸�(������),�������(������)
CREATE TABLE EMP_HIS(NO NUMBER(4),NAME VARCHAR2(20),STATUS VARCHAR2(50));

--EMP_TRI ���̺��� ���� �����ϰų� ���� �Ǵ� ������ ��� ��� ���� �� �� ����, ���� �Ǵ� ������ ���� ������ 
--EMP_HIS ���̺� �����ϴ� Ʈ���� ����
CREATE OR REPLACE TRIGGER INSERT_EMP_HIS AFTER INSERT OR UPDATE OR DELETE ON EMP_TRI FOR EACH ROW
BEGIN
    /* NEW.�÷��� : ������ �Ǵ� �������� ���ο� �÷��� ǥ�� */
    /* OLD.�÷��� : ������ �Ǵ� �������� ���� �÷��� ǥ�� */
    IF INSERTING THEN
        INSERT INTO EMP_HIS VALUES(:NEW.EMPNO, :NEW.ENAME, '�Ի�');
    ELSIF UPDATING THEN
        IF :NEW.DEPTNO <> :OLD.DEPTNO THEN
            INSERT INTO EMP_HIS VALUES(:OLD.EMPNO, :OLD.ENAME, '�μ��̵�');
        END IF;
    ELSIF DELETING THEN
        INSERT INTO EMP_HIS VALUES(:OLD.EMPNO, :OLD.ENAME, '���');
    END IF;
END;
/

--Ʈ���� Ȯ��
SELECT * FROM USER_TRIGGERS;

--INSERT_EMP_HIS Ʈ���� ���� Ȯ�� >> EMP_TRI ���̺��� �࿡ ���� ����,����,���� ��� ����
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
