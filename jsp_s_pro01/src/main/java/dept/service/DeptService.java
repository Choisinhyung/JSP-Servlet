package dept.service;

import java.util.List;

import dept.model.DeptDAO;
import dept.model.DeptDTO;

public class DeptService {
	
	private DeptDAO dao;
	
	public DeptService() { //생성자
		dao = new DeptDAO();
	}
	
	// getAll에서 바로 조회를 하는 것이 아니라 dao에게 요청할 것
	public List<DeptDTO> getAll() { //결과값을 리턴해야하기 때문에 void는 안된다. collection사용
		List<DeptDTO> datas = dao.searchAll();
		return datas; // 리스트에는 한 개의 부서 정보가 들어가게 됨. DTO or VO 사용
	}
}
