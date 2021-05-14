# 커밋 메시지 변경하기

- [블로그 참고1](https://velog.io/@mayinjanuary/git-%EC%BB%A4%EB%B0%8B-%EB%A9%94%EC%84%B8%EC%A7%80-%EC%88%98%EC%A0%95%ED%95%98%EA%B8%B0-changing-commit-message)  
- [블로그 참고2](http://tech.javacafe.io/2018/03/01/how-to-change-git-commit-message/)  
- [유튜브 참고](www.youtube.com/watch?v=bm2a5fozcms)  

#

#### 1. push 전 가장 최근 커밋 메시지 변경

```
$ git commit --amend "commit message"
```
또는
```
$ git commit --amend
```
- unix 에디터에서 수정 모드로 전환 - `a` 입력
- 수정한 뒤 `:wq!` 입력 => 수정된 상태로 저장된 후 에디터 종료

#

#### 2. push 전 더 오래된 커밋 메시지 변경
```
$ git log
```
로 수정할 커밋 확인  
```
git rebase -i HEAD~n
```
가장 최근 n번째까지의 커밋을 보여준다

- 수정하고 싶은 커밋 옆의 `pick`을 `reword`로 변경
- `esc` => `:wq` 를 통해 커밋 리스트를 저장
- 커밋을 수정 후 `:wq` 입력

```
$ git log
```
로 수정된 커밋 확인

#

#### 2. push 후 커밋 메시지 변경
- 커밋 메시지 변경
- 강제 push
```
$ git push -f  
```

- **강제 push는 최대한 사용하지 않는다**
