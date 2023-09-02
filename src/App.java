import java.util.Scanner;
import static java.lang.System.out;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        MyTime obj1 = new MyTime(40);

        MyTime obj2 = new MyTime(4, 6, 7);

        MyTime obj3 = new MyTime(40,0,0);

        MyTime objBroken1 = new MyTime(-6);

        MyTime objBroken2 = new MyTime(0, 6, -10);

        obj1.outFullTime();
        obj1.outSeconds();

        obj2.outFullTime();
        obj2.outSeconds();

        obj3.outFullTime();
        obj3.outSeconds();

        obj1.toCompare(obj2);
        obj1.toCompare(obj3);

        ATM brokenATM = new ATM(-60, -0, 05);

        ATM normalAtm = new ATM(10, 10, 10);

        normalAtm.outAvaibleMaximum();
        normalAtm.bankAccountReplenshment(20, 20,20);
        normalAtm.outAvaibleMaximum();

        out.println(normalAtm.getCash(scanner));
        scanner.nextLine();
        out.println(normalAtm.getCash(scanner));
        scanner.nextLine();
        out.println(normalAtm.getCash(scanner));
        scanner.nextLine();
        scanner.close();
    }
}
