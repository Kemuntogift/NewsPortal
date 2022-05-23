package dao;

import models.Department;
import models.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;

class Sql2oDepartmentDaoTest {
    private Connection conn;
    private Sql2oDepartmentDao departmentDao;
    private static Sql2oUserDao userDao;

    @BeforeEach
    public void setUp() throws Exception {
//        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/news_portal_test", "gift", "KEMUNTO543210");
        departmentDao = new Sql2oDepartmentDao(sql2o);
        userDao = new Sql2oUserDao(sql2o);
        conn = sql2o.open();
    }



    @Test
    public void addDepartmentSetsId() {
        Department testDepartment = setupDepartment();
        assertEquals(1, testDepartment.getId());
    }


    @Test
    public void getDepartmentUsingId(){
        Department department = setupDepartment();
        Department department2 = secondDepartment();
        assertTrue(departmentDao.allDepartments().contains(department));
        assertTrue(departmentDao.allDepartments().contains(department2));
    }

    @Test
    public void deleteDepartmentById() {
        Department department = setupDepartment();
        Department department2= secondDepartment();
        assertEquals(2,departmentDao.allDepartments().size());
        departmentDao.deleteDepartmentById(department.getId());
        assertEquals(0,departmentDao.allDepartments().size());
    }



    @Test
    public void addUserToDepartment() {
        Department department = setupDepartment();
        User user = setupUser();
        departmentDao.addUserToDepartment(department,user);
        assertEquals("IT",user.getDepartment());
    }

    @Test
    public void deleteEmployeeFromDepartment() {
        Department department = setupDepartment();
        User user = setupUser();
        User user2 = secondUser();
        departmentDao.addUserToDepartment(department,user);
        departmentDao.addUserToDepartment(department,user2);

        departmentDao.deleteEmployeeFromDepartment(department,user);
        assertEquals(6,department.getTotalEmployees());
        assertEquals("None",user.getDepartment());
    }


    @Test
    public void deleteAll() {
        Department department = setupDepartment();
        Department department2= secondDepartment();
        departmentDao.deleteAll();
        assertEquals(0,departmentDao.allDepartments().size());
    }
    @AfterEach
    public void tearDown() {
        departmentDao.deleteAll();
        userDao.deleteAll();
    }
    @AfterAll
    public void afterAll() {
        conn.close();
    }
//    HELPERS
private Department setupDepartment(){
    Department department = new Department("IT","Automating services", 5);
    departmentDao.add(department);
    return department;
}

    private Department secondDepartment(){
        Department department = new Department("Welfare","Providing support to all", 6);
        departmentDao.add(department);
        return department;
    }

    private User setupUser(){
        User user = new User("Diane","Cook","Catering");
        userDao.add(user);
        return user;
    }

    private User secondUser(){
        User user = new User("Karen","Developer","IT");
        userDao.add(user);
        return user;
    }
}