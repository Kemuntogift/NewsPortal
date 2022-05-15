package dao;

import models.Department;
import models.News;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oDepartmentDao implements DepartmentDao{
    private final Sql2o sql2o;
    public Sql2oDepartmentDao(Sql2o sql2o) { this.sql2o = sql2o; }

    @Override
    public void add(Department department) {
        String sql = "INSERT INTO departments (name,description,totalemployees) VALUES (:name,:description,:totalemployees)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql,true)
                    .bind(department)
                    .addParameter("totalemployees",department.getTotalEmployees())
                    .executeUpdate()
                    .getKey();
            department.setId(id);
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void addUserToDepartment(Department department, User user) {
        String sql = "INSERT INTO departments_users(deptid,userid) values (:deptid,:userid);";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("deptid",department.getId())
                    .addParameter("userid",user.getId())
                    .executeUpdate();
            user.setDepartment(department.getName());
            department.increaseTotalEmployees();
            updateEmployeeNumber(department);
        } catch (Sql2oException ex){
            System.out.println("Failed attempt to insert user into department ");
        }
    }

    @Override
    public Department findById(int id) {
        return null;
    }

    @Override
    public List<Department> allDepartments() {
        return null;
    }

    @Override
    public List<User> allDepartmentEmployees(int deptId) {
        return null;
    }

    @Override
    public List<News> allDepartmentNews(int deptId) {
        return null;
    }

    @Override
    public void updateEmployeeNumber(Department department) {

    }

    @Override
    public void deleteDepartmentById(int id) {

    }

    @Override
    public void deleteEmployeeFromDepartment(Department department, User user) {

    }

    @Override
    public void deleteDeptNewsById(int deptId, int newsId) {

    }

    @Override
    public void deleteAll() {

    }
}
