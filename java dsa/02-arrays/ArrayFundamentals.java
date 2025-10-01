/**
 * Array Fundamentals - Everything you need to know about arrays
 * 
 * Arrays are the foundation of DSA. Master this and you're set!
 */

public class ArrayFundamentals {
    
    public static void main(String[] args) {
        System.out.println("=== Array Fundamentals ===\n");
        
        arrayDeclarationAndInitialization();
        arrayOperations();
        multidimensionalArrays();
        commonArrayProblems();
    }
    
    /**
     * Different ways to declare and initialize arrays
     */
    public static void arrayDeclarationAndInitialization() {
        System.out.println("=== Array Declaration and Initialization ===");
        
        // Method 1: Declare then initialize
        int[] arr1;
        arr1 = new int[5];  // Creates array of size 5, all elements are 0
        System.out.println("Empty array length: " + arr1.length);
        
        // Method 2: Declare and initialize with size
        int[] arr2 = new int[3];
        arr2[0] = 10;
        arr2[1] = 20;
        arr2[2] = 30;
        printArray("arr2", arr2);
        
        // Method 3: Initialize with values (most common)
        int[] arr3 = {1, 2, 3, 4, 5};
        printArray("arr3", arr3);
        
        // Method 4: Alternative syntax
        int[] arr4 = new int[]{10, 20, 30, 40};
        printArray("arr4", arr4);
        
        // Different data types
        String[] names = {"Alice", "Bob", "Charlie"};
        boolean[] flags = {true, false, true, true};
        double[] prices = {19.99, 29.99, 39.99};
        
        System.out.println("String array: " + java.util.Arrays.toString(names));
        System.out.println("Boolean array: " + java.util.Arrays.toString(flags));
        System.out.println("Double array: " + java.util.Arrays.toString(prices));
        
        System.out.println();
    }
    
    /**
     * Essential array operations
     */
    public static void arrayOperations() {
        System.out.println("=== Array Operations ===");
        
        int[] arr = {10, 20, 30, 40, 50};
        
        // 1. ACCESS - O(1) time complexity
        System.out.println("First element: " + arr[0]);
        System.out.println("Last element: " + arr[arr.length - 1]);
        System.out.println("Middle element: " + arr[arr.length / 2]);
        
        // 2. UPDATE - O(1) time complexity
        arr[2] = 999;
        printArray("After updating index 2", arr);
        
        // 3. SEARCH - O(n) time complexity
        int target = 40;
        int index = linearSearch(arr, target);
        if (index != -1) {
            System.out.println("Found " + target + " at index " + index);
        } else {
            System.out.println(target + " not found");
        }
        
        // 4. INSERT - Need to create new array (arrays are fixed size)
        int[] newArr = insertAtIndex(arr, 2, 777);
        printArray("After inserting 777 at index 2", newArr);
        
        // 5. DELETE - Need to create new array
        int[] deletedArr = deleteAtIndex(arr, 1);
        printArray("After deleting index 1", deletedArr);
        
        // 6. REVERSE
        reverseArray(arr);
        printArray("After reversing", arr);
        
        System.out.println();
    }
    
