/**
 * Java Collections Framework and Advanced Algorithms
 *
 * This file includes implementations for:
 * - Dynamic Programming (1D and 2D)
 * - Kadane's Algorithm
 * - Knapsack Problem
 * - Recursion and Backtracking
 * - Trees and Graphs
 * - Tries
 * - List, Set, and Map Interfaces
 */

import java.util.*;

public class JavaCollectionsFramework {

    public static void main(String[] args) {
        System.out.println("=== Java Collections Framework and Advanced Algorithms ===\n");

        demonstrateDynamicProgramming();
        demonstrateKadaneAlgorithm();
        demonstrateKnapsackProblem();
        demonstrateRecursionAndBacktracking();
        demonstrateTreesAndGraphs();
        demonstrateTries();
        demonstrateListSetMapInterfaces();
    }

    /**
     * Dynamic Programming (1D and 2D)
     */
    public static void demonstrateDynamicProgramming() {
        System.out.println("=== Dynamic Programming ===");

        // 1D DP: Fibonacci sequence
        int n = 10;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println("Fibonacci sequence: " + Arrays.toString(dp));

        // 2D DP: Longest Common Subsequence
        String s1 = "abcde", s2 = "ace";
        int[][] lcs = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }
        System.out.println("Longest Common Subsequence length: " + lcs[s1.length()][s2.length()]);
        System.out.println();
    }

    /**
     * Kadane's Algorithm
     */
    public static void demonstrateKadaneAlgorithm() {
        System.out.println("=== Kadane's Algorithm ===");

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = nums[0], currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        System.out.println("Maximum subarray sum: " + maxSum);
        System.out.println();
    }

    /**
     * Knapsack Problem
     */
    public static void demonstrateKnapsackProblem() {
        System.out.println("=== Knapsack Problem ===");

        int[] weights = {1, 3, 4, 5};
        int[] values = {1, 4, 5, 7};
        int capacity = 7;
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        System.out.println("Maximum value in Knapsack: " + dp[n][capacity]);
        System.out.println();
    }

    /**
     * Recursion and Backtracking
     */
    public static void demonstrateRecursionAndBacktracking() {
        System.out.println("=== Recursion and Backtracking ===");

        // N-Queens Problem
        int n = 4;
        List<List<String>> solutions = new ArrayList<>();
        solveNQueens(n, 0, new boolean[n], new boolean[2 * n], new boolean[2 * n], new ArrayList<>(), solutions);
        System.out.println("N-Queens solutions: " + solutions);
        System.out.println();
    }

    private static void solveNQueens(int n, int row, boolean[] cols, boolean[] d1, boolean[] d2, List<String> board, List<List<String>> solutions) {
        if (row == n) {
            solutions.add(new ArrayList<>(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            int id1 = row - col + n, id2 = row + col;
            if (cols[col] || d1[id1] || d2[id2]) continue;
            char[] rowArray = new char[n];
            Arrays.fill(rowArray, '.');
            rowArray[col] = 'Q';
            board.add(new String(rowArray));
            cols[col] = d1[id1] = d2[id2] = true;
            solveNQueens(n, row + 1, cols, d1, d2, board, solutions);
            board.remove(board.size() - 1);
            cols[col] = d1[id1] = d2[id2] = false;
        }
    }

    /**
     * Trees and Graphs
     */
    public static void demonstrateTreesAndGraphs() {
        System.out.println("=== Trees and Graphs ===");

        // Binary Tree Traversal
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println("Inorder Traversal: " + inorderTraversal(root));
        System.out.println();
    }

    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    /**
     * Tries
     */
    public static void demonstrateTries() {
        System.out.println("=== Tries ===");

        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println("Search 'apple': " + trie.search("apple"));
        System.out.println("Search 'app': " + trie.search("app"));
        System.out.println();
    }

    static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode());
                }
                node = node.children.get(c);
            }
            node.isEndOfWord = true;
        }

        public boolean search(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    return false;
                }
                node = node.children.get(c);
            }
            return node.isEndOfWord;
        }

        static class TrieNode {
            Map<Character, TrieNode> children = new HashMap<>();
            boolean isEndOfWord;
        }
    }

    /**
     * List, Set, and Map Interfaces
     */
    public static void demonstrateListSetMapInterfaces() {
        System.out.println("=== List, Set, and Map Interfaces ===");

        // List
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("List: " + list);

        // Set
        Set<Integer> set = new HashSet<>(list);
        System.out.println("Set: " + set);

        // Map
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(i, "Value" + list.get(i));
        }
        System.out.println("Map: " + map);
        System.out.println();
    }
}