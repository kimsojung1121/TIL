**이클립스에서 자바 코드 변경 후 저장하고 확인하려고 하면 
<br> `Exception in thread "ContainerBackgroundProcessor[StandardEngine[Catalina]]"` 
<br> 다음과 같은 문구가 뜨면서 화면 새로고침이 안 되는 문제**

---

- Java VM에서 힙메모리가 부족한 증상으로 이클립스와 상관없이 톰캣 서버의 문제이다.

#### 해결방법
1. 이클립스 `Servers`에서 구동할 톰캣 더블클릭
2. `Overview` - `General Information` - `Open launch configuration` - `Arguments` - `VM arguments`
3. 다음 문구 추가

```
-Xms256m -Xmx1024m -XX:PermSize=256m -XX:MaxPermSize=256m
```

- 파일을 변경 후 저장해도 재빌드되며 새로고침 가능하다.
