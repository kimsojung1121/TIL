### CLOB -> String


- 데이터 타입을 CLOB으로 선언한 경우, 평소처럼 mybatis select 구문을 사용하여 조회 시 에러 발생
- CLOB 형태의 데이터는 json 형식으로 변환할 수 없음
- CLOB 타입을 String 타입으로 변경해 줘야 함
- `resultMap` 태그 사용

----


**변경 전**
```
<select id="id값" resultType="egoMap">
  select 
    a,
    b,
    c --데이터 타입 : clob
  from 테이블명
</select>
```

**변경 후**
```
<!-- clob 처리 -->
<resultMap id="resultMap_id값" type="egoMap">
  <result property="c" cloumn="c" jdbcType="CLOB" javaType="java.lang.String"/>
</resultMap>

<select id="id값" resultMap="resultMap_id값">
  select 
    a,
    b,
    c --데이터 타입 : clob
  from 테이블명
</select>
```


- resultMap id값이 일치해야 함

- property와 cloumn명을 따로 지정할 수 있어 컬럼명과 아이디값이 다른 경우 활용 가능(그러나 별칭으로 하는 게 효율적일 것 같다)
