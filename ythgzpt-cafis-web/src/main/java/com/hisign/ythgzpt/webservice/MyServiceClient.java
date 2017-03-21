package com.hisign.ythgzpt.webservice;

import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * 客户端调用
 * @author wangping
 * @version 1.0
 * @since 2016/11/10 17:43
 */
public class MyServiceClient {
    public static void main(String[] args) throws Exception {
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        org.apache.cxf.endpoint.Client client = dcf.createClient("http://localhost:8080/yth/services/testService?wsdl");
//        QName name=new QName("http://server.webservice.facelook.com/","getAlbumList");

        //sayHello 为接口中定义的方法名称   张三为传递的参数   返回一个Object数组
        Object[] objects=client.invoke("sayHi", "张三");
        //输出调用结果
        System.out.println(objects[0].toString());

        String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                + "     <facelook>"
                + "        <condition>"
                + "            <name>家</name>"
                + "            <description></description>"
                + "            <pageno></pageno>"
                + "            <pagesize></pagesize>"
                + "        </condition>"
                + "     </facelook>";

//        String.format("%s%s", a, b);

        objects=client.invoke("testXml", xmlStr);
        System.out.println(objects[0].toString());
    }

}
