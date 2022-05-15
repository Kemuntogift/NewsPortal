package dao;

import models.Department;
import models.News;
import models.User;

import java.util.List;

public interface DepartmentDao {
    //create
    void add(Department department);
    void addUserToDepartment(Department department,User user);

    //read
    Department findById(int id);
    List<Department> allDepartments();
    List<User> allDepartmentEmployees(int deptId);
    List<News> allDepartmentNews(int deptId);

    //update
    void updateEmployeeNumber(Department department);

    //delete
    void deleteDepartmentById(int id);
    void deleteEmployeeFromDepartment(Department department, User user);
    void deleteDeptNewsById(int deptId, int newsId);
    void deleteAll();
}
