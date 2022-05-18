import static spark.Spark.*;

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

        post("/departments/new","application/json",(request, response) -> {
            Department department = gson.fromJson(request.body(),Department.class);
            departmentDao.add(department);
            response.status(201);
            return gson.toJson(department);
        });



    }
}
