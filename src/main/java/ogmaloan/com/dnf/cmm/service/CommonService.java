package ogmaloan.com.dnf.cmm.service;

import java.util.List;
import ogmaloan.com.dnf.cmm.vo.ServerVO;

public interface CommonService {

	/* 서버 정보 등록 */
	public void insertServerList() throws Exception;
	
	/* 서버 리스트 조회 */
	public List<ServerVO> selectServerList() throws Exception;

	
}
