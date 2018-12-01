package com.yusheng.webservice.client;

import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

import com.yusheng.webservice.validation.UserValidation;

/***
 * 调用webervice接口的第一种方式
 * @author XuSheng
 *
 */
public class CallWebServiceInterfaceMethod01 {
	

	
	
	public static void main(String[] args) {
		//第一种webservice的调用方式

	    JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();  
	    
	    Client client = dcf.createClient("http://localhost:8080/cxf-ws-security/ws/soap/hello?wsdl");
	    
	    UserValidation userValidation = new UserValidation();
	    userValidation.setUsername("yusheng");
	    userValidation.setPassword("123456");
	    
	    Map<String, Object> props = new HashMap<String, Object>();  
        props.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);        
        //密码类型 明文:PasswordText密文：PasswordDigest  
        props.put(WSHandlerConstants.PASSWORD_TYPE,WSConstants.PW_TEXT);
         //用户名 
        props.put(WSHandlerConstants.USER, userValidation.getUsername());  
        //将PasswordHandler 的类名传递给服务器，相当于传递了密码给服务器
        props.put(WSHandlerConstants.PW_CALLBACK_CLASS, UserValidation.class.getName());
        // 注入拦截器，用于加密安全验证信息
        WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(props);  
        
        client.getOutInterceptors().add(wssOut);
        
	      
	    
	    
	    
	    
	    //invoke  第二个参数为可变参数列表
	    Object[] objects;
	    try {
	        objects = client.invoke("say", "海上月是天上月");

			System.out.print("=========================");
			System.out.print(objects[0]);
			System.out.print("=========================");
	    } catch (Exception e) {
	       
	        e.printStackTrace();
	    }  
	}
	
	 


}
