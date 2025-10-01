/**
 * Recursion and Backtracking - Master the Art of Problem Solving
 * 
 * Complete guide to recursive thinking and backtracking algorithms
 */

import java.util.*;

public class RecursionBacktracking {
    
    public static void main(String[] args) {
        System.out.println("=== Recursion and Backtracking Mastery ===\n");
        
        demonstrateBasicRecursion();
        demonstrateAdvancedRecursion();
        demonstrateBacktracking();
        demonstrateTreeRecursion();
        demonstrateOptimization();
    }
    
    /**
     * BASIC RECURSION - Foundation concepts
     */
    public static void demonstrateBasicRecursion() {
        System.out.println("=== Basic Recursion ===");
        
        // 1. Factorial
        int n = 5;
        System.out.println("Factorial of " + n + ": " + factorial(n));
        
        // 2. Fibonacci
        int fib = 10;
        System.out.println("Fibonacci(" + fib + "): " + fibonacci(fib));
        System.out.println("Fibonacci Optimized(" + fib + "): " + fibonacciOptimized(fib));
        
        // 3. Power calculation
        int base = 2, exp = 10;
        System.out.println(base + "^" + exp + " = " + power(base, exp));
        System.out.println(base + "^" + exp + " (Fast) = " + fastPower(base, exp));
        
        // 4. Sum of digits
        int num = 12345;
        System.out.println("Sum of digits in " + num + ": " + sumOfDigits(num));
        
        // 5. Reverse a string
        String str = "hello";
        System.out.println("Reverse of '" + str + "': " + reverseString(str));
        
        // 6. Check palindrome
        String palindrome = "racecar";
        System.out.println("Is '" + palindrome + "' palindrome? " + isPalindrome(palindrome, 0, palindrome.length() - 1));
        
        System.out.println();
    }
    
    /**
     * ADVANCED RECURSION - Complex recursive patterns
     */
    public static void demonstrateAdvancedRecursion() {
        System.out.println("=== Advanced Recursion ===");
        
        // 1. Tower of Hanoi
        System.out.println("Tower of Hanoi (3 disks):");
        towerOfHanoi(3, 'A', 'C', 'B');
        
        // 2. Generate all subsets
        int[] arr = {1, 2, 3};
        List<List<Integer>> subsets = generateSubsets(arr);
        System.out.println("All subsets of " + Arrays.toString(arr) + ": " + subsets);
        
        // 3. Generate all permutations
        List<List<Integer>> permutations = generatePermutations(arr);
        System.out.println("All permutations: " + permutations);
        
        // 4. Binary representation
        System.out.println("Binary representations from 1 to 4:");
        for (int i = 1; i <= 4; i++) {
            System.out.println(i + " -> " + decimalToBinary(i));
        }
        
        // 5. Count ways to climb stairs
        int stairs = 5;
        System.out.println("Ways to climb " + stairs + " stairs: " + climbStairs(stairs));
        
        System.out.println();
    }
    
    /**
     * BACKTRACKING - Systematic search with pruning
     */
    public static void demonstrateBacktracking() {
        System.out.println("=== Backtracking Algorithms ===");
        
        // 1. N-Queens Problem
        System.out.println("N-Queens (4x4 board):");
        List<List<String>> nQueensSolutions = solveNQueens(4);
        for (int i = 0; i < Math.min(2, nQueensSolutions.size()); i++) {
            System.out.println("Solution " + (i + 1) + ":");
            for (String row : nQueensSolutions.get(i)) {
                System.out.println("  " + row);
            }
        }
        
        // 2. Sudoku Solver
        int[][] sudoku = {
            {5,3,0,0,7,0,0,0,0},
            {6,0,0,1,9,5,0,0,0},
            {0,9,8,0,0,0,0,6,0},
            {8,0,0,0,6,0,0,0,3},
            {4,0,0,8,0,3,0,0,1},
            {7,0,0,0,2,0,0,0,6},
            {0,6,0,0,0,0,2,8,0},
            {0,0,0,4,1,9,0,0,5},
            {0,0,0,0,8,0,0,7,9}
        };
        System.out.println("Sudoku solved: " + solveSudoku(sudoku));
        
        // 3. Word Search
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        String word = "ABCCED";
        System.out.println("Word '" + word + "' exists in board: " + wordSearch(board, word));
        
        // 4. Combination Sum
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> combinations = combinationSum(candidates, target);
        System.out.println("Combinations that sum to " + target + ": " + combinations);
        
        // 5. Letter Combinations of Phone Number
        String digits = "23";
        List<String> letterCombinations = letterCombinations(digits);
        System.out.println("Letter combinations of '" + digits + "': " + letterCombinations);
        
        System.out.println();
    }
    
