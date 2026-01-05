package assignment3;

import java.util.Vector;
import java.util.ArrayList;

public class VectorDemo {

    public static void main(String[] args) {

        // 1. Constructors
      
    	// Default constructor
        Vector<String> v1 = new Vector<>();

        // Constructor with initial capacity
        Vector<String> v2 = new Vector<>(5);

        // Constructor with initial capacity & capacity increment
        Vector<String> v3 = new Vector<>(3, 2);

        // Adding elements to v1
        v1.add("Java");
        v1.add("Python");
        v1.add("C++");

        // Constructor using Collection
        Vector<String> v4 = new Vector<>(v1);

        // 2. Methods Demonstration

        // 1. add()
        v2.add("HTML");

        // 2. addElement()
        v2.addElement("CSS");

        // 3. add(index, element)
        v2.add(1, "JavaScript");

        // 4. addAll()
        v2.addAll(v1);

        // 5. get()
        System.out.println("Element at index 2: " + v2.get(2));

        // 6. set()
        v2.set(0, "React");

        // 7. remove(index)
        v2.remove(1);

        // 8. removeElement()
        v2.removeElement("C++");

        // 9. contains()
        System.out.println("Contains Java? " + v2.contains("Java"));

        // 10. size()
        System.out.println("Size of Vector: " + v2.size());

        // 11. capacity()
        System.out.println("Capacity of Vector: " + v2.capacity());

        // 12. isEmpty()
        System.out.println("Is Vector empty? " + v2.isEmpty());

        // 13. indexOf()
        System.out.println("Index of Java: " + v2.indexOf("Java"));

        // 14. lastIndexOf()
        v2.add("Java");
        System.out.println("Last index of Java: " + v2.lastIndexOf("Java"));

        // 15. clear()
        v4.clear();
        System.out.println("Vector v4 after clear(): " + v4);
    }
}
