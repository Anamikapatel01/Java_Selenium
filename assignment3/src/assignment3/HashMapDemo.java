package assignment3;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

    public static void main(String[] args) {

        // 1. Constructors

        // Default constructor
        HashMap<Integer, String> map1 = new HashMap<>();

        // Constructor with initial capacity
        HashMap<Integer, String> map2 = new HashMap<>(10);

        // Constructor with initial capacity and load factor
        HashMap<Integer, String> map3 = new HashMap<>(8, 0.75f);

        // Adding elements to map1
        map1.put(1, "Java");
        map1.put(2, "Python");
        map1.put(3, "C++");

        // Constructor with another Map
        HashMap<Integer, String> map4 = new HashMap<>(map1);

        // 2. Methods Demonstration
  
        // 1. put()
        map2.put(101, "HTML");

        // 2. putIfAbsent()
        map2.putIfAbsent(102, "CSS");

        // 3. putAll()
        map2.putAll(map1);

        // 4. get()
        System.out.println("Value for key 2: " + map2.get(2));

        // 5. remove()
        map2.remove(3);

        // 6. containsKey()
        System.out.println("Contains key 1? " + map2.containsKey(1));

        // 7. containsValue()
        System.out.println("Contains value Java? " + map2.containsValue("Java"));

        // 8. size()
        System.out.println("Size of HashMap: " + map2.size());

        // 9. isEmpty()
        System.out.println("Is HashMap empty? " + map2.isEmpty());

        // 10. keySet()
        System.out.println("Keys: " + map2.keySet());

        // 11. values()
        System.out.println("Values: " + map2.values());

        // 12. entrySet()
        System.out.println("Key-Value pairs:");
        for (Map.Entry<Integer, String> entry : map2.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        // 13. replace()
        map2.replace(1, "Core Java");

        // 14. getOrDefault()
        System.out.println("Value for key 99: "
                + map2.getOrDefault(99, "Not Found"));

        // 15. clear()
        map4.clear();
        System.out.println("Map4 after clear(): " + map4);
    }
}
