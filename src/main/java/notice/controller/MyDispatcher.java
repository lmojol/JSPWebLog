package notice.controller;

import java.io.IOException;
import java.security.Provider.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.controller.customer.NoticeController;
import notice.controller.customer.NoticeDelProcController;
import notice.controller.customer.NoticeDetailController;
import notice.controller.customer.NoticeEditController;
import notice.controller.customer.NoticeEditProcController;
import notice.controller.customer.NoticeRegController;
import notice.controller.customer.NoticeRegProcController;

public class MyDispatcher extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("신호");
		String uri=request.getRequestURI();
		String conpath=request.getContextPath();
		String com=uri.substring(conpath.length());
		
		System.out.println("uri : "+uri);
		System.out.println("conpath : "+conpath);
		System.out.println("com : "+com);
		
		/*
		 * NoticeDetailController controller1=new NoticeDetailController();
		 * NoticeEditController controller2=new NoticeEditController();
		 */
		Controller controller=null;
		
		try {
			if(com.equals("/customer/noticeDetail.do")) {//A-1 해당 주소로 오면
				controller=new NoticeDetailController(); //A-2 해당 주소로 보내라
			}
			else if(com.equals("/customer/noticeEdit.do")) {//A-1 해당 주소로 오면
				controller= new NoticeEditController();//A-2 해당 주소로 보내라
			}
			else if(com.equals("/customer/noticeEditProc.do")) {//A-1 해당 주소로 오면
				controller= new NoticeEditProcController();//A-2 해당 주소로 보내라
			}
			else if(com.equals("/customer/noticeReg.do")) {//A-1 해당 주소로 오면
				controller= new NoticeRegController();//A-2 해당 주소로 보내라
			}
			else if(com.equals("/customer/noticeRegProc.do")) {//A-1 해당 주소로 오면
				controller= new NoticeRegProcController();//A-2 해당 주소로 보내라
			}
			else if(com.equals("/customer/noticeDelProc.do")) {//A-1 해당 주소로 오면
				controller= new NoticeDelProcController();//A-2 해당 주소로 보내라
			}
			else if(com.equals("/customer/notice.do")) {//A-1 해당 주소로 오면
				controller= new NoticeController();//A-2 해당 주소로 보내라
			}
			
			controller.execute(request, response);
			
		}catch(Exception e) {
			
		}
	}
	
}
