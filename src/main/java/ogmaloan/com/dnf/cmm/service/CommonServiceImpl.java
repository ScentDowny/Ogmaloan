package ogmaloan.com.dnf.cmm.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ogmaloan.com.dnf.cmm.dao.CommonDAO;
import ogmaloan.com.dnf.cmm.utils.ConnectUtils;
import ogmaloan.com.dnf.cmm.vo.ServerVO;
import ogmaloan.com.dnf.main.dao.MainDAO;

@Service("CommonService")
public class CommonServiceImpl implements CommonService {

	private static final Logger logger = LoggerFactory.getLogger(CommonServiceImpl.class);
	
	@Resource(name = "CommonDAO")
	private CommonDAO commonDAO;
	
	@Override
	public void insertServerList() throws Exception {
		try {
			String API_URL = "/df/servers";
			
			JSONObject jsonObject = ConnectUtils.apiConnect(API_URL);
			JSONArray jsonArray = (JSONArray) jsonObject.get("rows");
			
			Gson gson = new Gson();
			List<ServerVO> jsonList = new ArrayList<ServerVO>();
			jsonList = gson.fromJson(jsonArray.toString() , new TypeToken<ArrayList<ServerVO>>(){}.getType());
			
			for(int i=0; i<jsonList.size(); i++) {
				commonDAO.insertServerList(jsonList.get(i));
			}
		} catch(Exception e) {
			logger.error("Exception :: " + e);
		}
	}
	
	@Override
	public List<ServerVO> selectServerList() throws Exception {
		List<ServerVO> serverList = commonDAO.selectServerList();
		return serverList;
	}
	
}
