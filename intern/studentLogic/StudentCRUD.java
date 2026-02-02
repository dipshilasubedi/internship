package studentLogic;

import student.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentCRUD {
    private List<Student> students;
    private int id;
    public StudentCRUD(){
        students=new ArrayList<>();
        id=1;

    }

    public Student addStudent(){

        Scanner scr=new Scanner(System.in);
        System.out.println("Enter your name");
        String name=scr.nextLine();

        System.out.println("Enter your age");
        int age=scr.nextInt();
        scr.nextLine();

        System.out.println("Enter your email");
        String email=scr.nextLine();

        System.out.println("Enter your gender");
        String gender=scr.nextLine();

        System.out.println("Enter your course");
        String course=scr.nextLine();

        Student student=new Student();
        student.setId(id++);
        student.setName(name);
        student.setAge(age);
        student.setEmail(email);
        student.setGender(gender);
        student.setCourse(course);
        students.add(student);
        return student;

    }

    public List<Student> getAllStudents(){
        return students;
    }

    public Student getStudentById(){
        Scanner scr= new Scanner(System.in);
    System.out.println("Enter the id:");
    int id=scr.nextInt();
    Student student=findStudentById(id);
    return student;
    }

    public Student findStudentById(int id){
       for(Student student:students){
           if(student.getId()== id){
               return student;
           }
       }
       return null;
    }

    public Student updateEmployee(){

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

        System.out.println("Enter your age");
        String age=scr.nextLine();

        Student employee=findStudentById();
        employee.setName(name);
        employee.setEmail(email);
        employee.setGender(gender);
        employee.setAge (age);
        students.add(student);
        return student;

    }

    public String deleteEmployee(){
        Scanner scr=new Scanner(System.in);
        System.out.println("Enter the id of the user to be delete");
        int id = scr.nextInt();

        Student employee = findStudentById(id);
        students.remove(employee);

        return "Employee deleted";
    }

    public void run(){
        System.out.println("Welcome to Student Management System");
        Scanner scr= new Scanner(System.in);

        System.out.println("1.Add student:");
        System.out.println("2.Get student by id:");
        System.out.println("3.Get all student:");

        while(true){
           System.out.println("Enter you choice");
            int choice=scr.nextInt();
            switch(choice){
                case 1:
                    System.out.println(addStudent());
                    break;
                case 2:
                    System.out.println(getStudentById());
                    break;
                case 3:
                    System.out.println(getAllStudents());
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

}
