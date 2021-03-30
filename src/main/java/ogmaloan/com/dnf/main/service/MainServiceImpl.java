package ogmaloan.com.dnf.main.service;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ogmaloan.com.dnf.main.dao.MainDAO;

@Service("MainService")
public class MainServiceImpl implements MainService {

	private static final Logger logger = LoggerFactory.getLogger(MainServiceImpl.class);
	
	@Resource(name = "MainDAO")
	private MainDAO mainDAO;
	
	
}
