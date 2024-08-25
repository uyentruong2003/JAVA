import java.util.Scanner;
public class CalcEngine {
    // to run on command line:
        //compile the file first: javac CalcEngine.java
        // run without any command line args: java CalcEngine.java
        // run with command line args: java CalcEngine.java a 12.3d 1.0d
    public static void main(String[] args){ //string[] args --> all the inputs from the command line.
                                            // Each item is separated by space
        double[] leftVals = {100.1d, -23.43d, 15.0d, -0.0573d};
        double[] rightVals = {54.30d, 9.442d, -11.25d, 0.21d};
        char[] opCodes = {'a','s','m','d'};
        double[] results = new double[4];

        if (args.length == 0){
            //loop through to calculate the data from the given arrays, update the results arr, and print on screen
            for(int i=0; i< opCodes.length; i++){
                results[i] = calculate(opCodes[i],leftVals[i],rightVals[i]);
                System.out.println(results[i]);
            }
        } else if (args.length == 1) { //prompt for user input & calculate
            executeInteractively();
        } else if (args.length == 3) {
            handleCommandLine(args); // get the command line args and calculate the result
        } else {
            System.out.println("You have to provide a opCode, a left value, and a right value.");
        }

    }

    private static double calculate(char opCode, double leftVal, double rightVal) {
        double result;
        switch(opCode){
            case 'a':
                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            case 'd':
                result = rightVal != 0 ? leftVal/rightVal : 0.0d;
                break;
            default:
                result = 0.0d;
                break;
        }
        return result;
    }

    // method to get the inputs from command line
    private static void handleCommandLine(String[] args) {
        char opCode = args[0].charAt(0);
        double leftVal = Double.parseDouble(args[1]);
        double rightVal = Double.parseDouble(args[2]);
        double result = calculate(opCode, leftVal, rightVal);
        printResult(opCode, leftVal, rightVal, result);
    }

    private static void executeInteractively () {
        System.out.println("Enter an operation and 2 numbers: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] parts = userInput.split(" ");
        handleCommandLine(parts);
    }

    private static char letterToSymbol (char letter) {
        char[] letters = {'a','s','m','d'};
        char[] symbols = {'+','-','*','/'};
        char symbol = ' ';
        for(int i = 0; i<letters.length; i++){
            if (letter == letters[i]){
                symbol = symbols[i];
                break;
            }
        }
        return symbol;
    }

    private static void printResult (char opCode, double leftVal, double rightVal, double result){
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
        System.out.println(output);
    }
}
