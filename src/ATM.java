import static java.lang.System.out;

import java.util.Scanner;

public class ATM {
    private int hundredsQuantity;
    private int fyftysQuantity;
    private int twentysQuantity;

    public int getFyftysQuantity() {
        return fyftysQuantity;
    }
    
    public void setFyftysQuantity(int fyftysQuantity) {
        this.fyftysQuantity = fyftysQuantity;
    }

    public int getHundredsQuantity() {
        return hundredsQuantity;
    }

    public void setHundredsQuantity(int hundredsQuantity) {
        this.hundredsQuantity = hundredsQuantity;
    }

    public int getTwentysQuantity() {
        return twentysQuantity;
    }

    public void setTwentysQuantity(int twentysQuantity) {
        this.twentysQuantity = twentysQuantity;
    }

    public ATM(int hundreds,int fyftys,int twentys){
        try {
            if(hundreds < 0 || fyftys < 0 || twentys < 0) throw new Exception();
            this.fyftysQuantity = hundreds;
            this.twentysQuantity = twentys;
            this.hundredsQuantity = hundreds;
        } catch (Exception e) {
            out.println("Number of bills must be integer and bigger than 0!");
        }
    }

    public int avaibleMaximum(){
        return hundredsQuantity*100 + fyftysQuantity*50 + twentysQuantity*20;
    }

    public void bankAccountReplenshment(int addedTwentys, int addedFyftys, int addedHundreds){
        setFyftysQuantity(getFyftysQuantity() + addedFyftys);
        setHundredsQuantity(getHundredsQuantity() + addedHundreds);
        setTwentysQuantity(getTwentysQuantity() + addedTwentys);
    }

    public void outAvaibleMaximum(){
        out.println("In this ATM " + avaibleMaximum() + " tugricks");
    }

    public boolean getCash(Scanner scanner){
        try {
            out.println("Enter a summ of money: ");
            int summ = scanner.nextInt();

            if(summ <=0) throw new Exception(); 
            if(!checkIfEnoughMoney(summ)){
                out.println("You want too much money!");
                return checkIfEnoughMoney(summ);
            }else{
            
            }
        
        } catch (Exception e) {
            out.println("You have to withdraw money, not letters, not 0 and not negative numbers");
            return false;
        }
    }

    public boolean checkIfEnoughMoney(int money){
        return money >= avaibleMaximum() ? false : true;
    }

    public boolean checkIfSummSuatable(int money){
        Boolean thm = money % 10 == 0 ? true: false;
        if(thm)
        int virtualHundreds;
        int virtualFyftys;
        int vitualTwentys;

        

    }
}
