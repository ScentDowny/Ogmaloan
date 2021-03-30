package ogmaloan.com.dnf.cmm.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import ogmaloan.com.dnf.cmm.vo.ServerVO;

@Repository("CommonDAO")
public class CommonDAO extends AbstractDAO {

	/* 서버 정보 등록 */
	public void insertServerList(ServerVO serverVO) {
		insert("common.insertServerList", serverVO);
	}
	
	/* 서버 리스트 조회 */
	@SuppressWarnings("unchecked")
	public List<ServerVO> selectServerList() {
		return (List<ServerVO>) selectList("common.selectServerList");
	}
	
}
