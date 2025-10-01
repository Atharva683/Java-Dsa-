/**
 * String Fundamentals - Master the basics of string manipulation
 * 
 * Understanding strings is crucial for many programming problems
 */

public class StringFundamentals {
    
    public static void main(String[] args) {
        System.out.println("=== String Fundamentals ===\n");
        
        stringBasics();
        stringOperations();
        characterOperations();
        stringComparison();
        stringBuilderDemo();
    }
    
    /**
     * STRING BASICS - Creation and properties
     */
    public static void stringBasics() {
        System.out.println("=== String Basics ===");
        
        // Different ways to create strings
        String str1 = "Hello";                    // String literal (recommended)
        String str2 = new String("Hello");        // Using constructor
        String str3 = "Hello";                    // Same literal
        
        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);
        System.out.println("str3: " + str3);
        
        // String pool demonstration
        System.out.println("str1 == str3: " + (str1 == str3));  // true (same reference)
        System.out.println("str1 == str2: " + (str1 == str2));  // false (different objects)
        System.out.println("str1.equals(str2): " + str1.equals(str2));  // true (same content)
        
        // String properties
        String text = "Programming";
        System.out.println("Length: " + text.length());
        System.out.println("Is empty: " + text.isEmpty());
        System.out.println("Character at index 4: " + text.charAt(4));
        
        // Immutability demonstration
        String original = "Java";
        String modified = original.concat(" Programming");
        System.out.println("Original: " + original);        // Still "Java"
        System.out.println("Modified: " + modified);        // "Java Programming"
        
