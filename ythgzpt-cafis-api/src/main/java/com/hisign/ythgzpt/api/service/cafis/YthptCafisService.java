package com.hisign.ythgzpt.api.service.cafis;

import com.hisign.ythgzpt.api.service.BaseService;
import com.hisign.ythgzpt.common.JsonResult;

/**
 * 一体化调用cafis服务接口
 * @author zhaoqian
 * @create 2017-03-05 10:55
 * mail to zhaoqian@hisign.com.cn
 **/
public interface YthptCafisService extends BaseService{

    JsonResult launchFingerPrintCompare(String zwbh) throws Exception;
}
