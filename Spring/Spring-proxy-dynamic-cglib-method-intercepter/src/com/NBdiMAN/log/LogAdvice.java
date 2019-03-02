package com.NBdiMAN.log;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import lombok.Setter;
@SuppressWarnings("all")
public class LogAdvice implements MethodInterceptor{
	
	@Setter
	private Object target;
	
	@Setter 
	private LogUtil logUtil;

	
	public <T> T getProxyObject() {
		/*Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(target.getClass());
		enhancer.setCallback(this);
		return (T) enhancer.create();*/
		return (T) Enhancer.create(target.getClass(), this);
	}
	
	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		logUtil.writeLog(method.getDeclaringClass().getName(), method.getName());
		Object ret = method.invoke(target, args);
		return ret;
	}
	
}
