<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>
	#errMSG {
		color : red;
		font-size: 20px;
	}
</style>
</head>
<body>
	<h1>로그인</h1>
	<div id="errMSG">${errMsg}</div>
	<div>
        <form action="/login" method="POST">
            <div><input type="text" name="user_id" placeholder="아이디" value="${data.user_id}"></div>
            <div><input type="text" name="user_pw" placeholder="패스워드"></div>
            <div><input type="submit" value="로그인"><button onclick="goTojoin()">회원가입</button></div>
        </form>
    </div>
</body>
<script>
	function goTojoin() {
		event.preventDefault();
		location.href="join";
	}
</script>
</html>