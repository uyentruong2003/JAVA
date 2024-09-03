public class Strings {
    public static void main(String[] args) {
        // strings are immutable. the variable just contains a reference to the string. Everytime we update the String, it creates a new String
        // string equality:
        String s1 = "I love ";
        s1 += "Java";
        String s2 = "I ";
        s2 += "love Java";

        // just use == operator:
        System.out.println(s1==s2); // false. because string variables contain the REFERENCE to the string, not the string content itself
        
        // use method equals:
        System.out.println(s1.equals(s2)); //true. char-by-char comparison of the strings that the variables refer to

        // use method intern:
        System.out.println(s1.intern() == s2.intern()); //true. used when string comparison is used for high-volume

        // string methods- string.method():
        // length
        // create new string from existing: concat, replace, toLowerCase, toUpperCase, trim, split
        // extract: charAt, substring
        // test substring: contains, endsWith, startsWith, indexOf, lastIndexOf
        // comparison: equals, equalsIgnoreCase, isEmpty, compareTo, compareToIgnoreCase
        // formatting: format
        // convert non-string to string: String.valueOf(non-string)

        // StringBuilder: treats string var like an array of chars
        StringBuilder builder = new StringBuilder(40);
        builder.append("Hi, my name is. ");
        builder.append("I am a at the University of Alabama.");
        System.out.println(builder);
        int namePosition = builder.indexOf(". ");
        builder.insert(namePosition," Uyen");

        int classPosition = builder.indexOf(" at");
        builder.insert(classPosition, " Senior");
        System.out.println(builder);
        
        
        
        
        

    }
}
