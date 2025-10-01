/**
 * Advanced Java Collections - LinkedHashSet, LinkedHashMap, TreeSet, TreeMap, PriorityQueue
 * 
 * Master all Java collections for optimal problem solving
 */

import java.util.*;

public class AdvancedCollections {
    
    public static void main(String[] args) {
        System.out.println("=== Advanced Java Collections Mastery ===\n");
        
        demonstrateLinkedHashSet();
        demonstrateLinkedHashMap();
        demonstrateTreeSet();
        demonstrateTreeMap();
        demonstratePriorityQueue();
        demonstrateDeque();
        collectionComparison();
        advancedPatterns();
    }
    
    /**
     * LINKEDHASHSET - Maintains insertion order
     */
    public static void demonstrateLinkedHashSet() {
        System.out.println("=== LinkedHashSet - Ordered Unique Elements ===");
        
        // LinkedHashSet maintains insertion order
        LinkedHashSet<String> linkedSet = new LinkedHashSet<>();
        linkedSet.add("apple");
        linkedSet.add("banana");
        linkedSet.add("cherry");
        linkedSet.add("apple");  // Duplicate - won't be added
        linkedSet.add("date");
        
        System.out.println("LinkedHashSet (insertion order): " + linkedSet);
        
        // vs regular HashSet (no order guarantee)
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("apple");
        hashSet.add("banana");
        hashSet.add("cherry");
        hashSet.add("date");
        
        System.out.println("HashSet (no order guarantee): " + hashSet);
        
        // Use case: Remove duplicates while preserving order
        List<Integer> numbersWithDuplicates = Arrays.asList(1, 3, 2, 3, 4, 1, 5, 2);
        LinkedHashSet<Integer> uniqueOrdered = new LinkedHashSet<>(numbersWithDuplicates);
        System.out.println("Original: " + numbersWithDuplicates);
        System.out.println("Unique with order: " + new ArrayList<>(uniqueOrdered));
        
        System.out.println();
    }
    
    /**
     * LINKEDHASHMAP - Maintains insertion order for key-value pairs
     */
    public static void demonstrateLinkedHashMap() {
        System.out.println("=== LinkedHashMap - Ordered Key-Value Pairs ===");
        
        // LinkedHashMap maintains insertion order
        LinkedHashMap<String, Integer> linkedMap = new LinkedHashMap<>();
        linkedMap.put("first", 1);
        linkedMap.put("second", 2);
        linkedMap.put("third", 3);
        linkedMap.put("fourth", 4);
        
        System.out.println("LinkedHashMap (insertion order):");
        for (Map.Entry<String, Integer> entry : linkedMap.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }
        
        // Access order LinkedHashMap (LRU cache implementation)
        LinkedHashMap<String, Integer> lruMap = new LinkedHashMap<String, Integer>(16, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                return size() > 3;  // Keep only 3 most recent
            }
        };
        
        lruMap.put("A", 1);
        lruMap.put("B", 2);
        lruMap.put("C", 3);
        System.out.println("LRU Map after adding A,B,C: " + lruMap);
        
        lruMap.get("A");  // Access A (moves to end)
        System.out.println("After accessing A: " + lruMap);
        
        lruMap.put("D", 4);  // Should remove B (least recently used)
        System.out.println("After adding D: " + lruMap);
        
