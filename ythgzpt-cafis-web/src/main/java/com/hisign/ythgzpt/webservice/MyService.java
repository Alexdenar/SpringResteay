package com.hisign.ythgzpt.webservice;

import javax.jws.WebService;

/**
 * webservice接口
 * @author wangping
 * @version 1.0
 * @since 2016/11/10 16:44
 */
@WebService
public interface MyService {
    public String sayHi(String name);

    String testXml(String xmlStr);
}
