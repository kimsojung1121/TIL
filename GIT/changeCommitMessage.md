## 커밋 메시지 변경하기

#### 1. 마지막 커밋 메시지 변경

```
$ git commit --amend "commit message"
```

> 강제 push
> ```
> $ git push -f  
> ```

#

#### 2. 마지막 이전의 커밋 메시지 변경

```
$ git rebase -i HEAD~3
```
- 최근 현재 HEAD부터 최근 3개의 커밋을 rebase
- 바꾸고자 하는 커밋 내역에 pick -> edit로 변경
- !wq 명령어로 내용 저장
