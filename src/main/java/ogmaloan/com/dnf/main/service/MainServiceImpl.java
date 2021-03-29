package ogmaloan.com.dnf.main.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ogmaloan.com.dnf.main.dao.MainDAO;

@Service("MainService")
public class MainServiceImpl implements MainService {

	@Resource(name = "MainDAO")
	private MainDAO mainDAO;
	
	@Override
	public void insertTest() throws Exception {
		mainDAO.insertTest();
	}
	
}
