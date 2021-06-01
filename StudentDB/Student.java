package StudentDB;

import java.util.Scanner;

public class Student {
    String firstName;
    String lastName;
    String collegeYear;
    String studentID;
    String courses = "";
    int year;
    int tuitionFee=0;
    int costOfCourse = 600;
    static int id = 1000;

    Scanner obj = new Scanner(System.in);

    public Student() {
        System.out.println("First Name: ");
        firstName = obj.nextLine();

        System.out.println("Last Name: ");
        lastName = obj.nextLine();
        System.out.println();

        getYear();
        System.out.println();
        getStudentID();
        enroll();
        System.out.println();
        payment();
        System.out.println();
        System.out.println();
        Info();
        System.out.println();
    }

    void getYear() {
        System.out.print("Year Selection. \nPress \n1 for 1st Year \n2 for 2nd Year\n3 for 3rd Year\nEnter your choice ");
        int choice = obj.nextInt();
        switch (choice) {
            case 1:
                collegeYear = "1st Year";
                year = 1;
                break;
            case 2:
                collegeYear = "2nd Year";
                year = 2;
                break;
            case 3:
                collegeYear = "3rd Year";
                year = 3;
                break;
        }
    }

    public void getStudentID(){
        id++;
        studentID = year + "" + id;
    }

    public void enroll(){
        while(true){
            System.out.print("Enter your course (press 0 to exit) ");
            Scanner obj1 = new Scanner (System.in);
            String course = obj1.nextLine();
            if (!course.equals("Q")){
                courses += "\n " + course;
                tuitionFee+= costOfCourse;
            }
            else{
                break;
            }
        }
        System.out.println("Total fees is :" +  tuitionFee + " rs");
    }

    public void viewBalance(){
        System.out.println("The total fees is left to pay is " + tuitionFee);
    }

    public void payment(){
        System.out.print("Enter the payment amount (in rupees) ");
        int payment = obj.nextInt();
        tuitionFee-=payment;
        System.out.println("Thank you or your payment of " + payment + "rs");
        viewBalance();
    }

    public void Info(){
        System.out.println( "Name: " + firstName + " " + lastName +
                "\nCollege Year: " + collegeYear +
                "\nStudent ID :" + studentID +
                "\nCourses enrolled:"  +  courses +
                "\nBalance: " + tuitionFee + "rs");

    }
}
