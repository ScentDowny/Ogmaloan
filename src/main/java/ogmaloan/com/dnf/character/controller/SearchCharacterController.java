package ogmaloan.com.dnf.character.controller;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import ogmaloan.com.dnf.character.service.SearchCharacterService;

@Controller
public class SearchCharacterController {

	@Resource(name = "SearchCharacterService")
	private SearchCharacterService searchCharacterService;
	 
	private static final Logger logger = LoggerFactory.getLogger(SearchCharacterController.class);
	
}
