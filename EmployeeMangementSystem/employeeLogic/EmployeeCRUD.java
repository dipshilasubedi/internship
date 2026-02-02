package employeeLogic;

import employee.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeCRUD {

    private List<Employee> employees;
    private int id;

    public EmployeeCRUD(){
        employees=new ArrayList<>();  //each time constructor call huda list new banxa for each student creation
        id=1;

    }

    public Employee addEmployee(){

        Scanner scr=new Scanner(System.in);
        System.out.println("Enter your name");
        String name=scr.nextLine();

        System.out.println("Enter your email");
        String email=scr.nextLine();

        System.out.println("Enter your gender");
        String gender=scr.nextLine();

        System.out.println("Enter your department");
        String department=scr.nextLine();

        Employee employee=new Employee();
        employee.setId(id++);
        employee.setName(name);
        employee.setEmail(email);
        employee.setGender(gender);
        employee.setDepartment(department);
        employees.add(employee);
        return employee;

    }

    public List<Employee> getAllEmployees(){

        return employees;

    }

    public Employee getEmployeeById(){
        Scanner scr= new Scanner(System.in);
        System.out.println("Enter the id:");
        int id=scr.nextInt();

        Employee employee=findEmployeeById(id);//use to find the employe and to remove code redundancy we made a seperate function
        return employee;
    }



    public Employee updateEmployee(){

        Scanner scr=new Scanner(System.in);
        System.out.println("Enter the id of the user to be update");
        int id = scr.nextInt();
        scr.nextLine();

        System.out.println("Enter your name");
        String name=scr.nextLine();

        System.out.println("Enter your email");
        String email=scr.nextLine();

        System.out.println("Enter your gender");
        String gender=scr.nextLine();

        System.out.println("Enter your department");
        String department=scr.nextLine();

        Employee employee=findEmployeeById(id);
        employee.setName(name);
        employee.setEmail(email);
        employee.setGender(gender);
        employee.setDepartment(department);
        employees.add(employee);
        return employee;

    }

    public String deleteEmployee(){
        Scanner scr=new Scanner(System.in);
        System.out.println("Enter the id of the user to be delete");
        int id = scr.nextInt();

        Employee employee = findEmployeeById(id);
        employees.remove(employee);

        return "Employee deleted";
    }


    public Employee findEmployeeById(int id){
        for(Employee employee:employees){
            if(employee.getId()== id){
                return employee;
            }
        }
        return null;
    }

    public void run(){
        System.out.println("Welcome to Employee Management System");
        Scanner scr= new Scanner(System.in);
        System.out.println("1.Add Employee:");
        System.out.println("2.Update Employee:");
        System.out.println("3.Get Employee by id:");
        System.out.println("4.Get all Employee:");
        System.out.println("5.Delete Employee:");

        while(true){
            System.out.println("Enter you choice");
            int choice=scr.nextInt();
            switch(choice){
                case 1:
                    System.out.println(addEmployee());
                    break;
                case 2:
                    System.out.println(updateEmployee());
                    break;
                case 3:
                    System.out.println(getEmployeeById());
                    break;
                case 4:
                    System.out.println(getAllEmployees());
                    break;
                case 5:
                    System.out.println(deleteEmployee());
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }


}
