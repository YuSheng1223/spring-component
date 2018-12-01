package com.yusheng.spring_cxf.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
/***
 * 接口类和实现类都必须都添加targetNamespace属性 而且值必须一直  这样在wsdl文档中才会显示 方法的参数和数据类型 如：<xs:element minOccurs="0" name="words" type="xs:string"/>
 * @author XuSheng
 *
 */
@WebService(targetNamespace="http://HelloService")
public interface HelloService {
	@WebMethod
	String say(@WebParam(name="words")String words);
}
