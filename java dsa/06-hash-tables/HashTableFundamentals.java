/**
 * Hash Table Implementation and Usage - Fast Key-Value Storage
 * 
 * Understanding hash tables is crucial for optimizing many algorithms
 */

import java.util.*;

public class HashTableFundamentals {
    
    /**
     * SIMPLE HASH TABLE IMPLEMENTATION (for educational purposes)
     */
    static class SimpleHashTable {
        private static final int DEFAULT_CAPACITY = 10;
        private LinkedList<Entry>[] buckets;
        private int size;
        
        // Entry class to store key-value pairs
        static class Entry {
            String key;
            Integer value;
            
            Entry(String key, Integer value) {
                this.key = key;
                this.value = value;
            }
        }
        
        // Constructor
        @SuppressWarnings("unchecked")
        public SimpleHashTable() {
            buckets = new LinkedList[DEFAULT_CAPACITY];
            for (int i = 0; i < DEFAULT_CAPACITY; i++) {
                buckets[i] = new LinkedList<>();
            }
            size = 0;
        }
        
        // Simple hash function
        private int hash(String key) {
            int hash = 0;
            for (char c : key.toCharArray()) {
                hash = (hash * 31 + c) % DEFAULT_CAPACITY;
            }
            return Math.abs(hash);
        }
        
        // Put key-value pair - O(1) average
        public void put(String key, Integer value) {
            int index = hash(key);
            LinkedList<Entry> bucket = buckets[index];
            
            // Check if key already exists
            for (Entry entry : bucket) {
                if (entry.key.equals(key)) {
                    entry.value = value;  // Update existing
                    return;
                }
            }
            
            // Add new entry
            bucket.add(new Entry(key, value));
            size++;
        }
        
        // Get value by key - O(1) average
        public Integer get(String key) {
            int index = hash(key);
            LinkedList<Entry> bucket = buckets[index];
            
            for (Entry entry : bucket) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
            
            return null;  // Key not found
        }
        
        // Remove key-value pair - O(1) average
        public boolean remove(String key) {
            int index = hash(key);
            LinkedList<Entry> bucket = buckets[index];
            
            Iterator<Entry> iterator = bucket.iterator();
            while (iterator.hasNext()) {
                Entry entry = iterator.next();
                if (entry.key.equals(key)) {
                    iterator.remove();
                    size--;
                    return true;
                }
            }
            
            return false;  // Key not found
        }
        
        // Check if key exists - O(1) average
        public boolean containsKey(String key) {
            return get(key) != null;
        }
        
        // Get current size
        public int size() {
            return size;
        }
        
        // Check if empty
        public boolean isEmpty() {
            return size == 0;
        }
        
        // Display hash table contents
        public void display() {
            System.out.println("Hash Table Contents:");
            for (int i = 0; i < buckets.length; i++) {
                if (!buckets[i].isEmpty()) {
                    System.out.print("Bucket " + i + ": ");
                    for (Entry entry : buckets[i]) {
                        System.out.print("[" + entry.key + "=" + entry.value + "] ");
                    }
                    System.out.println();
                }
            }
        }
    }
    
