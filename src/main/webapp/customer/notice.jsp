<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
/* String driver="oracle.jdbc.driver.OracleDriver";
String url="jdbc:oracle:thin:@localhost:1521:xe";
String user="hr";
String pw="123456";

Class.forName(driver);
Connection conn=DriverManager.getConnection(url,user,pw);
//접속성공
String sql="select * from notices order by to_number(seq) desc";

//실행
Statement st=conn.createStatement();
//결과값 가져오기
ResultSet rs=st.executeQuery(sql); */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>notice</title>
</head>
<body>
	<h3>notice</h3>
	<script >
	function clearVal() {
		var inputval=document.getElementById("q");
		inputval.value="";  /*클릭 했다가 밖에갔다가 다시 클릭시 모두 지워짐*/
	}
	</script>
	
	
	<form action="notice.do" method="get">
		<select name="f">
			<option ${param.f=="title"?"selected":"" } value="title">제목</option>
			<option ${param.f=="content"?"selected":"" } value="content">내용</option>
		</select>
		<input type="text" id="q" name="q" value="${query }" onclick="clearVal();"/>
		<input type="submit" value="검색">
	</form> 

	<table width="500" border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>조회수</td>
		</tr>
		<c:forEach items="${list }" var="n"> <!--'NoticeController'에서 보낸('list')'걸 'n'으로 받음-->
			<tr>
				<td>${n.seq }</td>
				<td><a href="noticeDetail.do?c=${n.seq }&h=${n.hit }">${n.title }</a></td>
				<td>${n.writer }</td>
				<td>${n.regdate }</td>
				<td>${n.hit }</td>
			</tr>
		</c:forEach>

	</table>
	<a href="noticeReg.do">write</a>
</body>
</html>
