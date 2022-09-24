package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;



// Abstract class
abstract class Animal {
    // Abstract method (does not have a body)
    public abstract void animalSound();

    // Regular method
    public void sleep() {
        System.out.println("Zzz");
    }
}

// Subclass (inherit from Animal)
class Pig extends Animal {
    public void animalSound() {
        // The body of animalSound() is provided here
        System.out.println("The pig says: wee wee");
    }

    public void sleep() {
        System.out.println("iiii");
    }
}


public class Main {
    public static void main(String[] args) {
        LocalDate myObj = LocalDate.of(1988, 05, 30); // Create a date object
        Person p = new Person("alex", "ctin", myObj);
        Person p1 = new Person("alex1");
        Person p2 = new Person();
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");
        for (String i : cars) {
            System.out.println(i);
        }
        // Create a date object
        // System.out.println(myObj); // Display the current date
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(12);
        numbers.add(8);
        numbers.add(2);
        numbers.add(23);
        Iterator<Integer> it = numbers.iterator();
        /*while (it.hasNext()) {
            Integer i = it.next();
            if (i < 10) {
                it.remove();
            }
        }*/
        do {
            Integer i = it.next();
        }
        while (it.hasNext());
        System.out.println(numbers);

        Integer myInt = 5;
        Double myDouble = 5.99;
        Character myChar = 'A';
        System.out.println(myInt.intValue());
        System.out.println(myDouble);
        System.out.println(myChar.charValue());

        Pig myPig = new Pig(); // Create a Pig object
        myPig.animalSound();
        myPig.sleep();
        test(myPig);


        int myNum1 = plusMethod(8, 26);
        double myNum2 = plusMethod(4.3, 6.26);
        System.out.println("int: " + myNum1);
        System.out.println("double: " + myNum2);




    }

    public static void test(Animal a) {
        a.sleep();
        System.out.println("A mers");
    }
    static int plusMethod(int x, int y) {
        return x + y;
    }

    static double plusMethod(double x, double y) {
        return x + y;
    }
}

