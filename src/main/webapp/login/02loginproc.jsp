<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<%
String id=request.getParameter("id");
String password=request.getParameter("password");

String driver="oracle.jdbc.driver.OracleDriver";
String url="jdbc:oracle:thin:@localhost:1521:xe";
String user="hr";
String pw="123456";

Class.forName(driver);
Connection conn=DriverManager.getConnection(url,user,pw);
//데이터베이스 접속성공

String sql="select * from nmember where id=?";
PreparedStatement pstmt=conn.prepareStatement(sql);
pstmt.setString(1, id);
ResultSet rs=pstmt.executeQuery(); //화면에 입력한 값을 ?에 넣음
//검사진행 일치판단
String ypass="";
int x=-1;
String msg="";
//비밀번호 일치판단
if(rs.next()){ //아이디가 존재한다
	ypass = rs.getString("pwd"); //'rs.getString'(데이터베이스 칼럼명)
	if(ypass.equals(password)){
		x=1;
	}else{//아이디는 있으나 비밀번호가 틀림
		x=0;
	}
}else{ //아이디가 존재하지 않는다.
	x=-1;
}
System.out.println("x value : "+x);
if(x==1){
	//로그인 성공 ,세션에 저장,MainForm.jsp로 이동
	session.setAttribute("sessionID", id); /* 'sessionID'라는 이름으로 'id'를 저장 */
	msg="../mainform.jsp";
}else if(x==0){
	msg="01loginform.jsp?msg=0";
}else {
	msg="01loginform.jsp?msg=-1";
}

response.sendRedirect(msg);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>loginproc</h3>
</body>
</html>