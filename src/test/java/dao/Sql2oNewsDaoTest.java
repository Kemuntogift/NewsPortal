package dao;

import models.Department;
import models.News;
import models.User;
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
        News news = setupNews();
        News news2 = secondNews();
        assertTrue(news.equals(newsDao.findById(news.getId())));
    }



    @Test
    void addNewsSetsId() {
        News news = setupNews();
        assertNotEquals(0,news.getId());
    }

//    HELPERS
private Department setupDepartment(){
    Department department = new Department("IT","Automating services", 5);
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
    private News setupNews(){
        News news = new News("Breaking news", "Offices closed over flu outbreak", "General", "Kemunto");
        news.setAuthor(setupUser().getName());
        newsDao.add(news);
        return news;
    }
    private News secondNews(){
        News news = new News("Sports","Offices closed over flu outbeak", "Department", "Danny");
        news.setType("entertainment");
        news.setAuthor(secondUser().getName());
        newsDao.add(news);
        return news;
    }
}