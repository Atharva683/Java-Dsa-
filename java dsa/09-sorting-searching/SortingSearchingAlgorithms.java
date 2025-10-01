/**
 * Sorting and Searching Algorithms - Complete Implementation
 * 
 * Master all fundamental algorithms for competitive programming
 */

import java.util.*;

public class SortingSearchingAlgorithms {
    
    public static void main(String[] args) {
        System.out.println("=== Sorting and Searching Algorithms Mastery ===\n");
        
        demonstrateSortingAlgorithms();
        demonstrateSearchingAlgorithms();
        demonstrateAdvancedTechniques();
        performanceAnalysis();
        leetCodePatterns();
    }
    
    /**
     * SORTING ALGORITHMS - All major sorting techniques
     */
    public static void demonstrateSortingAlgorithms() {
        System.out.println("=== Sorting Algorithms ===");
        
        int[] original = {64, 34, 25, 12, 22, 11, 90, 88, 76, 50, 42};
        System.out.println("Original array: " + Arrays.toString(original));
        
        // 1. Bubble Sort - O(n²)
        int[] bubbleArray = original.clone();
        bubbleSort(bubbleArray);
        System.out.println("Bubble Sort: " + Arrays.toString(bubbleArray));
        
        // 2. Selection Sort - O(n²)
        int[] selectionArray = original.clone();
        selectionSort(selectionArray);
        System.out.println("Selection Sort: " + Arrays.toString(selectionArray));
        
        // 3. Insertion Sort - O(n²)
        int[] insertionArray = original.clone();
        insertionSort(insertionArray);
        System.out.println("Insertion Sort: " + Arrays.toString(insertionArray));
        
        // 4. Merge Sort - O(n log n)
        int[] mergeArray = original.clone();
        mergeSort(mergeArray, 0, mergeArray.length - 1);
        System.out.println("Merge Sort: " + Arrays.toString(mergeArray));
        
        // 5. Quick Sort - O(n log n) average
        int[] quickArray = original.clone();
        quickSort(quickArray, 0, quickArray.length - 1);
        System.out.println("Quick Sort: " + Arrays.toString(quickArray));
        
        // 6. Heap Sort - O(n log n)
        int[] heapArray = original.clone();
        heapSort(heapArray);
        System.out.println("Heap Sort: " + Arrays.toString(heapArray));
        
        // 7. Counting Sort - O(n + k)
        int[] countingArray = {4, 2, 2, 8, 3, 3, 1};
        int[] countingSorted = countingSort(countingArray);
        System.out.println("Counting Sort: " + Arrays.toString(countingSorted));
        
        // 8. Radix Sort - O(d × (n + k))
        int[] radixArray = {170, 45, 75, 90, 2, 802, 24, 66};
        radixSort(radixArray);
        System.out.println("Radix Sort: " + Arrays.toString(radixArray));
        
        System.out.println();
    }
    
    /**
     * SEARCHING ALGORITHMS - All major searching techniques
     */
    public static void demonstrateSearchingAlgorithms() {
        System.out.println("=== Searching Algorithms ===");
        
        int[] sortedArray = {2, 5, 8, 12, 16, 23, 38, 45, 56, 67, 78};
        int target = 23;
        
        System.out.println("Array: " + Arrays.toString(sortedArray));
        System.out.println("Searching for: " + target);
        
        // 1. Linear Search - O(n)
        int linearResult = linearSearch(sortedArray, target);
        System.out.println("Linear Search result: " + linearResult);
        
        // 2. Binary Search - O(log n)
        int binaryResult = binarySearch(sortedArray, target);
        System.out.println("Binary Search result: " + binaryResult);
        
        // 3. Binary Search Variants
        System.out.println("\nBinary Search Variants:");
        int[] duplicates = {1, 2, 2, 2, 3, 4, 4, 5, 6};
        System.out.println("Array with duplicates: " + Arrays.toString(duplicates));
        
        int firstOccurrence = findFirstOccurrence(duplicates, 2);
        int lastOccurrence = findLastOccurrence(duplicates, 2);
        System.out.println("First occurrence of 2: " + firstOccurrence);
        System.out.println("Last occurrence of 2: " + lastOccurrence);
        
        // 4. Search in Rotated Array
        int[] rotated = {4, 5, 6, 7, 0, 1, 2};
        int rotatedResult = searchInRotatedArray(rotated, 0);
        System.out.println("Search 0 in rotated array: " + rotatedResult);
        
        // 5. Square Root using Binary Search
        int number = 25;
        int sqrt = squareRoot(number);
        System.out.println("Square root of " + number + ": " + sqrt);
        
        System.out.println();
    }
    