    /**
     * TREE RECURSION - Binary tree problems
     */
    public static void demonstrateTreeRecursion() {
        System.out.println("=== Tree Recursion ===");
        
        // Create a sample tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        
        // Tree traversals
        System.out.println("Inorder traversal: " + inorderTraversal(root));
        System.out.println("Preorder traversal: " + preorderTraversal(root));
        System.out.println("Postorder traversal: " + postorderTraversal(root));
        
        // Tree properties
        System.out.println("Tree height: " + maxDepth(root));
        System.out.println("Is balanced: " + isBalanced(root));
        System.out.println("Has path sum 8: " + hasPathSum(root, 8));
        
        // Path problems
        List<List<Integer>> allPaths = binaryTreePaths(root);
        System.out.println("All root-to-leaf paths: " + allPaths);
        
        System.out.println();
    }
    
    /**
     * OPTIMIZATION TECHNIQUES - Memoization and pruning
     */
    public static void demonstrateOptimization() {
        System.out.println("=== Optimization Techniques ===");
        
        // 1. Memoization example
        System.out.println("Fibonacci with memoization:");
        Map<Integer, Long> memo = new HashMap<>();
        for (int i = 1; i <= 10; i++) {
            System.out.println("fib(" + i + ") = " + fibMemo(i, memo));
        }
        
        // 2. Edit Distance with memoization
        String word1 = "horse", word2 = "ros";
        System.out.println("Edit distance between '" + word1 + "' and '" + word2 + "': " + 
                          minDistance(word1, word2));
        
        // 3. Longest Common Subsequence
        String text1 = "abcde", text2 = "ace";
        System.out.println("LCS of '" + text1 + "' and '" + text2 + "': " + 
                          longestCommonSubsequence(text1, text2));
        
        System.out.println();
    }
    
    // ===== BASIC RECURSION IMPLEMENTATIONS =====
    
    public static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
    
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    public static int fibonacciOptimized(int n) {
        return fibHelper(n, new HashMap<>());
    }
    
    private static int fibHelper(int n, Map<Integer, Integer> memo) {
        if (n <= 1) return n;
        if (memo.containsKey(n)) return memo.get(n);
        
        int result = fibHelper(n - 1, memo) + fibHelper(n - 2, memo);
        memo.put(n, result);
        return result;
    }
    
    public static int power(int base, int exp) {
        if (exp == 0) return 1;
        return base * power(base, exp - 1);
    }
    
    public static int fastPower(int base, int exp) {
        if (exp == 0) return 1;
        if (exp % 2 == 0) {
            int half = fastPower(base, exp / 2);
            return half * half;
        }
        return base * fastPower(base, exp - 1);
    }
    
    public static int sumOfDigits(int n) {
        if (n == 0) return 0;
        return n % 10 + sumOfDigits(n / 10);
    }
    
    public static String reverseString(String s) {
        if (s.length() <= 1) return s;
        return reverseString(s.substring(1)) + s.charAt(0);
    }
    
    public static boolean isPalindrome(String s, int left, int right) {
        if (left >= right) return true;
        if (s.charAt(left) != s.charAt(right)) return false;
        return isPalindrome(s, left + 1, right - 1);
    }
    
    // ===== ADVANCED RECURSION IMPLEMENTATIONS =====
    
    public static void towerOfHanoi(int n, char from, char to, char aux) {
        if (n == 1) {
            System.out.println("  Move disk 1 from " + from + " to " + to);
            return;
        }
        towerOfHanoi(n - 1, from, aux, to);
        System.out.println("  Move disk " + n + " from " + from + " to " + to);
        towerOfHanoi(n - 1, aux, to, from);
    }
    
