package ogmaloan.com.dnf.character.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ogmaloan.com.dnf.character.dao.SearchCharacterDAO;

@Service("SearchCharacterService")
public class SearchCharacterServiceImpl implements SearchCharacterService {

	@Resource(name = "SearchCharacterDAO")
	private SearchCharacterDAO searchCharacterDAO;
	
}
