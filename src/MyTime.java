import static java.lang.System.out;

public class MyTime{
    
    private int seconds;
    private int minutes;
    private int hours;

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public MyTime(int _seconds){
        try {
            if(_seconds < 0) throw new Exception();
            this.seconds = _seconds;
        } catch (Exception e) {
            out.println("Error! Senconds aren't an int type or less than 0!");
        }
        
    }

    public MyTime(int _seconds, int _minutes, int _hours){
        this(_seconds);
        try {
            if(_minutes < 0) throw new Exception();
            if(_hours < 0) throw new Exception();
            this.minutes = _minutes;
            this.hours = _hours;
        } catch (Exception e) {
            out.println("Error! Minutes or hours aren't an int type or less than 0!");
        }
      
    }

    public void outSeconds(){
        out.println("There is " + getSeconds() + " seconds");
    }

    public void outFullTime(){
        MyTime tempObject = bringToFullTime();
        out.println("There is "+ tempObject.hours + " hours," +
        tempObject.minutes + " minutes, " + tempObject.seconds + " seconds");
    }

    public int bringToSecondsOnly(){
        int tempSeconds = seconds;
        if(hours > 0){
            tempSeconds += hours*3600;
        }
        if(minutes > 0){
            tempSeconds += minutes*60;
        }
        return tempSeconds;
    }

    public MyTime bringToFullTime(){
        int tempSeconds = seconds;
        int tempMinutes = minutes;
        int tempHours = hours;

        if(seconds >= 60){
            tempMinutes += seconds/60;
            tempSeconds -= seconds/60;
        }
        if(minutes >= 60){
            tempHours += minutes/60;
            tempMinutes -= minutes/60;
        }
        return new MyTime(tempSeconds,tempMinutes,tempHours);
    }


    public int toCompare(MyTime timeObject){
     return 0;
   
    }
}