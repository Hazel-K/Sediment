<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style>
		.err {
			font-size: 20px;
			color: red;
		}
        #title1 {
            margin: 30px auto;
            text-align: center;
        }

        #frm{
            display: grid;
            grid-template-columns: repeat(5, auto);
            grid-template-rows: repeat(6, auto);
            grid-template-areas: 
                ". . ipt1 . ."
                ". . ipt2 . ."
                ". . ipt3 . ."
                ". . ipt4 . ."
                ". . ipt5 . ."
                ". . ipt6 . ."
            ;
            grid-row-gap: 10px;
        }

        #ipt1, #ipt2, #ipt3, #ipt4, #ipt5{
            width: 98%;
        }
        #grid_ipt1 {
            grid-area: ipt1;
        }
        #grid_ipt2 {
            grid-area: ipt2;
        }
        #grid_ipt3 {
            grid-area: ipt3;
        }
        #grid_ipt4 {
            grid-area: ipt4;
        }
        #grid_ipt5 {
            grid-area: ipt5;
        }
        #grid_ipt6 {
            grid-area: ipt6;
            display: flex;
            justify-content: flex-end;
            align-items: flex-end;
        }
    </style>
</head>
<body>
	<h1 id="title1">회원가입</h1>
	<div class="err">${msg}</div>
    <div id="container">
        <div>
            <form id="frm" action="/join" method="POST" onsubmit="return chk()">
                <div id="grid_ipt1"><label for="ipt1"></label><input name="user_id" id="ipt1" type="text" placeholder="아이디" required value="${data.user_id}"></div>
                <div id="grid_ipt2"><label for="ipt2"></label><input name="user_pw" id="ipt2" type="text" placeholder="비밀번호" required></div>
                <div id="grid_ipt3"><label for="ipt3"></label><input name="user_pwre" id="ipt3" type="text" placeholder="비밀번호 확인" required></div>
                <div id="grid_ipt4"><label for="ipt4"></label><input name="nm" id="ipt4" type="text" placeholder="이름" required value="${data.user_nm}"></div>
                <div id="grid_ipt5"><label for="ipt5"></label><input name="email" id="ipt5" type="text" placeholder="이메일" value="${data.email}"></div>
                <div id="grid_ipt6"><button onclick="gotoLogin()">돌아가기</button><input name="" id="ipt6" type="submit" placeholder="비밀번호 확인" value="가입하기"></div>
            </form>
        </div>
    </div>
    <script>
        function chk() {
            if(frm.user_id.value.length < 5) {
                alert('아이디는 5글자 이상이어야 합니다');
                frm.user_id.focus();
                return false;
            } else if(frm.user_pw.value.length < 5) {
                alert('비밀번호는 5글자 이상이어야 합니다');
                frm.user_pw.focus();
                return false;
            } else if(frm.user_pw.value != frm.user_pwre.value) {
                alert('비밀번호가 서로 맞지 않습니다')
                frm.user_pwre.focus();
                return false;
            } else if (frm.nm.value.length > 0) {
                const korean = /[^가-힣]/;
                const result = korean.test(frm.nm.value);
                if (result) {
                    alert('이름은 한글만 입력해주세요');
                    frm.nm.value.focus();
                    return false;
                }
            } 
            if(frm.email.value.length > 0) {
                const e_mail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
                if(!e_mail.test(frm.email.value)) {
                    alert('올바른 이메일 형식을 입력해주세요');
                    frm.email.focus();
                    return false;
                }
            }
        }
        
        function gotoLogin() {
        	event.preventDefault();
        	location.href = "/login";
        }
    </script>
</body>
</html>