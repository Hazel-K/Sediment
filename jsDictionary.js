<DEFAULT FUNCTION>
    console.log(a); a를 콘솔에 출력, 여러 개 출력 가능, printf문법 사용 가능, `${}`사용 가능 <return type: void>
    alert("String"|int); 경고창 생성 함수, 간단한 연산 가능 <return type: void>
    prompt("String", "_default"); 대화상자를 통해서 사용자에게 문자열을 입력하도록 하는 함수 <return type: String>
    confirm("String"); 대화상자를 통해서 사용자에게 확인 또는 취소의 응답을 요구 <return type: boolean>
    typeof a; 요소 a의 자료형을 반환 <return type: String>
    String(); 숫자를 문자로 변환하는 함수, toString();도 사용 가능 <return type: String>
    Number(); 문자를 숫자로 변환하는 함수, 못바꾼다면 NaN 반환, isNaN(); 으로 체크 가능 <return type: Number>
    boolean(); 비논리형을 논리형으로 변환하는 함수 <return type: boolean>
    parseInt(); 문자를 정수로 <return type: Number>
    parseFloat(); 문자를 실수로 <return type: Number>
    float.tofixed(n); 실수를 n번째 자리만큼 잘라서 반환 <return type: double>
    setInterval(Value, n); n밀리초마다 Value 실행
    clearInterval(); setInterval 함수 초기화
    setTimeout(Value, n); n밀리초를 초과하면 Value 실행
    clearTimeout(); setTimeout 함수 초기화

<TEXT FUNCTION>
    text.charAt(n); text n번째에 해당하는 문자 반환 <return type: String>
    text.indexOf("innerText"); text에 innerText가 있다면 해당 문자열의 첫번째 위치 반환, 해당 문자열이 없다면 -1 반환, search와 동일 <return type: Number>
    text.lastIndexOf("innerText"); text에 innerText가 여러 개 있다면 해당 문자열의 마지막 위치 반환, 해당 문자열이 없다면 -1 반환 <return type: Number>
    text.replace("oldText", "newText"); text 내 oldText를 newText로 변경, 변수에 대입해야 제대로 시행됨 <return type: String>
    text.slice(n1, n2); text에서 n1부터 n2(text첫 자리가 기준) 앞까지의 문자열을 잘라내 그것을 반환, subString과 동일 <return type: String>
    text.substr(n1, n2); text에서 n1부터 n2(n1첫 자리가 기준) 앞까지의 문자열을 잘라내 그것을 반환 <return type: String>
    text.match("innerText"); text 내 innerText가 있다면 가장 먼저 찾은 문자열을 반환, 없으면 null <return type: String>
    text.split("innerText"); text를 innerText기준으로 나누어 각각의 값을 하나의 배열로 반환 <return type: Array>
    text.toLowerCase(); 텍스트를 소문자로 변경 <> toUpperCase(); <return type: String>
    text.concat("innerText"); 텍스트를 innerText와 연결 <return type: String>
    text.charCodeAt(n); n번째 text에 해당하는 ASCII 코드 반환 <return type: String>
    String.fromCharCode(n); n번째에 해당하는 ASCII 코드 반환 <return type: String>
    text.trim(); 양쪽 공백 제거 <return type: String>

<MATH FUNCTION>
    Math.abs(n) n의 절대값
    Math.max(n1, n2...) 최대값
    Math.min(n1, n2...) 최소값
    Math.random 0 ~ 0.9... 사이의 난수 반환
    Math.pow(n1, n2) n1의 n2제곱값 반환
    Math.round(n) 반올림
    Math.floor(n) 버림
    Math.ceil(n) 올림
    Math.sqrt(n) 제곱근
    Math.PI 원주율

<DATE FUNCTION : new date()로 객체화시킨 다음 사용, 모든 get은 set으로 설정 전환 가능>
    date.getFullYear(); 연도 반환
    date.getMonth(); 달 반환
    date.getDate(); 일 반환
    date.getDay(); 요일 반환 (setDay는 존재하지 않음)
    date.getHours(); 시간 반환
    date.getMinutes(); 분 반환
    date.getSeconds(); 초 반환
    date.getMiliseconds(); 밀리초 반환
    date.getTime(); 경과된 시간을 밀리초로 표기. 70.01.01. 기준
    date.toGMTString(); GMT표준 방식으로 문자열로 반환

