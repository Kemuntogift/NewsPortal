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

class Sql2oUserDaoTest {
    private Connection conn;
    private static Sql2oUserDao userDao;
    @BeforeEach
    public void setUp() {
//        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/news_portal_test", "gift", "KEMUNTO543210");
        userDao = new Sql2oUserDao(sql2o);
        conn = sql2o.open();
    }



    @Test
    void addUserSEtsId() {
        User testUser = setupUser();
        assertEquals(1, testUser.getId());
    }

    @Test
    void findById() {
        User user = setupUser();
        User user2 = secondUser();
        User foundUser = userDao.findById(user.getId());
        assertTrue(user.equals(foundUser));
    }

    @Test
    void allUsers() {
        User user = setupUser();
        User user2 = secondUser();
        assertTrue(userDao.allUsers().contains(user));
        assertTrue(userDao.allUsers().contains(user2));
    }

    @Test
    void deleteById() {
        User user = setupUser();
        User user2 = secondUser();
        userDao.deleteById(user.getId());
        assertEquals(1, userDao.allUsers().size());
    }

    @Test
    void deleteAll() {
        User user = setupUser();
        User user2 = secondUser();
        userDao.deleteAll();
        assertEquals(0, userDao.allUsers().size());
    }
    @AfterEach
    public void tearDown() {
        userDao.deleteAll();

    }
    @AfterAll
    public void afterAll() {
        conn.close();
    }
//    HELPERS
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