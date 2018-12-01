package com.yusheng.spring_cxf.callback;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;


// 回调处理

/***
 * 验证账户和密码
 * 
 * 
 * 该类实现ws-security的CallbackHandler 接口，并重写它的handle方法
 * 该类就是身份验证的主要类，当客户端传过的用户名中为“yuhseng“时，
 * 该方法会将指定的密码告知ws-security的WSPasswordCallback 类，
 * 并让它后期去和客户端的密码进行验证，通过就放行，否则打回
 * @author XuSheng
 *
 */
public class ValidationCallBack implements CallbackHandler{

	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		 WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
         if ("yusheng".equals(pc.getIdentifier())) {
                pc.setPassword("123456");
            }

	}

}
