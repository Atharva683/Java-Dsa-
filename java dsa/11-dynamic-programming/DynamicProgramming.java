/**
 * Dynamic Programming - 1D and 2D DP with Kadane's Algorithm
 * 
 * Master all DP patterns and optimization problems
 */

import java.util.*;

public class DynamicProgramming {
    
    public static void main(String[] args) {
        System.out.println("=== Dynamic Programming Mastery ===\n");
        
        demonstrate1DDP();
        demonstrate2DDP();
        demonstrateKadaneAlgorithm();
        demonstrateKnapsackProblems();
        demonstrateStringDP();
        demonstrateAdvancedDP();
    }
    
    /**
     * 1D DYNAMIC PROGRAMMING - Linear DP problems
     */
    public static void demonstrate1DDP() {
        System.out.println("=== 1D Dynamic Programming ===");
        
        // 1. Fibonacci - Classic DP
        int n = 10;
        System.out.println("Fibonacci(" + n + "): " + fibonacci(n));
        System.out.println("Fibonacci Optimized: " + fibonacciOptimized(n));
        
        // 2. Climbing Stairs
        int stairs = 5;
        System.out.println("Ways to climb " + stairs + " stairs: " + climbStairs(stairs));
        
        // 3. House Robber
        int[] houses = {2, 7, 9, 3, 1};
        System.out.println("Max money from houses " + Arrays.toString(houses) + ": " + rob(houses));
        
        // 4. Min Cost Climbing Stairs
        int[] cost = {10, 15, 20};
        System.out.println("Min cost to climb: " + minCostClimbingStairs(cost));
        
        // 5. Decode Ways
        String s = "226";
        System.out.println("Ways to decode '" + s + "': " + numDecodings(s));
        
        // 6. Coin Change
        int[] coins = {1, 3, 4};
        int amount = 6;
        System.out.println("Min coins for amount " + amount + ": " + coinChange(coins, amount));
        
        // 7. Perfect Squares
        int num = 12;
        System.out.println("Min perfect squares for " + num + ": " + numSquares(num));
        
        // 8. Longest Increasing Subsequence
        int[] lis = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("LIS length in " + Arrays.toString(lis) + ": " + lengthOfLIS(lis));
        
        System.out.println();
    }
    
    /**
     * 2D DYNAMIC PROGRAMMING - Grid and matrix problems
     */
    public static void demonstrate2DDP() {
        System.out.println("=== 2D Dynamic Programming ===");
        
        // 1. Unique Paths
        int m = 3, n = 7;
        System.out.println("Unique paths in " + m + "x" + n + " grid: " + uniquePaths(m, n));
        
        // 2. Unique Paths II (with obstacles)
        int[][] obstacles = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println("Unique paths with obstacles: " + uniquePathsWithObstacles(obstacles));
        
        // 3. Minimum Path Sum
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println("Minimum path sum: " + minPathSum(grid));
        
        // 4. Maximum Path Sum in Triangle
        List<List<Integer>> triangle = Arrays.asList(
            Arrays.asList(2),
            Arrays.asList(3,4),
            Arrays.asList(6,5,7),
            Arrays.asList(4,1,8,3)
        );
        System.out.println("Minimum path sum in triangle: " + minimumTotal(triangle));
        
        // 5. Edit Distance
        String word1 = "horse", word2 = "ros";
        System.out.println("Edit distance '" + word1 + "' -> '" + word2 + "': " + minDistance(word1, word2));
        
        // 6. Longest Common Subsequence
        String text1 = "abcde", text2 = "ace";
        System.out.println("LCS of '" + text1 + "' and '" + text2 + "': " + longestCommonSubsequence(text1, text2));
        
        // 7. Longest Palindromic Subsequence
        String palindrome = "bbbab";
        System.out.println("Longest palindromic subsequence in '" + palindrome + "': " + longestPalindromeSubseq(palindrome));
        
        // 8. Interleaving String
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println("Is '" + s3 + "' interleaving of '" + s1 + "' and '" + s2 + "': " + isInterleave(s1, s2, s3));
        
        System.out.println();
    }
    
