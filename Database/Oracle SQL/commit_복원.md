```
select * from 테이블명 as of timestamp(systimestamp-interval '15' minute);
```

커밋 후 이전 데이터 확인
  
#### 백업
백업할 데이터 select 후, 질의결과에서 마우스 우클릭 - 익스포트 - 테이블 이름 기재 - 단일파일, 클립보드 등 저장방식 선택 
