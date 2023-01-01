package POJODEMO;//import java.util.*;

public class PojoMapper {
    public PojoMapper() {

    }

    public PojoMapper(String firstName, String lastName, String deptName, double salary, String location) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.deptName = deptName;
        this.salary = salary;
        this.location = location;
    }

    private String firstName;
    private String lastName;
    private String deptName;
    private double salary;
    private String location;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    /*@Override
    public String toString() {
        return "PojoMapper{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", deptName='" + deptName + '\'' +
                ", salary=" + salary +
                ", location='" + location + '\'' +
                '}';
    }*/
}
