/**
 * ArrayList and Java Collections - Dynamic Data Structures
 * 
 * Master Java's built-in collections for efficient programming
 */

import java.util.*;

public class ArrayListAndCollections {
    
    /**
     * ARRAYLIST FUNDAMENTALS
     */
    public static void arrayListBasics() {
        System.out.println("=== ArrayList Basics ===");
        
        // Creating ArrayList
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));
        
        System.out.println("Initial numbers: " + numbers);
        System.out.println("Initial names: " + names);
        
        // Adding elements
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(1, 15);  // Insert at specific index
        
        System.out.println("After adding: " + numbers);
        
        // Accessing elements
        System.out.println("Element at index 0: " + numbers.get(0));
        System.out.println("First element: " + numbers.get(0));
        System.out.println("Last element: " + numbers.get(numbers.size() - 1));
        
        // Modifying elements
        numbers.set(2, 25);  // Replace element at index 2
        System.out.println("After modification: " + numbers);
        
        // Searching elements
        System.out.println("Contains 20: " + numbers.contains(20));
        System.out.println("Index of 25: " + numbers.indexOf(25));
        System.out.println("Last index of 15: " + numbers.lastIndexOf(15));
        
        // Size and capacity
        System.out.println("Size: " + numbers.size());
        System.out.println("Is empty: " + numbers.isEmpty());
        
        System.out.println();
    }
    
    /**
     * ARRAYLIST ADVANCED OPERATIONS
     */
    public static void arrayListAdvanced() {
        System.out.println("=== ArrayList Advanced Operations ===");
        
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("cherry");
        fruits.add("date");
        fruits.add("elderberry");
        
        System.out.println("Original list: " + fruits);
        
        // Removing elements
        fruits.remove("banana");           // Remove by value
        fruits.remove(2);                  // Remove by index
        System.out.println("After removals: " + fruits);
        
        // Bulk operations
        ArrayList<String> moreFruits = new ArrayList<>(Arrays.asList("fig", "grape", "kiwi"));
        fruits.addAll(moreFruits);         // Add all elements
        System.out.println("After adding all: " + fruits);
        
        ArrayList<String> toRemove = new ArrayList<>(Arrays.asList("fig", "grape"));
        fruits.removeAll(toRemove);        // Remove all specified elements
        System.out.println("After removing all: " + fruits);
        
        // Retain only specified elements
        ArrayList<String> toKeep = new ArrayList<>(Arrays.asList("apple", "kiwi", "mango"));
        ArrayList<String> copy = new ArrayList<>(fruits);
        copy.retainAll(toKeep);
        System.out.println("Retained elements: " + copy);
        
        // Sublist operations
        List<String> subList = fruits.subList(1, 3);  // From index 1 to 2 (exclusive 3)
        System.out.println("Sublist [1,3): " + subList);
        
        // Converting to array
        String[] fruitsArray = fruits.toArray(new String[0]);
        System.out.println("Array: " + Arrays.toString(fruitsArray));
        
        System.out.println();
    }
    
    /**
     * ARRAYLIST ITERATION METHODS
     */
    public static void arrayListIteration() {
        System.out.println("=== ArrayList Iteration Methods ===");
        
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        
        // Method 1: Traditional for loop
        System.out.print("Traditional for: ");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }
        System.out.println();
        
        // Method 2: Enhanced for loop (for-each)
        System.out.print("Enhanced for: ");
        for (Integer num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // Method 3: Iterator
        System.out.print("Iterator: ");
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        
        // Method 4: ListIterator (bidirectional)
        System.out.print("ListIterator (reverse): ");
        ListIterator<Integer> listIterator = numbers.listIterator(numbers.size());
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }
        System.out.println();
        
        // Method 5: Java 8 Streams
        System.out.print("Stream forEach: ");
        numbers.stream().forEach(num -> System.out.print(num + " "));
        System.out.println();
        
        System.out.println();
    }
    
    /**
     * LINKEDLIST COMPARISON
     */
    public static void linkedListComparison() {
        System.out.println("=== LinkedList vs ArrayList Comparison ===");
        
        // LinkedList creation and basic operations
        LinkedList<String> linkedList = new LinkedList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        
        // Adding elements
        String[] elements = {"first", "second", "third", "fourth"};
        
        for (String element : elements) {
            linkedList.add(element);
            arrayList.add(element);
        }
        
        System.out.println("LinkedList: " + linkedList);
        System.out.println("ArrayList: " + arrayList);
        
        // LinkedList specific operations
        linkedList.addFirst("beginning");
        linkedList.addLast("end");
        System.out.println("LinkedList after addFirst/addLast: " + linkedList);
        
        System.out.println("First element: " + linkedList.getFirst());
        System.out.println("Last element: " + linkedList.getLast());
        
        // Remove from beginning and end
        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println("After removeFirst/removeLast: " + linkedList);
        
        // Performance comparison demonstration
        performanceComparison();
        
        System.out.println();
    }
    
    /**
     * PERFORMANCE COMPARISON between ArrayList and LinkedList
     */
    public static void performanceComparison() {
        System.out.println("\n--- Performance Comparison ---");
        
        int size = 100000;
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        
        // Test 1: Adding elements at the end
        long startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }
        long arrayListAddTime = System.nanoTime() - startTime;
        
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            linkedList.add(i);
        }
        long linkedListAddTime = System.nanoTime() - startTime;
        
        System.out.println("Add at end (nanoseconds):");
        System.out.println("ArrayList: " + arrayListAddTime);
        System.out.println("LinkedList: " + linkedListAddTime);
        
        // Test 2: Random access
        Random random = new Random();
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            arrayList.get(random.nextInt(size));
        }
        long arrayListAccessTime = System.nanoTime() - startTime;
        
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkedList.get(random.nextInt(size));
        }
        long linkedListAccessTime = System.nanoTime() - startTime;
        
        System.out.println("\nRandom access (1000 operations, nanoseconds):");
        System.out.println("ArrayList: " + arrayListAccessTime);
        System.out.println("LinkedList: " + linkedListAccessTime);
        System.out.println("ArrayList is " + (linkedListAccessTime / arrayListAccessTime) + "x faster for random access");
    }
    
    /**
     * COLLECTIONS UTILITY CLASS
     */
    public static void collectionsUtility() {
        System.out.println("=== Collections Utility Methods ===");
        
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(64, 34, 25, 12, 22, 11, 90));
        System.out.println("Original: " + numbers);
        
        // Sorting
        Collections.sort(numbers);
        System.out.println("After sort: " + numbers);
        
        Collections.sort(numbers, Collections.reverseOrder());
        System.out.println("Reverse sort: " + numbers);
        
        // Searching (binary search on sorted list)
        Collections.sort(numbers);  // Must be sorted for binary search
        int index = Collections.binarySearch(numbers, 25);
        System.out.println("Binary search for 25: index " + index);
        
        // Shuffling
        Collections.shuffle(numbers);
        System.out.println("After shuffle: " + numbers);
        
        // Min and Max
        System.out.println("Min: " + Collections.min(numbers));
        System.out.println("Max: " + Collections.max(numbers));
        
        // Frequency
        numbers.add(25);
        numbers.add(25);
        System.out.println("Frequency of 25: " + Collections.frequency(numbers, 25));
        
        // Rotating
        Collections.rotate(numbers, 2);
        System.out.println("After rotate by 2: " + numbers);
        
        // Filling
        ArrayList<String> words = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        Collections.fill(words, "X");
        System.out.println("After fill with 'X': " + words);
        
        // Creating unmodifiable list
        ArrayList<String> modifiable = new ArrayList<>(Arrays.asList("apple", "banana", "cherry"));
        List<String> unmodifiable = Collections.unmodifiableList(modifiable);
        System.out.println("Unmodifiable list: " + unmodifiable);
        // unmodifiable.add("date"); // This would throw UnsupportedOperationException
        
        System.out.println();
    }
    
    /**
     * PRACTICAL EXAMPLES AND PATTERNS
     */
    public static void practicalExamples() {
        System.out.println("=== Practical Examples ===");
        
        // Example 1: Remove duplicates while preserving order
        ArrayList<Integer> withDuplicates = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 4, 1, 5));
        ArrayList<Integer> withoutDuplicates = removeDuplicates(withDuplicates);
        System.out.println("Original: " + withDuplicates);
        System.out.println("Without duplicates: " + withoutDuplicates);
        
        // Example 2: Find intersection of two lists
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList("apple", "banana", "cherry", "date"));
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("banana", "date", "elderberry", "fig"));
        ArrayList<String> intersection = findIntersection(list1, list2);
        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);
        System.out.println("Intersection: " + intersection);
        
        // Example 3: Partition list into even and odd numbers
        ArrayList<Integer> mixedNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Map<String, ArrayList<Integer>> partitioned = partitionEvenOdd(mixedNumbers);
        System.out.println("Original: " + mixedNumbers);
        System.out.println("Even: " + partitioned.get("even"));
        System.out.println("Odd: " + partitioned.get("odd"));
        
        // Example 4: Find top K elements
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(85, 92, 78, 96, 88, 91, 87));
        ArrayList<Integer> topThree = findTopK(scores, 3);
        System.out.println("Scores: " + scores);
        System.out.println("Top 3: " + topThree);
        
        System.out.println();
    }
    
    // Helper method: Remove duplicates while preserving order
    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {
        LinkedHashSet<T> set = new LinkedHashSet<>(list);
        return new ArrayList<>(set);
    }
    
    // Helper method: Find intersection
    public static <T> ArrayList<T> findIntersection(ArrayList<T> list1, ArrayList<T> list2) {
        ArrayList<T> intersection = new ArrayList<>(list1);
        intersection.retainAll(list2);
        return intersection;
    }
    
    // Helper method: Partition into even and odd
    public static Map<String, ArrayList<Integer>> partitionEvenOdd(ArrayList<Integer> numbers) {
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();
        
        for (Integer num : numbers) {
            if (num % 2 == 0) {
                even.add(num);
            } else {
                odd.add(num);
            }
        }
        
        Map<String, ArrayList<Integer>> result = new HashMap<>();
        result.put("even", even);
        result.put("odd", odd);
        return result;
    }
    
    // Helper method: Find top K elements
    public static ArrayList<Integer> findTopK(ArrayList<Integer> list, int k) {
        ArrayList<Integer> copy = new ArrayList<>(list);
        Collections.sort(copy, Collections.reverseOrder());
        return new ArrayList<>(copy.subList(0, Math.min(k, copy.size())));
    }
    
    /**
     * CHOOSING THE RIGHT COLLECTION
     */
    public static void choosingRightCollection() {
        System.out.println("=== Choosing the Right Collection ===");
        System.out.println();
        
        System.out.println("USE ARRAYLIST WHEN:");
        System.out.println("✅ You need random access to elements by index");
        System.out.println("✅ You do more reading than inserting/deleting");
        System.out.println("✅ You add elements mostly at the end");
        System.out.println("✅ Memory usage is a concern");
        System.out.println();
        
        System.out.println("USE LINKEDLIST WHEN:");
        System.out.println("✅ You frequently insert/delete at the beginning");
        System.out.println("✅ You don't need random access by index");
        System.out.println("✅ The size varies significantly");
        System.out.println("✅ You implement queue/deque operations");
        System.out.println();
        
        System.out.println("USE VECTOR WHEN:");
        System.out.println("✅ You need thread-safe operations");
        System.out.println("✅ Working with legacy code");
        System.out.println("❌ Generally prefer ArrayList with synchronization");
        System.out.println();
    }
    
    /**
     * MAIN METHOD - Test all implementations
     */
    public static void main(String[] args) {
        System.out.println("=== ArrayList and Collections Demo ===\n");
        
        arrayListBasics();
        arrayListAdvanced();
        arrayListIteration();
        linkedListComparison();
        collectionsUtility();
        practicalExamples();
        choosingRightCollection();
    }
}