        System.out.println();
    }
    
    /**
     * TREESET - Sorted unique elements
     */
    public static void demonstrateTreeSet() {
        System.out.println("=== TreeSet - Sorted Unique Elements ===");
        
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(30);
        treeSet.add(10);
        treeSet.add(50);
        treeSet.add(20);
        treeSet.add(40);
        treeSet.add(20);  // Duplicate - won't be added
        
        System.out.println("TreeSet (sorted): " + treeSet);
        
        // Navigation methods
        System.out.println("First (smallest): " + treeSet.first());
        System.out.println("Last (largest): " + treeSet.last());
        System.out.println("Lower than 25: " + treeSet.lower(25));
        System.out.println("Floor of 25: " + treeSet.floor(25));
        System.out.println("Ceiling of 25: " + treeSet.ceiling(25));
        System.out.println("Higher than 25: " + treeSet.higher(25));
        
        // Subset operations
        System.out.println("HeadSet (< 30): " + treeSet.headSet(30));
        System.out.println("TailSet (>= 30): " + treeSet.tailSet(30));
        System.out.println("SubSet [20, 40): " + treeSet.subSet(20, 40));
        
        // Custom comparator
        TreeSet<String> words = new TreeSet<>(Collections.reverseOrder());
        words.addAll(Arrays.asList("apple", "banana", "cherry", "date"));
        System.out.println("Words (reverse order): " + words);
        
        // Custom objects with Comparable
        TreeSet<Person> people = new TreeSet<>();
        people.add(new Person("Alice", 25));
        people.add(new Person("Bob", 30));
        people.add(new Person("Charlie", 20));
        System.out.println("People (sorted by age): " + people);
        
        System.out.println();
    }
    
    /**
     * TREEMAP - Sorted key-value pairs
     */
    public static void demonstrateTreeMap() {
        System.out.println("=== TreeMap - Sorted Key-Value Pairs ===");
        
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("zebra", 26);
        treeMap.put("apple", 1);
        treeMap.put("mango", 13);
        treeMap.put("banana", 2);
        
        System.out.println("TreeMap (sorted by keys): " + treeMap);
        
        // Navigation methods
        System.out.println("First key: " + treeMap.firstKey());
        System.out.println("Last key: " + treeMap.lastKey());
        System.out.println("Lower key than 'mango': " + treeMap.lowerKey("mango"));
        System.out.println("Higher key than 'mango': " + treeMap.higherKey("mango"));
        
        // Subset operations
        System.out.println("HeadMap (< 'mango'): " + treeMap.headMap("mango"));
        System.out.println("TailMap (>= 'mango'): " + treeMap.tailMap("mango"));
        
        // Use case: Range queries
        TreeMap<Integer, String> scoreMap = new TreeMap<>();
        scoreMap.put(85, "Alice");
        scoreMap.put(92, "Bob");
        scoreMap.put(78, "Charlie");
        scoreMap.put(96, "David");
        scoreMap.put(88, "Eve");
        
        System.out.println("Scores between 80-90: " + scoreMap.subMap(80, true, 90, true));
        
        System.out.println();
    }
    
    /**
     * PRIORITYQUEUE - Heap-based priority queue
     */
    public static void demonstratePriorityQueue() {
        System.out.println("=== PriorityQueue - Heap Implementation ===");
        
        // Min heap (default)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.addAll(Arrays.asList(30, 10, 50, 20, 40));
        
        System.out.print("Min Heap extraction: ");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
        System.out.println();
        
        // Max heap (using reverse comparator)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(Arrays.asList(30, 10, 50, 20, 40));
        
        System.out.print("Max Heap extraction: ");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");
        }
        System.out.println();
        
        // Custom objects with priority
        PriorityQueue<Task> taskQueue = new PriorityQueue<>();
        taskQueue.add(new Task("Low priority", 3));
        taskQueue.add(new Task("High priority", 1));
        taskQueue.add(new Task("Medium priority", 2));
        
        System.out.println("Task execution order:");
        while (!taskQueue.isEmpty()) {
            System.out.println("  " + taskQueue.poll());
        }
        
        // Top K problems pattern
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        List<Integer> topK = findTopKElements(nums, k);
        System.out.println("Top " + k + " elements: " + topK);
        
        System.out.println();
    }
    
    /**
     * DEQUE - Double-ended queue
     */
    public static void demonstrateDeque() {
        System.out.println("=== Deque - Double-Ended Queue ===");
        
        // ArrayDeque - most efficient Deque implementation
        Deque<Integer> deque = new ArrayDeque<>();
        
        // Add elements
        deque.addFirst(10);
        deque.addLast(20);
        deque.addFirst(5);
        deque.addLast(30);
        
        System.out.println("Deque: " + deque);
        
        // Peek elements
        System.out.println("First: " + deque.peekFirst());
        System.out.println("Last: " + deque.peekLast());
        
        // Remove elements
        System.out.println("Remove first: " + deque.removeFirst());
        System.out.println("Remove last: " + deque.removeLast());
        System.out.println("After removals: " + deque);
        
        // Use as Stack
        Deque<String> stack = new ArrayDeque<>();
        stack.push("first");
        stack.push("second");
        stack.push("third");
        System.out.println("Stack pop: " + stack.pop());
        
        // Use as Queue
        Deque<String> queue = new ArrayDeque<>();
        queue.offer("first");
        queue.offer("second");
        queue.offer("third");
        System.out.println("Queue poll: " + queue.poll());
        
        // Sliding window maximum pattern
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int windowSize = 3;
        List<Integer> maxInWindow = slidingWindowMaximum(arr, windowSize);
        System.out.println("Sliding window maximum: " + maxInWindow);
        
        System.out.println();
    }
    
    /**
     * COLLECTION COMPARISON AND WHEN TO USE EACH
     */
    public static void collectionComparison() {
        System.out.println("=== Collection Comparison ===");
        
        // Performance comparison
        int size = 100000;
        
        // HashSet vs LinkedHashSet vs TreeSet
        long startTime = System.nanoTime();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < size; i++) {
            hashSet.add(i);
        }
        long hashSetTime = System.nanoTime() - startTime;
        
        startTime = System.nanoTime();
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        for (int i = 0; i < size; i++) {
            linkedHashSet.add(i);
        }
        long linkedHashSetTime = System.nanoTime() - startTime;
        
        startTime = System.nanoTime();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < size; i++) {
            treeSet.add(i);
        }
        long treeSetTime = System.nanoTime() - startTime;
        
        System.out.println("Insertion time comparison (nanoseconds):");
        System.out.println("HashSet: " + hashSetTime);
        System.out.println("LinkedHashSet: " + linkedHashSetTime);
        System.out.println("TreeSet: " + treeSetTime);
        
        System.out.println("\nWhen to use each:");
        System.out.println("HashSet: Fast operations, no order needed");
        System.out.println("LinkedHashSet: Need insertion order preserved");
        System.out.println("TreeSet: Need sorted order, range operations");
        
        System.out.println();
    }
    
    /**
     * ADVANCED PATTERNS AND USE CASES
     */
    public static void advancedPatterns() {
        System.out.println("=== Advanced Patterns ===");
        
        // Pattern 1: LRU Cache using LinkedHashMap
        LRUCache cache = new LRUCache(3);
        cache.put(1, "one");
        cache.put(2, "two");
        cache.put(3, "three");
        System.out.println("LRU Cache: " + cache);
        cache.get(1);  // Access 1
        cache.put(4, "four");  // Should evict 2
        System.out.println("After access and insert: " + cache);
        
        // Pattern 2: Top K Frequent Elements
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        List<Integer> topKFreq = topKFrequent(nums, k);
        System.out.println("Top " + k + " frequent elements: " + topKFreq);
        
        // Pattern 3: Range Sum Query using TreeMap
        RangeSumQuery rsq = new RangeSumQuery();
        rsq.update(1, 10);
        rsq.update(3, 20);
        rsq.update(5, 30);
        rsq.update(7, 40);
        System.out.println("Range sum [3, 7]: " + rsq.sumRange(3, 7));
        
        System.out.println();
    }
    
    // Helper classes and methods
    static class Person implements Comparable<Person> {
        String name;
        int age;
        
        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        @Override
        public int compareTo(Person other) {
            return Integer.compare(this.age, other.age);
        }
        
        @Override
        public String toString() {
            return name + "(" + age + ")";
        }
    }
    
    static class Task implements Comparable<Task> {
        String description;
        int priority;
        
        Task(String description, int priority) {
            this.description = description;
            this.priority = priority;
        }
        
        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.priority, other.priority);
        }
        
        @Override
        public String toString() {
            return description + " (priority: " + priority + ")";
        }
    }
    
    // Top K elements using PriorityQueue
    public static List<Integer> findTopKElements(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        return new ArrayList<>(minHeap);
    }
    
    // Top K frequent elements
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (a, b) -> freqMap.get(a) - freqMap.get(b)
        );
        
        for (int num : freqMap.keySet()) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        
        return new ArrayList<>(heap);
    }
    
    // Sliding window maximum using Deque
    public static List<Integer> slidingWindowMaximum(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < nums.length; i++) {
            // Remove elements outside window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            
            // Remove smaller elements
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            deque.offerLast(i);
            
            // Add to result if window is complete
            if (i >= k - 1) {
                result.add(nums[deque.peekFirst()]);
            }
        }
        
        return result;
    }
    
    // LRU Cache implementation
    static class LRUCache {
        private LinkedHashMap<Integer, String> cache;
        private final int capacity;
        
        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new LinkedHashMap<Integer, String>(capacity, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
                    return size() > LRUCache.this.capacity;
                }
            };
        }
        
        public String get(int key) {
            return cache.get(key);
        }
        
        public void put(int key, String value) {
            cache.put(key, value);
        }
        
        @Override
        public String toString() {
            return cache.toString();
        }
    }
    
    // Range Sum Query using TreeMap
    static class RangeSumQuery {
        private TreeMap<Integer, Integer> map;
        
        public RangeSumQuery() {
            map = new TreeMap<>();
        }
        
        public void update(int index, int val) {
            map.put(index, val);
        }
        
        public int sumRange(int left, int right) {
            int sum = 0;
            for (Map.Entry<Integer, Integer> entry : map.subMap(left, true, right, true).entrySet()) {
                sum += entry.getValue();
            }
            return sum;
        }
    }
}

