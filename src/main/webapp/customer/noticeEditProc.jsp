<%@page import="job.vo.Jobkorea"%>
<%@page import="job.dao.JobkoreaDao"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    request.setCharacterEncoding("utf-8");
        /* String title=request.getParameter("title");
        String content=request.getParameter("content");
        String seq=request.getParameter("c"); */
    %>
<%
Jobkorea n= new Jobkorea();
/* n.setTitle(title);
n.setContent(content);
n.setSeq(seq); //'n'에 담음 */

/* NoticeDao dao=new NoticeDao();
int cnt = dao.update(n); //수정(업데이트)완료//'n'안에 담은걸 'dao'의'update()'로 n의 형태로 보내줌

if(cnt>0){
	response.sendRedirect("noticeDetail.jsp?c="+seq);	
}else { 
	out.write("수정오류");
} */
%>  
