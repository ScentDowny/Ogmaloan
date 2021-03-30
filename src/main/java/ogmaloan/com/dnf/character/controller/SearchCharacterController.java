package ogmaloan.com.dnf.character.controller;

import java.util.List;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ogmaloan.com.dnf.character.service.SearchCharacterService;
import ogmaloan.com.dnf.cmm.service.CommonService;
import ogmaloan.com.dnf.cmm.vo.ServerVO;

@Controller
public class SearchCharacterController {

	@Resource(name = "SearchCharacterService")
	private SearchCharacterService searchCharacterService;
	
	@Resource(name = "CommonService")
	private CommonService commonService;
	 
	private static final Logger logger = LoggerFactory.getLogger(SearchCharacterController.class);
	
	@RequestMapping(value = "/character/main", method = RequestMethod.GET)
	public String doCharacterMain(Model model, ServerVO serverVO) throws Exception {
		
		List<ServerVO> serverList = commonService.selectServerList();
		model.addAttribute("serverList", serverList);
		model.addAttribute("serverVO", serverVO);
		
		return "character/crtMain";
	}
	
	@RequestMapping(value = "/character/search", method = RequestMethod.GET)
	public String characterSearch(Model model, ServerVO serverVO) throws Exception {
		
		List<ServerVO> serverList = commonService.selectServerList();
		model.addAttribute("serverList", serverList);
		model.addAttribute("serverVO", serverVO);
		
		return "character/crtMain";
	}
	
}
