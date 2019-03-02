package com.NBdiMAN.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.NBdiMAN.dao.IAccountDAO;
import com.NBdiMAN.service.IAccountService;

@Service
//@Transactional(read-only)将事务方法的属性可以直接写在括号里，本类中所有方法都是用这个属性，但是一般不推荐，应该在方法上贴注解
@Transactional
public class AccountServiceImpl implements IAccountService{
	
	@Autowired
	private IAccountDAO accountDAO;
	
	public void trans(Long outId, Long inId, int money) {
		accountDAO.transOut(outId, money);
		int a = 1 / 0;
		accountDAO.transIn(inId, money);
	}
	
	@Transactional(readOnly = true)
	public void listXxx() {
		
	}
}