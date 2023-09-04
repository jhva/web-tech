# 웹 브라우저 

브라우저는 텍스트,이미지,비디오 등 콘텐츠를 표현한는 응용 소프트웨어이다. 대표적으로 
크롬, 사파리, 엣지, 파이어폭스 가 있다. 

## 웹 브라우저 프로토콜과 표준 
웹 브라우저는 HTTP(hyper-text transfer protocol) 로 통신을 한다. <br/>
HTTP는 OSI Layer7 응용 계층에서 동작한다. HTTP는 TCP 기반으로 만들어진 프로토콜이며 HTTP를 이용해 웹 페이지나, 웹 서버에 정보를 수신하며 페이지들은 인터넷 브라우저 인터페이스에 보이는 주소창 URL(http:)을 통해 원하는 페이지들로 접속 할 수 있다.

웹 페이지의 파일 포맷은 HTML 로 많이쓰이고 그 밖에 JPEG,PNG,GIF 이미지 포맷들을 지원하면서 여러 플러그인을 통해 확장할 수 있다. 

### HTTP Protocol 이란
>http는 웹 브라우저 상에서 정보를 주고받기 위한 프로토콜이며 다양한 요청 메서드를 정의하면서, 리소스를 통해 클라이언트가 송(Reqeust),수신(Response)을 하며 무상태성(stateless)의 특성을 갖고, 평문으로 통신한다.
- 무상태성으로 인해 클라이언트의 이전 상태를 알 수 없으며 이를 위해 `Http 쿠키, 세션` 등을 통해 이 문제를 해결해가고있다. 


---


## 웹 브라우저 주요 기능 
클라이언트가 원하는 리소스를 웹 서버에 요청하면서 컨텐츠를 사용자에게 제공하고,응답으로 HTML,CSS,JS 등 해석해서 클라이언트에게 제공한다.

## 웹 브라우저 구조 
### 인터페이스
- 주소표시줄, 이전다음 버튼, 즐겨찾기, 메뉴 등등 그 밖의 모든 요소 
### 브라우저 엔진
- 사용자 인터페이스 및 렌더링 엔진 사이의 동작을 제어 
###  렌더링
- HTML,CSS 파싱 이후 화면에 출력 
### UI 백엔드 
- HTTP 네트워크 호출에 의해 사용됨
### JS 인터프리터 
- JavasScript 코드 해석 및 실행
### 브라우저 데이터베이스 
- 쿠키, 로컬스토리지 등등 

___

## 웹 브라우저의 동작원리 
<details>
<summary>웹 브라우저의 주소창에 도메인명의 IP를 검색했을때 과정</summary>
<div markdown="1">

1. 웹 브라우저 통신규격에 맞게 http,https 프로토콜을 사용해서 도메인을 치고 엔터를 누를경우 
제일 먼저 웹 브라우저는 URL을 통해 인터넷상에서의 연결할 서버를 파악하기 위해 웹 사이트를 호스팅하는 서버의 IP 주소를 알아낸 후 <strong><a href="https://github.com/jhva/tech-study/blob/main/network/dns.md" target="_blank">DNS</a></strong> 작업을 수행 한다 . 
2. DNS를 통해 IP 주소를 알게되었다면 이후 <strong><a href="https://github.com/jhva/tech-study/blob/main/network/TCP_3%20way%20handShake.md" target="_blank">TCP_3 Way HandShake / TCP_4 Way HandShake </a></strong> 과정이 이루어진다. 
3. 이후 HTTP 요청을 하는데, 이때 HTTPS 가 설정이 되어있을경우 <strong><a href="" target="_blank">TLS/SSL HandShake </a></strong> 과정이 발생
4. 이후 받은 데이터를 통해서 정적 리소스,혹은 데이터들을 보여준다
   1. 이때 정적 리소스라하면 `HTML`,`CSS` 혹은 `JS` 등이 있을텐데, 전송받은 리소스들을 파싱하고 렌더링 하게 됨.

</div>


</details>


