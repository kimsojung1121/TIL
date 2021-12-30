## [SQL SELECT](https://programmers.co.kr/learn/courses/30/parts/17042)

### 모든 레코드 조회하기

```
-- 코드를 입력하세요
SELECT * FROM ANIMAL_INS ORDER BY ANIMAL_ID;
```


### 역순 정렬하기

```
-- 코드를 입력하세요
SELECT NAME,DATETIME FROM ANIMAL_INS ORDER BY ANIMAL_ID DESC;
```


### 아픈 동물 찾기

```
-- 코드를 입력하세요
SELECT ANIMAL_ID,NAME FROM ANIMAL_INS WHERE INTAKE_CONDITION='SICK';
```

### 어린 동물 찾기

```
-- 코드를 입력하세요
SELECT ANIMAL_ID,NAME FROM ANIMAL_INS WHERE INTAKE_CONDITION != 'Aged';
```

### 동물의 아이디와 이름

```
-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME FROM ANIMAL_INS ORDER BY ANIMAL_ID;
```


### 여러 기준으로 정렬하기

```
-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME, DATETIME FROM ANIMAL_INS
ORDER BY NAME, DATETIME DESC;
```


### 상위 N개의 레코드

```
-- 코드를 입력하세요

SELECT NAME
FROM (
    SELECT NAME
    FROM ANIMAL_INS
    ORDER BY DATETIME
    )
WHERE ROWNUM <='1';
```

