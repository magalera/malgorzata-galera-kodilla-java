package com.kodilla.hibernate.manytomany.facade.api;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyFacade {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    public List<Company> findCompanies(String partOfName) {
        return companyDao.retrieveNameWhereNameContains("%" + partOfName + "%");
    }

    public List<Employee> findEmployees(String partOfLastName) {
        return employeeDao.retrieveWhereLastNameContains("%" + partOfLastName + "%");
    }
}
