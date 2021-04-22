package ogmaloan.com.dnf.main.controller;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ogmaloan.com.dnf.cmm.service.CommonService;
import ogmaloan.com.dnf.main.service.MainService;

@Controller
public class MainController {
	
	@Resource(name = "MainService")
	private MainService mainService;
	
	@Resource(name = "CommonService")
	private CommonService commonService;
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) throws Exception {
		return "main";
	}
	
}
