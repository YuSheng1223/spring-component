package com.yusheng.webservice.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cxf.binding.soap.saaj.SAAJOutInterceptor;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.message.Message;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

import com.yusheng.webservice.validation.UserValidation;
/***
 * 调用webService接口的第二种方式
 * 
 * 这种方式需要提供接口类 HelloService  并且如果服务端接口上注解有targetNamespace属性 客户端接口上也需要有且一致
 * 
 * 
 * 
 * @author XuSheng
 *
 */
public class CallWebServiceInterfaceMthod02 {
	
	public static void main(String[] args) {
		
		 //第二种webservice的调用方式

		
		
		
		UserValidation userValidation = new UserValidation();
	    userValidation.setUsername("yusheng");
	    userValidation.setPassword("123456");
	    
		Map<String, Object> outProps = new HashMap<String, Object>();
		outProps.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
		outProps.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
		outProps.put(WSHandlerConstants.USER, userValidation.getUsername());
		outProps.put(WSHandlerConstants.PW_CALLBACK_REF, userValidation);
		List<Interceptor<? extends Message>> list = new ArrayList<Interceptor<? extends Message>>();
//		// 添加cxf安全验证拦截器
		list.add(new SAAJOutInterceptor());
		
		list.add(new WSS4JOutInterceptor(outProps));
		
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		
		factory.setServiceClass(HelloService.class);

		// 设置ws访问地址
		factory.setAddress("http://localhost:8080/cxf-ws-security/ws/soap/hello?wsdl");
		// 注入拦截器，用于加密安全验证信息
		factory.getOutInterceptors().addAll(list);
		HelloService service = (HelloService) factory.create();
		// 执行调用
		

		String result = service.say("眼前人是心上人");
		System.out.println("=================================");
		System.out.println(result);
		System.out.println("=================================");
		
	}

}
