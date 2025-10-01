/**
 * Practice Exercises - Test your understanding!
 * 
 * Try to solve these problems before looking at the solutions
 */

public class PracticeExercises {
    
    public static void main(String[] args) {
        System.out.println("=== Practice Time! ===\n");
        System.out.println("Try to solve these problems step by step:");
        System.out.println("1. Run each test to see the expected output");
        System.out.println("2. Try to implement the solution yourself");
        System.out.println("3. Compare with the provided solution\n");
        
        testAllExercises();
    }
    
    public static void testAllExercises() {
        // Test each exercise
        exercise1_FindMaximum();
        exercise2_ReverseArray();
        exercise3_IsPalindrome();
        exercise4_TwoSum();
        exercise5_RemoveVowels();
        exercise6_CountWords();
        exercise7_IsSorted();
        exercise8_FindSecondLargest();
    }
    
    /**
     * EXERCISE 1: Find Maximum Element in Array
     * Write a method that finds the maximum element in an integer array
     */
    public static void exercise1_FindMaximum() {
        System.out.println("=== Exercise 1: Find Maximum ===");
        int[] arr = {3, 7, 1, 9, 4, 2, 8};
        System.out.print("Array: ");
        printArray(arr);
        
        int max = findMaximum(arr);
        System.out.println("Maximum: " + max);
        System.out.println("Expected: 9\n");
    }
    
