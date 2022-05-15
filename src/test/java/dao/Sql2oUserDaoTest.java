package dao;

import models.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Sql2oUserDaoTest {
    private static Sql2oUserDao userDao = new Sql2oUserDao();
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void add() {
    }

    @Test
    void findById() {
    }

    @Test
    void allUsers() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void deleteAll() {
    }

    @Test
    void myNews() {
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