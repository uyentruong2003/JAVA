
public class Fundamental {

    public static void main(String[] args) {
        System.out.println("Hello World Java");
        // variable declaration syntax
        int myInteger = 20;
        myInteger = 100;
        System.out.println(myInteger);
        // final modifier means the variable is immutable
        final String myString = "Uyen";
        System.out.println(myString);
        
        // integer types: byte (8 bits), short (16 bits), int (32 bits), long (64 bits)
        long longInt = 6000040002L; // for long type, needs the letter L at the end

        // float types (decimal values): float (32 bits), double (64 bits)
        float floatDecNum = 43.195f; // for float type, needs the letter f at the end
        double doubleDecNum = 0.00000000001d; // for double type, needs the letter d at the end

        // character type:
        char letter = 'U'; //single quotation

        // boolean type:
        boolean isTrue = true;

        // basic operators: add (+), subtract (-), multiply (*), divide (/), modulus (%)
        // prefix & postfix (++ and -- before or after the variable)
        // prefix
        System.out.println(++myInteger); // myInteger (100) + 1 = 101
        System.out.println(myInteger); // print out myInteger (now 101)
        // postfix
        int myOtherInt = 20;
        System.out.println(myOtherInt++); // print out myOtherInt original value (20)
        System.out.println(myOtherInt); // now increment the value to 21

        // compound assignment operatiors: +=, -=, *=, /=
        myInteger -= 1; //minus 1 from myInteger (101) and reassign to myInteger
        myOtherInt /= 7*3; // divide myOtherInt (21) to 7*3=21 and reassign the value to myOtherInt
        System.out.println(myInteger);
        System.out.println(myOtherInt);

        //type conversion (data type casting):
        myInteger = (int) floatDecNum; //syntax for explicit type conversion
        longInt = myOtherInt; // syntax for implicit type conversion
        System.out.println(myInteger);
        System.out.println(longInt);
        // implicit type conversion: widening = convert to the larger data type 
            // (e.g., convert from byte to float --> automatically done)
        // explicit type conversion: narrowing = convert to the smaller data type (discard some bits)
            // (e.g., convert from double to float --> some bits will be discarded)

        // var: versatile data type; must assign value right at declaration
        var val1 = 50;
        int val2;
        val2 = val1;
        System.out.println(val2);

        // relational operators: >, <, >=, <=, ==, !=
        val1 = 100;
        int maxValue = val1 > val2 ? val1 : val2;
        System.out.println(maxValue);

        // if-else:
        if (val1 > val2)
            System.out.println("Val1 is bigger");
        else if (val1 < val2)
            System.out.println("Val2 is bigger");
        else
            System.out.println("Val1 and val2 are equal");
        
        // logical operators: and (&), or (|), exclusive or (^) - both true scenario is excluded
        boolean result = val1 > val2 & val1 % val2 == 0; //true AND true => true
        System.out.println(result);
        result = val1 - val2 >= 0 | val1 < val2; // true OR false => true
        System.out.println(result);
        result = val1 - val2 >= 0 ^ val1 > val2; // true XOR true => false
        System.out.println(result);
        // conditional logical operators (and or in if-else statement): and (&&), or (||)
        if (val1 > val2 && val1 % val2 == 0)
            System.out.println("Val1 is greater than val2 and val1 is divisible to val2");
        else {
            System.out.println("val1 is smaller than val2");
            System.out.println("Val1 is also not divisible to val2");
        }

        //switch statement:
        char myChoice = 'a';
        var calc = 0;
        val1 = 10;
        val2 = 11;
        switch(myChoice) {
            case 'a':
                calc = val1 + val2;
                break;
            case 's':
                calc = val2 - val1;
                break;
            case 'm':
                calc = val1 * val2;
            case 'd':
                calc = val2 != 0 ? val1/val2 : 0;
                break;
            default:
                calc = 0;
            break;
        }
        System.out.println(calc);

        // while loop:
        int someValue = 4; //initial read
        int factorial = 1;
        while (someValue > 1){ //check first, do later
            factorial *= someValue;
            someValue--; //update read
        }
        System.out.println(factorial);

        //do-while loop:
        int iVal = 10; //initial read
        do {
            System.out.print(iVal);
            iVal *= 2; //update read
            System.out.print(" * 2 = ");
            System.out.println(iVal);
        } while (iVal < 25); //do first, check later

        //for loop: still the factorial example
        int newFactorial = 1;
        for(int i = 5; i>1; i--){
            newFactorial *= i;
            System.out.print(i);
            System.out.print(" * ");
        }
        System.out.print("1 = ");
        System.out.println(newFactorial);

        //array
        //declare an array- method 1
        float[] array1 = new float[3];
        array1[0] = 99.0f;
        array1[1] = 13.11f;
        array1[2] = -0.2210f;

        //declare an array- method 2
        float[] array2 = {99.0f, 13.11f, -0.2210f};

        //loop through an array with for loop
        float sumArr = 0f;
        for (int index=0; index < array2.length; index++){
            sumArr += array2[index];
        }
        System.out.println(sumArr);

        sumArr = 0f;
        //loop through an array with for each loop
        for (float currentVal : array2) {
            sumArr += currentVal;
        }
        System.out.println(sumArr);

        // call void method
        float[] myArr = {10.2222f, -21.1f, 0.11f, 20f};
        incrementArrVal(myArr, 2);
        incrementArrVal(array2, 0);

        // call method with return value
        System.out.println(calcFactorial(6));
    }
    // declare a void method (aka function)
    static void incrementArrVal (float[] array, int number) {
        if (number <= 0){
            System.out.println("No increment occurs with the input number");
            return; // exit
        }
        for (int i=0; i< array.length; i++) {
            array[i] += number;
            System.out.print(array[i]);
            System.out.print(" | ");
        }
        System.out.println("");
        return;
    }

    //declare a method with return value
    static int calcFactorial (int number) {
        int newFactorial = 1;
        for(int i = number; i>1; i--){
            newFactorial *= i;
            System.out.print(i);
            System.out.print(" * ");
        }
        System.out.print("1 = ");
        System.out.println(newFactorial);
        return newFactorial;
    }

}