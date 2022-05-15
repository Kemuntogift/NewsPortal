package models;

import java.util.Objects;

public class User {
    private int id;
    private String name;
    private String role;
    private int departmentId;

    public User(String name, String role, String department, int departmentId) {
        this.name = name;
        this.role = role;
        this.department = department;
        this.departmentId = departmentId;
    }

    public User(int id, String name, String role, String department, int departmentId) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.department = department;
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && departmentId == user.departmentId && name.equals(user.name) && role.equals(user.role) && department.equals(user.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, role, departmentId, department);
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    private String department;


}