    /**
     * HASHMAP USAGE EXAMPLES - Java's built-in hash table
     */
    public static void demonstrateHashMap() {
        System.out.println("=== HashMap Usage Examples ===");
        
        // Basic operations
        HashMap<String, Integer> map = new HashMap<>();
        
        // Put elements
        map.put("apple", 5);
        map.put("banana", 3);
        map.put("orange", 8);
        map.put("grape", 12);
        
        System.out.println("Initial map: " + map);
        
        // Get elements
        System.out.println("apple count: " + map.get("apple"));
        System.out.println("mango count: " + map.get("mango")); // null
        
        // Check existence
        System.out.println("Contains apple: " + map.containsKey("apple"));
        System.out.println("Contains mango: " + map.containsKey("mango"));
        
        // Update value
        map.put("apple", 10);  // Updates existing value
        System.out.println("Updated apple count: " + map.get("apple"));
        
        // Use getOrDefault for safer access
        System.out.println("Mango count (with default): " + map.getOrDefault("mango", 0));
        
        // Iterate through map
        System.out.println("\nIterating through map:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        
        // Alternative iteration methods
        System.out.println("\nKeys: " + map.keySet());
        System.out.println("Values: " + map.values());
        
        // Remove elements
        map.remove("banana");
        System.out.println("After removing banana: " + map);
        
        System.out.println();
    }
    
    /**
     * HASHSET USAGE EXAMPLES - For unique elements
     */
    public static void demonstrateHashSet() {
        System.out.println("=== HashSet Usage Examples ===");
        
        HashSet<Integer> set = new HashSet<>();
        
        // Add elements
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(2);  // Duplicate - won't be added
        set.add(4);
        
        System.out.println("Set contents: " + set);
        System.out.println("Size: " + set.size());
        
        // Check existence
        System.out.println("Contains 2: " + set.contains(2));
        System.out.println("Contains 5: " + set.contains(5));
        
        // Remove element
        set.remove(3);
        System.out.println("After removing 3: " + set);
        
        // Set operations
        HashSet<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(4);
        set2.add(6);
        set2.add(8);
        
        // Union (all elements from both sets)
        HashSet<Integer> union = new HashSet<>(set);
        union.addAll(set2);
        System.out.println("Union: " + union);
        
        // Intersection (common elements)
        HashSet<Integer> intersection = new HashSet<>(set);
        intersection.retainAll(set2);
        System.out.println("Intersection: " + intersection);
        
        // Difference (elements in set1 but not in set2)
        HashSet<Integer> difference = new HashSet<>(set);
        difference.removeAll(set2);
        System.out.println("Difference: " + difference);
        
        System.out.println();
    }
    
    /**
     * COMMON HASH TABLE PATTERNS AND PROBLEMS
     */
    
    // Pattern 1: Frequency Counting
    public static void frequencyCount() {
        System.out.println("=== Frequency Counting Pattern ===");
        
        String text = "hello world hello";
        String[] words = text.split(" ");
        
        // Count word frequencies
        HashMap<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        System.out.println("Word frequencies: " + wordCount);
        
        // Find most frequent word
        String mostFrequent = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequent = entry.getKey();
            }
        }
        
