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
    @Test
    public void setNameSetsCorrectName() throws Exception {
        Department testDepartment = setupDepartment();
        testDepartment.setName("Research");
        assertNotEquals("Finance",testDepartment.getName());
    }
    @Test
    public void setDescriptionSetsCorrectDescription() throws Exception {
        Department testDepartment = setupDepartment();
        testDepartment.setDescription("Finds stuff out");
        assertNotEquals("Handles money",testDepartment.getDescription());
    }
    @Test
    public void setEmployeesSetsCorrectEmployees() throws Exception {
        Department testDepartment = setupDepartment();
        testDepartment.setTotalEmployees(5);
        assertNotEquals(1,testDepartment.getTotalEmployees());
    }
    @Test
    public void setId() {
        Department testDepartment = setupDepartment();
        testDepartment.setId(5);
        assertEquals(5, testDepartment.getId());
    }
    private Department setupDepartment() {
        return new Department("Finance", "Handles money", 1);
    }
}