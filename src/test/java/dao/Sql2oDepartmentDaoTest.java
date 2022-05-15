package dao;

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
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        departmentDao = new Sql2oDepartmentDao(sql2o);
        userDao = new Sql2oUserDao(sql2o);
        conn = sql2o.open();
    }

    @AfterEach
    void tearDown() {
        conn.close();
    }

    @Test
    void add() {
    }

    @Test
    void findById() {
    }

    @Test
    void allDepartments() {
    }

    @Test
    void deleteDepartmentById() {
    }

    @Test
    void allDepartmentEmployees() {
    }

    @Test
    void allDepartmentNews() {
    }

    @Test
    void updateEmployeeNumber() {
    }

    @Test
    void addUserToDepartment() {
    }

    @Test
    void deleteEmployeeFromDepartment() {
    }

    @Test
    void deleteDeptNewsById() {
    }

    @Test
    void deleteAll() {
    }
}