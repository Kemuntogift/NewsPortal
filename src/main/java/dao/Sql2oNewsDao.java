package dao;

import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oNewsDao implements NewsDao{
    private final Sql2o sql2o;
    public Sql2oNewsDao(Sql2o sql2o) { this.sql2o = sql2o; }
    @Override
    public void addNewsToDepartment(int deptid, int newsid, int userid) {
        String sql = "INSERT INTO departments_news (deptid,newsid,userid) VALUES (:deptid,:newsid,:userid)";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("deptid",deptid)
                    .addParameter("newsid",newsid)
                    .addParameter("userid",userid)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public News findById(int id) {
        String sql = "SELECT * from news WHERE id=:id;";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(News.class);
        }
    }

    @Override
    public List<News> allNews() {
        String sql = "SELECT * from news;";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(News.class);
        }
    }

    @Override
    public List<News> allGeneralNews() {
        String sql = "SELECT * from news where type='General';";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(News.class);
        }
    }

    @Override
    public List<News> allDepartmentalNews() {
        String sql = "SELECT * from news where type!='General';";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(News.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from news WHERE id=:id;";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println("Delete by id error: "+ex);
        }
    }

    @Override
    public void deleteAll() {
        String sql = "DELETE from news;";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
