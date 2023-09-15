package usefull;
import static java.lang.System.out;

public class MyTime{
    
    private int seconds;
    private int minutes;
    private int hours;

    public int getSeconds() {
        return seconds + minutes*60 + hours*3600;
    }

    public MyTime(int seconds){
        int tempSeconds = seconds;
        int tempMinutes = 0;
        int tempHours = 0;

        if(tempSeconds >= 60){
            tempMinutes += seconds/60;
            tempSeconds = seconds%60;
        }
        if(tempMinutes >= 60){
            tempHours += tempMinutes/60;
            tempMinutes = tempMinutes%60;
        }
        this.minutes = tempMinutes;
        this.hours = tempHours;
        this.seconds = tempSeconds;
        
    }

    public MyTime(int seconds, int minutes, int hours){
        int tempSeconds = seconds;
        int tempMinutes = minutes;
        int tempHours = hours;
     
        if(tempSeconds >= 60){
            tempMinutes += tempSeconds/60;
            tempSeconds = tempSeconds%60;
        }
        if(tempMinutes >= 60){
            tempHours += tempMinutes/60;
            tempMinutes = tempMinutes%60;
        }
        this.seconds = tempSeconds;
        this.minutes = tempMinutes;
        this.hours = tempHours;
    }

    public void outSeconds(){
        out.println("There is " + getSeconds() + " seconds");
    }

    public void outFullTime(){
        out.println("There is "+ hours + " hours," +
        minutes + " minutes, " + seconds + " seconds");
    }

    public int compareTo(MyTime otherTime) {
        int thisTotalSeconds = this.getSeconds();
        int otherTotalSeconds = otherTime.getSeconds();

        if (thisTotalSeconds < otherTotalSeconds) {
            return -1;
        } else if (thisTotalSeconds > otherTotalSeconds) {
            return 1;
        } else {
            return 0;
        }
    }

    public void outCompareResult(MyTime timeObj){
        int result = compareTo(timeObj);
        if(result > 0){
            out.println("First time period is longer! "+ getSeconds() + " vs " + timeObj.getSeconds());
        } else if(result < 0){
            out.println("First time period is shorter! "+ getSeconds() + " vs " + timeObj.getSeconds());
        }else{
            out.println("Both are equal to " + getSeconds() + " seconds");
        }
    }



}