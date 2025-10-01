/**
 * Java Basics - Variables and Data Types
 * 
 * This file covers all essential data types you'll use in DSA
 */

public class JavaBasics {
    
    public static void main(String[] args) {
        System.out.println("=== Java Data Types for DSA ===\n");
        
        // 1. INTEGER TYPES - Most commonly used in DSA
        int number = 42;                    // Most common for array indices, counters
        long bigNumber = 1000000000L;       // For large numbers (use L suffix)
        
        System.out.println("Integer: " + number);
        System.out.println("Long: " + bigNumber);
        
        // 2. FLOATING POINT - Less common in DSA but important
        double decimal = 3.14159;           // For calculations requiring precision
        
        System.out.println("Double: " + decimal);
        
        // 3. CHARACTER AND BOOLEAN
        char letter = 'A';                  // Single character (useful for string problems)
        boolean isTrue = true;              // For conditions and flags
        
        System.out.println("Character: " + letter);
        System.out.println("Boolean: " + isTrue);
        
        // 4. STRINGS - Very important for DSA
        String text = "Hello DSA";          // Sequence of characters
        
        System.out.println("String: " + text);
        System.out.println("String length: " + text.length());
        
        // 5. ARRAYS - The foundation of DSA
        int[] numbers = {1, 2, 3, 4, 5};    // Fixed size collection
        
        System.out.println("\n=== Array Basics ===");
        System.out.println("Array length: " + numbers.length);
        System.out.println("First element: " + numbers[0]);
        System.out.println("Last element: " + numbers[numbers.length - 1]);
        
        // Printing all elements
        System.out.print("All elements: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
        
        // Enhanced for loop (for-each) - cleaner but no index access
        System.out.print("Using for-each: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // 6. COMMON OPERATIONS YOU'LL USE
        demonstrateCommonOperations();
    }
    
    /**
     * Common operations you'll use in DSA problems
     */
    public static void demonstrateCommonOperations() {
        System.out.println("\n=== Common DSA Operations ===");
        
        // Math operations
        int a = 10, b = 3;
        System.out.println("Division: " + a / b);          // Integer division: 3
        System.out.println("Remainder: " + a % b);         // Modulo: 1
        System.out.println("Max: " + Math.max(a, b));      // Maximum
        System.out.println("Min: " + Math.min(a, b));      // Minimum
        System.out.println("Absolute: " + Math.abs(-5));   // Absolute value
        
        // String operations
        String str = "leetcode";
        System.out.println("Character at index 0: " + str.charAt(0));
        System.out.println("Substring (0 to 4): " + str.substring(0, 4));
        
        // Type conversion (very important!)
        char digit = '5';
        int digitValue = digit - '0';  // Convert char digit to int
        System.out.println("Char '5' to int: " + digitValue);
        
        int intValue = 7;
        char intToChar = (char)(intValue + '0');  // Convert int to char
        System.out.println("Int 7 to char: " + intToChar);
    }
}

/*
KEY TAKEAWAYS FOR DSA:

1. int: Use for array indices, counters, most numeric operations
2. long: Use when numbers might exceed int range (2^31)
3. char: Important for string manipulation problems
4. boolean: For flags and conditions
5. String: Essential for text processing problems
6. Arrays: Foundation of most data structures

MEMORY TIPS:
- int range: -2^31 to 2^31-1 (about -2 billion to 2 billion)
- Array indexing starts at 0
- String.charAt(i) gets character at index i
- Math.max(), Math.min(), Math.abs() are your friends
- char to int: subtract '0'
- int to char: add '0' and cast to char
*/