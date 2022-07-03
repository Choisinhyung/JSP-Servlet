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
	
	// doGet안에서 선언하면 사용자가 요청될 때 마다 계속 요청해야하기 때문에 멤버변수로 만들어 놓는게 편함
	private DeptService service = new DeptService();  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<DeptDTO> deptDatas = service.getAll();
		
		request.setAttribute("deptDatas", deptDatas);   // 컨트롤러에서 jsp파일로 값을 가져오는 코드
		// request 객체에 속성을 설정한다고 보면 됨.
		
		String view = "/WEB-INF/jsp/dept/index.jsp";
		request.getRequestDispatcher(view).forward(request, response); // request가 같이 전달
	}

}
