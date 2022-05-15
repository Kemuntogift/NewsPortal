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
    @Test
    public void setNameSetsCorrectName() throws Exception {
        User testUser = setupUser();
        testUser.setName("Thando");
        assertNotEquals("Anna",testUser.getName());
    }
    @Test
    public void setRoleReturnsCorrectRole() throws Exception {
        User testUser = setupUser();
        testUser.setRole("Security");
        assertNotEquals("Financial officer", testUser.getRole());
    }
    @Test
    public void setDepartmentReturnsCorrectDepartment() throws Exception {
        User testUser = setupUser();
        testUser.setDepartment("Welfare");
        assertNotEquals("Finance", testUser.getDepartment());
    }
    private User setupUser() {
        return new User ("Anna", "Financial officer", "Finance");
    }


}