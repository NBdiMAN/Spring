package com.NBdiMAN.dao;

import com.NBdiMAN.domain.Employee;

public interface IEmployeeDAO {
	
	void save(Employee emp);
	
	void update(Employee emp);
}
