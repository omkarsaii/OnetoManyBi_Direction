package com.jsp.OnetoMany_Bidirection.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.OnetoMany_Bidirection.dta.Company;
import com.jsp.OnetoMany_Bidirection.dta.Employee;

public class CompanyDao {

	public Object company;
	
	public EntityManager getEntityManager()
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Omkarr");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	public void save(Company company)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
	
		entityTransaction.begin();
		entityManager.persist(company);
		
		List<Employee>list=company.getEmployee();
		for(Employee employee:list)
		{
			employee.setCompany(company);
			entityManager.persist(employee);	
		}
		entityTransaction.commit();
	}
	
}
