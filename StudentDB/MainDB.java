package StudentDB;
import java.util.Scanner;
public class MainDB {
    public static void main(String args[]) {
        System.out.println("How many students do you want to enroll? ");
        Scanner obj = new Scanner(System.in);
        int num = obj.nextInt();
        Student[] students = new Student[num];

        for (int i = 0; i < num; i++) {
            students[i] = new Student();
        }
    }
}
