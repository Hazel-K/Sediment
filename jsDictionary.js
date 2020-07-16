<DEFAULT FUNCTION>
    console.log(a); a를 콘솔에 출력, 여러 개 출력 가능, printf문법 사용 가능, `${}`사용 가능 <return type: void>
    alert("String"|int); 경고창 생성 함수, 간단한 연산 가능 <return type: void>
    prompt("String", "_default"); 대화상자를 통해서 사용자에게 문자열을 입력하도록 하는 함수 <return type: String>
    confirm("String"); 대화상자를 통해서 사용자에게 확인 또는 취소의 응답을 요구 <return type: boolean>

<DOCUMENT FUNCTION>
    document.querySelector("Selector"); 선택자를 통해 Element 지정 <return type: element>
    document.getElementById("id"); #id를 통해 Element 지정 <return type: element>
    document.getElementByClass("class"); .class를 통해 Element 지정 <return type: element>
    document.write("text"); 원하는 text를 출력 <return type: void>

<FIELD SETTING>
    let or var = n; 변수 설정
    const = n; 상수 설정
    function (args) {excutor;} 함수 설정의 기본 형태

<DATA TYPE>
    String: 문자형
    number: 숫자형, int|float
    boolean: 논리형, true|false
    null: 빈 데이터, undefined