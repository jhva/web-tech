
# HTTPS
HTTP는 앞에서 설명한것처럼 누구나 읽을 수 있는 일반 텍스트로 통신하고 있습니다. 이러한 이유로 고객이 주문, 신용 카드 비밀번호, 여러가지 보안이 필요한 부분들이 HTTP 프로토콜로 통신하게 될 경우 숨겨지지 않은 채 인터넷을 이용하게 됩니다. <br/>

이를 해결하기위해 `SSL or TLS`가 나오면서 사용자 개인 정보를 보호하기 위해 제작이 되었다고합니다. <br/>

SSL은 웹 서버 와 통신 모든 과정에서 모든 데이터를 암호화 하고 데이터를 누군가 가로채더라도 트래픽이 암호화되므로 무의미한 문자로만 인식이 되며, 사이버 공격으로부터 방어 할 수 있고,사용자들의 데이터를 훔치거나,조작 방지에 대해 막을 수 있습니다. 


## SSL/TLS ?  
SSL은 TLS(Transport Layer Security) 의 또 다른 버전입니다. 1999년 이후 `IETF`가  Netscape는 더 이상 참여하지 않으면서 이름이 `TLS`로 바뀌게 되었습니다. <br/>

SSL과 TLS 는 버전차이는 크게 있다고하지 않으며 이름이 바뀐이유는 `소유권 변경을` 위해 나타났습니다. 

## SSL 인증서 세부 정보 
- 인증서가 발급된 도메인 이름 
- 어떤 사람, 조직에서 발급되었는지 
- 인증 기관에서 발급한 인증서
- 디지털 서명 
- 인증서의 연결된 하위 도메인
- 인증서 발급 날짜 
- 인증서의 만료 날짜 
- 공용 키
- 
## CA (Certificate Authority) - 인증기관 
위에서 말한 것 처럼 서버와 클라이언트 간 신뢰할수 있고 보안이 된 서버라는것을 인증 받기위한 작업이 필요한데 그것이 `SSL 인증서` 입니다. <br/>

`SSL 인증서`는 CA(Root Certificate)에서 발급 받을 수 있습니다. CA는 신뢰성 공인된 기업들만 받을 수 있으며 TLS/SSL 통신을 하기위해선 CA 인증서를 발급받아야함. 

## SSL 인증서 발급 과정 
1. 도메인 정보 와 공개키를 CA 기관에 제출
2. CA 검증을 마친 이후 발급 받고자 하는 기관의 공개 키를 SHA-256으로 해싱 하여 인증서에 `지문` 등록 
3. 이후 등록한 `지문`을 통해 CA의 비밀키로 암호화 하여 인증서의 발급자 서명으로 등록 
4. 인증서 발급 

## SSL 인증서를 발급 (비대칭키/공개키 방식)
> 이전엔 대칭키 암복화 방식을 많이 사용하였다. 대칭키 암호화 방식은 암복호화키가 동일해서 해당 키를 알고 있는 사람은 문서를 복호화 할 수 있고, 때문에 알고리즘이 상대적으로 간단하고 빠른데요,<br/> 하지만 이로 인하여 클라이언트 -> 서버로 키를 전달할때 이 키를 훔치려는 
> 해커가 
있게되면 저희의 목적인 개인정보가 유출 가능성이 생깁니다. 이런 문제를 해결하기 위해서 나온것이 `비대칭키/공개키 암호화` 방식입니다. 
1. 자신의 서버의 비밀키/공개키 생성 
2. 서버 공개키를 통해 `SSL 인증서` 발급 요청
3. CA는 `CA 비밀키로 암호화된 인증서` 발급
    1. 인증서 내부에 자신의 서버 공개키가 있음 
4. 이후 SSL 통신을 하게되는데 이때 브라우저가 자신의 서버에 접속하면 인증서를 보내줌 
5. 브라우저는 받은 인증서를 통해 `CA의 공개키로`로 복호화함 
   1. 공인된 CA들의 공개키는 브라우저 내부에 보관
6. 인증서 복호화에 성공하면 CA가 발급한 것임을 인증 이를 통해 서버도 CA가 인증한 서버임을 증명 
7. 복호화한 인증서에 자신의 서버 `공개키` 를 가지고 이후 데이터 통신
## SSL HandShake

1. 클라이언트가 서버에 접속 `Client Hello`
2. 서버가 클라이언트에 응답 `Server Hello`
    1. 이때 암호화 방식맞추고, 인증서를전달 
3. 클라이어너트의 확인 작업 
    1. 서버에게 받은 인증서가 CA 리스트에 있는 CA의 리스트인지 확인 
   2. 확인이 되면 브라우저에 있는 CA의 공개키로 복호화 하면서 성공시에 `CA에 의해 발급 인증`, & `CA 인증서를 전송한 서버도 인증 ok`
   3. 인증서를 복호화하면 `서버의 공개키`가 있음.
4. `pre master secret key` 생성 
    1. 서버에서 받은 데이터 + 클라이언트에서 받은 데이터 를 조합하여 특정값 생성 
   2. 인증서에 있는 `서버 공개키`로 암호화 하면서 서버에게 전달 
5. `session key`
    1. 암호화된  `pre master secret key` 를 `서버 비밀키`로 복호화
   2.  복호화된 키를 통해 `master secret` 값 생성 
   3. `session key` 를 생성하면서 클라이언트와 공유
        1. 이걸로 암호화하여 통신 
6. 종료 
    1. <b>매번 연결 시 새로운 `session key`를 생성해서 아주 짧은 시간 동안 사용하므로 비교적 안전</b>