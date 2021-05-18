## 커밋 합치기
 github 8일차,  
 이상하게 내 잔디밭이 너무 초록색이다! .md 파일을 계속 수정한 게 log에 남아서라는 걸 깨달았다... 그럼 그렇지... 커밋 기록엔 온통 Update뿐.  
 [블로그](https://madplay.github.io/post/squash-git-commits-with-rebase)를 참고하여 커밋 합치는 법을 알아보았다.  
 내일부터는 제대로 커밋 메시지를 관리하자!

```
$ git log
```
> 커밋 상태 확인

```
$ git rebase -i HEAD~3
```
> HEAD를 기준으로 n개(위 코드에서는 3개)의 커밋 내역 확인 - vi편집기

---
vi 편집기 모드에 관한 내용은 [블로그](https://blockdmask.tistory.com/25)를 참고했다.
- vi 편집기는 명령모드, 입력모드, 마지막 행 모드로 총 3가지 모드로 구성
  - 명령모드
    > 처음 vi 편집기에 들어갔을 때 나오는 모드  
  - 입력모드
    > 명령모드에서 `i` 나 `a` 명령을 입력하면 입력 모드로 넘어감  
    > 명령모드로 돌아오려면 `ESC`  
  - 마지막 행 모드
    > 명령모드에서 `:` 입력  
    > `wq` : 작성한 내용을 저장하고 vi 종료  
    > `q`, `q!` : 그냥 종료  
---

```
pick cf37e3e Update README.md
s 86e8dca Update 210517.md
s a6a50ac Update 210517.md
```
> 입력모드에서 합쳐질 커밋 해시값 앞에 `squash`(약어로는 `s`)를 붙여주고 명령모드에서 `:wq`로 저장하며 종료  
> 기존의 작업에 대한 커밋 메시지 지우고 하나로 통일하여 메시지 작성

```
$ git log
```
> 커밋 상태 확인

## 원격저장소에 반영

```
$ git push -f
```

---
`rebase` 명령을 쓰고 난 뒤 빠져나오고 push를 진행했을 때  
**You are not currently on a branch.** 와 같은 에러가 발생하였다.
```
$ git checkout master
```
에러 메시지를 검색하고 [게시글](https://okky.kr/article/437352)을 참고하여 위의 명령을 입력하니 에러가 해결되었지만,  
아직 rebase 명령이나 branch에 대한 개념이 너무 부족한 것 같다.
