import static spark.Spark.*;
import static spark.Spark.get;
import static spark.Spark.post;
import com.google.gson.Gson;
import models.*;
import dao.Sql2oNewsDao;
import dao.Sql2oDepartmentDao;
import dao.Sql2oUserDao;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class App {

    public static void main(String[] args) {
        Sql2oDepartmentDao departmentDao;
        Sql2oNewsDao newsDao;
        Sql2oUserDao userDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:h2:~/news.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");

        departmentDao = new Sql2oDepartmentDao(sql2o);
        userDao = new Sql2oUserDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        conn = sql2o.open();


        //post request for new department
        post("/departments/new","application/json",(request, response) -> {
            Department department = gson.fromJson(request.body(),Department.class);
            departmentDao.add(department);
            response.status(201);
            return gson.toJson(department);
        });

        //get request for all departments
        get("/departments","application/json",(request, response) -> gson.toJson(departmentDao.allDepartments()));

        //get users in department
        get("/departments/:deptId/users/:userId/details","application/json",(request, response) -> {
            int userId = Integer.parseInt(request.params("userId"));
            User foundUser = userDao.findById(userId);

            if (foundUser != null) {
                return gson.toJson(foundUser);
            }
            else {
                return "{\"Error!\":\"User not found\"}";
            }
        });

        //get department details
        get("/departments/:deptId/details","application/json",(request, response) -> {
            int deptId = Integer.parseInt(request.params("deptId"));
            return gson.toJson(departmentDao.findById(deptId));
        });

        post("/departments/:deptId/users/new","application/json",(request, response) -> {
            int deptId = Integer.parseInt(request.params("deptId"));
            Department department = departmentDao.findById(deptId);

            if(department != null){
                User employee = gson.fromJson(request.body(),User.class);
                employee.setDepartment(department.getName());
                userDao.add(employee);
                departmentDao.addUserToDepartment(department,employee);
                response.status(201);
                return gson.toJson(employee);
            } else {
                throw new ApiException(404,"Department not found");
            }
        });
        //filter
        after((req, res) -> res.type("application/json"));

    }
}
