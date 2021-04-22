package ogmaloan.com.dnf.cmm.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import jdk.nashorn.internal.scripts.JO;
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
					commonDAO.insertServerMaster(serverList.get(i));
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
		List<JobVO> list = new ArrayList<JobVO>();
		String jobId = "";
		String jobName = "";
		String jobGrowId = "";
		String jobGrowName = "";

		try {
			/* API URL 및 Parameter 설정 */
			String API_URL = "/df/jobs";

			/* API Connection */
			JSONObject jsonObject = ConnectUtils.apiConnect(API_URL);

			/* API Result To Json */
			JSONArray jsonArray = (JSONArray) jsonObject.get("rows");

			/* API Result is not null */
			/* 직업 */
			if(!StringUtils.isEmpty(jsonArray)) {
				for(int i=0; i<jsonArray.size(); i++) {
					JSONObject jobObject = (JSONObject) jsonArray.get(i);
					jobId = (String) jobObject.get("jobId");
					jobName = (String) jobObject.get("jobName");

					JSONArray jobGrowArray = (JSONArray) jobObject.get("rows");
					/* 1차 */
					if(!StringUtils.isEmpty(jobGrowArray)) {
						for (int j = 0; j < jobGrowArray.size(); j++) {
							JSONObject jobGrowObject = (JSONObject) jobGrowArray.get(j);
							jobGrowId = (String) jobGrowObject.get("jobGrowId");
							jobGrowName = (String) jobGrowObject.get("jobGrowName");
							this.setJobInfo(list, jobId, jobGrowId, jobName, jobGrowName, i, j, 0);

							/* 2차 */
							JSONObject nextJobGrowObject = (JSONObject) jobGrowObject.get("next");
							if(!StringUtils.isEmpty(nextJobGrowObject)) {
								jobGrowId = (String) nextJobGrowObject.get("jobGrowId");
								jobGrowName = (String) nextJobGrowObject.get("jobGrowName");
								this.setJobInfo(list, jobId, jobGrowId, jobName, jobGrowName, i, j, 1);

								/* 3차 */
								nextJobGrowObject = (JSONObject) nextJobGrowObject.get("next");
								if(!StringUtils.isEmpty(nextJobGrowObject)) {
									jobGrowId = (String) nextJobGrowObject.get("jobGrowId");
									jobGrowName = (String) nextJobGrowObject.get("jobGrowName");
									this.setJobInfo(list, jobId, jobGrowId, jobName, jobGrowName, i, j, 2);

									/* 진 각성 */
									nextJobGrowObject = (JSONObject) nextJobGrowObject.get("next");
									if(!StringUtils.isEmpty(nextJobGrowObject)) {
										jobGrowId = (String) nextJobGrowObject.get("jobGrowId");
										jobGrowName = (String) nextJobGrowObject.get("jobGrowName");
										this.setJobInfo(list, jobId, jobGrowId, jobName, jobGrowName, i, j, 3);
									}
								}
							}
						}
					}
				}
			}

			/* DataBase Insert(+ Merge into) */
			for(int size=0; size<list.size(); size++) {
				commonDAO.insertJobMaster(list.get(size));
			}

		} catch(Exception e) {
			logger.error("insertServerList / Exception : [" + e + "]");
		}
	}

	/* List에 JobVO 담기 */
	private List<JobVO> setJobInfo(List<JobVO> list, String jobId, String jobGrowId, String jobName, String jobGrowName, int parentJobOrder, int jobGrowOrder, int jobOrder) {
		JobVO jobVo = new JobVO();
		jobVo.setJobInfo(jobId, jobGrowId, jobName, jobGrowName, parentJobOrder, jobGrowOrder, jobOrder);
		list.add(jobVo);
		return list;
	}

}
