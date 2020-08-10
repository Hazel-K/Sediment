<DOCUMENT FUNCTION>
    $('Selector'); Selector를 설정. document.querySelector=('Selector'); 와 동일
    $('Selector').html(); 해당 html정보를 확인 html("Text")의 경우 innerHTML과 같음
    $('Selector').text("Text"); 해당 Selector 요소에 Text 삽입, innerText와 동일
    $('Selector').css('Attribute', 'Value'); 해당 Selector 요소에 Attribute에 해당하는 Style을 설정 Chaining 가능
    $('Selector').next(); 해당 Selector 요소의 다음 형제를 선택 <> prev();
    $('Selector').nextAll(); 해당 Selector 요소의 다음 형제 전부를 선택 <> prevAll();
    $('Selector').nextUntil(); 해당 Selector 요소의 다음 형제를 Selector2까지 선택 <> prevUntil('Selector');
    $('Selector').parent(); 해당 Selector 요소의 부모 형제를 선택, parent('Selector2') 형태로 Selector2인 부모만 선택 가능
    $('Selector').eq(index); 해당 Selector 요소의 index에 해당하는 자식을 선택 $('Selector element:eq(index)'); 형태로도 사용 가능
    $('Selector').lt(index); 해당 Selector 요소의 index보다 적은 자식들을 선택 $('Selector element:lt(index)'); 형태로도 사용 가능
    $('Selector').gt(index); 해당 Selector 요소의 index보다 큰 자식들을 선택 $('Selector element:gt(index)'); 형태로도 사용 가능
    $('Selector:first-of-type'); 해당 Selector 요소 중 첫 번째 요소를 선택 <> last-of-type, (n)추가 시 시작, 끝에서 n번째 요소 선택
    $('Selector:nth-child(n)'); 해당 Selector 요소 중 n번째 요소를 선택, 3n, 2n+1 등등의 연산식 활용이 가능
    $('Selector').addClass('Name'); 해당 Selector 요소에 Name을 class로 추가
    $('Selector:contains(text)'); 해당 Selector 요소에 text가 포함된 것을 선택
    $('Selector:has(Attribute)'); 해당 Selector 요소에 Attribute 요소가 포함된 것을 선택
    $('Selector').not('Selector2'); 해당 Selector 요소 중 Selector2가 아닌 요소를 선택
    $('Selector').end(); 해당 요소 이전의 요소를 선택
    $('Selector').contents().EX; 해당 Selector 요소 중 EX에 해당하는 조건을 가진 요소와 Selector를 선택 EX) eq(),lt(),gt(),find(),filter() 등
    $('Selector').find('Selector2'); 해당 Selector 의 하위 요소 중 Selector2인 요소를 선택
    $('Selector').filter('Selector2'); 해당 Selector 요소 중 Selector2인 요소를 선택
    $('Selector').is(':Attribute'); 해당 Seleoctor 요소가 해당 Attribute속성을 갖고 있는지 확인 <retrun type: boolean>

<ARRAY FUNCTION>
    $.each(array, function(){index, item}); foreach문의 jquery형태, function을 통해 실행, item.Name 등으로 값 출력 가능
    $.map(array, function(){return;}); return값을 통해 해당 array를 재정립
    $.index($('Selector')); 해당 Selector에 해당하는 index값을 반환, 결과가 여러 개일 경우, 가장 먼저 찾은 값을 반환

<FEILD SETTING>
    $(document).ready(function(params) {}); 함수 설정의 기본 형태
    $('Selector').css1('Value').css2('Value')...; Chaining 문법의 기본 형태
    $('Selector').css({attribute1:'Value1', attribute2:'Value2'...}); Chaining 문법의 다른 형태