<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<%
String tid=request.getParameter("tid");
String tpwd=request.getParameter("tpwd");
String tpwd2=request.getParameter("tpwd2");
String tname=request.getParameter("tname");
String ttgender=request.getParameter("ttgender");

String year=request.getParameter("year");
String month=request.getParameter("month");
String day=request.getParameter("day");
String tbirth=String.format("%s-%s-%s",year,month,day);

String tis_lunar=request.getParameter("tis_lunar");
String tcphone=request.getParameter("tcphone");
String temail=request.getParameter("temail");
String[] thabits=request.getParameterValues("thabits");
String thabit="";
if(thabits!=null){
	for(int i=0;i<thabits.length;i++){
		thabit+=thabits[i];
		if(thabits.length>i+1)
			thabit+=",";
	}
}

List<String> errors=new ArrayList();
if(tid==null || tid.equals(""))
	errors.add("아이디없음");
if(!tpwd.equals(tpwd2))
	errors.add("비번불일치");

if(errors.size()>0) {
	request.setAttribute("errors", errors);
	request.getRequestDispatcher("01join.jsp").forward(request,response);
	
}else{
	
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "hr";
	String pw = "123456";
	
	Class.forName(driver);
	Connection conn = DriverManager.getConnection(url, user, pw);
	//접속성공
	String sql="insert into nmember2(tid,tpwd,tname,ttgender,tbirth,tis_lunar,tcphone,temail,thabit,tregdate) "
	+"values(?,?,?,?,?,?,?,?,?,sysdate)";
	
	PreparedStatement pstmt=conn.prepareStatement(sql);
	pstmt.setString(1,tid);
	pstmt.setString(2,tpwd);
	pstmt.setString(3,tname);
	pstmt.setString(4,ttgender);
	pstmt.setString(5,tbirth);
	pstmt.setString(6,tis_lunar);
	pstmt.setString(7,tcphone);
	pstmt.setString(8,temail);
	pstmt.setString(9,thabit);
	
	pstmt.executeUpdate();
	response.sendRedirect("../index.jsp");
		
}

%>
id : <%=tid%> <br />
gender : <%=ttgender %> <br />
birth : <%=tbirth %> <br />
email : <%=temail %> <br />
habit : <%=thabit %> <br />


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>joinProc2</h3>
</body>
</html>