        System.out.println();
    }
    
    /**
     * COMMON STRING OPERATIONS
     */
    public static void stringOperations() {
        System.out.println("=== String Operations ===");
        
        String text = "  Hello World Programming  ";
        System.out.println("Original: '" + text + "'");
        
        // Basic operations
        System.out.println("Length: " + text.length());
        System.out.println("Upper case: " + text.toUpperCase());
        System.out.println("Lower case: " + text.toLowerCase());
        System.out.println("Trimmed: '" + text.trim() + "'");
        
        // Substring operations
        String trimmed = text.trim();
        System.out.println("Substring(0, 5): '" + trimmed.substring(0, 5) + "'");
        System.out.println("Substring(6): '" + trimmed.substring(6) + "'");
        
        // Search operations
        System.out.println("Index of 'World': " + trimmed.indexOf("World"));
        System.out.println("Last index of 'o': " + trimmed.lastIndexOf('o'));
        System.out.println("Contains 'Program': " + trimmed.contains("Program"));
        System.out.println("Starts with 'Hello': " + trimmed.startsWith("Hello"));
        System.out.println("Ends with 'ing': " + trimmed.endsWith("ing"));
        
        // Replace operations
        System.out.println("Replace 'o' with '0': " + trimmed.replace('o', '0'));
        System.out.println("Replace 'World' with 'Java': " + trimmed.replace("World", "Java"));
        
        // Split operation
        String sentence = "apple,banana,cherry,date";
        String[] fruits = sentence.split(",");
        System.out.print("Split result: ");
        for (String fruit : fruits) {
            System.out.print("'" + fruit + "' ");
        }
        System.out.println();
        
        System.out.println();
    }
    
    /**
     * CHARACTER OPERATIONS - Working with individual characters
     */
    public static void characterOperations() {
        System.out.println("=== Character Operations ===");
        
        String text = "Hello123!";
        System.out.println("Text: " + text);
        
        // Analyze each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            System.out.print("'" + ch + "' -> ");
            
            if (Character.isLetter(ch)) {
                System.out.print("Letter");
                if (Character.isUpperCase(ch)) {
                    System.out.print(" (Upper)");
                } else {
                    System.out.print(" (Lower)");
                }
            } else if (Character.isDigit(ch)) {
                System.out.print("Digit");
            } else {
                System.out.print("Special");
            }
            
            System.out.println(" ASCII: " + (int)ch);
        }
        
        // Character conversion examples
        System.out.println("\n--- Character Conversions ---");
        char digit = '7';
        int digitValue = digit - '0';  // Convert char digit to int
        System.out.println("Char '" + digit + "' to int: " + digitValue);
        
        int number = 5;
        char numberChar = (char)(number + '0');  // Convert int to char digit
        System.out.println("Int " + number + " to char: '" + numberChar + "'");
        
        char lower = 'a';
        char upper = Character.toUpperCase(lower);
        System.out.println("'" + lower + "' to upper: '" + upper + "'");
        
        // ASCII difference approach
        char lowerB = 'b';
        char upperB = (char)(lowerB - 'a' + 'A');  // Convert using ASCII difference
        System.out.println("'" + lowerB + "' to upper (ASCII): '" + upperB + "'");
        
        System.out.println();
    }
    
    /**
     * STRING COMPARISON - Different ways to compare strings
     */
    public static void stringComparison() {
        System.out.println("=== String Comparison ===");
        
        String str1 = "apple";
        String str2 = "Apple";
        String str3 = "banana";
        String str4 = "apple";
        
        // Content comparison (case-sensitive)
        System.out.println("'" + str1 + "'.equals('" + str2 + "'): " + str1.equals(str2));
        System.out.println("'" + str1 + "'.equals('" + str4 + "'): " + str1.equals(str4));
        
        // Case-insensitive comparison
        System.out.println("'" + str1 + "'.equalsIgnoreCase('" + str2 + "'): " + str1.equalsIgnoreCase(str2));
        
        // Lexicographic comparison (dictionary order)
        System.out.println("'" + str1 + "'.compareTo('" + str3 + "'): " + str1.compareTo(str3));  // negative
        System.out.println("'" + str3 + "'.compareTo('" + str1 + "'): " + str3.compareTo(str1));  // positive
        System.out.println("'" + str1 + "'.compareTo('" + str4 + "'): " + str1.compareTo(str4));  // zero
        
        // Case-insensitive lexicographic comparison
        System.out.println("'" + str1 + "'.compareToIgnoreCase('" + str2 + "'): " + str1.compareToIgnoreCase(str2));
        
        // Demonstration of sorting strings
        String[] words = {"banana", "apple", "Cherry", "date"};
        System.out.print("Original: ");
        printStringArray(words);
        
        // Sort using compareTo (case-sensitive)
        java.util.Arrays.sort(words);
        System.out.print("Sorted: ");
        printStringArray(words);
        
        System.out.println();
    }
    
    /**
     * STRINGBUILDER - Efficient string building
     */
    public static void stringBuilderDemo() {
        System.out.println("=== StringBuilder Demo ===");
        
        // Problem: Building string with concatenation (inefficient)
        String result1 = "";
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            result1 += "a";  // Creates new string object each time!
        }
        long stringTime = System.nanoTime() - startTime;
        
        // Solution: Using StringBuilder (efficient)
        StringBuilder sb = new StringBuilder();
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            sb.append("a");  // Modifies existing buffer
        }
        String result2 = sb.toString();
        long sbTime = System.nanoTime() - startTime;
        
        System.out.println("String concatenation time: " + stringTime + " ns");
        System.out.println("StringBuilder time: " + sbTime + " ns");
        System.out.println("StringBuilder is " + (stringTime / sbTime) + "x faster!");
        System.out.println("Both results equal: " + result1.equals(result2));
        
        // StringBuilder operations
        StringBuilder builder = new StringBuilder("Hello");
        System.out.println("Initial: " + builder.toString());
        
        builder.append(" World");
        System.out.println("After append: " + builder.toString());
        
        builder.insert(5, " Java");
        System.out.println("After insert: " + builder.toString());
        
        builder.delete(5, 10);
        System.out.println("After delete: " + builder.toString());
        
        builder.reverse();
        System.out.println("After reverse: " + builder.toString());
        
        // Building complex strings
        StringBuilder complex = new StringBuilder();
        complex.append("Numbers: ");
        for (int i = 1; i <= 5; i++) {
            complex.append(i);
            if (i < 5) {
                complex.append(", ");
            }
        }
        System.out.println("Complex string: " + complex.toString());
        
        System.out.println();
    }
    
    /**
     * Helper method to print string array
     */
    public static void printStringArray(String[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("'" + arr[i] + "'");
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

/*
KEY STRING CONCEPTS:

IMMUTABILITY:
- Strings cannot be changed after creation
- Operations like concat(), replace() create new strings
- Use StringBuilder for multiple modifications

STRING POOL:
- Java stores string literals in a special memory area
- Same literals share the same object (memory optimization)
- Use equals() for content comparison, not ==

COMMON OPERATIONS COMPLEXITY:
- charAt(i): O(1)
- length(): O(1)
- substring(): O(n)
- indexOf(): O(n)
- concat(): O(n)

CHARACTER OPERATIONS:
- char to int: subtract '0'
- int to char: add '0' and cast
- Case conversion: use Character methods or ASCII math

STRINGBUILDER BENEFITS:
- Mutable buffer for building strings
- append(), insert(), delete() operations
- Much faster than repeated concatenation
- Use when building strings in loops

INTERVIEW TIPS:
- Always validate input (null, empty strings)
- Consider case sensitivity requirements
- Think about Unicode vs ASCII
- Choose appropriate data structure (String vs StringBuilder vs char[])
*/