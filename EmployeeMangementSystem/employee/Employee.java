package employee;

public class Employee {
    private int id;
    private String name;
    private String email;
    private String gender;
    private String department;

//    public Employee(int id, String name,  String email,String gender, String department) {
//       this.id = id;
//       this.name = name;
//        this.email=email;
//       this.gender = gender;
//       this.department = department;
//
 

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee Details:\n" +
                "ID: " + id + "\n" +
                "Name: " + name + "\n" +
                "Email: " + email + "\n" +
                "Gender: " + gender + "\n" +
                "Department: " + department;

    }
}