- OVER() 함수 사용 시 ORDER BY, GROUP BY 서브쿼리 간략화 가능
- 테이블의 일부 행과 함수를 같이 출력하고 싶을 때 서브쿼리 사용하지 않고 OVER() 함수 사용


```sql
SELECT 컬럼1, 컬럼2
FROM 테이블명;
```

```sql
SELECT 컬럼1, 컬럼2, COUNT(1)
FROM 테이블명;
```
> ERROR : 단일 그룹의 그룹 함수가 아닙니다

```sql
SELECT 컬럼1, 컬럼2, COUNT(1)
FROM 테이블명
GROUP BY 컬럼1, 컬럼2;
```
- 에러는 안 뜨나 행 하나에 대해서만 함수가 적용됨


**방법 1**
```sql
SELECT 컬럼1, 컬럼2, 
    (SELECT COUNT(1) FROM 테이블명) AS COUNT_ALL
FROM 테이블명;
```

**방법 2**
```sql
SELECT 컬럼1, 컬럼2, COUNT(1) OVER() AS COUNT_ALL
FROM 테이블명;
```
