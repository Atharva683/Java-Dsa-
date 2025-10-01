/**
 * Array Algorithms - Essential sorting and searching algorithms
 * 
 * These are fundamental algorithms every programmer should know
 */

public class ArrayAlgorithms {
    
    public static void main(String[] args) {
        System.out.println("=== Array Algorithms ===\n");
        
        demonstrateSearchAlgorithms();
        demonstrateSortingAlgorithms();
        demonstrateTwoPointerTechnique();
    }
    
    /**
     * SEARCHING ALGORITHMS
     */
    public static void demonstrateSearchAlgorithms() {
        System.out.println("=== Searching Algorithms ===");
        
        int[] unsortedArr = {64, 34, 25, 12, 22, 11, 90};
        int[] sortedArr = {11, 12, 22, 25, 34, 64, 90};
        int target = 25;
        
        // Linear Search - works on any array
        int linearResult = linearSearch(unsortedArr, target);
        System.out.println("Linear Search for " + target + ": index " + linearResult);
        
        // Binary Search - only works on sorted arrays
        int binaryResult = binarySearch(sortedArr, target);
        System.out.println("Binary Search for " + target + ": index " + binaryResult);
        
        // Compare time complexity demonstration
        demonstrateSearchComplexity();
        
        System.out.println();
    }
    
