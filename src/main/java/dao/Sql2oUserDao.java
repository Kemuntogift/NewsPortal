package dao;

import models.News;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;

public class Sql2oUserDao implements UserDao{
    private final Sql2o sql2o;
    public Sql2oUserDao(Sql2o sql2o) { this.sql2o = sql2o; }

    @Override
    public void add(User user) {
        String sql = "INSERT INTO users (name,role,department) VALUES (:name,:role,:department);";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql,true)
                    .bind(user)
                    .executeUpdate()
                    .getKey();
            user.setId(id);
        } catch (Sql2oException ex){
            System.out.println("User not added");
        }
    }

    @Override
    public User findById(int id) {
        String sql = "SELECT * from users WHERE id=:id;";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(User.class);
        }
    }

    @Override
    public List<User> allUsers() {
        String sql = "SELECT * from users;";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(User.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from users where id = :id;";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();
        }
    }

    @Override
    public void deleteAll() {
        String sql = "DELETE from users;";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        }
    }

    @Override
    public List<News> myNews(int userId){
        List<   News> newsList = new ArrayList<>();
        String jointSql = "SELECT newsid from departments_news WHERE userid = :userid;";
        try (Connection con = sql2o.open()) {
            List<Integer> allIds = con.createQuery(jointSql)
                    .addParameter("userid",userId)
                    .executeAndFetch(Integer.class);

            String getSql = "SELECT * FROM news WHERE id = :id;";
            for(int id:allIds){
                newsList.add(
                        con.createQuery(getSql)
                                .addParameter("id",id)
                                .executeAndFetchFirst(News.class)
                );
            }
        }

        return newsList;
    }

}
