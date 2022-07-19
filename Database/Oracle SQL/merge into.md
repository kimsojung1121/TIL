- 참고
  - [[Oracle] 오라클 MERGE INTO 사용법 & 노하우 정리](https://gent.tistory.com/406)

## 오라클 MERGE문
- 오라클 9i부터 사용 가능
> delete절은 10i부터
- 하나의 쿼리문 내에서 조건에 따라 insert, update, delete가 가능하다.

- 기본 문법
```sql
MERGE
  INTO {테이블|뷰} a        --별칭 a
USING {테이블|뷰|서브쿼리} b --별칭 b
  ON (a.pk_num = b.pk_num) --조건절
WHEN MATCHED THEN     --일치하는 경우 {UPDATE|DELETE}
  UPDATE SET a.job = b.job
  DELETE
WHEN NOT MATCHED THEN --불일치하는 경우 INSERT
  INSERT (a.pk_num, a.job)
  VALUES (b.pk_num, b.job)
```

- 단일 테이블 MERGE
  - USING절에 dual 테이블을 사용하면 된다.
```SQL
MERGE 
 INTO emp a
USING dual
   ON (a.empno = 7788)
 WHEN MATCHED THEN
      UPDATE
         SET a.deptno = 20
 WHEN NOT MATCHED THEN
      INSERT (a.empno, a.ename, a.deptno)
      VALUES (7788, 'SCOTT', 20);
```

- 조인 사용
- 서브쿼리 사용
- WHERE절 사용
  - INSERT절에 사용하면 오류 발생한다.
```SQL
MERGE 
 INTO emp a
USING dual
   ON (a.empno = 7788)
 WHEN MATCHED THEN
      UPDATE
         SET a.deptno = 20
       WHERE a.job = 'ANALYST';
```

- DELETE절 사용
  - WHERE절 작성하지 않고 사용하면 매칭되는 모든 데이터가 삭제된다.
```SQL
MERGE 
 INTO emp a
USING dual
   ON (a.empno = 7788)
 WHEN MATCHED THEN
      UPDATE
         SET a.deptno = 20
       WHERE a.job = 'ANALYST'
      DELETE
       WHERE a.job <> 'ANALYST';
```
