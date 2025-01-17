OOP: program with a systems of objects. Pillars: Abstraction

Abstraction: Class serves as a template with specific fields & methods that objects are built on => Hide complexity.
Encapsulation:  The visibility of a field/method is specified and controlled within the class (public/private). All changes you want to make to an object must be made to the class, not the object itself.
Inheritance: A subclass can inherit fields & methods from its parent class.
Polymorphism: a class can appear and be used in different forms.

Primitive vs. Object:
- Primitive variable: the value is stored in the variable
- Object variable: the variable only stores the reference to the object, not the object itself.

- Aliasing objects: object variables refer to the same object

Equality vs Identity:
==: in objects, it checks if 2 objects are identical (refer to the same object in memory)
to check for equality (contain same values) between 2 objects, use object1.equals(object2)

Object var can be null (not referring to any object)

Interface (public) & implementation (private) & no access modifier means "package private"-- only accessible within the package & protected (subclass use only).

Inheritance-- "super" in methods & constructors, "protected", "sealed", "final"

Is-a Relationship: a subclass is a superclass type.

Upcasting: reference to a subclass object is stored in a superclass variable

Alarm alarm1 = new FireAlarm();
Alarm alarm2 = new LockdownAlarm();
<getMessage() is a method of the Alarm class; the class is overriden in each subclass- FireAlarm, LockdownAlarm>
alarm1.getMessage(); //print out "Exit the building ASAP"
alarm2.getMessage(); //print out "The elephant is in the room"

Polymorphism: when we upcast objects of the same superclass, we can call the same superclass's methods across all objects, but the behaviors of the methods may vary based on the overriding properties that each subclass has.

Downcasting: cast an object that's previously upcasted to the superclass to its original class. Should avoid if possible

if (alarm1 instanceof FireAlarm) {
      FireAlarm fireAlarm = (FireAlarm)alarm1;
}
fireAlarm.getFireType(); // getFireType() is a method unique to the FireAlarm class

Abstract class- a superclass that doesn't have any implementation in the program-- it's just a guiding template for its  subclasses.

Interface- doesn't have fields, only has methods. The abstract class will "implement" the interface. One class can implement multiple interfaces.
