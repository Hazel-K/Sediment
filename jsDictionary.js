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

<DOCUMENT FUNCTION>
    document.querySelector("Selector"); 선택자를 통해 Element 지정 <return type: element>
    document.getElementById("id"); #id를 통해 Element 지정 <return type: element>
    document.getElementByClass("class"); .class를 통해 Element 지정 <return type: element>
    document.write("text"); 원하는 text를 출력 <return type: void>

<FIELD SETTING>
    let or var = n; 변수 설정
    const = n; 상수 설정
    function funcName(args) {excutor;} 함수 설정의 기본 형태

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