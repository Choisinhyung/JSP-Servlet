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
	
	// 아래 세 가지 메서드 동일한 작업을 매개변수의 타입에 따라 다르게. 오버로딩 / 내부 처리 결과는 다 같다 그러므로 처리 작업은 메서드로 생성 후 호출
	public DeptDTO getId(String id) {
		return _getId(Integer.parseInt(id));
	}
	
	public DeptDTO getId(int id) {
		return _getId(id);
	}
	
	public DeptDTO getId(DeptDTO deptDto) {
		return _getId(deptDto.getDeptId());
	}
	
	private DeptDTO _getId(int id ) {
		DeptDTO data = dao.searchId(id);
		return data;
	}
}
