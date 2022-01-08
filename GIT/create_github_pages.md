- repository 생성 시 [계정이름.github.io]로 생성하면 `https://계정이름.github.io/`으로 접속 가능  


- 또는 `Settings` - `Pages` - `Source` 항목에서 `None`을 `Master`로 변경 후 `Save`하면    
`https://사용자이름.github.io/repository이름/`으로 접속 가능


### Fork 해서 Github pages 만들기

1. [https://github.com/topics/jekyll-theme](https://github.com/topics/jekyll-theme)
- 테마 선택
2. 적용할 테마 `Fork`
3. `Settings` - `Repository name`에서 `계정이름.github.io`로 `Rename`
4. `_config.yml`에서 url 변경
- `you must be on a branch to make or propose changes to this file`  
위와 같은 문구가 뜰 경우, branch 변경  
![image](https://user-images.githubusercontent.com/39394592/148649165-d1e81156-fd1f-405d-8b16-d4ff601ecee3.png)
5. url 변경 후 commit

![image](https://user-images.githubusercontent.com/39394592/148649375-5b7203ab-95c8-4d45-8768-46c3db7f7cb3.png)

> Fork 해온 리포지토리는 잔디가 안 심어진다   
> 잔디 심으려면 리포지토리 새로 만들어야 함   
> [참고 : [Git] 커밋을 해도 잔디가 안 심어질 때, fork한 repository의 커밋으로도 잔디를 심어보자, 저장소의 커밋 기록까지 전부 복사해오기 !](https://joyful-development.tistory.com/m/12)

### Visual Studio 2022 연동

1. [Visual Studio 다운로드](https://visualstudio.microsoft.com/ko/)
2. 복제
![image](https://user-images.githubusercontent.com/39394592/148649732-5e55ae52-ceba-4a73-8cd2-b829d0d45da6.png)
![image](https://user-images.githubusercontent.com/39394592/148649948-b66c1a1d-3ded-422d-b743-32e29fed5f79.png)
- 위치는 깃헙 주소 복사해서 붙여넣기
- 경로는 프로젝트 넣고 싶은 곳에 빈 폴더 만들어서 지정
- 혹은 로컬에 git clone 후, 로컬 리포지토리 -> 로컬 리포지토리 열기


![image](https://user-images.githubusercontent.com/39394592/148649873-4b8b7673-c41a-499e-8946-ab7768a9276a.png)
- 로컬 리포지토리 쉽게 변경 가능
- Git  변경내용에서 커밋 가능
