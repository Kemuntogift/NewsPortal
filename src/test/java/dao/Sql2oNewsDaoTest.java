package dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;

class Sql2oNewsDaoTest {
    private Connection conn;
    private Sql2oDepartmentDao departmentDao;
    private static Sql2oNewsDao newsDao;
    private static Sql2oUserDao userDao;
    @BeforeEach
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        departmentDao = new Sql2oDepartmentDao(sql2o);
        userDao = new Sql2oUserDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        conn = sql2o.open();
    }

    @AfterEach
    public void tearDown() {
        conn.close();
    }

    @Test
    void addNewsToDepartment() {
    }

    @Test
    void findById() {
    }

    @Test
    void allNews() {
    }

    @Test
    void allGeneralNews() {
    }

    @Test
    void allDepartmentalNews() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void deleteAll() {
    }

    @Test
    void add() {
    }
}