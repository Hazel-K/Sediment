<DOCUMENT FUNCTION>
    $('Selector'); Selector를 설정. document.querySelector=('Selector'); 와 동일
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

<FEILD SETTING>
    $(document).ready(function(params) {}); 함수 설정의 기본 형태
    $('Selector').css1('Value').css2('Value')...; Chaining 문법의 기본 형태
    $('Selector').css({attribute1:'Value1', attribute2:'Value2'...}); Chaining 문법의 다른 형태