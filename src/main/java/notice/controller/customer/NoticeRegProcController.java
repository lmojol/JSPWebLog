package notice.controller.customer;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.controller.Controller;
import notice.dao.NoticeDao;
import notice.vo.Notice;

public class NoticeRegProcController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("NoticeRegProcController pass");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Notice n = new Notice();
		n.setTitle(title);
		n.setContent(content); //'n'안에 담음
		
		NoticeDao dao = new NoticeDao();	
		int af=dao.insert(n);
		
		PrintWriter out=response.getWriter(); //out.print를 가능하게하는 문장
		
		//화면전환1
		if(af>0) {
			response.sendRedirect("notice.do");
			
		}else {
			out.println("글쓰기 오류");
		}

		// 화면전환2
		//request.getRequestDispatcher("notice.jsp").forward(request, response);
		// 담은 request값들을 noticeDetail.jsp로 보냄
	}
}
