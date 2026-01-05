package assignment3;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo {

    public static void main(String[] args) {

     
        // 1. Constructors

        // Default constructor
        ArrayList<String> list1 = new ArrayList<>();

        // Constructor with initial capacity
        ArrayList<String> list2 = new ArrayList<>(5);

        // Adding elements to list1
        list1.add("Java");
        list1.add("Python");
        list1.add("C++");

        // Constructor with Collection
        ArrayList<String> list3 = new ArrayList<>(list1);

      
        // 2. Methods Demonstration
  
        // 1. add()
        list2.add("HTML");
        list2.add("CSS");

        // 2. add(index, element)
        list2.add(1, "JavaScript");

        // 3. addAll()
        list2.addAll(list1);

        // 4. get()
        System.out.println("Element at index 2: " + list2.get(2));

        // 5. set()
        list2.set(0, "React");

        // 6. remove(index)
        list2.remove(1);

        // 7. remove(object)
        list2.remove("C++");

        // 8. contains()
        System.out.println("Contains Java? " + list2.contains("Java"));

        // 9. size()
        System.out.println("Size of list: " + list2.size());

        // 10. isEmpty()
        System.out.println("Is list empty? " + list2.isEmpty());

        // 11. indexOf()
        System.out.println("Index of Java: " + list2.indexOf("Java"));

        // 12. lastIndexOf()
        list2.add("Java");
        System.out.println("Last index of Java: " + list2.lastIndexOf("Java"));

        // 13. toArray()
        Object[] arr = list2.toArray();
        System.out.println("Array elements:");
        for (Object o : arr) {
            System.out.println(o);
        }

        // 14. iterator()
        System.out.println("Using Iterator:");
        Iterator<String> it = list2.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // 15. clear()
        list3.clear();
        System.out.println("List3 after clear(): " + list3);
    }
}