/*
ADVANCED COLLECTIONS CHEAT SHEET:

WHEN TO USE EACH:

HashSet/HashMap:
✅ Need fast O(1) operations
✅ Order doesn't matter
✅ Most common choice

LinkedHashSet/LinkedHashMap:
✅ Need insertion order preserved
✅ LRU cache implementation
✅ Remove duplicates keeping order

TreeSet/TreeMap:
✅ Need sorted order
✅ Range queries (floor, ceiling, subSet)
✅ Natural ordering required

PriorityQueue:
✅ Top K problems
✅ Merge K sorted lists
✅ Dijkstra's algorithm
✅ Huffman coding

Deque (ArrayDeque):
✅ Stack operations (instead of Stack class)
✅ Queue operations (instead of LinkedList)
✅ Sliding window problems
✅ Best choice for stack/queue needs

COMPLEXITY COMPARISON:
                Add    Remove  Contains  Access
HashSet         O(1)   O(1)    O(1)      N/A
LinkedHashSet   O(1)   O(1)    O(1)      N/A
TreeSet         O(logn) O(logn) O(logn)   N/A
PriorityQueue   O(logn) O(logn) O(n)      O(1) peek
ArrayDeque      O(1)   O(1)    O(n)      O(1) ends

MEMORY USAGE (relative):
HashSet < LinkedHashSet < TreeSet
HashMap < LinkedHashMap < TreeMap

INTERVIEW TIPS:
- Use LinkedHashSet for ordered unique elements
- Use TreeSet when you need sorted operations
- Use PriorityQueue for heap operations
- Use ArrayDeque instead of Stack/LinkedList for stack/queue
- LinkedHashMap is perfect for LRU cache
- TreeMap is great for range queries
*/