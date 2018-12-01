package com.yusheng.spring_cxf.service.Impl;

import javax.jws.WebService;

import org.springframework.stereotype.Component;

import com.yusheng.spring_cxf.service.HelloService;
/***
 * targetNamespace : wsdl:definitions 根标签的命名空间 可有可无 默认值为 接口所在包名的倒序 如：http://service.spring_cxf.yusheng.com/
 * serviceName ：serviceName： 对外发布的服务名，指定 Web Service 的服务名称：wsdl:service。
 * 				缺省值为 Java 类的简单名称 + Service。（字符串）
 * endpointInterface ：  服务器段接口的全类名 必填
 * 
 * @WebService 注解内完全可以什么参数都不写
 * @author XuSheng
 *
 */
@Component
@WebService(targetNamespace="http://HelloService",serviceName = "helloService", 
endpointInterface = "com.yusheng.spring_cxf.service.HelloService"  
)
public class HelloServiceImpl implements HelloService{

	public String say(String words) {
		
		return "我想说"+words;
	}

}
