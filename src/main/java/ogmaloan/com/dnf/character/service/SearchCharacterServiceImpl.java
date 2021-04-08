package ogmaloan.com.dnf.character.service;

import javax.annotation.Resource;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ogmaloan.com.dnf.cmm.utils.ConnectUtils;
import ogmaloan.com.dnf.cmm.vo.CharacterVO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ogmaloan.com.dnf.character.dao.SearchCharacterDAO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("SearchCharacterService")
public class SearchCharacterServiceImpl implements SearchCharacterService {

	/* logger */
	private static final Logger logger = LoggerFactory.getLogger(SearchCharacterServiceImpl.class);

	/* Resource */
	@Resource(name = "SearchCharacterDAO")
	private SearchCharacterDAO searchCharacterDAO;

	/* 캐릭터 검색 - 목록형 */
	@Override
	public List<CharacterVO> searchCharacterLists(CharacterVO characterVO) throws Exception {
		List<CharacterVO> searchCharacters = new ArrayList<CharacterVO>();

		try {
			String serverId = characterVO.getServerId();
			String characterName = ConnectUtils.encodeURIComponent(characterVO.getCharacterName()); //캐릭터 명칭 URL UTF-8 인코딩
			String jobId = characterVO.getJobId();
			String jobGrowId = characterVO.getJobGrowId();

			/* 필수 값 유효성 검사 */
			if (StringUtils.isEmpty(serverId) || StringUtils.isEmpty(characterName)) {
				throw new NullPointerException();
			}
			if (characterName.length() < 2 || characterName.length() > 12) {
				throw new NullPointerException();
			}

			/* API URL 및 Parameter 설정 */
			String API_URL = "/df/servers/" + serverId + "/characters";
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("characterName", characterName);
			map.put("wordType", "full"); 				//동일 단어(match), 전문 검색(full) - full의 경우 최소 2자에서 최대 12자까지 이용 가능
			map.put("limit", "200");

			//직업 고유 코드 기준 추가 - 각성 코드의 경우 jobId가 있어야만 검색 가능
			if (!StringUtils.isEmpty(jobId)) {
				map.put("jobId", jobId);

				if (!StringUtils.isEmpty(jobGrowId)) {
					map.put("jobGrowId", jobGrowId);
				}
			}

			/* API Connection */
			JSONObject jsonObject = ConnectUtils.apiConnect(API_URL, map);

			/* API Result To Json */
			JSONArray jSONArray = (JSONArray) jsonObject.get("rows");

			/* API Result is not null */
			if(!StringUtils.isEmpty(jSONArray)) {
				Gson gson = new Gson();
				searchCharacters = gson.fromJson(jSONArray.toString(), new TypeToken<ArrayList<CharacterVO>>(){}.getType());

				/* DataBase Insert(+ Merge into) */
				for(int i=0; i<jSONArray.size(); i++) {
					searchCharacterDAO.insertCharacterLists(searchCharacters.get(i));
				}
			}

		} catch (Exception e) {
			logger.error("searchCharacterLists / Exception : [" + e + "]");
		}

		return searchCharacters;
	}
	
}
