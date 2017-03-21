package com.hisign.ythgzpt.webservice;

import javax.jws.WebService;

/**
 * webservice接口实现
 * @author wangping
 * @version 1.0
 * @since 2016/11/10 16:45
 */
@WebService(endpointInterface = "com.hisign.ythgzpt.webservice.MyService")
public class MyServiceImpl implements MyService {
    @Override
    public String sayHi(String name) {
        System.out.println("11111111111111111");
        return String.format("Hello, %s", name);
    }

    @Override
    public String testXml(String xmlStr) {
        return xmlStr;
    }
}
