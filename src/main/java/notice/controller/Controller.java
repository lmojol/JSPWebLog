package notice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	//추상메소드화 시킴
	public void execute (HttpServletRequest request, HttpServletResponse response) throws Exception;
}
