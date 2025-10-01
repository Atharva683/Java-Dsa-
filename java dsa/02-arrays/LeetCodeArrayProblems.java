/**
 * LeetCode Array Problems - Practice makes perfect!
 * 
 * These are actual interview questions you'll encounter
 */

public class LeetCodeArrayProblems {
    
    public static void main(String[] args) {
        System.out.println("=== LeetCode Array Problems ===\n");
        
        solveTwoSum();
        solveRemoveDuplicates();
        solveMaxSubArray();
        solvePlusOne();
        solveMoveZeroes();
        solveRotateArray();
    }
    
    /**
     * PROBLEM 1: Two Sum (LeetCode #1)
     * Given an array and target, return indices of two numbers that add up to target
     */
    public static void solveTwoSum() {
        System.out.println("=== Two Sum Problem ===");
        
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        
        System.out.print("Array: ");
        printArray(nums);
        System.out.println("Target: " + target);
        
        // Brute Force Solution - O(n²)
        int[] result1 = twoSumBruteForce(nums, target);
        System.out.println("Brute Force Result: [" + result1[0] + ", " + result1[1] + "]");
        
        // Optimized Solution using HashMap concept (simplified for beginners)
        int[] result2 = twoSumOptimized(nums, target);
        System.out.println("Optimized Result: [" + result2[0] + ", " + result2[1] + "]");
        
        System.out.println();
    }
    
    // Brute Force: Check all pairs
    public static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
    
    // Optimized: Use complement search
    public static int[] twoSumOptimized(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // Search for complement in remaining array
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == complement) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
    
    /**
     * PROBLEM 2: Remove Duplicates from Sorted Array (LeetCode #26)
     * Remove duplicates in-place and return new length
     */
    public static void solveRemoveDuplicates() {
        System.out.println("=== Remove Duplicates Problem ===");
        
        int[] nums = {1, 1, 2, 2, 3, 4, 4, 5};
        System.out.print("Original: ");
        printArray(nums);
        
        int newLength = removeDuplicates(nums);
        System.out.print("After removing duplicates (" + newLength + " unique): ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\n");
    }
    
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        
        int uniqueIndex = 1;  // Position for next unique element
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {  // Found unique element
                nums[uniqueIndex] = nums[i];
                uniqueIndex++;
            }
        }
        
        return uniqueIndex;
    }
    
    /**
     * PROBLEM 3: Maximum Subarray (Kadane's Algorithm) - LeetCode #53
     * Find the contiguous subarray with the largest sum
     */
    public static void solveMaxSubArray() {
        System.out.println("=== Maximum Subarray Problem ===");
        
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.print("Array: ");
        printArray(nums);
        
        int maxSum = maxSubArray(nums);
        System.out.println("Maximum subarray sum: " + maxSum);
        
        // Show the subarray that gives maximum sum
        int[] subarray = findMaxSubArray(nums);
        System.out.print("Maximum subarray: ");
        printArray(subarray);
        
        System.out.println();
    }
    
    // Kadane's Algorithm - O(n) time, O(1) space
    public static int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // Either extend existing subarray or start new one
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        
        return maxSoFar;
    }
    
    // Find the actual subarray (for demonstration)
    public static int[] findMaxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        int start = 0, end = 0, tempStart = 0;
        
        for (int i = 1; i < nums.length; i++) {
            if (currentSum < 0) {
                currentSum = nums[i];
                tempStart = i;
            } else {
                currentSum += nums[i];
            }
            
            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }
        
        // Extract subarray
        int[] result = new int[end - start + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = nums[start + i];
        }
        
        return result;
    }
    
    /**
     * PROBLEM 4: Plus One (LeetCode #66)
     * Add 1 to number represented as array of digits
     */
    public static void solvePlusOne() {
        System.out.println("=== Plus One Problem ===");
        
        int[] digits1 = {1, 2, 3};  // 123 + 1 = 124
        int[] digits2 = {9, 9, 9};  // 999 + 1 = 1000
        
        System.out.print("123 + 1 = ");
        printArray(plusOne(digits1));
        
        System.out.print("999 + 1 = ");
        printArray(plusOne(digits2));
        
        System.out.println();
    }
    
    public static int[] plusOne(int[] digits) {
        // Start from the least significant digit
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;  // No carry needed
            }
            digits[i] = 0;  // Set to 0 and continue with carry
        }
        
        // If we reach here, all digits were 9
        // Result will be 1000...0 (one more digit)
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
    
    /**
     * PROBLEM 5: Move Zeroes (LeetCode #283)
     * Move all zeroes to end while maintaining relative order of non-zeroes
     */
    public static void solveMoveZeroes() {
        System.out.println("=== Move Zeroes Problem ===");
        
        int[] nums = {0, 1, 0, 3, 12};
        System.out.print("Before: ");
        printArray(nums);
        
        moveZeroes(nums);
        System.out.print("After: ");
        printArray(nums);
        
        System.out.println();
    }
    
    public static void moveZeroes(int[] nums) {
        int writeIndex = 0;  // Position to write next non-zero element
        
        // Move all non-zero elements to the front
        for (int readIndex = 0; readIndex < nums.length; readIndex++) {
            if (nums[readIndex] != 0) {
                nums[writeIndex] = nums[readIndex];
                writeIndex++;
            }
        }
        
        // Fill remaining positions with zeros
        while (writeIndex < nums.length) {
            nums[writeIndex] = 0;
            writeIndex++;
        }
    }
    
    /**
     * PROBLEM 6: Rotate Array (LeetCode #189)
     * Rotate array to the right by k steps
     */
    public static void solveRotateArray() {
        System.out.println("=== Rotate Array Problem ===");
        
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        
        System.out.print("Original: ");
        printArray(nums);
        System.out.println("Rotate right by " + k + " steps");
        
        rotateArray(nums, k);
        System.out.print("After rotation: ");
        printArray(nums);
        
        System.out.println();
    }
    
    // Rotate using reverse technique - O(n) time, O(1) space
    public static void rotateArray(int[] nums, int k) {
        int n = nums.length;
        k = k % n;  // Handle k > n
        
        // Reverse entire array
        reverse(nums, 0, n - 1);
        
        // Reverse first k elements
        reverse(nums, 0, k - 1);
        
        // Reverse remaining elements
        reverse(nums, k, n - 1);
    }
    
    // Helper method to reverse array section
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
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
PROBLEM SOLVING STRATEGIES:

1. UNDERSTAND THE PROBLEM:
   - Read carefully
   - Identify inputs/outputs
   - Think of edge cases

2. PLAN YOUR APPROACH:
   - Brute force first
   - Think of optimizations
   - Consider space-time tradeoffs

3. COMMON PATTERNS:
   - Two pointers
   - Sliding window
   - Hash table (we'll learn later)
   - Prefix sums
   - In-place modifications

4. EDGE CASES TO CONSIDER:
   - Empty array
   - Single element
   - All same elements
   - Negative numbers
   - Very large arrays

5. OPTIMIZATION TECHNIQUES:
   - Early termination
   - Two pointers instead of nested loops
   - In-place modifications
   - Mathematical insights

NEXT STEPS:
Practice these problems until you can solve them without looking!
Then move on to:
- Best Time to Buy and Sell Stock
- Contains Duplicate  
- Single Number
- Intersection of Two Arrays
- Majority Element
*/