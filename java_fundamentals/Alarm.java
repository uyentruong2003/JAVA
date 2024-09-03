public class Alarm {
    boolean active;
    final protected String message; //protected: access modifier that allows subclasses to see the variable

    //constructor:
    Alarm() {
        // this.message = "This is an alarm message";
        this("This is an alarm message"); //call the constructor w/ message arg passed in
    }

    //constructor:
    Alarm (String message) {
        this.message = message;
    }

    //methods:
    void turnOnAlarm() {
        this.active = true;
    }

    void turnOffAlarm() {
        this.active = false;
    }

    void printAlarmMessage(){
        System.out.println(this.message);
    }

}
