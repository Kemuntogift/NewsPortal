package models;

import java.util.Objects;

public class Department {
    private int id;
    private String name;
    private String description;
    private int totalEmployees;

    public Department(String name, String description, int totalEmployees) {
        this.name = name;
        this.description = description;
        this.totalEmployees = totalEmployees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id && totalEmployees == that.totalEmployees && name.equals(that.name) && description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, totalEmployees);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotalEmployees() {
        return totalEmployees;
    }
    public void increaseTotalEmployees(){
        this.totalEmployees += 1;

    }
    public void decreaseTotalEmployees(){
        this.totalEmployees -= 1;
    }
    public void setTotalEmployees(int totalEmployees) {
        this.totalEmployees = totalEmployees;
    }
}
