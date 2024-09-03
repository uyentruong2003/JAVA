// this class is called in Object example
//class is a template to create an object
public class ClassExample {
    //fields:
    public String className;
    private int classId;


    //constructor:
    ClassExample(){
        className = "Hello World";
        classId = 12345;
    }

    // Access modifier: public- can be called outside of the class; private- can only be called within the class
    //methods:
    public void printOutName(){
        System.out.print("Class Name is ");
        System.out.println(this.className);
    }

    // Getters (Accessors) & Setters (Mutators)
    public void setName(String newName) {
        this.className = newName;
    }

    public String getName() {
        return this.className;
    }
}
