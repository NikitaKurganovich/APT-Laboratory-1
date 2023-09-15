package usefull;

import java.util.Scanner;
import static java.lang.System.out;


public class AppRelated{
    static public int userNumberInput(Scanner scanner, String message){
        int receivedValue;
        while(true){
            try {
                out.println(message);
                receivedValue = scanner.nextInt();
                break;
            } catch (Exception e) {
                out.println("Incorrect input. Try again");
                scanner.nextLine();
            }
        }
        return receivedValue;
    }

    static public int userNumberInputWithoutMinus(Scanner scanner, String message){
        int receivedValue;
            while(true){
                try {
                    out.println(message);
                    receivedValue = scanner.nextInt();
                    if(receivedValue < 0) throw new Exception();
                    break;
                } catch (Exception e) {
                    out.println("Incorrect input. Try again");
                    scanner.nextLine();
                }
            }
            return receivedValue;
    }
    
    static public void ATMPart(Scanner scanner){
        out.println("Enter the initial quantity of bills");
        int twenties = AppRelated.userNumberInputWithoutMinus(scanner, "Entre a twenties quantity:");
        int fifties = AppRelated.userNumberInputWithoutMinus(scanner, "Entre a fifties quantity:");
        int hundreds = AppRelated.userNumberInputWithoutMinus(scanner, "Entre a hundreds quantity:");
        
        ATM atm = new ATM(twenties, fifties, hundreds);

        while (true) {
            out.println("==================================");
            out.println("Choose an option:");
            out.println("1. Add Money");
            out.println("2. Withdraw Money");
            out.println("3. See avaible cash amount");
            out.println("0. Return");
            out.println("==================================");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    out.println("Enter the quantity of bills to add (twenties, fifties, hundreds):");
                    int addTwenties = AppRelated.userNumberInputWithoutMinus(scanner, "Entre a twenties quantity:");
                    int addFifties = AppRelated.userNumberInputWithoutMinus(scanner, "Entre a fifties quantity:");
                    int addHundreds = AppRelated.userNumberInputWithoutMinus(scanner, "Entre a hundreds quantity:");
                    atm.addMoney(addTwenties, addFifties, addHundreds);
                    break;
                case 2:
                    out.println("Enter the amount to withdraw:");
                    int withdrawAmount = AppRelated.userNumberInputWithoutMinus(scanner, "Entre a how much money do you want to withdraw:");
                    Boolean result = atm.withdrawMoney(withdrawAmount);
                    out.println("Is operation successful: " + result);
                    break;
                case 3:
                    atm.printAvaibleCash();
                    break;
                case 0:
                    return;
                default:
                    out.println("Invalid option. Please choose a valid option.");
            }
        }
    }

    static public void timePart(Scanner scanner){
        out.println("Entre a two periods of time");
        int secondsForFirst = AppRelated.userNumberInputWithoutMinus(scanner, "Entre only seconds for first period:");

        int secondsForSecond = AppRelated.userNumberInputWithoutMinus(scanner, "Entre seconds for second period:");
        int minutesForSecond = AppRelated.userNumberInputWithoutMinus(scanner, "Entre minutes for second period:");      
        int hoursForSecond = AppRelated.userNumberInputWithoutMinus(scanner, "Entre hours for second period:");   

        MyTime firstPeriod = new MyTime(secondsForFirst);
        MyTime secondPeriod = new MyTime(secondsForSecond, minutesForSecond, hoursForSecond);

        while (true) {
            out.println("==================================");
            out.println("Choose an option:");
            out.println("1. Compare periods");
            out.println("2. Show both periods in second");
            out.println("3. Show both periods in full time");
            out.println("0. Return");
            out.println("==================================");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    firstPeriod.outCompareResult(secondPeriod);
                    break;
                case 2:
                    out.println("First period:");
                    firstPeriod.outSeconds();
                    out.println("Second period:");
                    secondPeriod.outSeconds();
                    break;
                case 3:
                    out.println("First period:");
                    firstPeriod.outFullTime();
                    out.println("Second period:");
                    secondPeriod.outFullTime();
                    break;
                case 0:
                    return;
                default:
                    out.println("Invalid option. Please choose a valid option.");
            }
        }
    
    } 

}



