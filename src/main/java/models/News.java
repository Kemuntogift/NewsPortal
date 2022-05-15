package models;

import java.util.Objects;

public class News {
    private int id;
    private String title;
    private String description;
    private String type;
    private String author;


    public News(String title, String description, String type, String author) {
        this.title = title;
        this.description = description;
        this.type = "General";
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return id == news.id && title.equals(news.title) && description.equals(news.description) && type.equals(news.type) && author.equals(news.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, type, author);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
