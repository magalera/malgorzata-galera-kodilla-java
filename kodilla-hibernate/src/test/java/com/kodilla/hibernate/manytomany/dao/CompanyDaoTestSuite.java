package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        Assert.assertNotEquals(0, softwareMachineId);
        Assert.assertNotEquals(0, dataMaestersId);
        Assert.assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testRetrieveCompaniesWhereNameStartsWith() {
        //Given
        Company company1 = new Company("Google");
        Company company2 = new Company("Amazon");

        //When
        companyDao.save(company1);
        companyDao.save(company2);

        //Then
        List<Company> companies = companyDao.retrieveCompaniesWhereNameStartsWith("Goo");
        Assert.assertEquals(1, companies.size());

        //CleanUp
        try {
            companyDao.deleteById(company1.getId());
            companyDao.deleteById(company2.getId());
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testRetrieveEmployeesWithFirstName() {
        //Given
        Employee employee1 = new Employee("Adam", "Smith");
        Employee employee2 = new Employee("Mark", "Taylor");

        //When
        employeeDao.save(employee1);
        employeeDao.save(employee2);

        //Then
        List<Employee> employees = employeeDao.retrieveEmployeesWithFirstName("Adam");
        Assert.assertEquals(1, employees.size());

        //CleanUp
        try {
            employeeDao.deleteById(employee1.getId());
            employeeDao.deleteById(employee2.getId());
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testRetrieveWhereNameContains() {
        //Given
        Company company1 = new Company("VirtusLab");
        Company company2 = new Company("Britenet");

        //When
        companyDao.save(company1);
        companyDao.save(company2);

        //Then
        List<Company> companies = companyDao.retrieveNameWhereNameContains("%t%");
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
    public void testRetrieveWhereLastNameContains() {
        //Given
        Employee employee1 = new Employee("John", "Travolta");
        Employee employee2 = new Employee("Steven", "Tyler");

        //When
        employeeDao.save(employee1);
        employeeDao.save(employee2);

        //Then
        List<Employee> employees = employeeDao.retrieveWhereLastNameContains("%Ty%");
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