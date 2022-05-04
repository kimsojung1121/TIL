## [GROUP BY](https://programmers.co.kr/learn/courses/30/parts/17044)

### 고양이와 개는 몇 마리 있을까
```
-- 코드를 입력하세요
SELECT ANIMAL_TYPE, COUNT(1) FROM ANIMAL_INS GROUP BY ANIMAL_TYPE ORDER BY ANIMAL_TYPE;
```

### 동명 동물 수 찾기
```
-- 코드를 입력하세요
SELECT NAME, COUNT(NAME) FROM ANIMAL_INS
GROUP BY NAME HAVING COUNT(NAME) >='2'
ORDER BY NAME;
```

### 입양 시각 구하기(1)
```
SELECT* FROM 
(select to_char(datetime, 'HH24') AS HOUR
       ,COUNT(1)
from ANIMAL_OUTS
GROUP BY to_char(datetime, 'HH24')
)
WHERE HOUR BETWEEN '09' AND '19'
ORDER BY HOUR;
```

### 입양 시각 구하기(2)
```
SELECT* FROM 
(select to_char(datetime, 'HH24') AS HOUR
       ,COUNT(1)
from ANIMAL_OUTS
GROUP BY to_char(datetime, 'HH24')
)
WHERE HOUR BETWEEN '09' AND '19'
ORDER BY HOUR;
```

**시간대별로 출력 안 됨**
=> 틀 만들어서 짜보기
```
SELECT ROWNUM+8 FROM DUAL
CONNECT BY LEVEL <= 11
```
