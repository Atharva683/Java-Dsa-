# Java DSA Quick Reference Cheat Sheet 📋

## 🔤 Basic Syntax Reminders

### Variable Declaration
```java
int number = 42;
long bigNumber = 1000000000L;
double decimal = 3.14;
char letter = 'A';
boolean flag = true;
String text = "Hello";
```

### Array Operations
```java
// Declaration
int[] arr = {1, 2, 3, 4, 5};
int[] arr2 = new int[5];

// Access
int first = arr[0];
int last = arr[arr.length - 1];

// Length
int size = arr.length;

// Common loops
for (int i = 0; i < arr.length; i++) { /* forward */ }
for (int i = arr.length - 1; i >= 0; i--) { /* reverse */ }
for (int num : arr) { /* for-each */ }
```

### String Operations
```java
String str = "Hello World";
int len = str.length();
char ch = str.charAt(0);
String sub = str.substring(0, 5);
boolean contains = str.contains("World");
String[] parts = str.split(" ");

// StringBuilder for efficiency
StringBuilder sb = new StringBuilder();
sb.append("Hello").append(" World");
String result = sb.toString();
```

## ⚡ Time Complexity Cheat Sheet

### Array Operations
- **Access**: O(1)
- **Search**: O(n)
- **Insert**: O(n) - need to shift elements
- **Delete**: O(n) - need to shift elements

### String Operations
- **Access**: O(1)
- **Length**: O(1)
- **Substring**: O(n)
- **Concatenation**: O(n)
- **Search**: O(n)

### Common Algorithms
- **Linear Search**: O(n)
- **Binary Search**: O(log n) - sorted array only
- **Bubble Sort**: O(n²)
- **Selection Sort**: O(n²)
- **Insertion Sort**: O(n²)

## 🎯 Common Problem Patterns

### Two Pointers
```java
int left = 0, right = arr.length - 1;
while (left < right) {
    // Process arr[left] and arr[right]
    left++;
    right--;
}
```

### Sliding Window
```java
int windowStart = 0;
for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
    // Expand window
    while (/* condition to shrink */) {
        // Shrink window
        windowStart++;
    }
}
```

### Frequency Counter
```java
int[] count = new int[26]; // for lowercase letters
for (char c : str.toCharArray()) {
    count[c - 'a']++;
}
```

## 🔍 Problem-Solving Templates

### Array Problem Template
```java
public int[] solve(int[] nums) {
    // 1. Handle edge cases
    if (nums == null || nums.length == 0) return new int[0];
    
    // 2. Initialize variables
    int result = 0;
    
    // 3. Main logic
    for (int i = 0; i < nums.length; i++) {
        // Process nums[i]
    }
    
    // 4. Return result
    return new int[]{result};
}
```

### String Problem Template
```java
public String solve(String s) {
    // 1. Handle edge cases
    if (s == null || s.length() == 0) return "";
    
    // 2. Convert to char array if needed
    char[] chars = s.toCharArray();
    
    // 3. Use StringBuilder for building result
    StringBuilder result = new StringBuilder();
    
    // 4. Main logic
    for (int i = 0; i < chars.length; i++) {
        // Process chars[i]
    }
    
    // 5. Return result
    return result.toString();
}
```

## 🚀 LeetCode Problem Categories

### Easy Arrays (Start Here!)
1. **Two Sum** - Hash map or brute force
2. **Remove Duplicates** - Two pointers
3. **Plus One** - Handle carry
4. **Move Zeroes** - Two pointers
5. **Contains Duplicate** - Set or sorting

### Easy Strings (Foundation)
1. **Valid Palindrome** - Two pointers
2. **Valid Anagram** - Frequency count
3. **Reverse String** - Two pointers
4. **First Unique Character** - Frequency count
5. **Implement strStr()** - Pattern matching

### Medium (Next Level)
1. **Maximum Subarray** - Kadane's algorithm
2. **Rotate Array** - Reverse technique
3. **Container With Most Water** - Two pointers
4. **Longest Substring Without Repeating** - Sliding window
5. **Group Anagrams** - Hash map with sorted keys

## 🔧 Debugging Tips

### Common Errors
- **ArrayIndexOutOfBoundsException**: Check `i < arr.length`
- **NullPointerException**: Check `str != null` before operations
- **Infinite Loops**: Ensure loop variables are modified
- **Off-by-one**: Check boundary conditions

### Testing Strategy
```java
// Test edge cases
int[] empty = {};
int[] single = {1};
int[] duplicate = {1, 1, 1};
String nullStr = null;
String emptyStr = "";
String singleChar = "a";
```

## 📊 Space vs Time Trade-offs

### When to prioritize time:
- Large datasets
- Repeated operations
- Real-time systems

### When to prioritize space:
- Memory-constrained environments
- One-time operations
- Simple solutions preferred

## 🎨 Code Style Best Practices

### Naming Conventions
```java
// Variables: camelCase
int maxValue, currentIndex, isFound;

// Methods: camelCase with verbs
public boolean isPalindrome() { }
public int findMaximum() { }

// Constants: UPPER_SNAKE_CASE
public static final int MAX_SIZE = 100;
```

### Method Structure
```java
/**
 * Brief description of what method does
 * @param parameter description
 * @return description of return value
 */
public int methodName(int parameter) {
    // Input validation
    if (parameter < 0) {
        throw new IllegalArgumentException("Parameter must be non-negative");
    }
    
    // Main logic with clear variable names
    int result = 0;
    
    // Return meaningful result
    return result;
}
```

## 🏆 Interview Success Formula

### Before Coding:
1. **Clarify requirements** - Ask questions!
2. **Think out loud** - Explain your approach
3. **Consider edge cases** - Empty inputs, single elements
4. **Estimate complexity** - Time and space

### While Coding:
1. **Start simple** - Brute force is okay initially
2. **Write clean code** - Readable variable names
3. **Test as you go** - Verify with small examples
4. **Optimize if needed** - Only after working solution

### After Coding:
1. **Walk through example** - Trace your code
2. **Discuss complexity** - Big O analysis
3. **Suggest improvements** - Alternative approaches
4. **Handle follow-ups** - What if constraints change?

---

**Remember**: Practice consistently, understand patterns, and don't memorize solutions! 💪

**Good luck with your DSA journey!** 🌟