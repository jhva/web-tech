# ES5 & ES6
_나는 내가 사용하고 있는 javascript 의 버전도 모르고 사용하였다. 그리하여 작성하게된 ES5 & ES6 의 차이_ 

> ES는 ECMAScript 의 약자이다 
> 
## 주요 특징
### <b>let</b> <b>const</b> 키워드 추가 
블록 레벨 스코프에서는 변수명으로 재선언이 불가능하다. 재할당만 가능한 let 키워드와 const 가 추가되었다. 

기존 ES5 에서는 변수 선언을 할 때 <b>var</b> 를 사용하였다. 
```javascript
var age= 25

console.log(age);
var age = 23
```
var 로 선언한 변수는 여러번 중복선언이 가능하다. 하지만 이러한 부분이 코드량이 많아지고 여러 중복 선언으로 인해 값이 도중 값이 바뀌어버리는 문제가 발생하는경우 어디서 찾아야 되는지 알수가 없어, 이러한 단점을 보완하기위해 let const 가 나왔다. 

#### let const 
> var와 달리 let 과 const는 모두 코드블록을 지역 스코프로 인정하는 블록 레벨 스코프이다. 
> 
1. let 은 기본적으로 변수 중복 선언이 불가능하고, 변수에 재할당은 가능하다. 
2. 반면 const 는 변수를 중복 선언 불가능하고, 변수 재할당 또한 불가능하다.

### 템플릿 리터럴 
es5에서는 플러스를 사용하여 표현하는 방식이 좀 번거러웠지만 es6부터는 백틱(`) 을 통해서 내부에 표현식을 넣어 사용할 수 있게 되어 문자열 표현법이 간단해졌다.

```javascript
// es5
var age=25;
var st2 = "면접"
console.log(age +"와"+ st2); 


//es6
let age = 25;
let st2= "면접";
console.log(`${age}와${st2}`);
```


### 구조 분해 할당 
구조 분해 할당은 개별 값을 변수에 할당 수 있게 하는 javascript 표현식
```javascript
const str1,str2;
({str1,str2})= {str1:1,str2:2};
```

### 화살표 함수 - Arrow functions
```javascript
//es5
var fun=function (a,b){} 

// es6 
let fun =(a,b)=>{}
```
### Default parameter
```javascript
//es5
var age = function(age){}

//es6
var age = function(age=15){}

```


### 클래스 
클래스 이전엔 프로토타입 기반 형식이었다.

```javascript
//es5

var Age = function(young,age){
    this.young =young;
    this.age =age;
}

Age.prototype.old = function(){
    return this.young+this.age;
}

var newOldAge= new Age(25,20);
```

```javascript
//es6
class Age{
    constructor(young, age) {
        this.young = young
        this.age = age
    }
    old() {
        return `${this.young} ${this.age} 으악`
    }
}

let newOldAge = new Age(25,20);
console.log(newOldAge.old())
```




### promise(프로미스)
>매개변수를 통해 넘겨지는 코드가 계속해서 반복되어 쓰고,읽기 수준이 감당하기 힘들정도로 깊어지는 현상을 콜백 헬이라고부름
> 
콜백 헬에 대한 문제를 해결하기위해 promise 가 도입되었고, promise 후속처리 메서드를 이용해 에러 처리 또한 손쉽게 할 수 있게 됨 




## ES7 & ES8
### ES7
- **연산자 등장 
- Array.includes 메서드 추가 

### ES8 
- async
- await
- Object.keys,Object.values
- 매개변수 끝 콤마 허용 
- 문자열 앞부분 과 끝부분 공백 자리수 맞추기
  1. String.padStart
  2. String.padEnd
