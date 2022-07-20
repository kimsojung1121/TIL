### 오라클 LAG, LEAD 함수 (이전값, 다음값)
```SQL
LAG(expr [,offset] [,default]) OVER([partition_by_clause] order_by_clause)
LEAD(expr [,offset] [,default]) OVER([partition_by_clause] order_by_clause)
```
- `LAG()` : 이전 행의 값을 리턴

- `LEAD()` : 다음 행의 값을 리턴

- `expr` : 대상 컬럼명

- `offset` : 값을 가져올 행의 위치 기본값은 1, 생략가능

- `default` : 값이 없을 경우 기본값, 생략가능

- `partition_by_clause` : 그룹 컬럼명, 생략가능

- `order_by_clause` : 정렬 컬럼명, **필수**

#### 기본
```SQL
SELECT empno
     , ename
     , job
     , sal
     , LAG(empno) OVER(ORDER BY empno)  AS empno_prev
     , LEAD(empno) OVER(ORDER BY empno) AS empno_next
  FROM emp 
 WHERE job IN ('MANAGER', 'ANALYST', 'SALESMAN')
```
- `SELECT * FROM EMP WHERE JOB IN ('MANAGER', 'ANALYST', 'SALESMAN')` 결과를 기준으로,
EMPNO으로 정렬하여 현재 행의 이전 행 EMPNO과 다음 행 EMPNO을 표시한다.

#### LAG()
```SQL
SELECT empno
     , ename
     , job
     , sal
     , LAG(empno, 2, 9999) OVER(ORDER BY empno) AS empno_prev
  FROM emp 
 WHERE job IN ('MANAGER', 'ANALYST', 'SALESMAN')
```
- 현재 행을의 2번째 이전 행의 값을 조회하되, 가져올 행이 없으면 default 값을 9999로 설정한다.

### PARTITON BY
```SQL
SELECT empno
     , ename
     , job
     , sal
     , LAG(job) OVER(PARTITION BY job ORDER BY empno) AS empno_prev
  FROM emp 
 WHERE job IN ('MANAGER', 'ANALYST', 'SALESMAN')
```
- JOB 컬럼 내에서의 이전값을 조회한다. 
- 이전 EMPNO값이 있더라도 동일한 JOB이 아니면 NULL
