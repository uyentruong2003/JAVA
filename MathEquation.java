import java.util.Random;
public class MathEquation {
    //fields:
    int id;
    double leftVal = 1; //field initializer- an alt way to set the initial state of the fields beside constructor
    double rightVal;
    MathOperation opCode;
    double result; //instance field: field of an instance of the class
    private static int numberOfEquations; //static fields: fields for the entire class
    private static double sumOfResults;

    //initialization block; run everytime a new object is created.
        // static initialization- used for codes executed on a static field: static {}
    {
        Random rand = new Random();
        this.id = rand.nextInt(50);
        
    }
    //constructors: there can be multiple constructors as long as the parameters are different
    // this is an example of METHOD OVERLOADING. Method overloading requires each method to have a SIGNATURE 
    // (different in # of parameters, parameter type, and names)
    public MathEquation() {} //no parameter; default constructor

    public MathEquation(MathOperation opCode){ //parameter char type opCode
        this();
        this.opCode = opCode;
    }
    public MathEquation(double leftVal, double rightVal, MathOperation opCode) { //parameter has arguments passed in
        // chaining constructor: only 1 nested constructor per; the chained constructor must come before the field's value assignment 
        this(rightVal != 0 && opCode == MathOperation.DIVIDE ? rightVal : 1); // chained constructor that takes rightVal based on the condition
        this.leftVal = leftVal;
        this.opCode = opCode;
    }

    private MathEquation(double rightVal){
        this.rightVal = rightVal;
    }

    

    //methods:
    //setters:
    void setLeftVal(double leftVal){
        this.leftVal = leftVal;
    }
    void setRightVal(double rightVal){
        this.rightVal = rightVal;
    }
    void setOpCode(MathOperation opCode){
        this.opCode = opCode;
    }
    //getter:
    double getResult(){
        return this.result;
    }
    void execute() {
        switch(opCode){
            case ADD:
                result = leftVal + rightVal;
                break;
            case SUBTRACT:
                result = leftVal - rightVal;
                break;
            case MULTIPLY:
                result = leftVal * rightVal;
                break;
            case DIVIDE:
                result = rightVal != 0 ? leftVal/rightVal : 0.0d;
                break;
            default:
                result = 0.0d;
                break;
        }
        this.sumOfResults += result;
        this.numberOfEquations++;
    }

    void execute (double leftVal, double rightVal) {
        this.leftVal = leftVal;
        this.rightVal = rightVal;
        execute();
    }

    public static double getAverageResult() { //static method- method used for the entire class
        return sumOfResults/numberOfEquations;
    }

    public String toString(){
        char opSymbol = letterToSymbol(opCode);
        StringBuilder builder = new StringBuilder(30);
        builder.append(leftVal);
        builder.append(" ");
        builder.append(opSymbol);
        builder.append(" ");
        builder.append(rightVal);
        builder.append(" = ");
        builder.append(result);
        String output = builder.toString();
        return output;
    }

    private char letterToSymbol (MathOperation opCode) {
        // char symbol = ' ';
        // switch (opCode){
        //     case ADD:
        //     symbol = '+';
        //     break;
        //     case SUBTRACT:
        //     symbol = '-';
        //     break;
        //     case MULTIPLY:
        //     symbol='*';
        //     break;
        //     default:
        //     symbol='/';
        //     break;
        // }
        char symbol = opCode.getSymbol();
        return symbol;
    }

}
