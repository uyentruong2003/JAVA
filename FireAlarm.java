public class FireAlarm extends Alarm {
    String fireType = "";
    int firefightersNo;

    //constructor
    public FireAlarm(String fireType){
        super("This is the "+ fireType + " alarm"); //inherit the constructor from the superclass
        this.fireType = fireType;
    }

    public FireAlarm(){
        this("input fire type");
    }

    void setFireType(String fireType) {
        this.fireType = fireType;
    }

    String getFireType () {
        return this.fireType;
    }

    int getFirefightersNo(){
        return this.firefightersNo;
    }

    private void determineNoFirefighters (){
        switch (this.fireType) {
            case "wildfire":
            firefightersNo = 100;
            break;
            case "arson":
            firefightersNo = 20;
            break;
            case "fire hazard":
            firefightersNo = 5;
            break;
            default:
            firefightersNo = 10;
            break;
        }
    }

    @Override //annotation to help debug if overriding method is misspelled
    void printAlarmMessage() { //overriding the superclass printAlarmMessage
        super.printAlarmMessage(); //call the printAlarmMessage from the superclass
        determineNoFirefighters();
        System.out.println(String.valueOf(firefightersNo) + " firefighters will be dispatched to the scene.");
    }
}
