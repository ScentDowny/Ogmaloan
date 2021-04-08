package ogmaloan.com.dnf.cmm.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;

import ogmaloan.com.dnf.cmm.vo.JobVO;
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
import org.springframework.util.StringUtils;

@Service("CommonService")
public class CommonServiceImpl implements CommonService {

	/* logger */
	private static final Logger logger = LoggerFactory.getLogger(CommonServiceImpl.class);

	/* Resource */
	@Resource(name = "CommonDAO")
	private CommonDAO commonDAO;
	
	/* 서버목록 업데이트 */
	@Override
	public void insertServerList() throws Exception {
		List<ServerVO> serverList = new ArrayList<ServerVO>();

		try {
			/* API URL 및 Parameter 설정 */
			String API_URL = "/df/servers";

			/* API Connection */
			JSONObject jsonObject = ConnectUtils.apiConnect(API_URL);

			/* API Result To Json */
			JSONArray jSONArray = (JSONArray) jsonObject.get("rows");

			/* API Result is not null */
			if(!StringUtils.isEmpty(jSONArray)) {
				Gson gson = new Gson();
				serverList = gson.fromJson(jSONArray.toString() , new TypeToken<ArrayList<ServerVO>>(){}.getType());

				/* DataBase Insert(+ Merge into) */
				for(int i=0; i<serverList.size(); i++) {
					commonDAO.insertServerList(serverList.get(i));
				}
			}

		} catch(Exception e) {
			logger.error("insertServerList / Exception : [" + e + "]");
		}
	}
	
	/* 서버목록 조회 */
	@Override
	public List<ServerVO> selectServerList() throws Exception {
		List<ServerVO> serverList = commonDAO.selectServerList();
		return serverList;
	}

	/* 직업목록 등록 */
	@Override
	public void insertJobList() throws Exception {
		List<JobVO> jobList = new ArrayList<JobVO>();

		String jobId = "";
		String jobName = "";
		String jobGrowId = "";
		String jobGrowName = "";

		try {
			/* API URL 및 Parameter 설정 */
			String API_URL = "/df/servers";

			/* API Connection */
			JSONObject jsonObject = ConnectUtils.apiConnect(API_URL);

			/* API Result To Json */
			JSONArray jSONArray = (JSONArray) jsonObject.get("rows");

			/* API Result is not null */
			if(!StringUtils.isEmpty(jSONArray)) {

				/* 직업전체 목록 for */
				for(int i=0; i<jSONArray.size(); i++) {
					JSONObject jobObject = (JSONObject) jSONArray.get(i);
					jobId = (String) jobObject.get("jobId");
					jobName = (String) jobObject.get("jobName");

					JSONArray jobGrowArray = (JSONArray) jobObject.get("rows");

					/* jobId 기준 > 각성 직업 전체 목록 is not null */
					if(!StringUtils.isEmpty(jobGrowArray)) {

						/* jobId 기준 > 각성 직업 전체 목록 for */
						for(int j=0; j<jobGrowArray.size(); j++) {
							JSONObject jobGrowObject = (JSONObject) jobGrowArray.get(j);
							jobGrowId = (String) jobGrowObject.get("jobGrowId");
							jobGrowName = (String) jobGrowObject.get("jobGrowName");
						}
					}
				}
			}

		} catch(Exception e) {
			logger.error("insertServerList / Exception : [" + e + "]");
		}
	}
}
