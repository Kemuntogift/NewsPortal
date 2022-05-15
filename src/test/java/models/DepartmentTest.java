package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    public void getNameReturnsCorrectName() throws Exception {
        Department testDepartment = setupDepartment();
        assertEquals("Finance", testDepartment.getName());
    }
    @Test
    public void getDescriptionReturnsCorrectDescription() throws Exception {
        Department testDepartment = setupDepartment();
        assertEquals("Handles money", testDepartment.getDescription());
    }
    @Test
    public void getEmployeesReturnsCorrectNumber() throws Exception {
        Department testDepartment = setupDepartment();
        assertEquals(1, testDepartment.getTotalEmployees());
    }

    private Department setupDepartment() {
    }
}