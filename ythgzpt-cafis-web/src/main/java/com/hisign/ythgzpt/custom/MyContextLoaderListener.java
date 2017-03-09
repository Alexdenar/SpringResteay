package com.hisign.ythgzpt.custom;/**
 * 自定义ContextLoader
 *
 * @author zhaoqian
 * @create 2017-03-06 12:25
 * mail to zhaoqian@hisign.com.cn
 **/

import org.jboss.resteasy.plugins.spring.SpringContextLoaderSupport;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContext;

/**
 * 自定义ContextLoader
 * 修复spring4+resteasy3环境下所有rest服务都是404错误
 * @author zhaoqian
 * @create 2017-03-06 12:25
 * mail to zhaoqian@hisign.com.cn
 **/
public class MyContextLoaderListener extends ContextLoaderListener {

    private SpringContextLoaderSupport springContextLoaderSupport = new SpringContextLoaderSupport();
    @Override
    protected void customizeContext(ServletContext servletContext, ConfigurableWebApplicationContext configurableWebApplicationContext) {

        super.customizeContext(servletContext, configurableWebApplicationContext);
        this.springContextLoaderSupport.customizeContext(servletContext, configurableWebApplicationContext);
    }
}