    /**
     * KADANE'S ALGORITHM - Maximum subarray problems
     */
    public static void demonstrateKadaneAlgorithm() {
        System.out.println("=== Kadane's Algorithm ===");
        
        // 1. Maximum Subarray Sum
        int[] arr1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Max subarray sum in " + Arrays.toString(arr1) + ": " + maxSubArray(arr1));
        
        // 2. Maximum Subarray with indices
        int[] arr2 = {-2, -3, 4, -1, -2, 1, 5, -3};
        MaxSubarrayResult result = maxSubarrayWithIndices(arr2);
        System.out.println("Max subarray: sum=" + result.sum + ", start=" + result.start + ", end=" + result.end);
        
        // 3. Maximum Product Subarray
        int[] arr3 = {2, 3, -2, 4};
        System.out.println("Max product subarray in " + Arrays.toString(arr3) + ": " + maxProduct(arr3));
        
        // 4. Maximum Sum Circular Subarray
        int[] arr4 = {1, -2, 3, -2};
        System.out.println("Max circular subarray sum: " + maxSubarraySumCircular(arr4));
        
        // 5. Maximum Sum of 3 Non-Overlapping Subarrays
        int[] arr5 = {1, 2, 1, 2, 6, 7, 5, 1};
        int k = 2;
        int[] indices = maxSumOfThreeSubarrays(arr5, k);
        System.out.println("Max sum of 3 non-overlapping subarrays: " + Arrays.toString(indices));
        
        // 6. Best Time to Buy and Sell Stock
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Max profit from stock prices: " + maxProfit(prices));
        
        // 7. Best Time to Buy and Sell Stock with Multiple Transactions
        System.out.println("Max profit with multiple transactions: " + maxProfitMultiple(prices));
        
        System.out.println();
    }
    
    /**
     * KNAPSACK PROBLEMS - 0/1 and Unbounded Knapsack
     */
    public static void demonstrateKnapsackProblems() {
        System.out.println("=== Knapsack Problems ===");
        
        // 1. 0/1 Knapsack
        int[] weights = {1, 3, 4, 5};
        int[] values = {1, 4, 5, 7};
        int capacity = 7;
        System.out.println("0/1 Knapsack max value: " + knapsack01(weights, values, capacity));
        
        // 2. Unbounded Knapsack
        System.out.println("Unbounded Knapsack max value: " + unboundedKnapsack(weights, values, capacity));
        
        // 3. Partition Equal Subset Sum
        int[] partition = {1, 5, 11, 5};
        System.out.println("Can partition " + Arrays.toString(partition) + " equally: " + canPartition(partition));
        
        // 4. Target Sum
        int[] targetNums = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println("Ways to reach target " + target + ": " + findTargetSumWays(targetNums, target));
        
        // 5. Coin Change (Unbounded Knapsack variation)
        int[] coinTypes = {1, 2, 5};
        int coinAmount = 11;
        System.out.println("Min coins for amount " + coinAmount + ": " + coinChange(coinTypes, coinAmount));
        
        // 6. Coin Change II (Number of ways)
        System.out.println("Ways to make amount " + coinAmount + ": " + coinChange2(coinAmount, coinTypes));
        
        System.out.println();
    }
    
    /**
     * STRING DP PROBLEMS - Pattern matching and string manipulation
     */
    public static void demonstrateStringDP() {
        System.out.println("=== String DP Problems ===");
        
        // 1. Longest Palindromic Substring
        String s1 = "babad";
        System.out.println("Longest palindromic substring in '" + s1 + "': " + longestPalindrome(s1));
        
        // 2. Palindromic Substrings Count
        String s2 = "abc";
        System.out.println("Count of palindromic substrings in '" + s2 + "': " + countSubstrings(s2));
        
        // 3. Regular Expression Matching
        String str = "aa", pattern = "a*";
        System.out.println("Does '" + str + "' match pattern '" + pattern + "': " + isMatch(str, pattern));
        
        // 4. Wildcard Matching
        String text = "adceb", wildcard = "*a*b*";
        System.out.println("Does '" + text + "' match wildcard '" + wildcard + "': " + isMatchWildcard(text, wildcard));
        
        // 5. Distinct Subsequences
        String s = "rabbbit", t = "rabbit";
        System.out.println("Distinct subsequences of '" + t + "' in '" + s + "': " + numDistinct(s, t));
        
        // 6. Word Break
        String wordBreakStr = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println("Can break '" + wordBreakStr + "': " + wordBreak(wordBreakStr, wordDict));
        
        System.out.println();
    }
    
