public class ObjExample {
    public static void main (String[] args){
        ClassExample class1 = new ClassExample();
        ClassExample class2 = new ClassExample();

        class1.setName("Uyen");
        System.out.println(class1.getName());

        class1 = class2;
        System.out.println(class1.getName()); //class2 is now the same value as class1

        class2.setName("Deep"); //class2 is updated to "Deep"; not class1
        System.out.println(class1.getName()); //but when printing class1 out, class1 value is updated to Deep as class2

        MathEquation equation = new MathEquation(12, 3, MathOperation.MULTIPLY);
        // equation.leftVal  = 12;
        // equation.rightVal = 3;
        // equation.opCode = 'm';
        equation.execute();
        System.out.println(equation.result);

        //array of objects:
        double[] leftVals = {100.1d, -23.43d, 15.0d, -0.0573d};
        double[] rightVals = {54.30d, 9.442d, -11.25d, 0.21d};
        MathOperation[] opCodes = {MathOperation.ADD,MathOperation.SUBTRACT,MathOperation.MULTIPLY,MathOperation.DIVIDE};
        double[] results = new double[opCodes.length];

        MathEquation[] equationArr = new MathEquation[opCodes.length];
        for (int i=0; i<equationArr.length; i++){
            equationArr[i] = new MathEquation(leftVals[i],rightVals[i],opCodes[i]);
            equationArr[i].execute();
            results[i] = equationArr[i].result;
            System.out.println("Equation #"+ (i+1) + " = "+ results[i]);
        }
        System.out.println("Average result = " + MathEquation.getAverageResult());

        //example method overload:
        MathEquation equationOverload = new MathEquation(MathOperation.ADD);
        equationOverload.execute(12,11);
        System.out.println(equationOverload.getResult());
        //overloading toString method:
        System.out.println(equationOverload.toString());

        // Object class: all types of objects can be declared under the object class
        Object stuff = new Object();
        stuff = "I love JAVA";
        stuff = new MathEquation();

        // Primitive Types vs. Primitive Wrapper Class:
        // int, long, short, byte, char, double, float... ==> Primitive Types for variables
        // Integer, Long, Short, Byte, String, Double, Float ==> Primitive Wrapper Class, allow the use of methods related to that primitive type
        int val1 = 11;
        String val1Class = Integer.toString(val1);
        
        // record example:
        Student student1 = new Student("Uyen", "Senior", "MIS and OM", 4.0d);
        System.out.println(student1.name() + " is a "+ student1.grade() + ", majoring in " + student1.major() + ". She has a " + student1.gpa() + " GPA.");


        // Alarm inheritance example
        Alarm generalAlarm = new Alarm("This is a general alarm");
        generalAlarm.printAlarmMessage();
        FireAlarm arsonAlarm = new FireAlarm("arson");
        arsonAlarm.printAlarmMessage();
    }

    // static import- import the static methods just as a package: import static [className].[staticMethodName or * for all static methods]

}
