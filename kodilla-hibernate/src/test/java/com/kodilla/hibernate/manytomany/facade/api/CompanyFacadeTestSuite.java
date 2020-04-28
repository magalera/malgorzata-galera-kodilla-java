package com.kodilla.hibernate.manytomany.facade.api;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyFacadeTestSuite {
    @Autowired
    private CompanyFacade companyFacade;
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void testFindCompanies() {
        //Given
        Company company1 = new Company("VirtusLab");
        Company company2 = new Company("Britenet");

        //When
        companyDao.save(company1);
        companyDao.save(company2);

        //Then
        List<Company> companies = companyFacade.findCompanies("t");
        Assert.assertEquals(2, companies.size());

        //CleanUp
        try {
            companyDao.deleteById(company1.getId());
            companyDao.deleteById(company2.getId());
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testFindEmployees() {
        //Given
        Employee employee1 = new Employee("John", "Travolta");
        Employee employee2 = new Employee("Steven", "Tyler");

        //When
        employeeDao.save(employee1);
        employeeDao.save(employee2);

        //Then
        List<Employee> employees = companyFacade.findEmployees("Ty");
        Assert.assertEquals(1, employees.size());

        //CleanUp
        try {
            employeeDao.deleteById(employee1.getId());
            employeeDao.deleteById(employee2.getId());
        } catch (Exception e) {
            //do nothing
        }
    }
}