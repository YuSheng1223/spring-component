package com.yusheng.webservice.validation;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

/***
 * 用户验证   用来实现ws-security的账户密码验证
 * @author XuSheng
 *
 */
public class UserValidation implements CallbackHandler{
	
	private String username; //用户名
	private String password; //密码
	
	
	
	
	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		// TODO Auto-generated method stub
		for (int i = 0; i < callbacks.length; i++) {
			WSPasswordCallback callback = (WSPasswordCallback)callbacks[i];
			callback.setPassword("123456");
		}
	}

}
