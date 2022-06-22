<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>join2</h3>
	<form action="02joinProc.jsp">
		<p style="color:red;">
		<%
		if(request.getAttribute("errors")!=null){
			List<String> errors=(List)request.getAttribute("errors");
			for(int i=0;i<errors.size();i++){
				%>
				<%=errors.get(i) %> <br />
				 
				<%
			}
		}
		%>
		</p>
	
	
		아이디 : <input type="text" name="tid"/>
		<input type="button"  value="중복확인"/> <br />
		비밀번호 : <input type="text" name="tpwd"/> <br />
		비밀번호 확인 : <input type="text" name="tpwd2"/> <br />
		이름 : <input type="text" name="tname"/> <br />
		성별 : 
		<select name="ttgender" id="ttgender">
			<option value="남">남</option>
			<option value="여">여</option>
		</select> <br />
		생년월일 :
		<input type="text" name="year" size="5"/>년
		<input type="text" name="month" size="5"/>월
		<input type="text" name="day" size="5"/>일
		
		<input type="radio" name="tis_lunar" value="solar" checked />양력
		<input type="radio" name="tis_lunar" value="islunar"  />음력 <br />
		번호 : <input type="tel" name="tcphone"/> 예)010-1234-4567 <br />
		이메일 : <input type="email" name="temail"/> <br />
		취미 :
		 <input type="checkbox" name="thabit" value="취미1"/>취미1
		 <input type="checkbox" name="thabit" value="취미2"/>취미2
		 <input type="checkbox" name="thabit" value="취미3"/>취미3 <br />
		 
		<input type="submit" value="확인" />
	
	</form>
</body>
</html>