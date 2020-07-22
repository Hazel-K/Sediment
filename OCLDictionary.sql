<CRUD : SQL 기본 구문>
1_테이블 작성:
CREATE TABLE tableName(
    fieldName1(fieldType[NUMBER|VARCHAR2(length)|CHAR|DATE DEFAULT SYSDATE|], NOT NULL|UNIQUE|PRIMARY KEY|FOREIGN KEY),
    fieldName2(fieldType[NUMBER|VARCHAR2(length)|CHAR|DATE DEFAULT SYSDATE|], NOT NULL|UNIQUE|PRIMARY KEY|FOREIGN KEY),
    fieldName3(fieldType[NUMBER|VARCHAR2(length)|CHAR|DATE DEFAULT SYSDATE|], NOT NULL|UNIQUE|PRIMARY KEY|FOREIGN KEY),
    PRIMARY KEY(fieldName1),
    FOREIGN KEY(fieldName2) REFERENCES alterTable(alterField) ON DELETE[CASCADE|RESTRICT|SET NULL|NO ACTION]
)

2_데이터 검색:
SELECT *[fieldNames|tableName(fieldNames)|subQuery|basicFunction] AS subName1 FROM tableName[dual|subQuery] AS subName2
WHERE condition1 AND condition2 OR condition3
LEFT|RIGHT|INNER|OUTER|FULLOUTER JOIN alterTable ON alterTable.field = subName2.field
GROUP BY alterField HAVING condition4
ORDER BY alterField[ASC|DESC]

3_데이터 갱신:
UPDATE alterTable SET alterFieldValue = setValue
WHERE condition1 AND condition2 OR condition3

4_데이터 삭제:
DELETE alterField FROM alterTable
WHERE condition1 AND condition2 OR condition3


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

<SQl FUNCTION>
SYSDATE,['expression']; 현재 시간을 출력, 형식을 쓸 경우 형식에 맞게 표시 ex) 'yyyy-mm-dd hh24:mi:ss'
    (기본형) SELECT TO_CHAR (SYSDATE, 'yyyy-mm-dd hh24:mi:ss') FROM dual;