    /**
     * ADVANCED TECHNIQUES - Two pointers, sliding window, etc.
     */
    public static void demonstrateAdvancedTechniques() {
        System.out.println("=== Advanced Techniques ===");
        
        // Two Pointers Technique
        System.out.println("Two Pointers Technique:");
        int[] twoSumArray = {2, 7, 11, 15};
        int twoSumTarget = 9;
        int[] twoSumResult = twoSum(twoSumArray, twoSumTarget);
        System.out.println("Two Sum result: " + Arrays.toString(twoSumResult));
        
        // Three Sum
        int[] threeSumArray = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> threeSumResult = threeSum(threeSumArray);
        System.out.println("Three Sum result: " + threeSumResult);
        
        // Dutch National Flag (3-way partitioning)
        int[] colors = {2, 0, 2, 1, 1, 0};
        sortColors(colors);
        System.out.println("Sort Colors: " + Arrays.toString(colors));
        
        // Sliding Window Technique
        System.out.println("\nSliding Window Technique:");
        int[] windowArray = {1, 12, -5, -6, 50, 3};
        int windowSize = 4;
        int maxSum = maxSumSubarray(windowArray, windowSize);
        System.out.println("Max sum of subarray size " + windowSize + ": " + maxSum);
        
        // Longest Substring Without Repeating Characters
        String s = "abcabcbb";
        int longestLength = lengthOfLongestSubstring(s);
        System.out.println("Longest substring without repeating in '" + s + "': " + longestLength);
        
        System.out.println();
    }
    
    /**
     * PERFORMANCE ANALYSIS
     */
    public static void performanceAnalysis() {
        System.out.println("=== Performance Analysis ===");
        
        int[] sizes = {1000, 5000, 10000};
        
        for (int size : sizes) {
            System.out.println("Array size: " + size);
            
            // Generate random array
            int[] arr = generateRandomArray(size);
            
            // Test sorting algorithms
            testSortingPerformance("Bubble Sort", arr.clone(), SortingSearchingAlgorithms::bubbleSort);
            testSortingPerformance("Selection Sort", arr.clone(), SortingSearchingAlgorithms::selectionSort);
            testSortingPerformance("Insertion Sort", arr.clone(), SortingSearchingAlgorithms::insertionSort);
            testSortingPerformance("Merge Sort", arr.clone(), (array) -> mergeSort(array, 0, array.length - 1));
            testSortingPerformance("Quick Sort", arr.clone(), (array) -> quickSort(array, 0, array.length - 1));
            testSortingPerformance("Heap Sort", arr.clone(), SortingSearchingAlgorithms::heapSort);
            
            System.out.println();
        }
    }
    
    /**
     * LEETCODE PATTERNS AND COMMON PROBLEMS
     */
    public static void leetCodePatterns() {
        System.out.println("=== LeetCode Patterns ===");
        
        // Pattern 1: Find Kth Largest Element
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int kthLargest = findKthLargest(nums, k);
        System.out.println("Kth largest element: " + kthLargest);
        
        // Pattern 2: Merge Intervals
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merged = mergeIntervals(intervals);
        System.out.println("Merged intervals: " + Arrays.deepToString(merged));
        
        // Pattern 3: Meeting Rooms
        int[][] meetings = {{0, 30}, {5, 10}, {15, 20}};
        boolean canAttend = canAttendMeetings(meetings);
        System.out.println("Can attend all meetings: " + canAttend);
        
        // Pattern 4: Top K Frequent Elements
        int[] freqNums = {1, 1, 1, 2, 2, 3};
        int[] topK = topKFrequent(freqNums, 2);
        System.out.println("Top K frequent: " + Arrays.toString(topK));
        
        System.out.println();
    }
    
