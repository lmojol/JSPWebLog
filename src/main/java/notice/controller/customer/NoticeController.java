package notice.controller.customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.controller.Controller;
import notice.dao.NoticeDao;
import notice.vo.Notice;

public class NoticeController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NoticeController pass");
		
		String field=request.getParameter("f");
		System.out.println("field : "+field);
		if(field==null || field.equals("")) {
			field="title";
		}
		String query=request.getParameter("q");
		if(query==null) {
			query="";
		}

		// db접속해서 셀렉트 결과물 dao로 보냄
		NoticeDao dao = new NoticeDao();
		List<Notice> list = dao.getNotices(field,query);
		
		// request에 Notice n 을 담아주기(저장) 
		request.setAttribute("list", list); // (명칭 지정, 'list'을 담음) //좌list라는 이름으로 우list를 담음
		request.setAttribute("query",query);

		request.getRequestDispatcher("notice.jsp").forward(request, response); // 담은 request값들을 noticeDetail.jsp로 보냄
	}
}
