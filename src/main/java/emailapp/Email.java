package emailapp;


import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Email {
    public Scanner scanner = new Scanner(System.in);
    private String firstName;
    private String lastName;
    private String department;
    private String email;
    private String password;
    private int mailCapacity = 500;
    private String alter_email;

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("New Employee:" + this.firstName + " " + this.lastName);
        this.department = this.setDept();
        this.password = this.generatePassword(8);
        this.email = this.generateEmail();
    }

    //generate email
    private String generateEmail() {
        return this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department.toLowerCase() + ".com";
    }

    public String setDept() {
            System.out.println("Department codes \n1 for Sales \n2 for Development \n3 for Accounting \n0 for none");

        boolean flag = false;
        do {

            System.out.println("Enter Department code:");
            int choice = scanner.nextInt();
            if (choice == 1) {
                return "Sales";
            } else if (choice == 2) {
                return "Development";
            } else if (choice == 3) {
                return "Accounting";
            } else if (choice == 0) {
                return "None";
            } else {
                System.out.println("Invalid choice please choose it again");
            }

        } while(!flag);
            return null;
    }

        // generating password
    private String generatePassword(int length){
        Random random = new Random();
        String capitalChars ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smallChars ="abcdefghijklmnopqrstuvwxyz";
        String numders = "0123456789";
        String symbols="!@#$%&?";
        String values = capitalChars + smallChars + numders + symbols;
        String password ="";
        for (int i = 0; i<length;i++ ){
            password = password + values.charAt(random.nextInt(values.length()));
        }
        return password;
    }

    // change password
    public void setPassword(){
        boolean flag = false;
        do{
            System.out.println("Do you want change your password? (Y/N)");
            char choice = scanner.next().charAt(0);
            if (choice=='Y'|| choice == 'y'){
                flag=true;
                System.out.println("Enter current password:");
                String temp = scanner.next();
                if (temp.equals(this.password)){
                    System.out.println("Enter new password:");
                    this.password = scanner.next();
                    System.out.println("Password changed successfully");
                } else {
                    System.out.println("Incorrect password");
                }

            } else if(choice == 'N' || choice == 'n'){
                flag = true;
                System.out.println("Password changer option cancelled!");
            }
            else {
                System.out.println("Enter valid choice");
            }
        } while (!flag);
    }

    //set mailbox capacity
    public  void setMailCapacity(){
        System.out.println("Current capacity = "+ this.mailCapacity +"mb");
        System.out.println("Enter new mailbox capacity:");
        this.mailCapacity = scanner.nextInt();
        System.out.println("Mailbox capacity is successfully changed");
    }

    //set another mail
    public void alternateEmail(){
        System.out.println("Enter new alternative mail:");
        this.alter_email = scanner.next();
        System.out.println("Alternative email is set!");
    }

    public void getInfo(){
        System.out.println("New: " + this.firstName + " "+ this.lastName);
        System.out.println("Department: " + this.department);
        System.out.println("Email: " + this.email);
        System.out.println("Password: " + this.password);
        System.out.println("MailBox capacity: " + this.mailCapacity +" mb");
        System.out.println("Another email: " + this.alter_email);
    }


}
