package ogmaloan.com.dnf.character.service;

import ogmaloan.com.dnf.cmm.vo.CharacterVO;

import java.util.List;

public interface SearchCharacterService {

    /* 캐릭터 검색 - 목록형 */
    List<CharacterVO> searchCharacterLists(CharacterVO characterVO) throws Exception;
}