    /**
     * ADVANCED DP PROBLEMS - Complex optimization problems
     */
    public static void demonstrateAdvancedDP() {
        System.out.println("=== Advanced DP Problems ===");
        
        // 1. Longest Valid Parentheses
        String parentheses = "((())";
        System.out.println("Longest valid parentheses in '" + parentheses + "': " + longestValidParentheses(parentheses));
        
        // 2. Russian Doll Envelopes
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        System.out.println("Max Russian dolls: " + maxEnvelopes(envelopes));
        
        // 3. Burst Balloons
        int[] balloons = {3, 1, 5, 8};
        System.out.println("Max coins from bursting balloons: " + maxCoins(balloons));
        
        // 4. Stone Game
        int[] stones = {5, 3, 7, 1};
        System.out.println("Can first player win stone game: " + stoneGame(stones));
        
        // 5. Maximal Rectangle
        char[][] matrix = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
        };
        System.out.println("Maximal rectangle area: " + maximalRectangle(matrix));
        
        System.out.println();
    }
    
    // ===== 1D DP IMPLEMENTATIONS =====
    
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }
    
    public static int fibonacciOptimized(int n) {
        if (n <= 1) return n;
        int prev2 = 0, prev1 = 1;
        
        for (int i = 2; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }
    
    public static int climbStairs(int n) {
        if (n <= 2) return n;
        int prev2 = 1, prev1 = 2;
        
        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }
    
    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < nums.length; i++) {
            int current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }
    
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prev2 = 0, prev1 = 0;
        
        for (int i = 2; i <= n; i++) {
            int current = Math.min(prev1 + cost[i - 1], prev2 + cost[i - 2]);
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }
    
    public static int numDecodings(String s) {
        if (s.isEmpty() || s.charAt(0) == '0') return 0;
        
        int n = s.length();
        int prev2 = 1, prev1 = 1;
        
        for (int i = 1; i < n; i++) {
            int current = 0;
            
            // Single digit
            if (s.charAt(i) != '0') {
                current += prev1;
            }
            
            // Two digits
            int twoDigit = Integer.parseInt(s.substring(i - 1, i + 1));
            if (twoDigit >= 10 && twoDigit <= 26) {
                current += prev2;
            }
            
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }
    
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }
    
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        
        return dp[n];
    }
    
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLength = 1;
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        
        return maxLength;
    }
    
    // ===== 2D DP IMPLEMENTATIONS =====
    
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        // Initialize first row and column
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        
        return dp[m - 1][n - 1];
    }
    
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        
        // Initialize first cell
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        
        // Initialize first row
        for (int j = 1; j < n; j++) {
            dp[0][j] = obstacleGrid[0][j] == 1 ? 0 : dp[0][j - 1];
        }
        
        // Initialize first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i - 1][0];
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        
        return dp[m - 1][n - 1];
    }
    
    public static int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        
        dp[0][0] = grid[0][0];
        
        // Initialize first row
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        
        // Initialize first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        
        return dp[m - 1][n - 1];
    }
    
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        
        // Initialize with last row
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }
        
        // Bottom-up approach
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        
        return dp[0];
    }
    
    public static int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        // Initialize base cases
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], // Replace
                                           Math.min(dp[i - 1][j],     // Delete
                                                   dp[i][j - 1]));    // Insert
                }
            }
        }
        
        return dp[m][n];
    }
    
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[m][n];
    }
    
    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        
        // Every single character is a palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        
        // Check for palindromes of length 2 to n
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[0][n - 1];
    }
    
    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        
        int m = s1.length(), n = s2.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        dp[0][0] = true;
        
        // Initialize first row
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        
        // Initialize first column
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                          (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        
        return dp[m][n];
    }
    
    // ===== KADANE'S ALGORITHM IMPLEMENTATIONS =====
    
    public static int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        
        return maxSoFar;
    }
    
    public static MaxSubarrayResult maxSubarrayWithIndices(int[] nums) {
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];
        int start = 0, end = 0, tempStart = 0;
        
        for (int i = 1; i < nums.length; i++) {
            if (maxEndingHere < 0) {
                maxEndingHere = nums[i];
                tempStart = i;
            } else {
                maxEndingHere += nums[i];
            }
            
            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                start = tempStart;
                end = i;
            }
        }
        
        return new MaxSubarrayResult(maxSoFar, start, end);
    }
    
    public static int maxProduct(int[] nums) {
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }
            
            maxSoFar = Math.max(nums[i], maxSoFar * nums[i]);
            minSoFar = Math.min(nums[i], minSoFar * nums[i]);
            
            result = Math.max(result, maxSoFar);
        }
        
        return result;
    }
    
    public static int maxSubarraySumCircular(int[] nums) {
        // Case 1: Maximum subarray is non-circular (use Kadane's)
        int maxKadane = maxSubArray(nums);
        
        // Case 2: Maximum subarray is circular
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        // Find minimum subarray sum
        int minKadane = minSubArray(nums);
        int maxCircular = totalSum - minKadane;
        
        // If all elements are negative, maxCircular will be 0
        return maxCircular == 0 ? maxKadane : Math.max(maxKadane, maxCircular);
    }
    
    private static int minSubArray(int[] nums) {
        int minSoFar = nums[0];
        int minEndingHere = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            minEndingHere = Math.min(nums[i], minEndingHere + nums[i]);
            minSoFar = Math.min(minSoFar, minEndingHere);
        }
        
        return minSoFar;
    }
    
    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n - k + 1];
        
        // Calculate sum of each subarray of length k
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        sum[0] = windowSum;
        
        for (int i = k; i < n; i++) {
            windowSum += nums[i] - nums[i - k];
            sum[i - k + 1] = windowSum;
        }
        
        // Find the best left and right indices
        int[] left = new int[sum.length];
        int[] right = new int[sum.length];
        
        int best = 0;
        for (int i = 0; i < sum.length; i++) {
            if (sum[i] > sum[best]) {
                best = i;
            }
            left[i] = best;
        }
        
        best = sum.length - 1;
        for (int i = sum.length - 1; i >= 0; i--) {
            if (sum[i] >= sum[best]) {
                best = i;
            }
            right[i] = best;
        }
        
        // Find the maximum sum
        int[] result = new int[3];
        int maxSum = 0;
        
        for (int mid = k; mid < sum.length - k; mid++) {
            int l = left[mid - k];
            int r = right[mid + k];
            int currentSum = sum[l] + sum[mid] + sum[r];
            
            if (currentSum > maxSum) {
                maxSum = currentSum;
                result[0] = l;
                result[1] = mid;
                result[2] = r;
            }
        }
        
        return result;
    }
    
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        
        return maxProfit;
    }
    
    public static int maxProfitMultiple(int[] prices) {
        int maxProfit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        
        return maxProfit;
    }
    
    // ===== KNAPSACK IMPLEMENTATIONS =====
    
    public static int knapsack01(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], 
                                       dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        
        return dp[n][capacity];
    }
    
    public static int unboundedKnapsack(int[] weights, int[] values, int capacity) {
        int[] dp = new int[capacity + 1];
        
        for (int w = 1; w <= capacity; w++) {
            for (int i = 0; i < weights.length; i++) {
                if (weights[i] <= w) {
                    dp[w] = Math.max(dp[w], dp[w - weights[i]] + values[i]);
                }
            }
        }
        
        return dp[capacity];
    }
    
    public static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        
        return dp[target];
    }
    
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (sum < Math.abs(target) || (sum + target) % 2 != 0) return 0;
        
        int subsetSum = (sum + target) / 2;
        int[] dp = new int[subsetSum + 1];
        dp[0] = 1;
        
        for (int num : nums) {
            for (int j = subsetSum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        
        return dp[subsetSum];
    }
    
    public static int coinChange2(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        
        return dp[amount];
    }
    
    // ===== STRING DP IMPLEMENTATIONS =====
    
    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0, maxLen = 1;
        
        // Every single character is palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        
        // Check for palindrome of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLen = 2;
            }
        }
        
        // Check for palindromes of length 3 and more
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    start = i;
                    maxLen = len;
                }
            }
        }
        
        return s.substring(start, start + maxLen);
    }
    
    public static int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;
        
        // Single characters
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            count++;
        }
        
        // Two characters
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                count++;
            }
        }
        
        // Three or more characters
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public static boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        dp[0][0] = true;
        
        // Handle patterns like a*, a*b*, a*b*c*
        for (int j = 2; j <= n; j += 2) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] || 
                              (dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'));
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && 
                              (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
                }
            }
        }
        
        return dp[m][n];
    }
    
    public static boolean isMatchWildcard(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        dp[0][0] = true;
        
        // Handle leading *
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && 
                              (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?');
                }
            }
        }
        
        return dp[m][n];
    }
    
    public static int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        long[][] dp = new long[m + 1][n + 1];
        
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        
        return (int) dp[m][n];
    }
    
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
    
    // ===== ADVANCED DP IMPLEMENTATIONS =====
    
    public static int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int maxLen = 0;
        
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (dp[i - 1] > 0) {
                    int matchIndex = i - dp[i - 1] - 1;
                    if (matchIndex >= 0 && s.charAt(matchIndex) == '(') {
                        dp[i] = dp[i - 1] + 2 + (matchIndex > 0 ? dp[matchIndex - 1] : 0);
                    }
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        
        return maxLen;
    }
    
    public static int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; // Sort height in descending order
            }
            return a[0] - b[0]; // Sort width in ascending order
        });
        
        int[] heights = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            heights[i] = envelopes[i][1];
        }
        
        return lengthOfLIS(heights);
    }
    
    public static int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = newNums[n + 1] = 1;
        System.arraycopy(nums, 0, newNums, 1, n);
        
        int[][] dp = new int[n + 2][n + 2];
        
        for (int len = 1; len <= n; len++) {
            for (int left = 1; left <= n - len + 1; left++) {
                int right = left + len - 1;
                for (int k = left; k <= right; k++) {
                    dp[left][right] = Math.max(dp[left][right], 
                        dp[left][k - 1] + newNums[left - 1] * newNums[k] * newNums[right + 1] + dp[k + 1][right]);
                }
            }
        }
        
        return dp[1][n];
    }
    
    public static boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }
        
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        
        return dp[0][n - 1] > 0;
    }
    
    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        
        int m = matrix.length, n = matrix[0].length;
        int[] heights = new int[n];
        int maxArea = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        
        return maxArea;
    }
    
    private static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        
        for (int i = 0; i <= heights.length; i++) {
            int h = i == heights.length ? 0 : heights[i];
            
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            
            stack.push(i);
        }
        
        return maxArea;
    }
    
    // Helper class for maximum subarray with indices
    static class MaxSubarrayResult {
        int sum, start, end;
        
        MaxSubarrayResult(int sum, int start, int end) {
            this.sum = sum;
            this.start = start;
            this.end = end;
        }
    }
}

