## Ajax beforeSend

- Ajax를 요청하기 직전의 콜백함수
- 서버에 요청을 보내기 전 동작을 수행

**CSS**
```css
#wrap.loading:after{position:absolute;top:50%;left:50%;width:100px;height:100px;margin:-50px 0 0 -50px;background:url(../images/loading.gif);background-size: 100px auto;z-index:11;content:''}
```

**JS**
```js
$.ajax({
  url: '<c:url value="URL" />',
  data: JSON.stringify(params),
  beforeSend: function() {
    $("#wrap").loading(true);
  },
  complete: function() {
    self.close();
  },
  success: function(res) { 		
    try {
      $("#wrap").loading(false);
    } catch (error) { }
  }
});
```

**HTML**
```html
<div id="wrap">
  내용
</div>
```
- Ajax를 요청하기 전에(beforeSend) 로딩 gif 표시
- Ajax 성공하면(success) 로딩 gif 없앰
- 마지막으로(complete) 창 닫음

### 주의사항
**ajax를 동기식( async: false )으로 구현할 경우 beforeSend:function() 구현 안 됨**

