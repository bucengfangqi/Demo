package com.java.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map session=invocation.getInvocationContext().getSession();
		if(session.get("loginSign")==null){
			return "none";
		}else{
			String result=invocation.invoke();
			return result;
		}
	}
	
}
