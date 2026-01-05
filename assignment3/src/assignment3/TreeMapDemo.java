package assignment3;

import java.util.TreeMap;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;

public class TreeMapDemo {

    public static void main(String[] args) {

        // 1. Constructors

        // Default constructor (Natural Sorting)
        TreeMap<Integer, String> tm1 = new TreeMap<>();

        tm1.put(3, "C++");
        tm1.put(1, "Java");
        tm1.put(2, "Python");

        // Constructor with Comparator (Reverse Order)
        TreeMap<Integer, String> tm2 =
                new TreeMap<>(Comparator.reverseOrder());

        // Constructor with Map
        TreeMap<Integer, String> tm3 = new TreeMap<>(tm1);

        // Constructor with SortedMap
        SortedMap<Integer, String> sm = tm1;
        TreeMap<Integer, String> tm4 = new TreeMap<>(sm);

        // 2. Methods Demonstration

        // 1. put()
        tm2.put(101, "HTML");

        // 2. putIfAbsent()
        tm2.putIfAbsent(102, "CSS");

        // 3. putAll()
        tm2.putAll(tm1);

        // 4. get()
        System.out.println("Value for key 1: " + tm2.get(1));

        // 5. remove()
        tm2.remove(3);

        // 6. containsKey()
        System.out.println("Contains key 2? " + tm2.containsKey(2));

        // 7. containsValue()
        System.out.println("Contains value Java? " + tm2.containsValue("Java"));

        // 8. size()
        System.out.println("Size of TreeMap: " + tm2.size());

        // 9. isEmpty()
        System.out.println("Is TreeMap empty? " + tm2.isEmpty());

        // 10. firstKey()
        System.out.println("First Key: " + tm2.firstKey());

        // 11. lastKey()
        System.out.println("Last Key: " + tm2.lastKey());

        // 12. keySet()
        System.out.println("Keys: " + tm2.keySet());

        // 13. values()
        System.out.println("Values: " + tm2.values());

        // 14. entrySet()
        System.out.println("Key-Value pairs:");
        for (Map.Entry<Integer, String> entry : tm2.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        // 15. clear()
        tm4.clear();
        System.out.println("TreeMap tm4 after clear(): " + tm4);
    }
}

