package notice.controller.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.controller.Controller;
import notice.dao.NoticeDao;
import notice.vo.Notice;

public class NoticeEditController implements Controller {
	
	@Override
	public void execute (HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("NoticeEditController pass");
		
		String seq = request.getParameter("c");
		NoticeDao dao = new NoticeDao(); //객체생성
		Notice n=dao.getNotice(seq);//seq를 보냄
		
		//request에 Notice n 을 담아주기(저장)
		request.setAttribute("n", n); //(명칭 지정, 'n'을 담음)
		
		request.getRequestDispatcher("noticeEdit.jsp").forward(request, response); //담은 request값들을 noticeDetail.jsp로 보냄
		
	}
}
