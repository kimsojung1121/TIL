### WITH절

- 오라클9 이후 버전부터 사용 가능
- 이름이 부여된 서브쿼리(임시테이블 생성)
- VIEW와 달리 쿼리문 내에서만 실행된다
- 여러번 사용되는 구문을 WITH절로 정의할 경우 성능 향상
- **한 번만 사용되는 구문을 WITH절로 정의할 경우 단순 서브쿼리와 큰 차이가 있지 않음**




```SQL
WITH WITH절명 AS (
  SELECT * FROM 테이블명
  WHERE 조건
)
SELECT * 
  FROM WITH절명
```


```SQL
WITH WITH절1 AS (
  SELECT * FROM 테이블명
  WHERE 조건
)
, WITH절2 AS (
  SELECT * FROM 테이블명
  WHERE 조건
)
SELECT * 
  FROM WITH절1, WITH절2 
```
- WITH절 여러개 사용 가능
