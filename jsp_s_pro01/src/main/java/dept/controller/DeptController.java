package dept.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.model.DeptDTO;
import dept.service.DeptService;

@WebServlet("/depts")
public class DeptController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeptService service = new DeptService();
		List<DeptDTO> deptDatas = service.getAll();
		
		request.setAttribute("deptDatas", deptDatas);   // 컨트롤러에서 jsp파일로 값을 가져오는 코드
		// request 객체에 속성을 설정한다고 보면 됨.
		
		String view = "/WEB-INF/jsp/dept/index.jsp";
		request.getRequestDispatcher(view).forward(request, response); // request가 같이 전달
	}

}
