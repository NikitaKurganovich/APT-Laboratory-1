
import java.util.Scanner;

import usefull.AppRelated;

import static java.lang.System.out;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            out.println("==================================");
            out.println("Choose an option:");
            out.println("1. Time part");
            out.println("2. ATM part");
            out.println("0. Exit");
            out.println("==================================");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    AppRelated.timePart(scanner);
                    break;
                case 2:
                    AppRelated.ATMPart(scanner);
                    break;
                case 0:
                    scanner.close();
                    System.exit(0);;
                default:
                    out.println("Invalid option. Please choose a valid option.");
            }
        }


       
    }
}


