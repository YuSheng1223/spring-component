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

	    Map<String, Object> props = new HashMap<String, Object>();
	    // 没有用户密码token验证的情况  使用NO_SECURITY策略
        props.put(WSHandlerConstants.ACTION, WSHandlerConstants.NO_SECURITY);
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
