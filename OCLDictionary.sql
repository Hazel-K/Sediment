<CRUD : SQL 기본 구문>
1_테이블 작성:
CREATE TABLE tableName(
    fieldName1(fieldType[NUMBER|VARCHAR2(length)|CHAR|DATE DEFAULT SYSDATE|], NOT NULL|UNIQUE(auto INDEX)|PRIMARY KEY|FOREIGN KEY|INDEX|DEFAULT),
    fieldName2(fieldType[NUMBER|VARCHAR2(length)|CHAR|DATE DEFAULT SYSDATE|], NOT NULL|UNIQUE(auto INDEX)|PRIMARY KEY|FOREIGN KEY|INDEX|DEFAULT),
    fieldName3(fieldType[NUMBER|VARCHAR2(length)|CHAR|DATE DEFAULT SYSDATE|], NOT NULL|UNIQUE(auto INDEX)|PRIMARY KEY|FOREIGN KEY|INDEX|DEFAULT),
    PRIMARY KEY(fieldName1),
    FOREIGN KEY(fieldName2) REFERENCES alterTable(alterField) ON DELETE[CASCADE|RESTRICT|SET NULL|NO ACTION]
)

2_데이터 검색:
SELECT *[fieldNames|tableName(fieldNames)|subQuery|basicFunction] AS subName1 FROM tableName[dual|subQuery] AS subName2
WHERE condition1 AND condition2 OR condition3
GROUP BY alterField HAVING condition4
ORDER BY alterField[ASC|DESC]

3_데이터 갱신:
UPDATE alterTable SET alterFieldValue = setValue
WHERE condition1 AND condition2 OR condition3

4_데이터 삭제:
DELETE alterField FROM alterTable
WHERE condition1 AND condition2 OR condition3


<SQL 추가 구문>
1_뷰 생성:
CREATE OR REPLACE VIEW viewName AS subQuery(SELECT)

2_데이터 사전(테이블 내 데이터 검색):
SELECT * FROM USER_TABLES;
SELECT * FROM USER_INDEXES;
SELECT * FROM USER_VIEWS;

3_인덱스 생성:
CREATE INDEX indexName ON tableName(fieldName1, fieldName2...);


<SQL Syntex:JOIN>
WHERE 절을 이용한 JOIN 방식
SELECT a.alterField, b.alterField FROM alterTable a, alterTable b WHERE a.commonValue = b.commonValue(+) AND conditon2...;
-- 별칭이 a, b인 테이블의 필드를 선택하는데, 각 필드의 공통된 값을 비교하여 출력하고 싶은 필드의 값을 찾아준다. (+)는 TABLE a에 있을 경우 RIGHT, TABLE b에 있을 경우 LEFT outer join의 의미이다.
JOIN ON 을 이용한 JOIN 방식
SELECT a.alterField, b.alterField FROM alterTable a, JOIN alterTable b ON a.commonValue = b.commonValue JOIN ON 2... 혹은 AND condition2...;
-- 위의 구문을 JOIN ON형식으로 변환했을 때 표현식. LEFT, RIGHT는 기본적으로 OUTER JOIN의 특성을 가지고 있다.


<SQL BASIC FUNCTION>
UPPER(alterField); 대문자로
LOWER(alterField); 소문자로
CASE('alterFieldValue' THEN 'setValue' ELSE 'undefinedValue') END; 기성 값을 설정하려는 값으로 변경
DECODE('alterFieldValue', 'setValue', 'undefinedValue') CASE 함수의 축약화, 오라클에서만 사용 가능
COUNT(*[alterField]); 해당 필드, 컬럼의 개수 반환, GROUP BY 구문과 함께 사용
SUM(*[alterField]); 해당 필드, 컬럼 값의 합 반환, GROUP BY 구문과 함께 사용
AVG(*[alterField]); 해당 필드, 컬럼 값의 평균 반환, GROUP BY 구문과 함께 사용
MIN(*[alterField]); 해당 필드, 컬럼 값 중 최소값을 반환(문자열의 경우 길이가 제일 작은 것)
MAX(*[alterField]); 해당 필드, 컬럼 값 중 최대값을 반환(문자열의 경우 길이가 제일 작은 것)
LTRIM(*[alterField]); 해당 필드, 컬럼 값의 좌측 공백을 없앰
RTRIM(*[alterField]); 해당 필드, 컬럼 값의 우측 공백을 없앰
TRIM(*[alterField]); 해당 필드, 컬럼 값의 양쪽 공백을 없앰
SUBSTR('alterFieldValue', n1, n2); 기성 값의 n1번째부터 n2길이 만큼의 문자열을 반환 -n1일 경우 역순
INSTR('alterFieldValue', 'findValue', n1, n2); 기성 값 중 찾으려는 값의 위치를 정수로 반환, n1, n2를 사용할 경우 n1은 찾으려는 값보다 n1만큼 뒤의 값을 찾고, n2은 중복된 값이 있을 경우, 여러 값 중 몇번째의 값을 찾을 것인지를 검색
LPAD('alterFieldValue', n, 'setValue'); 기성값의 좌측에 n의 길이만큼(n에는 기성값의 길이를 포함) setValue를 추가
RPAD('alterFieldValue', n, 'setValue'); 기성값의 우측에 n의 길이만큼(n에는 기성값의 길이를 포함) setValue를 추가
LENGTH('alterFieldValue'); 기성값의 문자열 길이 반환
LENGTHB('alterFieldValue'); 기성값의 문자열 바이트 길이 반환
MOD('alterFieldValue', n); 기성값을 n으로 나눈 나머지값 반환
ROWNUM = n; n번째 값을 출력, 연산식 사용가능


<SQl FUNCTION>
SYSDATE,['expression']; 현재 시간을 출력, 형식을 쓸 경우 형식에 맞게 표시 ex) 'yyyy-mm-dd hh24:mi:ss'
    (기본형) SELECT TO_CHAR (SYSDATE, 'yyyy-mm-dd hh24:mi:ss') FROM dual;
