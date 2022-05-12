**org.springframework.beans.factory.BeanCreationException**: Error creating bean with name ~`파일명`

nested exception is **org.springframework.beans.factory.BeanCreationException**: Error creating bean with name 'sqlSession' defined in file `파일명`

- sqlSession이 나오면서 빈을 생성할 수 없다고 하는 경우,,, 나의 경우엔 오탈자가 나거나 파일에서 아예 누락한 경우가 다였음
- .xml에서만 쓰고,, 해당 id를 .java에서 정의하지 않았거나 하는 경우. ..
- 서비스, 서비스임플, 매퍼, XML 다 확인하자! 

