package usefull;
import static java.lang.System.out;

public class ATM {
    private int twenties;
    private int fifties;
    private int hundreds;

    public ATM(int twenties, int fifties, int hundreds) {
        this.twenties = twenties;
        this.fifties = fifties;
        this.hundreds = hundreds;
    }

    public void addMoney(int twenties, int fifties, int hundreds) {
        this.twenties += twenties;
        this.fifties += fifties;
        this.hundreds += hundreds;
    }

    public boolean withdrawMoney(int amount) {
        int totalAmount = (this.twenties * 20) + (this.fifties * 50) + (this.hundreds * 100);
        if (amount <= totalAmount) {
            int remainingAmount = amount;
            int twentiesToGive = 0;
            int fiftiesToGive = 0;
            int hundredsToGive = 0;
    
            while (remainingAmount > 0) {
                if(remainingAmount == 110 && this.twenties >= 3 + twentiesToGive && this.fifties > fiftiesToGive){
                    twentiesToGive += 3;
                    fiftiesToGive ++;
                    remainingAmount -= 110;
                }
                if(remainingAmount == 130 && this.twenties >= 4 + twentiesToGive && this.fifties > fiftiesToGive){
                    twentiesToGive += 4;
                    fiftiesToGive ++;
                    remainingAmount -= 130;
                }
                if (remainingAmount >= 100 && this.hundreds > hundredsToGive) {
                    hundredsToGive++;
                    remainingAmount -= 100;
                } else if (remainingAmount >= 50 && this.fifties > fiftiesToGive) {
                    fiftiesToGive++;
                    remainingAmount -= 50;
                } else if (remainingAmount >= 20 && this.twenties > twentiesToGive) {
                    twentiesToGive++;
                    remainingAmount -= 20;
                } else {
                    // Not enough bills to complete the withdrawal
                    break;
                }
            }
            if (remainingAmount == 0) {
                out.println("Withdrawn: ");
                out.println("Twenties: " + twentiesToGive);
                out.println("Fifties: " + fiftiesToGive);
                out.println("Hundreds: " + hundredsToGive);
                commitATMAccountChange(twentiesToGive, fiftiesToGive, hundredsToGive);
                return true;
            } else {
                remainingAmount = amount;
                twentiesToGive = 0;
                fiftiesToGive = 0;
                hundredsToGive = 0;
                
                while (remainingAmount > 0) {
                    if(remainingAmount == 110 && this.twenties >= 3 + twentiesToGive && this.fifties > fiftiesToGive){
                        twentiesToGive += 3;
                        fiftiesToGive ++;
                        remainingAmount -= 110;
                    }
                    if(remainingAmount == 130 && this.twenties >= 4 + twentiesToGive && this.fifties > fiftiesToGive){
                        twentiesToGive += 4;
                        fiftiesToGive ++;
                        remainingAmount -= 130;
                    }
                    if (remainingAmount >= 20 && this.twenties > twentiesToGive) {
                        twentiesToGive++;
                        remainingAmount -= 20;
                    } else if (remainingAmount >= 50 && this.fifties > fiftiesToGive) {
                        fiftiesToGive++;
                        remainingAmount -= 50;
                    } else if (remainingAmount >= 100 && this.hundreds > hundredsToGive) {
                        hundredsToGive++;
                        remainingAmount -= 100;
                    } else {
                        // Not enough bills to complete the withdrawal
                        break;
                    }
                }
                if (remainingAmount == 0) {
                    out.println("Withdrawn: ");
                    out.println("Twenties: " + twentiesToGive);
                    out.println("Fifties: " + fiftiesToGive);
                    out.println("Hundreds: " + hundredsToGive);
                    commitATMAccountChange(twentiesToGive, fiftiesToGive, hundredsToGive);
                    return true;
                }
            }
        }
        return false;
    }

    private void commitATMAccountChange(int twentiesToRemove, int fiftiesToRemove, int hundredsToRemove){
        this.twenties -= twentiesToRemove;
        this.fifties -= fiftiesToRemove;
        this.hundreds -= hundredsToRemove;
    }

    public void printAvaibleCash(){
        int fullSum = this.twenties*20 + this.fifties*50 + this.hundreds*100;
        out.println("Available sum at ATM: " + fullSum);
        out.println("This sum includes: ");
        out.println("Twenties: " + twenties);
        out.println("Fifties: " + fifties);
        out.println("Hundreds: " + hundreds);
    }
}
