package ogmaloan.com.dnf.character.dao;

import ogmaloan.com.dnf.cmm.vo.CharacterVO;
import org.springframework.stereotype.Repository;
import ogmaloan.com.dnf.cmm.dao.AbstractDAO;

@Repository("SearchCharacterDAO")
public class SearchCharacterDAO extends AbstractDAO {

    /* 캐릭터 검색 - 목록형 등록 */
    public void insertCharacterLists(CharacterVO characterVO) {
        insert("character.insertCharacterLists", characterVO);
    }
}