    // TODO: Implement this method
    public static int findMaximum(int[] arr) {
        // YOUR CODE HERE
        // Hint: Start with first element, compare with rest
        
        // Solution:
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    
    /**
     * EXERCISE 2: Reverse Array In-Place
     * Write a method that reverses an array without creating a new array
     */
    public static void exercise2_ReverseArray() {
        System.out.println("=== Exercise 2: Reverse Array ===");
        int[] arr = {1, 2, 3, 4, 5};
        System.out.print("Before: ");
        printArray(arr);
        
        reverseArray(arr);
        System.out.print("After: ");
        printArray(arr);
        System.out.println("Expected: [5, 4, 3, 2, 1]\n");
    }
    
    // TODO: Implement this method
    public static void reverseArray(int[] arr) {
        // YOUR CODE HERE
        // Hint: Use two pointers, swap elements
        
        // Solution:
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    
    /**
     * EXERCISE 3: Check if String is Palindrome
     * Write a method that checks if a string reads the same forwards and backwards
     */
    public static void exercise3_IsPalindrome() {
        System.out.println("=== Exercise 3: Is Palindrome ===");
        String[] testStrings = {"racecar", "hello", "madam", "java"};
        
        for (String str : testStrings) {
            boolean result = isPalindrome(str);
            System.out.println("'" + str + "' is palindrome: " + result);
        }
        System.out.println("Expected: true, false, true, false\n");
    }
    
    // TODO: Implement this method
    public static boolean isPalindrome(String str) {
        // YOUR CODE HERE
        // Hint: Compare characters from both ends moving inward
        
        // Solution:
        int left = 0;
        int right = str.length() - 1;
        
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    /**
     * EXERCISE 4: Two Sum Problem
     * Find two numbers in array that add up to target
     */
    public static void exercise4_TwoSum() {
        System.out.println("=== Exercise 4: Two Sum ===");
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        System.out.print("Array: ");
        printArray(arr);
        System.out.println("Target: " + target);
        
        int[] result = twoSum(arr, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
        System.out.println("Expected: [0, 1]\n");
    }
    
    // TODO: Implement this method
    public static int[] twoSum(int[] arr, int target) {
        // YOUR CODE HERE
        // Hint: Use nested loops to check all pairs
        
        // Solution:
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
    
    /**
     * EXERCISE 5: Remove Vowels from String
     * Create a new string with all vowels removed
     */
    public static void exercise5_RemoveVowels() {
        System.out.println("=== Exercise 5: Remove Vowels ===");
        String input = "Hello World";
        System.out.println("Input: " + input);
        
        String result = removeVowels(input);
        System.out.println("Output: " + result);
        System.out.println("Expected: Hll Wrld\n");
    }
    
    // TODO: Implement this method
    public static String removeVowels(String str) {
        // YOUR CODE HERE
        // Hint: Use StringBuilder, check each character
        
        // Solution:
        StringBuilder result = new StringBuilder();
        String vowels = "aeiouAEIOU";
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (vowels.indexOf(ch) == -1) {  // Not a vowel
                result.append(ch);
            }
        }
        return result.toString();
    }
    
    /**
     * EXERCISE 6: Count Words in String
     * Count the number of words in a string (words separated by spaces)
     */
    public static void exercise6_CountWords() {
        System.out.println("=== Exercise 6: Count Words ===");
        String input = "Java is awesome for programming";
        System.out.println("Input: '" + input + "'");
        
        int count = countWords(input);
        System.out.println("Word count: " + count);
        System.out.println("Expected: 5\n");
    }
    
    // TODO: Implement this method
    public static int countWords(String str) {
        // YOUR CODE HERE
        // Hint: Split by spaces or count transitions from space to non-space
        
        // Solution:
        if (str == null || str.trim().isEmpty()) {
            return 0;
        }
        
        String[] words = str.trim().split("\\s+");
        return words.length;
    }
    
    /**
     * EXERCISE 7: Check if Array is Sorted
     * Determine if array is sorted in ascending order
     */
    public static void exercise7_IsSorted() {
        System.out.println("=== Exercise 7: Is Array Sorted ===");
        int[][] testArrays = {
            {1, 2, 3, 4, 5},
            {5, 4, 3, 2, 1},
            {1, 3, 2, 4, 5}
        };
        
        for (int[] arr : testArrays) {
            System.out.print("Array: ");
            printArray(arr);
            boolean result = isSorted(arr);
            System.out.println("Is sorted: " + result);
        }
        System.out.println("Expected: true, false, false\n");
    }
    
    // TODO: Implement this method
    public static boolean isSorted(int[] arr) {
        // YOUR CODE HERE
        // Hint: Compare each element with the next one
        
        // Solution:
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * EXERCISE 8: Find Second Largest Element
     * Find the second largest element in the array
     */
    public static void exercise8_FindSecondLargest() {
        System.out.println("=== Exercise 8: Find Second Largest ===");
        int[] arr = {3, 7, 1, 9, 4, 2, 8};
        System.out.print("Array: ");
        printArray(arr);
        
        int secondLargest = findSecondLargest(arr);
        System.out.println("Second largest: " + secondLargest);
        System.out.println("Expected: 8\n");
    }
    
    // TODO: Implement this method
    public static int findSecondLargest(int[] arr) {
        // YOUR CODE HERE
        // Hint: Keep track of largest and second largest while iterating
        
        // Solution:
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        
        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }
        
        return secondLargest;
    }
    
    /**
     * Helper method to print array
     */
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

/*
PRACTICE STRATEGY:

1. READ THE PROBLEM CAREFULLY
   - Understand what's being asked
   - Identify inputs and expected outputs
   - Think about edge cases

2. PLAN YOUR APPROACH
   - Write pseudocode first
   - Think about time and space complexity
   - Consider different approaches

3. IMPLEMENT STEP BY STEP
   - Start with the simplest approach
   - Test with given examples
   - Handle edge cases

4. OPTIMIZE IF NEEDED
   - Look for redundant operations
   - Consider better algorithms
   - Balance time vs space complexity

NEXT STEPS:
- Try solving these without looking at solutions
- Create your own variations
- Time yourself to build speed
- Practice explaining your approach out loud

COMMON MISTAKES TO AVOID:
- Not checking array bounds
- Forgetting edge cases (empty arrays, single elements)
- Using == instead of .equals() for strings
- Off-by-one errors in loops
- Not handling null inputs

Keep practicing! The more problems you solve, the better you'll become! 🚀
*/