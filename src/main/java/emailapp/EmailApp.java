package emailapp;

import java.sql.SQLOutput;
import java.util.Scanner;

public class EmailApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter First name:");
        String fistName = scanner.next();

        System.out.println("Enter Last name:");
        String lastName = scanner.next();

        Email email = new Email(fistName, lastName);
        int choice = -1;
        do{
            System.out.println("\n**********\n Enter your choice\n1. Show info\n2. Change password\n3. Change mailbox capacity\n4.Set another mail\n5. Exit ");
            choice =scanner.nextInt();
            switch (choice){
                case 1: email.getInfo();
                        break;
                case 2: email.setPassword();
                        break;
                case 3: email.setMailCapacity();
                        break;
                case 4: email.alternateEmail();
                        break;
                case 5:
                    System.out.println("Thank you for using application!");
                    break;
                default:
                    System.out.println("Invalid choice!!\nEnter proper choice again:");

            }
        } while ( choice!=5);
    }

}