    /**
     * Linear Search - O(n) time complexity
     * Works on any array (sorted or unsorted)
     */
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;  // Found at index i
            }
        }
        return -1;  // Not found
    }
    
    /**
     * Binary Search - O(log n) time complexity
     * Only works on SORTED arrays
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;  // Avoid overflow
            
            if (arr[mid] == target) {
                return mid;  // Found at index mid
            } else if (arr[mid] < target) {
                left = mid + 1;  // Search right half
            } else {
                right = mid - 1;  // Search left half
            }
        }
        
        return -1;  // Not found
    }
    
    /**
     * Recursive Binary Search
     */
    public static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;  // Base case: not found
        }
        
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == target) {
            return mid;  // Base case: found
        } else if (arr[mid] < target) {
            return binarySearchRecursive(arr, target, mid + 1, right);
        } else {
            return binarySearchRecursive(arr, target, left, mid - 1);
        }
    }
    
    /**
     * Demonstrate search complexity differences
     */
    public static void demonstrateSearchComplexity() {
        System.out.println("\n--- Search Complexity Comparison ---");
        
        // Create large sorted array
        int[] largeArray = new int[1000000];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = i * 2;  // Even numbers
        }
        
        int target = 999998;  // Near the end
        
        // Linear Search timing
        long startTime = System.nanoTime();
        int linearResult = linearSearch(largeArray, target);
        long linearTime = System.nanoTime() - startTime;
        
        // Binary Search timing
        startTime = System.nanoTime();
        int binaryResult = binarySearch(largeArray, target);
        long binaryTime = System.nanoTime() - startTime;
        
        System.out.println("Array size: " + largeArray.length);
        System.out.println("Linear Search: " + linearResult + " (Time: " + linearTime + " ns)");
        System.out.println("Binary Search: " + binaryResult + " (Time: " + binaryTime + " ns)");
        System.out.println("Binary search is " + (linearTime / binaryTime) + "x faster!");
    }
    
    /**
     * SORTING ALGORITHMS
     */
    public static void demonstrateSortingAlgorithms() {
        System.out.println("=== Sorting Algorithms ===");
        
        int[] originalArr = {64, 34, 25, 12, 22, 11, 90};
        
        // Bubble Sort
        int[] bubbleArr = originalArr.clone();
        System.out.print("Original: ");
        printArray(bubbleArr);
        bubbleSort(bubbleArr);
        System.out.print("Bubble Sort: ");
        printArray(bubbleArr);
        
        // Selection Sort
        int[] selectionArr = originalArr.clone();
        selectionSort(selectionArr);
        System.out.print("Selection Sort: ");
        printArray(selectionArr);
        
        // Insertion Sort
        int[] insertionArr = originalArr.clone();
        insertionSort(insertionArr);
        System.out.print("Insertion Sort: ");
        printArray(insertionArr);
        
        System.out.println();
    }
    
    /**
     * Bubble Sort - O(n²) time complexity
     * Repeatedly swaps adjacent elements if they're in wrong order
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;  // Optimization
            
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
            // If no swapping occurred, array is sorted
            if (!swapped) {
                break;
            }
        }
    }
    
    /**
     * Selection Sort - O(n²) time complexity
     * Finds minimum element and places it at the beginning
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            
            // Find minimum element in remaining array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            
            // Swap minimum element with first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    
    /**
     * Insertion Sort - O(n²) time complexity, but efficient for small arrays
     * Builds sorted array one element at a time
     */
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            
            // Move elements greater than key one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            
            arr[j + 1] = key;
        }
    }
    
    /**
     * TWO POINTER TECHNIQUE - Very important for interviews!
     */
    public static void demonstrateTwoPointerTechnique() {
        System.out.println("=== Two Pointer Technique ===");
        
        // Problem 1: Check if array is palindrome
        int[] palindromeArr = {1, 2, 3, 2, 1};
        boolean isPalindrome = isPalindromeArray(palindromeArr);
        System.out.println("Is palindrome: " + isPalindrome);
        
        // Problem 2: Two Sum in sorted array
        int[] sortedArr = {2, 7, 11, 15, 20, 30};
        int target = 22;
        int[] twoSumResult = twoSumSorted(sortedArr, target);
        if (twoSumResult[0] != -1) {
            System.out.println("Two sum indices: [" + twoSumResult[0] + ", " + twoSumResult[1] + "]");
        } else {
            System.out.println("Two sum not found");
        }
        
        // Problem 3: Reverse array in place
        int[] reverseArr = {1, 2, 3, 4, 5, 6};
        System.out.print("Before reverse: ");
        printArray(reverseArr);
        reverseArrayTwoPointer(reverseArr);
        System.out.print("After reverse: ");
        printArray(reverseArr);
        
        // Problem 4: Remove duplicates from sorted array
        int[] duplicateArr = {1, 1, 2, 2, 3, 4, 4, 5};
        System.out.print("With duplicates: ");
        printArray(duplicateArr);
        int newLength = removeDuplicatesTwoPointer(duplicateArr);
        System.out.print("After removing duplicates (" + newLength + " elements): ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(duplicateArr[i] + " ");
        }
        System.out.println();
        
        System.out.println();
    }
    
    /**
     * Check if array is palindrome using two pointers
     */
    public static boolean isPalindromeArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
    
    /**
     * Two Sum problem for sorted array using two pointers
     * Find two numbers that add up to target
     */
    public static int[] twoSumSorted(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            int sum = arr[left] + arr[right];
            
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;  // Need larger sum
            } else {
                right--;  // Need smaller sum
            }
        }
        
        return new int[]{-1, -1};  // Not found
    }
    
    /**
     * Reverse array using two pointers
     */
    public static void reverseArrayTwoPointer(int[] arr) {
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
     * Remove duplicates from sorted array using two pointers
     */
    public static int removeDuplicatesTwoPointer(int[] arr) {
        if (arr.length == 0) return 0;
        
        int writePointer = 1;  // Position to write next unique element
        
        for (int readPointer = 1; readPointer < arr.length; readPointer++) {
            if (arr[readPointer] != arr[readPointer - 1]) {
                arr[writePointer] = arr[readPointer];
                writePointer++;
            }
        }
        
        return writePointer;
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
ALGORITHM COMPLEXITY SUMMARY:

SEARCHING:
- Linear Search: O(n) time, O(1) space
- Binary Search: O(log n) time, O(1) space

SORTING:
- Bubble Sort: O(n²) time, O(1) space
- Selection Sort: O(n²) time, O(1) space  
- Insertion Sort: O(n²) time, O(1) space
- Quick Sort: O(n log n) average, O(n²) worst
- Merge Sort: O(n log n) time, O(n) space

TWO POINTER PATTERNS:
1. Opposite directions: left=0, right=n-1
2. Same direction: slow and fast pointers
3. Sliding window: expand and contract window

WHEN TO USE BINARY SEARCH:
✅ Array is sorted
✅ Need O(log n) search time
✅ Random access available

WHEN TO USE TWO POINTERS:
✅ Sorted array problems
✅ Palindrome checking
✅ Pair finding problems
✅ In-place array modifications

LEETCODE PROBLEMS TO PRACTICE:
1. Two Sum (1)
2. Remove Duplicates from Sorted Array (26)
3. Search Insert Position (35)
4. Valid Palindrome (125)
5. Two Sum II - Input array is sorted (167)
*/