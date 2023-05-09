/**
 * Created by pietrocenciarelli on 11/05/22.
 */

import java.lang.reflect.*;

public class TestReflection {
    /*
    It creates an object of type Class and then uses it to construct
    an object of the corresponding class and call one of its methods.
    Class is a generic type!
     */

    private static void printMembers (Member[] mems) {
        // it prints an array of objects of type Member
        for (Member m : mems) {
            System.out.println(m);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {

        String s = "Snap";
        /*
        three ways of creating a Class object
        representing the class of strings
        */
        System.out.println(s.getClass()); // 1) using a string
        System.out.println(String.class); // 2) using the literal String
        System.out.println(Class.forName("java.lang.String")); // giving the name of the class to method forName
        System.out.println(Class.forName("java.lang.String").getSimpleName()); // returns the simple name

        // Class C = new Class(); // Class has no public constructor

        // Class<Integer> MyInteger = Class.forName("java.lang.Integer"); // show error!
        // Class MyInteger2 = Class.forName("java.lang.Integer"); // using raw type
        String dog = args[0];
        System.out.println(dog);
        Class<?> C = Class.forName("HuskyDog");
        // a Class<?> because we don't know what's written in args[0]
        System.out.println(C);

        // Class<Integer> C = Class.forName("java.lang.Integer"); // show error!
        // Class C = Class.forName("java.lang.Integer"); // using raw type

        printMembers(C.getDeclaredConstructors());
        printMembers(C.getDeclaredFields());
        printMembers(C.getDeclaredMethods());

        Method m0 = C.getDeclaredMethods()[0]; // represents method runAway
        Method m1 = C.getDeclaredMethods()[1]; // represents method eatChicken
        Constructor makeHusky = C.getDeclaredConstructors()[1]; // the constructor with a parameter

        Object H1 = C.newInstance(); // creates an object with the default constructor

        ((HuskyDog)H1).runAway();
        m0.invoke(H1); // invoke is a method of class Method

        Object H2 = makeHusky.newInstance("Zampa");
        // in order to call a non-default constructor must use an object of type Constructor
        m1.invoke(H2);

    }

}
