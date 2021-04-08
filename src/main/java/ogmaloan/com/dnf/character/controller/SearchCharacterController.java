package ogmaloan.com.dnf.character.controller;

import java.util.List;

import javax.annotation.Resource;

import ogmaloan.com.dnf.cmm.vo.CharacterVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ogmaloan.com.dnf.character.service.SearchCharacterService;
import ogmaloan.com.dnf.cmm.service.CommonService;
import ogmaloan.com.dnf.cmm.vo.ServerVO;

@Controller
public class SearchCharacterController {

	/* logger */
	private static final Logger logger = LoggerFactory.getLogger(SearchCharacterController.class);

	/* Resource */
	@Resource(name = "SearchCharacterService")
	private SearchCharacterService searchCharacterService;
	@Resource(name = "CommonService")
	private CommonService commonService;

	/* 캐릭터 검색 메인 화면 이동 */
	@RequestMapping(value = "/character/main", method = RequestMethod.GET)
	public String doCharacterMain(Model model, CharacterVO characterVO) throws Exception {
		
		List<ServerVO> serverList = commonService.selectServerList();
		model.addAttribute("serverList", serverList); 			// 전체 서버 목록
		model.addAttribute("characterVO", characterVO); 		// 검색한 파라미터 정보
		
		return "character/crtMain";
	}

	/* 캐릭터 검색 */
	@RequestMapping(value = "/character/search", method = RequestMethod.GET)
	public String characterSearch(Model model, CharacterVO characterVO) throws Exception {

		searchCharacterService.searchCharacterLists(characterVO);

		List<ServerVO> serverList = commonService.selectServerList();
		model.addAttribute("serverList", serverList); 			// 전체 서버 목록
		model.addAttribute("characterVO", characterVO); 		// 검색한 파라미터 정보
		
		return "character/crtMain";
	}
	
}
