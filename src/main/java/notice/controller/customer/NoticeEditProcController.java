package notice.controller.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.controller.Controller;
import notice.dao.NoticeDao;
import notice.vo.Notice;

public class NoticeEditProcController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("NoticeEditProcController pass");

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String seq = request.getParameter("c");

		Notice n = new Notice();
		n.setTitle(title);
		n.setContent(content);
		n.setSeq(seq); // 'n'에 담음

		NoticeDao dao = new NoticeDao();
		int cnt = dao.update(n); // 수정(업데이트)완료//'n'안에 담은걸 'dao'의'update()'로 n의 형태로 보내줌

		// 수정된 Notice값을 다시 가져오기
		n = dao.getNotice(seq,"temp");

		// request에 Notice n 을 담아주기(저장)
		request.setAttribute("n", n); // (명칭 지정, 'n'을 담음)

		request.getRequestDispatcher("noticeDetail.do").forward(request, response);
		// 담은 request값들을 noticeDetail.jsp로 보냄

	}
}