    public static List<List<Integer>> generateSubsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsetsHelper(nums, 0, new ArrayList<>(), result);
        return result;
    }
    
    private static void generateSubsetsHelper(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            generateSubsetsHelper(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
    
    public static List<List<Integer>> generatePermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generatePermutationsHelper(nums, new ArrayList<>(), new boolean[nums.length], result);
        return result;
    }
    
    private static void generatePermutationsHelper(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                current.add(nums[i]);
                generatePermutationsHelper(nums, current, used, result);
                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }
    
    public static String decimalToBinary(int n) {
        if (n == 0) return "0";
        if (n == 1) return "1";
        return decimalToBinary(n / 2) + (n % 2);
    }
    
    public static int climbStairs(int n) {
        if (n <= 2) return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
    
    // ===== BACKTRACKING IMPLEMENTATIONS =====
    
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        solveNQueensHelper(board, 0, result);
        return result;
    }
    
    private static void solveNQueensHelper(char[][] board, int row, List<List<String>> result) {
        if (row == board.length) {
            result.add(constructBoard(board));
            return;
        }
        
        for (int col = 0; col < board.length; col++) {
            if (isQueenSafe(board, row, col)) {
                board[row][col] = 'Q';
                solveNQueensHelper(board, row + 1, result);
                board[row][col] = '.';
            }
        }
    }
    
    private static boolean isQueenSafe(char[][] board, int row, int col) {
        int n = board.length;
        
        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        
        // Check diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        
        // Check anti-diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        
        return true;
    }
    
    private static List<String> constructBoard(char[][] board) {
        List<String> result = new ArrayList<>();
        for (char[] row : board) {
            result.add(new String(row));
        }
        return result;
    }
    
    public static boolean solveSudoku(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValidSudoku(board, i, j, num)) {
                            board[i][j] = num;
                            if (solveSudoku(board)) return true;
                            board[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private static boolean isValidSudoku(int[][] board, int row, int col, int num) {
        // Check row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) return false;
        }
        
        // Check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) return false;
        }
        
        // Check 3x3 box
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }
        
        return true;
    }
    
    public static boolean wordSearch(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (wordSearchDFS(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private static boolean wordSearchDFS(char[][] board, String word, int index, int row, int col) {
        if (index == word.length()) return true;
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || 
            board[row][col] != word.charAt(index)) {
            return false;
        }
        
        char temp = board[row][col];
        board[row][col] = '#'; // Mark as visited
        
        boolean found = wordSearchDFS(board, word, index + 1, row + 1, col) ||
                       wordSearchDFS(board, word, index + 1, row - 1, col) ||
                       wordSearchDFS(board, word, index + 1, row, col + 1) ||
                       wordSearchDFS(board, word, index + 1, row, col - 1);
        
        board[row][col] = temp; // Backtrack
        return found;
    }
    
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSumHelper(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    
    private static void combinationSumHelper(int[] candidates, int target, int start, 
                                           List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) return;
        
        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            combinationSumHelper(candidates, target - candidates[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }
    
    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();
        
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        letterCombinationsHelper(digits, 0, new StringBuilder(), mapping, result);
        return result;
    }
    
    private static void letterCombinationsHelper(String digits, int index, StringBuilder current,
                                               String[] mapping, List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        
        String letters = mapping[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            current.append(c);
            letterCombinationsHelper(digits, index + 1, current, mapping, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
    
    // ===== TREE RECURSION IMPLEMENTATIONS =====
    
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }
    
    private static void inorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        inorderHelper(node.left, result);
        result.add(node.val);
        inorderHelper(node.right, result);
    }
    
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }
    
    private static void preorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        result.add(node.val);
        preorderHelper(node.left, result);
        preorderHelper(node.right, result);
    }
    
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderHelper(root, result);
        return result;
    }
    
    private static void postorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        postorderHelper(node.left, result);
        postorderHelper(node.right, result);
        result.add(node.val);
    }
    
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    
    public static boolean isBalanced(TreeNode root) {
        return checkBalance(root) != -1;
    }
    
    private static int checkBalance(TreeNode node) {
        if (node == null) return 0;
        
        int leftHeight = checkBalance(node.left);
        if (leftHeight == -1) return -1;
        
        int rightHeight = checkBalance(node.right);
        if (rightHeight == -1) return -1;
        
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        
        return 1 + Math.max(leftHeight, rightHeight);
    }
    
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        
        int remainingSum = targetSum - root.val;
        return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
    }
    
    public static List<List<Integer>> binaryTreePaths(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            pathsHelper(root, new ArrayList<>(), result);
        }
        return result;
    }
    
    private static void pathsHelper(TreeNode node, List<Integer> current, List<List<Integer>> result) {
        current.add(node.val);
        
        if (node.left == null && node.right == null) {
            result.add(new ArrayList<>(current));
        } else {
            if (node.left != null) pathsHelper(node.left, current, result);
            if (node.right != null) pathsHelper(node.right, current, result);
        }
        
        current.remove(current.size() - 1);
    }
    
    // ===== OPTIMIZATION IMPLEMENTATIONS =====
    
    public static long fibMemo(int n, Map<Integer, Long> memo) {
        if (n <= 1) return n;
        if (memo.containsKey(n)) return memo.get(n);
        
        long result = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);
        memo.put(n, result);
        return result;
    }
    
    public static int minDistance(String word1, String word2) {
        Integer[][] memo = new Integer[word1.length()][word2.length()];
        return minDistanceHelper(word1, word2, 0, 0, memo);
    }
    
    private static int minDistanceHelper(String word1, String word2, int i, int j, Integer[][] memo) {
        if (i == word1.length()) return word2.length() - j;
        if (j == word2.length()) return word1.length() - i;
        
        if (memo[i][j] != null) return memo[i][j];
        
        if (word1.charAt(i) == word2.charAt(j)) {
            memo[i][j] = minDistanceHelper(word1, word2, i + 1, j + 1, memo);
        } else {
            int insert = minDistanceHelper(word1, word2, i, j + 1, memo);
            int delete = minDistanceHelper(word1, word2, i + 1, j, memo);
            int replace = minDistanceHelper(word1, word2, i + 1, j + 1, memo);
            memo[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
        }
        
        return memo[i][j];
    }
    
    public static int longestCommonSubsequence(String text1, String text2) {
        Integer[][] memo = new Integer[text1.length()][text2.length()];
        return lcsHelper(text1, text2, 0, 0, memo);
    }
    
    private static int lcsHelper(String text1, String text2, int i, int j, Integer[][] memo) {
        if (i == text1.length() || j == text2.length()) return 0;
        
        if (memo[i][j] != null) return memo[i][j];
        
        if (text1.charAt(i) == text2.charAt(j)) {
            memo[i][j] = 1 + lcsHelper(text1, text2, i + 1, j + 1, memo);
        } else {
            memo[i][j] = Math.max(lcsHelper(text1, text2, i + 1, j, memo),
                                 lcsHelper(text1, text2, i, j + 1, memo));
        }
        
        return memo[i][j];
    }
    
    // Helper class for tree problems
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int val) {
            this.val = val;
        }
    }
}

