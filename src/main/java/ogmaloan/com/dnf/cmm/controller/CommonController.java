package ogmaloan.com.dnf.cmm.controller;

import ogmaloan.com.dnf.cmm.service.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class CommonController {

    /* logger */
    private static final Logger logger = LoggerFactory.getLogger(CommonController.class);

    /* Resource */
    @Resource(name = "CommonService")
    private CommonService commonService;

    /* 서버 목록 가져오기 */
    @RequestMapping(value = "/cmm/updateServer", method = RequestMethod.POST)
    @ResponseBody
    public void insertServerList() throws Exception {
        commonService.insertServerList();
    }

    /* 직업 목록 가져오기 */
    @RequestMapping(value = "/cmm/updateJob", method = RequestMethod.POST)
    @ResponseBody
    public void insertJobList() throws Exception {
        commonService.insertJobList();
    }



}
