package com.hisign.ythgzpt.app.resteasy.cafis;

import com.hisign.ythgzpt.common.JsonResult;
import com.hisign.ythgzpt.common.util.JsonResultUtil;
import com.hisign.ythgzpt.common.util.PropertiesUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * 一体化调用Cafis服务
 * @author zhaoqian
 * @create 2017-03-05 14:40
 * mail to zhaoqian@hisign.com.cn
 **/

@Path("/invokeCafis")
@Component
public class InvokeCafisService {

    public static final Logger logger = LoggerFactory.getLogger(InvokeCafisService.class);

    @GET
    @Path(value = "/launchComparsion/{zwbh}")
    @Produces("application/json")
    public JsonResult launchFingerPrintCompare(@PathParam("zwbh") String zwbh) {
        logger.debug("调用cafis发起指纹比对");
        // 拼接cmd命令
        String batPath = InvokeCafisService.class.getClassLoader().getResource("PP_TRANS.exe")
                        .getPath().replaceFirst("/","").replaceAll("%20"," ");
        StringBuffer command = new StringBuffer();

        command.append(batPath+" ");
        command.append(PropertiesUtils.findPropertiesKey("cafis_hostname")+" ");
        command.append(PropertiesUtils.findPropertiesKey("cafis_port")+" ");
        command.append("RS_UTIL insert"+" ");
        command.append(zwbh+" ");
        command.append("lt"+" ");
        command.append(PropertiesUtils.findPropertiesKey("cafis_dbname")+" ");
        command.append("0 0 0 12 8 . 3 3");


        try{
            Process p = Runtime.getRuntime().exec(command.toString());
            int num = p.waitFor();
            if (num == 0) {
                return JsonResultUtil.success();
            } else {
                logger.debug("调用cafis外挂程序失败");
                return JsonResultUtil.error("调用cafis外挂程序失败");
            }
        }catch (Exception e){
            logger.debug("程序异常");
            e.printStackTrace();
            return JsonResultUtil.error("调用cafis外挂程序失败");
        }
    }
}
