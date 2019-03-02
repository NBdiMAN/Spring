package com.NBdiMAN;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.NBdiMAN.domain.Employee;
import com.NBdiMAN.log.LogAdvice;
import com.NBdiMAN.service.impl.EmployeeServiceImpl;

@SpringJUnitConfig
public class App {
	
	@Autowired
	private LogAdvice advice;
	
	@Test
	void testSave() throws Exception {
		EmployeeServiceImpl proxy = advice.getProxyObject();
		System.out.println(advice);
		System.out.println(proxy.getClass());
		proxy.save(new Employee());
	}
	
	@Test
	void testUpdate() throws Exception {
		EmployeeServiceImpl proxy = advice.getProxyObject();
		
		proxy.update(new Employee());
	}
}
