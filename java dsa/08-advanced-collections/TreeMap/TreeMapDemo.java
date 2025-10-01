/**
 * Demonstrates the usage of TreeMap in Java.
 */

import java.util.*;

public class TreeMapDemo {

    public static void main(String[] args) {
        System.out.println("=== TreeMap - Sorted Key-Value Pairs ===");

        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Zebra", 95);
        treeMap.put("Apple", 85);
        treeMap.put("Banana", 90);
        treeMap.put("Cherry", 88);

        System.out.println("TreeMap (sorted by keys): " + treeMap);

        // Navigation methods
        System.out.println("First entry: " + treeMap.firstEntry());
        System.out.println("Last entry: " + treeMap.lastEntry());
        System.out.println("Lower entry than 'Banana': " + treeMap.lowerEntry("Banana"));
        System.out.println("Higher entry than 'Banana': " + treeMap.higherEntry("Banana"));
        System.out.println("Head map (< 'Cherry'): " + treeMap.headMap("Cherry"));
        System.out.println("Tail map (>= 'Banana'): " + treeMap.tailMap("Banana"));
        System.out.println("Sub map ('Apple' to 'Cherry'): " + treeMap.subMap("Apple", "Cherry"));
    }
}