/*
ARRAYLIST KEY CONCEPTS:

INTERNAL IMPLEMENTATION:
- Uses dynamic array (resizes automatically)
- Default initial capacity: 10
- Grows by 50% when capacity exceeded
- Shrinks when size < 25% of capacity (in some implementations)

ARRAYLIST VS ARRAY:
ARRAYLIST:
✅ Dynamic size
✅ Rich API (add, remove, contains, etc.)
✅ Type safety with generics
✅ Works with Collections framework
❌ Slightly slower than arrays
❌ Can only store objects (not primitives directly)

ARRAY:
✅ Faster for basic operations
✅ Can store primitives directly
✅ Lower memory overhead
❌ Fixed size
❌ Limited functionality

PERFORMANCE CHARACTERISTICS:
- get(index): O(1)
- set(index, element): O(1)
- add(element): O(1) amortized, O(n) worst case
- add(index, element): O(n)
- remove(index): O(n)
- contains(element): O(n)
- size(): O(1)

MEMORY CONSIDERATIONS:
- ArrayList maintains internal array
- Capacity >= size
- May waste memory if size << capacity
- Use trimToSize() to minimize waste

THREAD SAFETY:
- ArrayList is NOT thread-safe
- Use Collections.synchronizedList() for thread safety
- Or use Vector (legacy, not recommended)
- Or use CopyOnWriteArrayList for read-heavy scenarios

BEST PRACTICES:
1. Specify initial capacity if you know approximate size
2. Use enhanced for-loop when you don't need index
3. Prefer ArrayList over Vector in new code
4. Use Collections utility methods for common operations
5. Consider LinkedList for frequent insertions/deletions

INTERVIEW TIPS:
- Know time complexity of operations
- Understand when to use ArrayList vs LinkedList
- Be familiar with Collections utility methods
- Understand the growth strategy (50% increase)
- Know about fail-fast iterators
*/