package com.yusheng.webservice.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
/***
 * 
 * @author XuSheng
 *
 */
@WebService(targetNamespace="http://HelloService")
public interface HelloService {
	@WebMethod
	String say(@WebParam(name="words")String words);
}