        System.out.println("Most frequent word: '" + mostFrequent + "' (count: " + maxCount + ")");
        System.out.println();
    }
    
    // Pattern 2: Two Sum Problem using HashMap
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            
            map.put(nums[i], i);
        }
        
        return new int[]{-1, -1};  // No solution found
    }
    
    // Pattern 3: Find First Non-Repeating Character
    public static char firstNonRepeatingChar(String str) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        
        // Count frequency of each character
        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        // Find first character with count 1
        for (char c : str.toCharArray()) {
            if (charCount.get(c) == 1) {
                return c;
            }
        }
        
        return '\0';  // No non-repeating character found
    }
    
    // Pattern 4: Check if two strings are anagrams
    public static boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        
        HashMap<Character, Integer> charCount = new HashMap<>();
        
        // Count characters in first string
        for (char c : str1.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        // Subtract characters from second string
        for (char c : str2.toCharArray()) {
            if (!charCount.containsKey(c)) {
                return false;
            }
            charCount.put(c, charCount.get(c) - 1);
            if (charCount.get(c) == 0) {
                charCount.remove(c);
            }
        }
        
        return charCount.isEmpty();
    }
    
    // Pattern 5: Find all pairs with given sum
    public static List<int[]> findPairsWithSum(int[] nums, int target) {
        List<int[]> pairs = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            if (map.containsKey(complement)) {
                pairs.add(new int[]{complement, nums[i]});
            }
            
            map.put(nums[i], i);
        }
        
        return pairs;
    }
    
    // Pattern 6: Longest Substring Without Repeating Characters
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charIndex = new HashMap<>();
        int maxLength = 0;
        int start = 0;
        
        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);
            
            if (charIndex.containsKey(currentChar)) {
                start = Math.max(start, charIndex.get(currentChar) + 1);
            }
            
            charIndex.put(currentChar, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        
        return maxLength;
    }
    
    /**
     * MAIN METHOD - Test all implementations and patterns
     */
    public static void main(String[] args) {
        System.out.println("=== Hash Table Fundamentals Demo ===\n");
        
        // Test simple hash table implementation
        System.out.println("=== Simple Hash Table Test ===");
        SimpleHashTable hashTable = new SimpleHashTable();
        
        hashTable.put("name", 25);
        hashTable.put("age", 30);
        hashTable.put("score", 95);
        hashTable.put("level", 10);
        
        hashTable.display();
        
        System.out.println("Get 'name': " + hashTable.get("name"));
        System.out.println("Contains 'age': " + hashTable.containsKey("age"));
        
        hashTable.remove("score");
        System.out.println("After removing 'score':");
        hashTable.display();
        
        // Test built-in HashMap and HashSet
        demonstrateHashMap();
        demonstrateHashSet();
        
        // Test common patterns
        frequencyCount();
        
        // Test algorithmic problems
        System.out.println("=== Algorithmic Problems ===");
        
        // Two Sum
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println("Two Sum result: [" + result[0] + ", " + result[1] + "]");
        
        // First non-repeating character
        String str = "leetcode";
        char firstNonRepeating = firstNonRepeatingChar(str);
        System.out.println("First non-repeating char in '" + str + "': " + firstNonRepeating);
        
        // Anagram check
        String str1 = "listen";
        String str2 = "silent";
        System.out.println("'" + str1 + "' and '" + str2 + "' are anagrams: " + areAnagrams(str1, str2));
        
        // Find pairs with sum
        int[] pairNums = {1, 5, 7, -1, 5};
        int pairTarget = 6;
        List<int[]> pairs = findPairsWithSum(pairNums, pairTarget);
        System.out.print("Pairs with sum " + pairTarget + ": ");
        for (int[] pair : pairs) {
            System.out.print("[" + pair[0] + ", " + pair[1] + "] ");
        }
        System.out.println();
        
        // Longest substring without repeating characters
        String longStr = "abcabcbb";
        int maxLength = lengthOfLongestSubstring(longStr);
        System.out.println("Longest substring without repeating chars in '" + longStr + "': " + maxLength);
    }
}

/*
HASH TABLE KEY CONCEPTS:

HASH FUNCTION:
- Maps keys to array indices
- Should distribute keys uniformly
- Common methods: division, multiplication, universal hashing

COLLISION HANDLING:
1. CHAINING (used in Java HashMap):
   - Each bucket contains a list of entries
   - Simple to implement
   - Performance degrades gracefully

2. OPEN ADDRESSING:
   - Find next available slot
   - Types: linear probing, quadratic probing, double hashing
   - Better cache performance

LOAD FACTOR:
- Ratio of elements to buckets
- Java HashMap resizes when load factor > 0.75
- Trade-off between space and time

HASH TABLE VS ARRAY:
HASH TABLE:
✅ Fast lookup O(1) average
✅ Dynamic size
✅ Key-based access
❌ No ordering
❌ Extra memory overhead

ARRAY:
✅ Ordered elements
✅ Cache-friendly
✅ Simple implementation
❌ Fixed size
❌ Index-based access only

COMMON PATTERNS:
1. Frequency counting - count occurrences
2. Two pointer optimization - find pairs/triplets
3. Sliding window - track elements in window
4. Caching/memoization - store computed results
5. Set operations - union, intersection

INTERVIEW PROBLEMS:
- Two Sum (LeetCode #1)
- Valid Anagram (LeetCode #242)
- First Unique Character (LeetCode #387)
- Longest Substring Without Repeating Characters (LeetCode #3)
- Group Anagrams (LeetCode #49)
- Contains Duplicate (LeetCode #217)

TIPS FOR INTERVIEWS:
- Consider hash table when you need fast lookups
- Use frequency counting for duplicate problems
- HashMap vs HashSet - choose based on needs
- Handle null keys/values appropriately
- Consider time/space trade-offs
*/