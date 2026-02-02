package studentmanagementsystem;

import studentLogic.StudentCRUD;

public class StudentManagementSystem {
    public static void main(String[] args){
        StudentCRUD studentCrud= new StudentCRUD();
        studentCrud.run();
    }
}