/*
RECURSION AND BACKTRACKING CHEAT SHEET:

RECURSION FUNDAMENTALS:
1. Base Case: When to stop recursion
2. Recursive Case: How to break down the problem
3. Progress: Each call should move toward base case
4. State: What information to pass between calls

RECURSION PATTERNS:
1. Linear Recursion: f(n) = f(n-1) + something
2. Binary Recursion: f(n) = f(n-1) + f(n-2)
3. Tail Recursion: Recursive call is the last operation
4. Tree Recursion: Multiple recursive calls per function

BACKTRACKING TEMPLATE:
```
void backtrack(state, choices) {
    if (isValidSolution(state)) {
        processSolution(state);
        return;
    }
    
    for (choice in choices) {
        if (isValid(choice)) {
            makeChoice(choice);
            backtrack(newState, newChoices);
            undoChoice(choice); // Backtrack
        }
    }
}
```

COMMON BACKTRACKING PROBLEMS:
- N-Queens: Place N queens on NxN board
- Sudoku: Fill 9x9 grid with constraints
- Word Search: Find word in 2D grid
- Combination Sum: Find combinations that sum to target
- Permutations: Generate all arrangements
- Subsets: Generate all possible subsets

OPTIMIZATION TECHNIQUES:
1. Memoization: Store results of expensive calls
2. Pruning: Skip invalid branches early
3. Iterative approach: Convert to iteration when possible
4. Tail recursion optimization: Use iteration

TIME COMPLEXITY:
- Linear recursion: O(n)
- Binary recursion: O(2^n) without memoization
- With memoization: Often O(n) or O(n²)
- Backtracking: O(b^d) where b=branching factor, d=depth

SPACE COMPLEXITY:
- Recursion stack: O(depth)
- Memoization: O(number of states)
- Backtracking: O(depth) for call stack

WHEN TO USE:
- Problem has optimal substructure
- Problem can be broken into similar subproblems
- Need to explore all possibilities (backtracking)
- Tree/graph traversal problems
- Mathematical problems (factorial, fibonacci)

LEETCODE PATTERNS:
- Tree problems: Almost always use recursion
- Combination/Permutation: Use backtracking
- Path finding: DFS with backtracking
- Validation: Recursive checking
- Construction: Build solutions recursively
*/