<LOCATION FUNCTION>
    location.reload(); 브라우저를 새로 고침 <return type: void>
    location.href; 참조 주소 반환
    location.hash; 해시값(#)을 반환
    location.hostname; 호스트 이름 설정 혹은 반환
    location.host; 호스트 이름과 포트 번호 반환
    location.protocol; 프로토콜 반환
    location.search; 쿼리를 반환

<HISTORY FUNCTION>
    history.back(); 이전 방문 사이트
    history.forward(); 다음 방문 사이트
    history.go(n); n번째 만큼의 다음 방문 사이트
    history.length; 방문 기록에 저장된 목록 개수 반환

<NAVIGATOR FUNCTION>
    navigator.appCodeName; 브라우저의 코드명 반환
    navigator.appCodeName; 브라우저 이름 반환
    navigator.appVersion; 브라우저 버전 반환
    navigator.language; 브라우저 언어 반환
    navigator.product; 브라우저 엔진 반환
    navigator.plattfom; 컴퓨터 운영체제 반환
    navigator.onLine; 온라인 상태 여부 반환
    navigator.userAgent; 브라우저, 운영체제 종합 정보 반환

<SCREEN FUNCTION>
    screen.width; 화면의 너비값 반환
    screen.height; 화면의 높이값 반환
    screen.availWidth; 상태 표시줄을 제외한 너비값 반환
    screen.availHeight; 상태 표시줄을 제외한 높이값 반환
    screen.colorDepth; 사용자의 모니터가 표현 가능한 컬러 bit를 반환

<WINDOW FUNCTION>
    window.open(); 해당 윈도우 창을 연다(문법 참고 : https://offbyone.tistory.com/312)
    window.close(); 해당 윈도우 창을 닫는다

<LOCALSTORAGE FUNCTION>
    localstorage.getItem(String); String에 해당하는 저장소의 요소를 가져온다.
    localstorage.setItem(String, Object); String에 해당하는 이름으로 Object들을 저장한다.

<JSON FUNCTION>
    JSON.parse(Object); 해당 JSON객체를 JS 객체로 변환한다.
    JSON.stringify(Array); 해당 Array, Object에 있는 값을 JSON객체로 변형한다.

<ARRAY FUNCTION>
    Array.join(anyLetter); 해당 배열 인덱스 사이사이에 anyLetter를 삽입하여 출력 <return type: String>
    Array.concat(Array2); Array에 Array2를 붙임 <return type: void>
    Array.slice(n1, n2); Array를 n1부터 (n2 - 1)까지 남겨두고 잘라냄 <return type: void>
    Array.splice(n1, n2, obj); Array를 n1부터 n2개 까지 잘라내고 그 자리에 obj를 삽입 <return type: void>
    Array.unshift(obj); Array 처음 index에 obj를 추가 <return type: void>
    Array.push(obj); Array 마지막 index에 obj를 추가 <return type: void>
    Array.pop(); Array의 마지막 index value를 삭제 후 반환 <return type: 해당 value type>
    Array.shift(); Array의 처음 index value를 삭제 후 반환 <return type: 해당 value type>
    Array.sort(); Array의 value를 오름차순 으로 변환 <return type: void>
    Array.reverse(); Array의 index를 뒤집음 <return type: void>
    Array.legnth Array의 길이 반환 <return type: Number>
    Array.filter(function); function을 수행하여 조건에 맞는 것들을 모아 새로운 Array로 반환

<DOCUMENT FUNCTION>
    document.querySelector("Selector"); 선택자를 통해 Element 지정 <return type: element>
    document.getElementById("id"); #id를 통해 Element 지정 <return type: element>
    document.getElementByClass("class"); .class를 통해 Element 지정 <return type: element>
    document.write("text"); 원하는 text를 출력, html문법 직접사용 가능 <return type: void>
    document.innerText = ""; 원하는 text를 입력 <return type: void>
    document.innerHTML = ""; 원하는 text를 입력, HTML 문법을 적용 <return type: void>
    document.createElement("tagName"); tagName을 생성
    document.createTextnode("text"); text로 구성된 Node를 생성
    document.appendChild(`tagName`); 해당 element에 자식 tagName을 생성 <return type: element>
    document.style.METHOD = ""; 해당 element에 METHOD에 해당하는 style을 적용
    document.setAttribute("attName", "attValue"); 해당 element의 attName에 해당하는 attValue를 지정
    document.addEventListener("event", function); 해당 element에 event 시 function을 호출(이벤트 참고 : https://abc1211.tistory.com/201)

<FIELD SETTING>
    let or var = n; 변수 설정
    let or var = function(params){} 익명 함수 설정, varName(prams)의 형태로 호출 가능(hoisting 지원하지 않음)
    let or var = (function(params){} (params) ); 익명함수 바로 실행(hoisting 지원하지 않음)
    const = n; 상수 설정
    function funcName(arguments.length) {excutor;} 함수 설정의 기본 형태
    function fn1(fn2) {fn2();} 콜백 함수의 기본 형태

<DATA TYPE>
    String: 문자형, a = "character";
    number: 숫자형, int|float, a = n;
    boolean: 논리형, 문자열은 true로 판단, 0,null,undefined는 false로 판단, true|false, a = true|false;
    null: 빈 데이터, 주로 초기화하는 용도로 사용 undefined, a;
    array: 하나의 변수의 여러 값을 저장, a = [ n1, n2, "char1" ...];
    object: 함수와 속성이 포함된 자료형, a = null;

<SCRIPT Operator>
    <대부분 JAVA가 가진 Operator와 일치>
    "a" == a: true, 순수 값이 같은지를 확인
    "a" === a: false, 값 이외에 자료형이 일치하는지도 확인

<SCRIPT ~ HTML>
    form 안에 있는 여러 input 태그들의 값 추출이 가능. ex) formName[`inputName`].value