    /**
     * Linear search implementation
     */
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;  // Not found
    }
    
    /**
     * Insert element at specific index (creates new array)
     */
    public static int[] insertAtIndex(int[] arr, int index, int value) {
        int[] newArr = new int[arr.length + 1];
        
        // Copy elements before insertion point
        for (int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }
        
        // Insert new value
        newArr[index] = value;
        
        // Copy remaining elements
        for (int i = index; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }
        
        return newArr;
    }
    
    /**
     * Delete element at specific index (creates new array)
     */
    public static int[] deleteAtIndex(int[] arr, int index) {
        int[] newArr = new int[arr.length - 1];
        
        // Copy elements before deletion point
        for (int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }
        
        // Copy elements after deletion point
        for (int i = index + 1; i < arr.length; i++) {
            newArr[i - 1] = arr[i];
        }
        
        return newArr;
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
     * Multidimensional arrays (2D arrays)
     */
    public static void multidimensionalArrays() {
        System.out.println("=== Multidimensional Arrays ===");
        
        // 2D array declaration and initialization
        int[][] matrix1 = new int[3][4];  // 3 rows, 4 columns
        System.out.println("Created 2D array with " + matrix1.length + " rows and " + matrix1[0].length + " columns");
        
        // Initialize with values
        int[][] matrix2 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("2D Array:");
        print2DArray(matrix2);
        
        // Access elements
        System.out.println("Element at [1][2]: " + matrix2[1][2]);
        
        // Modify element
        matrix2[1][2] = 99;
        System.out.println("After modification:");
        print2DArray(matrix2);
        
        // Jagged arrays (arrays of different lengths)
        int[][] jaggedArray = {
            {1, 2},
            {3, 4, 5, 6},
            {7}
        };
        
        System.out.println("Jagged Array:");
        print2DArray(jaggedArray);
        
        System.out.println();
    }
    
    /**
     * Common array problems and patterns
     */
    public static void commonArrayProblems() {
        System.out.println("=== Common Array Problems ===");
        
        int[] arr = {64, 34, 25, 12, 22, 11, 90, 88, 76, 50, 42};
        
        // 1. Find maximum and minimum
        int max = findMax(arr);
        int min = findMin(arr);
        System.out.println("Max: " + max + ", Min: " + min);
        
        // 2. Sum and average
        int sum = calculateSum(arr);
        double average = (double) sum / arr.length;
        System.out.println("Sum: " + sum + ", Average: " + average);
        
        // 3. Count even and odd numbers
        int[] evenOddCount = countEvenOdd(arr);
        System.out.println("Even: " + evenOddCount[0] + ", Odd: " + evenOddCount[1]);
        
        // 4. Find second largest
        int secondLargest = findSecondLargest(arr);
        System.out.println("Second largest: " + secondLargest);
        
        // 5. Check if array is sorted
        boolean isSorted = isSorted(arr);
        System.out.println("Is sorted: " + isSorted);
        
        // 6. Remove duplicates (for sorted array)
        int[] sortedArr = {1, 1, 2, 2, 3, 4, 4, 5};
        int newLength = removeDuplicates(sortedArr);
        System.out.print("After removing duplicates: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(sortedArr[i] + " ");
        }
        System.out.println();
        
        System.out.println();
    }
    
    // Helper methods for common problems
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    
    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
    
    public static int calculateSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
    
    public static int[] countEvenOdd(int[] arr) {
        int evenCount = 0, oddCount = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        return new int[]{evenCount, oddCount};
    }
    
    public static int findSecondLargest(int[] arr) {
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
    
    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Remove duplicates from sorted array in-place
     * Returns new length of array
     */
    public static int removeDuplicates(int[] arr) {
        if (arr.length == 0) return 0;
        
        int writeIndex = 1;  // Position to write next unique element
        
        for (int readIndex = 1; readIndex < arr.length; readIndex++) {
            if (arr[readIndex] != arr[readIndex - 1]) {
                arr[writeIndex] = arr[readIndex];
                writeIndex++;
            }
        }
        
        return writeIndex;
    }
    
    // Helper methods
    public static void printArray(String label, int[] arr) {
        System.out.print(label + ": ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    public static void print2DArray(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

/*
ARRAY COMPLEXITY ANALYSIS:

OPERATIONS:
- Access: O(1) - Direct index access
- Search: O(n) - Must check each element
- Insert: O(n) - Need to shift elements
- Delete: O(n) - Need to shift elements
- Update: O(1) - Direct index access

SPACE COMPLEXITY:
- Fixed: O(n) where n is array size
- Additional space for operations may be needed

ADVANTAGES:
✅ Fast access by index
✅ Memory efficient
✅ Cache friendly (contiguous memory)
✅ Simple to understand and use

DISADVANTAGES:
❌ Fixed size
❌ Expensive insertions/deletions
❌ Memory waste if not fully used

COMMON PATTERNS:
1. Two Pointers: left and right pointers moving
2. Sliding Window: maintain a window of elements
3. Prefix Sum: precompute cumulative sums
4. Dutch National Flag: partition array into regions

INTERVIEW TIPS:
- Always check array bounds
- Consider edge cases (empty array, single element)
- Think about in-place vs creating new array
- Master basic operations first
*/