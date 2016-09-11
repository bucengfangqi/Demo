package com.java.action;

import java.util.List;
import java.util.Map;

import com.java.util.UserUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class User extends ActionSupport{
	private String username;
	private String password;
	private String password1;
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	ActionContext context;
	Map request;
	Map session;
	//Map application;
	
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
	//判断用户
	public String judge(){
		
		//这家伙是用来辅助传递值到页面的
		context=ActionContext.getContext();
		//这家伙是用来传递值到页面的
		request=(Map) context.get("request");
		//session=context.getSession();
		//application=context.getApplication();
		
		String str="com.java.mapping.UserMapper.getUsername";
		String str1="com.java.mapping.UserMapper.getPassword";
		//List list = Arrays.asList(new String[]{"1","232","345"});
		List<String> user1=UserUtils.getSession().selectList(str);
		String password1=UserUtils.getSession().selectOne(str1,username);
		//关闭资源
		UserUtils.getSession(true).close();
		if(null==username||"".equals(username.replace(" ",""))){
			request.put("req","请务必输入昵称！");
			return NONE;
		}else if(user1.contains(username.replace(" ",""))==false){
			request.put("req","昵称未注册！");
			return NONE;
		}else if(null==password||"".equals(password.replace(" ",""))){
			request.put("req","请输入密码！");
			return NONE;
		}else if(user1.contains(username.replace(" ",""))==true&&password.replace(" ","").equals(password1)){
			session=context.getSession();
			session.put("loginSign",username);
			return SUCCESS;
		}else if(user1.contains(username)==true&&password!=password1.replace(" ","")){
			request.put("req","密码错误！请重新输入~");
			return NONE;
		}else{
			request.put("req","账号输入错误!");
			return NONE;
		}
	}
	//替换session为null达到清除session的效果
	public String clean(){
		ActionContext context;
		Map session;
		context=ActionContext.getContext();
		session=context.getSession();
		session.put("loginSign",null);
		return SUCCESS;
	}
	//注册账号
	public String regist(){
				
				String str="com.java.mapping.UserMapper.getUsername";
				String str1="com.java.mapping.UserMapper.addUser";
				
				//这家伙是用来辅助传递值到页面的
				context=ActionContext.getContext();
				//这家伙是用来传递值到页面的
				request=(Map) context.get("request");
				
				User user=new User();
				//List list = Arrays.asList(new String[]{"1","232","345"});
				List<String> user1=UserUtils.getSession().selectList(str,user.getUsername());
				//防止资源泄漏必须关闭
				UserUtils.getSession(true).close();
				//判断
				if(user1.contains(username.replace(" ",""))==true){
					request.put("req", "很抱歉！账号已经被注册！");
					return NONE;
					
				}else if(null==username||"".equals(username.replace(" ",""))){
					request.put("req", "请务必输入昵称！");
					return NONE;
					
				}else if(null==password||"".equals(password.replace(" ",""))){
					request.put("req", "请输入密码！");
					return NONE;
					
				}else if(null==password1||"".equals(password1.replace(" ",""))){
					request.put("req", "请输入确认密码！");
					return NONE;
					
				}else if(!password.replace(" ","").equals(password1.replace(" ",""))){
					request.put("req", "两次密码不一致");
					return NONE;
					
				}else{
					//将所有空格替换
					username=username.replace(" ","");
					password=password.replace(" ","");
					
					user.setPassword(password);
					user.setUsername(username);
					UserUtils.getSession(true).insert(str1,user);
					request.put("req", "注册成功！");
					return SUCCESS;
					
				}
	}
}