/*
DYNAMIC PROGRAMMING COMPLETE CHEAT SHEET:

FUNDAMENTAL CONCEPTS:
1. Optimal Substructure: Problem can be broken into subproblems
2. Overlapping Subproblems: Same subproblems solved multiple times
3. Memoization: Top-down approach with caching
4. Tabulation: Bottom-up approach with table

DP PROBLEM IDENTIFICATION:
- "Find optimal (maximum/minimum) value"
- "Count number of ways"
- "Find if possible/exists"
- "Find all possible solutions"

1D DP PATTERNS:
- Linear scan: dp[i] depends on dp[i-1], dp[i-2], etc.
- Decision problems: Include/exclude current element
- Sequence problems: Build optimal sequence

2D DP PATTERNS:
- Grid problems: dp[i][j] from dp[i-1][j] and dp[i][j-1]
- String matching: Compare characters from two strings
- Range problems: dp[i][j] represents range from i to j

KADANE'S ALGORITHM:
- Maximum subarray sum in O(n) time
- Key insight: At each position, either extend previous subarray or start new
- Variations: Circular array, product instead of sum, k-length subarray

KNAPSACK PATTERNS:
1. 0/1 Knapsack: Each item can be taken at most once
2. Unbounded Knapsack: Items can be taken multiple times
3. Bounded Knapsack: Each item has limited quantity

COMMON DP PROBLEMS BY PATTERN:

LINEAR DP:
- Fibonacci, Climbing Stairs, House Robber
- Coin Change, Perfect Squares
- Longest Increasing Subsequence

GRID DP:
- Unique Paths, Minimum Path Sum
- Triangle, Dungeon Game

STRING DP:
- Edit Distance, Longest Common Subsequence
- Palindrome problems, Pattern matching

INTERVAL DP:
- Matrix Chain Multiplication
- Burst Balloons, Stone Game

BITMASK DP:
- Traveling Salesman Problem
- Assignment problems with constraints

OPTIMIZATION TECHNIQUES:
1. Space optimization: Use 1D array instead of 2D
2. Rolling array: Keep only last few states
3. Memoization vs Tabulation: Choose based on problem

TIME/SPACE COMPLEXITY:
- 1D DP: Usually O(n) time, O(n) or O(1) space
- 2D DP: Usually O(mn) time, O(mn) or O(min(m,n)) space
- String DP: Often O(n²) time and space

INTERVIEW TIPS:
1. Always clarify constraints and edge cases
2. Start with recursive solution, then optimize
3. Draw the DP table for small examples
4. Consider space optimization after getting correct solution
5. Practice explaining the state transition
*/