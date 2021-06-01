package EmailPass;
import java.util.Scanner;
public class Working {
    private String firstname;
    private String lastname;
    private String CompanyName = "dundermifflin";
    private String department;
    private String password;
    private String alternateEmail;
    private int mailboxCapacity;
    private String email;

    //constructor to receive first and last name
    public Working(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        System.out.println("Email created: " + this.firstname + " " + this.lastname);
        department = deptName();


        Scanner obj1 = new Scanner(System.in);
        System.out.println("Enter the length of password you want to create: ");
        int num = obj1.nextInt();
        System.out.println("Enter the length of password you want to create: ");
        System.out.println(setPassword(num));

        email = firstname.toLowerCase() + "." + lastname.toLowerCase() + "@" + department.toLowerCase() + "." + CompanyName.toLowerCase() + ".com";

        System.out.println("The generated email is " + email);

        System.out.println("Enter the mailbox capacity: ");
        num = obj1.nextInt();
        System.out.println("Your mailbox capacity os set to " + MailboxCapacity(num));

        System.out.println("Do you want to change your password?\n Press 'Y' for Yes\n 'N' for No");
        int choice1 = obj1.next().charAt(0);
        int choice = Character.toUpperCase(choice1);

        if (choice == 'Y') {
            changePass();
        }
        else if(choice == 'N') {
                System.out.println();
        }

    }


    //method to ask company ad dept name
    String deptName() {
        System.out.println("Department codes: \n1 for sales  \n2 for accounting \n3 for development \nEnter your code: ");
        Scanner obj = new Scanner(System.in);
        int choice = obj.nextInt();
        String dep;
        switch (choice) {
            case 1:
                System.out.println("Your department is Sales");
                dep = "sales";
                break;
            case 2:
                System.out.println("Your department is Accounting");
                dep = "acc";
                break;
            case 3:
                System.out.println("Your department is Accounting");
                dep = "cust";
                break;
            default:
                dep = "";
        }
        return dep;
    }

    char[] setPassword(int length) {
        String set = "ABCDEFGIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%&1234567890";
        int len = set.length();
        char[] pass = new char[length];
        for (int i = 0; i < length; i++) {
            pass[i] += set.charAt((int) (Math.random() * len));
        }
        return pass;
    }

    public int MailboxCapacity(int capacity) {
        mailboxCapacity = capacity;
        return mailboxCapacity;
    }

    public String ChangePass(String password) {
        this.password = password;
        return this.password;
    }

    public String setAlternateEmail(String altemail) {
        email = altemail;
        return email;
    }

    public void changePass() {
            System.out.println("Enter your new password: ");
            Scanner obj2 = new Scanner(System.in);
            String newPassword = obj2.nextLine();
            String password = ChangePass(newPassword);
            System.out.println("New password set successfully!");
    }

    public String getInfo(){
        return "NAME: " + firstname + " " + lastname +
                "\nEMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}