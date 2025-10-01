/**
 * Control Structures - The building blocks of algorithms
 * 
 * Mastering these is crucial for implementing any algorithm
 */

public class ControlStructures {
    
    public static void main(String[] args) {
        System.out.println("=== Control Structures for DSA ===\n");
        
        // Sample array for demonstrations
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        
        demonstrateConditions(arr);
        demonstrateLoops(arr);
        demonstrateNestedLoops();
        demonstrateBreakContinue();
    }
    
    /**
     * IF-ELSE CONDITIONS - Decision making in algorithms
     */
    public static void demonstrateConditions(int[] arr) {
        System.out.println("=== Conditional Statements ===");
        
        // Find maximum element
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {  // Simple if condition
                max = arr[i];
            }
        }
        System.out.println("Maximum element: " + max);
        
        // Classify numbers as even/odd
        System.out.print("Even numbers: ");
        for (int num : arr) {
            if (num % 2 == 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
        
        // Multiple conditions with else-if
        System.out.println("Number classification:");
        for (int num : arr) {
            if (num < 20) {
                System.out.println(num + " is small");
            } else if (num < 50) {
                System.out.println(num + " is medium");
            } else {
                System.out.println(num + " is large");
            }
        }
        System.out.println();
    }
    
    /**
     * LOOPS - Essential for traversing data structures
     */
    public static void demonstrateLoops(int[] arr) {
        System.out.println("=== Loop Structures ===");
        
        // 1. FOR LOOP - Most common in DSA
        System.out.print("Forward traversal: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        
        // Reverse traversal - very common pattern
        System.out.print("Reverse traversal: ");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        
        // 2. WHILE LOOP - Useful when condition is not index-based
        System.out.print("Elements > 30: ");
        int i = 0;
        while (i < arr.length) {
            if (arr[i] > 30) {
                System.out.print(arr[i] + " ");
            }
            i++;
        }
        System.out.println();
        
        // 3. FOR-EACH LOOP - Clean but no index access
        System.out.print("All elements (for-each): ");
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println("\n");
    }
    
    /**
     * NESTED LOOPS - Common in many algorithms
     */
    public static void demonstrateNestedLoops() {
        System.out.println("=== Nested Loops ===");
        
        int[] arr = {3, 1, 4, 1, 5};
        
        // Example 1: Compare all pairs (useful for many problems)
        System.out.println("All pairs:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.println("(" + arr[i] + ", " + arr[j] + ")");
            }
        }
        
        // Example 2: Bubble sort pattern
        System.out.println("Bubble sort visualization:");
        int[] sortArr = arr.clone(); // Copy array
        
        for (int i = 0; i < sortArr.length - 1; i++) {
            for (int j = 0; j < sortArr.length - 1 - i; j++) {
                if (sortArr[j] > sortArr[j + 1]) {
                    // Swap elements
                    int temp = sortArr[j];
                    sortArr[j] = sortArr[j + 1];
                    sortArr[j + 1] = temp;
                    
                    System.out.print("After swap: ");
                    printArray(sortArr);
                }
            }
        }
        System.out.println();
    }
    
    /**
     * BREAK and CONTINUE - Control loop execution
     */
    public static void demonstrateBreakContinue() {
        System.out.println("=== Break and Continue ===");
        
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        // BREAK - Exit loop early
        System.out.print("Numbers until first number > 5: ");
        for (int num : arr) {
            if (num > 5) {
                break;  // Exit the loop completely
            }
            System.out.print(num + " ");
        }
        System.out.println();
        
        // CONTINUE - Skip current iteration
        System.out.print("Only odd numbers: ");
        for (int num : arr) {
            if (num % 2 == 0) {
                continue;  // Skip even numbers
            }
            System.out.print(num + " ");
        }
        System.out.println();
        
        // Real DSA example: Linear search with early termination
        int target = 6;
        int position = linearSearch(arr, target);
        if (position != -1) {
            System.out.println("Found " + target + " at position " + position);
        } else {
            System.out.println(target + " not found");
        }
    }
    
    /**
     * Linear Search - A classic algorithm using control structures
     */
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;  // Found! Return index
            }
        }
        return -1;  // Not found
    }
    
    /**
     * Helper method to print array
     */
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

/*
ESSENTIAL PATTERNS FOR DSA:

1. SINGLE LOOP PATTERNS:
   - Forward: for(int i = 0; i < n; i++)
   - Reverse: for(int i = n-1; i >= 0; i--)
   - Two pointers: left++, right--

2. NESTED LOOP PATTERNS:
   - All pairs: for(i=0; i<n; i++) for(j=i+1; j<n; j++)
   - Matrix traversal: for(i=0; i<rows; i++) for(j=0; j<cols; j++)
   - Sorting algorithms: outer loop for passes, inner for comparisons

3. WHILE LOOP PATTERNS:
   - Binary search: while(left <= right)
   - Linked list traversal: while(node != null)
   - Two pointers: while(left < right)

4. BREAK/CONTINUE USAGE:
   - Early termination in searches
   - Skipping invalid cases
   - Optimizing nested loops

PRACTICE PROBLEMS:
1. Find second largest element in array
2. Check if array is sorted
3. Count vowels in a string
4. Print all prime numbers up to n
*/