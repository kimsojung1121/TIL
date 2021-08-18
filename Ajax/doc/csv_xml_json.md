## 데이터 전송 형식

### CSV(Comma Deparated Value)
- 쉼표를 기준으로 항목을 구분하여 저장한 데이터
- 가독성이 떨어진다
- `split()` 메소드로 분해하여 처리
- 비구조적 형태의 text 데이터
- 용량이 적다

---

### XML(eXtensible Markup Language)
- 다목적 마크업 언어
- 가독성이 좋다 - 엘리먼트를 이용해 값을 구조적으로 표현
- 용량이 크다
- XML 문서를 만들기 위해서는 XML 선언문이 있어야 함
```
<?xml version="1.0" encoding="utf-8"?>
```

---

### JSON(JavaScript Object Notation)
- '속성-값 쌍' 또는 '키-값 쌍'으로 이루어진 데이터 Object를 전달하기 위한 개방형 표준 포맷
- 서버 통신 REST API를 사용할 때 가장 많이 사용
