package assignment3;


import java.util.Hashtable;
import java.util.Enumeration;
import java.util.Map;

public class HashtableDemo {

    public static void main(String[] args) {

        // 1. Constructors
   
        // Default constructor
        Hashtable<Integer, String> ht1 = new Hashtable<>();

        // Constructor with initial capacity
        Hashtable<Integer, String> ht2 = new Hashtable<>(10);

        // Constructor with initial capacity and load factor
        Hashtable<Integer, String> ht3 = new Hashtable<>(8, 0.75f);

        // Adding elements to ht1
        ht1.put(1, "Java");
        ht1.put(2, "Python");
        ht1.put(3, "C++");

        // Constructor using another Map
        Hashtable<Integer, String> ht4 = new Hashtable<>(ht1);

        // 2. Methods Demonstration

        // 1. put()
        ht2.put(101, "HTML");

        // 2. putIfAbsent()
        ht2.putIfAbsent(102, "CSS");

        // 3. putAll()
        ht2.putAll(ht1);

        // 4. get()
        System.out.println("Value for key 2: " + ht2.get(2));

        // 5. remove()
        ht2.remove(3);

        // 6. containsKey()
        System.out.println("Contains key 1? " + ht2.containsKey(1));

        // 7. containsValue()
        System.out.println("Contains value Java? " + ht2.containsValue("Java"));

        // 8. size()
        System.out.println("Size of Hashtable: " + ht2.size());

        // 9. isEmpty()
        System.out.println("Is Hashtable empty? " + ht2.isEmpty());

        // 10. keys()
        System.out.println("Keys:");
        Enumeration<Integer> keys = ht2.keys();
        while (keys.hasMoreElements()) {
            System.out.println(keys.nextElement());
        }

        // 11. elements()
        System.out.println("Values:");
        Enumeration<String> values = ht2.elements();
        while (values.hasMoreElements()) {
            System.out.println(values.nextElement());
        }

        // 12. entrySet()
        System.out.println("Key-Value pairs:");
        for (Map.Entry<Integer, String> entry : ht2.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        // 13. replace()
        ht2.replace(1, "Core Java");

        // 14. getOrDefault()
        System.out.println("Value for key 99: "
                + ht2.getOrDefault(99, "Not Found"));

        // 15. clear()
        ht4.clear();
        System.out.println("Hashtable ht4 after clear(): " + ht4);
    }
}
