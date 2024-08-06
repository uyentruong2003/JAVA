
public class Main {
    public static void Fundamentals(String[] args) {
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

    }
    
}