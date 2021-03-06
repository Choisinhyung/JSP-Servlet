package dept.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dept.model.DeptDAO;
import dept.model.DeptDTO;

public class DeptService {
	
	private DeptDAO dao;

	public List<DeptDTO> getAll() { //결과값을 리턴해야하기 때문에 void는 안된다. collection사용
		dao = new DeptDAO();
		
		// getAll에서 바로 조회를 하는 것이 아니라 dao에게 요청할 것
		List<DeptDTO> datas = dao.searchAll();
		
		dao.close();
		return datas;
	}
	
	public List<DeptDTO> getPage(int pageNumber) {
		int start, end;
		start = (pageNumber - 1) * 10;
		end = 10;
		dao = new DeptDAO();
		List<DeptDTO> datas = dao.searchPage(start, end);
		dao.close();
		return datas;
	}
	
	/*
	public List<DeptDTO> getPage(int pageNumber) {
		Map<String, Integer> page = new HashMap<String, Integer>();
		page.put("start", (pageNumber - 1) * 10 + 1);
		page.put("end", (pageNumber - 1) * 10 + 10);
		
		dao = new DeptDAO();
		List<DeptDTO> datas = dao.searchPage(page);
		dao.close();
		
		return datas;
	}
	*/
	
	public List<Integer> getPageList() {
		dao = new DeptDAO();
		
		List<Integer> pageList = new ArrayList<Integer>();
		int total = dao.totalRow();
		
		for(int num = 0; num <= (total - 1) / 10; num++) {
			pageList.add(num + 1);
		}
		
		return pageList;
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
	
	private DeptDTO _getId(int id) {
		dao = new DeptDAO();
		
		DeptDTO data = dao.searchId(id);
		
		dao.close();
		return data;
	}

	public DeptDTO addDept(String deptId, String deptName, String mngId, String locId) {
		dao = new DeptDAO();
		
		DeptDTO deptDto = null;
		if(deptId.matches("\\d+") && mngId.matches("\\d+") && locId.matches("\\d+")) {
			deptDto = new DeptDTO();
			deptDto.setDeptId(Integer.parseInt(deptId));
			deptDto.setDeptName(deptName);
			deptDto.setMngId(Integer.parseInt(mngId));
			deptDto.setLocId(Integer.parseInt(locId));
			
			if(dao.searchId(deptDto.getDeptId()) != null) { // deptId가 존재하는지
				deptDto.setDeptId(-1);
				dao.close();
				return deptDto;
			}
			
			if(!dao.existManager(deptDto.getMngId())) {
				deptDto.setMngId(-1); // 참조할 객체가 없다..
				dao.close();
				return deptDto;
			}
			
			if(!dao.existLocation(deptDto.getLocId())) {
				deptDto.setLocId(-1);
				dao.close();
				return deptDto;
			}
			
			boolean isSaved = dao.insertDept(deptDto);
			
			if(!isSaved) {
				dao.close();
				return null;
			}
		}
		
		dao.close();
		return deptDto;
	}

	public int modifyDept(DeptDTO data) {
		dao = new DeptDAO();
		
		if(!dao.existManager(data.getMngId())) {
			dao.close();
			return -1;
		}
		
		if(!dao.existLocation(data.getLocId())) {
			dao.close();
			return -2;
		}
		
		boolean isSaved = dao.updateDept(data);
		dao.close();
		
		if(isSaved) {
			return 1;
		}
		return 0;
	}

	public int deleteDept(String id) {
		dao = new DeptDAO();
		
		if(dao.searchId(Integer.parseInt(id)) == null) {
			dao.close();
			return -1;	// 삭제 대상이 없음을 알림
		}
		
		boolean result = dao.deleteDept(Integer.parseInt(id));
		dao.close();
		if(result) {
			return 1;
		}
		return 0;
	}
}
