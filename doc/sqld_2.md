#### 알게 된 것

- `NULLIF(COL1, COL2)` : COL1이 COL2와 같으면 NULL 반환, 같지 않으면 COL1 반환
- `COALESCE(COL1, CO2)` : NULL이 아닌 최초의 표현식 반환, 모두 NULL이면 NULL 반환
- `CHAR()`, `VARCHAR()` 차이
  - `CHAR()` : 고정 길이 문자열, 'AA' = 'AA  '
  - `VARCHAR()` : 가변 길이 문자열, 'AA' <> 'AA  '
- 연산자 우선순위 : () → NOT → 비교연산자 → AND → OR
- **Oracle에서는 NULL을 가장 큰값으로 취급하며, SQL Server에서는 가장 작은 값으로 취급한다**
- 문장 실행 순서 : SELECT ALIAS → FROM → WHERE → GROUP BY → HAVING → SELECT → ORDER BY
- INTERSECT : 교집합 연산자(중복행 제외)
- 계층형 쿼리
  - 계층형 쿼리에서 `PRIOR` 자식 = 부모 형태이면 부모에서 자식 방향으로 전개되는 순방향 전개이다.
  - `LEVEL`은 1부터 시작
  - `CONNECT_BY_ISLEAF` : 리프 데이터면 1, 아니면 0 반환
  - `CONNECT_BY_ISCYCLE` : 조상 데이터면 1, 아니면 0
  - `CONNECT_BY_ROOT` : 전개할 데이터의 루트 데이터를 표시, 단항 연산자
- `ROLLUP`, `CUBE`, `GROUPING SETS`
- `RANK`, `DENSE_RANK`, `ROW_NUMBER`
