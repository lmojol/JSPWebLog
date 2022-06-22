<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
	function logoutproc() {
		location.href="login/03logoutproc.jsp"
	}
	</script>

	<h3>mainform</h3>
	<b><font size="3" color="skyblue">메인화면</font></b>
	<%
	if(session.getAttribute("sessionID")==null){//로그인 안된 상태
		
	}else{//로그인 된 상태
	%>
		<h3>
			<font color="blue"><%=session.getAttribute("sessionID") %></font>님 로그인
		</h3>
		<br /><br />
		<input type="button" value="logout" onclick="logoutproc()" />
	<%
	}
	%>
</body>
</html>