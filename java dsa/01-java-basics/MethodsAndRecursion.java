/**
 * Methods and Recursion - Breaking down complex problems
 * 
 * Methods help organize code and recursion solves many DSA problems elegantly
 */

public class MethodsAndRecursion {
    
    public static void main(String[] args) {
        System.out.println("=== Methods and Recursion in DSA ===\n");
        
        demonstrateMethods();
        demonstrateRecursion();
        recursionVsIteration();
    }
    
    /**
     * METHODS - Essential for clean, reusable code
     */
    public static void demonstrateMethods() {
        System.out.println("=== Method Examples ===");
        
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        
        // Method with return value
        int sum = calculateSum(arr);
        System.out.println("Sum of array: " + sum);
        
        // Method with multiple parameters
        int max = findMaxInRange(arr, 1, 5);
        System.out.println("Max in range [1,5]: " + max);
        
        // Method that modifies array
        reverseArray(arr);
        System.out.print("Reversed array: ");
        printArray(arr);
        
        // Method that returns boolean
        boolean isSorted = isSortedAscending(arr);
        System.out.println("Is array sorted? " + isSorted);
        
        System.out.println();
    }
    
    /**
     * Calculate sum of all elements in array
     */
    public static int calculateSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
    
    /**
     * Find maximum element in a specific range
     */
    public static int findMaxInRange(int[] arr, int start, int end) {
        // Boundary checking - very important in DSA!
        if (start < 0 || end >= arr.length || start > end) {
            throw new IllegalArgumentException("Invalid range");
        }
        
        int max = arr[start];
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    
    /**
     * Reverse array in place
     */
    public static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            // Swap elements
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            
            left++;
            right--;
        }
    }
    
    /**
     * Check if array is sorted in ascending order
     */
    public static boolean isSortedAscending(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * RECURSION - Solving problems by breaking them into smaller subproblems
     */
    public static void demonstrateRecursion() {
        System.out.println("=== Recursion Examples ===");
        
        // Factorial
        int n = 5;
        System.out.println(n + "! = " + factorial(n));
        
        // Fibonacci
        System.out.print("Fibonacci sequence (first 10): ");
        for (int i = 0; i < 10; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();
        
        // Sum of array using recursion
        int[] arr = {1, 2, 3, 4, 5};
        int sum = recursiveSum(arr, 0);
        System.out.println("Recursive sum: " + sum);
        
        // Binary search
        int[] sortedArr = {1, 3, 5, 7, 9, 11, 13, 15};
        int target = 7;
        int index = binarySearch(sortedArr, target, 0, sortedArr.length - 1);
        System.out.println("Binary search for " + target + ": index " + index);
        
        // Power calculation
        int base = 2, exponent = 8;
        long result = power(base, exponent);
        System.out.println(base + "^" + exponent + " = " + result);
        
        System.out.println();
    }
    
    /**
     * Factorial using recursion
     * Base case: factorial(0) = 1
     * Recursive case: factorial(n) = n * factorial(n-1)
     */
    public static int factorial(int n) {
        // Base case
        if (n <= 1) {
            return 1;
        }
        // Recursive case
        return n * factorial(n - 1);
    }
    
    /**
     * Fibonacci using recursion
     * Base cases: fib(0) = 0, fib(1) = 1
     * Recursive case: fib(n) = fib(n-1) + fib(n-2)
     */
    public static int fibonacci(int n) {
        // Base cases
        if (n <= 1) {
            return n;
        }
        // Recursive case
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    /**
     * Sum of array using recursion
     */
    public static int recursiveSum(int[] arr, int index) {
        // Base case: reached end of array
        if (index >= arr.length) {
            return 0;
        }
        // Recursive case: current element + sum of rest
        return arr[index] + recursiveSum(arr, index + 1);
    }
    
    /**
     * Binary search using recursion
     */
    public static int binarySearch(int[] arr, int target, int left, int right) {
        // Base case: element not found
        if (left > right) {
            return -1;
        }
        
        int mid = left + (right - left) / 2;  // Avoid overflow
        
        // Base case: element found
        if (arr[mid] == target) {
            return mid;
        }
        
        // Recursive cases
        if (target < arr[mid]) {
            return binarySearch(arr, target, left, mid - 1);
        } else {
            return binarySearch(arr, target, mid + 1, right);
        }
    }
    
    /**
     * Power calculation using recursion (fast exponentiation)
     */
    public static long power(int base, int exponent) {
        // Base case
        if (exponent == 0) {
            return 1;
        }
        
        // Recursive case with optimization
        long half = power(base, exponent / 2);
        
        if (exponent % 2 == 0) {
            return half * half;
        } else {
            return base * half * half;
        }
    }
    
    /**
     * RECURSION VS ITERATION comparison
     */
    public static void recursionVsIteration() {
        System.out.println("=== Recursion vs Iteration ===");
        
        int n = 10;
        
        // Measure time for recursive factorial
        long startTime = System.nanoTime();
        int recursiveResult = factorial(n);
        long recursiveTime = System.nanoTime() - startTime;
        
        // Measure time for iterative factorial
        startTime = System.nanoTime();
        int iterativeResult = factorialIterative(n);
        long iterativeTime = System.nanoTime() - startTime;
        
        System.out.println("Factorial of " + n + ":");
        System.out.println("Recursive: " + recursiveResult + " (Time: " + recursiveTime + " ns)");
        System.out.println("Iterative: " + iterativeResult + " (Time: " + iterativeTime + " ns)");
        
        // Fibonacci comparison (more dramatic difference)
        n = 30;
        System.out.println("\nFibonacci of " + n + ":");
        
        startTime = System.nanoTime();
        int fibRecursive = fibonacci(n);
        long fibRecursiveTime = System.nanoTime() - startTime;
        
        startTime = System.nanoTime();
        int fibIterative = fibonacciIterative(n);
        long fibIterativeTime = System.nanoTime() - startTime;
        
        System.out.println("Recursive: " + fibRecursive + " (Time: " + fibRecursiveTime + " ns)");
        System.out.println("Iterative: " + fibIterative + " (Time: " + fibIterativeTime + " ns)");
        System.out.println("Iterative is " + (fibRecursiveTime / fibIterativeTime) + "x faster!");
    }
    
    /**
     * Iterative factorial for comparison
     */
    public static int factorialIterative(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    /**
     * Iterative fibonacci for comparison
     */
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        
        int prev1 = 0, prev2 = 1;
        int current = 0;
        
        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
        }
        
        return current;
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
KEY CONCEPTS:

METHOD DESIGN PRINCIPLES:
1. Single Responsibility: Each method should do one thing well
2. Clear naming: Method name should describe what it does
3. Parameter validation: Check for invalid inputs
4. Return appropriate values: -1 for "not found", boolean for yes/no

RECURSION ESSENTIALS:
1. Base Case: Condition to stop recursion (prevents infinite loop)
2. Recursive Case: Problem broken into smaller subproblem
3. Progress: Each recursive call should move toward base case

WHEN TO USE RECURSION:
✅ Tree/graph traversal
✅ Divide and conquer algorithms
✅ Backtracking problems
✅ Mathematical sequences

WHEN TO AVOID RECURSION:
❌ Simple iterations (use loops instead)
❌ Deep recursion (stack overflow risk)
❌ Performance-critical code (iterative often faster)

RECURSION PATTERNS:
1. Linear recursion: f(n) calls f(n-1)
2. Binary recursion: f(n) calls f(n/2) twice
3. Multiple recursion: f(n) calls f(n-1) and f(n-2)

PRACTICE PROBLEMS:
1. Tower of Hanoi
2. Generate all subsets
3. Tree traversals
4. Permutations and combinations
*/