package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    public void getNameReturnsCorrectName() throws Exception {
        User testUser = setupUser();
        assertEquals("Anna", testUser.getName());
    }
    @Test
    public void getRoleReturnsCorrectRole() throws Exception {
        User testUser = setupUser();
        assertEquals("Financial officer", testUser.getRole());
    }
    @Test
    public void getDepartmentReturnsCorrectDepartment() throws Exception {
        User testUser = setupUser();
        assertEquals("Finance", testUser.getDepartment());
    }
    private User setupUser() {
    }


}