package com.jsp.OnetoMany_Bidirection;

import java.util.ArrayList;
import java.util.List;

import com.jsp.OnetoMany_Bidirection.dao.CompanyDao;
import com.jsp.OnetoMany_Bidirection.dta.Company;
import com.jsp.OnetoMany_Bidirection.dta.Employee;

public class App 
{
    public static void main( String[] args )
    {
        Company company=new Company();
        company.setName("Infosys");
        
        Employee e1=new Employee();
        e1.setName("Krishna");
        e1.setAddress("Gujurat");
        
        Employee e2=new Employee();
        e2.setName("Ram");
        e2.setAddress("Ayodya");
        
        List<Employee>list=new ArrayList<Employee>();
        list.add(e1);
        list.add(e2);
        
        company.setEmployee(list);
        
        e1.setCompany(company);
        e2.setCompany(company);
        
        CompanyDao companyDao=new CompanyDao();
        companyDao.save(company);
    }
}