    // ===== SORTING ALGORITHM IMPLEMENTATIONS =====
    
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break; // Optimization: stop if no swaps
        }
    }
    
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            swap(arr, i, minIdx);
        }
    }
    
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    
    private static void merge(int[] arr, int left, int mid, int right) {
        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);
        
        int i = 0, j = 0, k = left;
        
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        
        while (i < leftArr.length) arr[k++] = leftArr[i++];
        while (j < rightArr.length) arr[k++] = rightArr[j++];
    }
    
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
    
    public static void heapSort(int[] arr) {
        int n = arr.length;
        
        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        
        // Extract elements one by one
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }
    
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }
    
    public static int[] countingSort(int[] arr) {
        int max = Arrays.stream(arr).max().orElse(0);
        int[] count = new int[max + 1];
        int[] result = new int[arr.length];
        
        // Count occurrences
        for (int num : arr) {
            count[num]++;
        }
        
        // Calculate cumulative count
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }
        
        // Build result array
        for (int i = arr.length - 1; i >= 0; i--) {
            result[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }
        
        return result;
    }
    
    public static void radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().orElse(0);
        
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }
    
    private static void countingSortByDigit(int[] arr, int exp) {
        int[] count = new int[10];
        int[] result = new int[arr.length];
        
        for (int num : arr) {
            count[(num / exp) % 10]++;
        }
        
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        
        for (int i = arr.length - 1; i >= 0; i--) {
            result[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        
        System.arraycopy(result, 0, arr, 0, arr.length);
    }
    
    // ===== SEARCHING ALGORITHM IMPLEMENTATIONS =====
    
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
    
    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                result = mid;
                right = mid - 1; // Continue searching left
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                result = mid;
                left = mid + 1; // Continue searching right
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    public static int searchInRotatedArray(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            }
            
            // Left half is sorted
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        
        return -1;
    }
    
    public static int squareRoot(int x) {
        if (x < 2) return x;
        
        int left = 2, right = x / 2;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;
            
            if (square == x) {
                return mid;
            } else if (square < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return right;
    }
    
    // ===== ADVANCED TECHNIQUES =====
    
    public static int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        
        return new int[]{-1, -1};
    }
    
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int left = i + 1, right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return result;
    }
    
    public static void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low++, mid++);
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high--);
            }
        }
    }
    
    public static int maxSumSubarray(int[] arr, int k) {
        int maxSum = 0;
        int windowSum = 0;
        
        // Calculate sum of first window
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;
        
        // Slide the window
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        
        return maxSum;
    }
    
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int left = 0, maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            while (window.contains(s.charAt(right))) {
                window.remove(s.charAt(left++));
            }
            window.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
    
    // ===== LEETCODE PATTERNS =====
    
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        return minHeap.peek();
    }
    
    public static int[][] mergeIntervals(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }
        
        return merged.toArray(new int[merged.size()][]);
    }
    
    public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] > intervals[i][0]) {
                return false;
            }
        }
        
        return true;
    }
    
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> count.get(a) - count.get(b));
        
        for (int num : count.keySet()) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = heap.poll();
        }
        
        return result;
    }
    
    // ===== HELPER METHODS =====
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(1000);
        }
        return arr;
    }
    
    private static void testSortingPerformance(String algorithmName, int[] arr, SortingAlgorithm algorithm) {
        long startTime = System.nanoTime();
        algorithm.sort(arr);
        long endTime = System.nanoTime();
        
        long duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds
        System.out.println(algorithmName + ": " + duration + " ms");
    }
    
    @FunctionalInterface
    interface SortingAlgorithm {
        void sort(int[] arr);
    }
}

/*
ALGORITHM COMPLEXITY CHEAT SHEET:

SORTING ALGORITHMS:
Algorithm       Best      Average    Worst     Space    Stable
Bubble Sort     O(n)      O(n²)      O(n²)     O(1)     Yes
Selection Sort  O(n²)     O(n²)      O(n²)     O(1)     No
Insertion Sort  O(n)      O(n²)      O(n²)     O(1)     Yes
Merge Sort      O(n log n) O(n log n) O(n log n) O(n)    Yes
Quick Sort      O(n log n) O(n log n) O(n²)     O(log n) No
Heap Sort       O(n log n) O(n log n) O(n log n) O(1)    No
Counting Sort   O(n+k)    O(n+k)     O(n+k)    O(k)     Yes
Radix Sort      O(d(n+k)) O(d(n+k))  O(d(n+k)) O(n+k)   Yes

SEARCHING ALGORITHMS:
Algorithm           Time        Space     Prerequisites
Linear Search       O(n)        O(1)      None
Binary Search       O(log n)    O(1)      Sorted array
Binary Search Tree  O(log n)    O(1)      BST structure

WHEN TO USE EACH:
- Bubble Sort: Educational purposes only
- Selection Sort: Small datasets, memory is limited
- Insertion Sort: Small datasets, nearly sorted data
- Merge Sort: Stable sort needed, worst-case O(n log n)
- Quick Sort: Average case performance, in-place sorting
- Heap Sort: Guaranteed O(n log n), in-place
- Counting Sort: Small range of integers
- Radix Sort: Large integers, non-comparative

COMMON PATTERNS:
1. Two Pointers: Sorted array problems
2. Sliding Window: Subarray problems
3. Binary Search: Search space reduction
4. Divide and Conquer: Merge sort, quick sort
5. Heap: Top K problems
6. Hash Map: Frequency counting
*/