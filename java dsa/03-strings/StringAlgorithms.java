/**
 * String Algorithms - Common patterns and algorithms for string problems
 * 
 * Master these patterns and you'll solve most string-related interview questions
 */

public class StringAlgorithms {
    
    public static void main(String[] args) {
        System.out.println("=== String Algorithms ===\n");
        
        palindromeChecking();
        stringReversal();
        anagramChecking();
        patternMatching();
        stringPermutations();
    }
    
    /**
     * PALINDROME CHECKING - Very common in interviews
     */
    public static void palindromeChecking() {
        System.out.println("=== Palindrome Checking ===");
        
        String[] testStrings = {
            "racecar",
            "A man a plan a canal Panama",
            "race a car",
            "hello",
            "madam"
        };
        
        for (String str : testStrings) {
            boolean isPalin1 = isPalindromeTwoPointer(str);
            boolean isPalin2 = isPalindromeReverse(str);
            boolean isPalin3 = isPalindromeAlphanumericOnly(str);
            
            System.out.println("'" + str + "':");
            System.out.println("  Two Pointer: " + isPalin1);
            System.out.println("  Reverse Method: " + isPalin2);
            System.out.println("  Alphanumeric Only: " + isPalin3);
            System.out.println();
        }
    }
    
    /**
     * Check palindrome using two pointers - O(n) time, O(1) space
     */
    public static boolean isPalindromeTwoPointer(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
    
    /**
     * Check palindrome by reversing string - O(n) time, O(n) space
     */
    public static boolean isPalindromeReverse(String s) {
        String reversed = reverseString(s);
        return s.equals(reversed);
    }
    
    /**
     * Check palindrome considering only alphanumeric characters - LeetCode style
     */
    public static boolean isPalindromeAlphanumericOnly(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            // Skip non-alphanumeric characters from left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            
            // Skip non-alphanumeric characters from right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            
            // Compare characters (case-insensitive)
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
    
    /**
     * STRING REVERSAL - Multiple approaches
     */
    public static void stringReversal() {
        System.out.println("=== String Reversal ===");
        
        String original = "Hello World";
        System.out.println("Original: " + original);
        
        // Method 1: Using StringBuilder
        String reversed1 = reverseStringBuilder(original);
        System.out.println("StringBuilder: " + reversed1);
        
        // Method 2: Using two pointers on char array
        String reversed2 = reverseCharArray(original);
        System.out.println("Char Array: " + reversed2);
        
        // Method 3: Using recursion
        String reversed3 = reverseStringRecursive(original);
        System.out.println("Recursive: " + reversed3);
        
        // Method 4: Manual approach
        String reversed4 = reverseString(original);
        System.out.println("Manual: " + reversed4);
        
        System.out.println();
    }
    
    public static String reverseStringBuilder(String s) {
        return new StringBuilder(s).reverse().toString();
    }
    
    public static String reverseCharArray(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        
        return new String(chars);
    }
    
    public static String reverseStringRecursive(String s) {
        if (s.length() <= 1) {
            return s;
        }
        return reverseStringRecursive(s.substring(1)) + s.charAt(0);
    }
    
    public static String reverseString(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            result.append(s.charAt(i));
        }
        return result.toString();
    }
    
    /**
     * ANAGRAM CHECKING - Determine if two strings are anagrams
     */
    public static void anagramChecking() {
        System.out.println("=== Anagram Checking ===");
        
        String[][] testPairs = {
            {"listen", "silent"},
            {"elbow", "below"},
            {"study", "dusty"},
            {"hello", "world"},
            {"anagram", "nagaram"}
        };
        
        for (String[] pair : testPairs) {
            boolean isAnagram1 = isAnagramSort(pair[0], pair[1]);
            boolean isAnagram2 = isAnagramCount(pair[0], pair[1]);
            
            System.out.println("'" + pair[0] + "' and '" + pair[1] + "':");
            System.out.println("  Sort method: " + isAnagram1);
            System.out.println("  Count method: " + isAnagram2);
            System.out.println();
        }
    }
    
    /**
     * Check anagram by sorting - O(n log n) time
     */
    public static boolean isAnagramSort(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        
        java.util.Arrays.sort(chars1);
        java.util.Arrays.sort(chars2);
        
        return java.util.Arrays.equals(chars1, chars2);
    }
    
    /**
     * Check anagram by counting characters - O(n) time
     */
    public static boolean isAnagramCount(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        
        // Count frequency of each character
        int[] charCount = new int[26];  // Assuming lowercase English letters
        
        for (int i = 0; i < s1.length(); i++) {
            charCount[s1.charAt(i) - 'a']++;  // Increment for s1
            charCount[s2.charAt(i) - 'a']--;  // Decrement for s2
        }
        
        // If anagrams, all counts should be zero
        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * PATTERN MATCHING - Find all occurrences of pattern in text
     */
    public static void patternMatching() {
        System.out.println("=== Pattern Matching ===");
        
        String text = "ababcababa";
        String pattern = "aba";
        
        System.out.println("Text: " + text);
        System.out.println("Pattern: " + pattern);
        
        // Naive pattern matching
        java.util.List<Integer> positions = findPatternNaive(text, pattern);
        System.out.println("Pattern found at positions: " + positions);
        
        // Count occurrences
        int count = countPatternOccurrences(text, pattern);
        System.out.println("Total occurrences: " + count);
        
        System.out.println();
    }
    
    /**
     * Naive pattern matching - O(nm) time where n=text length, m=pattern length
     */
    public static java.util.List<Integer> findPatternNaive(String text, String pattern) {
        java.util.List<Integer> positions = new java.util.ArrayList<>();
        
        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            boolean found = true;
            
            for (int j = 0; j < pattern.length(); j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    found = false;
                    break;
                }
            }
            
            if (found) {
                positions.add(i);
            }
        }
        
        return positions;
    }
    
    /**
     * Count pattern occurrences
     */
    public static int countPatternOccurrences(String text, String pattern) {
        int count = 0;
        int index = 0;
        
        while ((index = text.indexOf(pattern, index)) != -1) {
            count++;
            index++;  // Move to next position for overlapping matches
        }
        
        return count;
    }
    
    /**
     * STRING PERMUTATIONS - Generate and check permutations
     */
    public static void stringPermutations() {
        System.out.println("=== String Permutations ===");
        
        String str = "abc";
        System.out.println("Permutations of '" + str + "':");
        
        java.util.List<String> permutations = generatePermutations(str);
        for (int i = 0; i < permutations.size(); i++) {
            System.out.println((i + 1) + ". " + permutations.get(i));
        }
        
        // Check if one string is permutation of another
        String str1 = "abc";
        String str2 = "bca";
        String str3 = "xyz";
        
        System.out.println("\nPermutation checks:");
        System.out.println("'" + str1 + "' is permutation of '" + str2 + "': " + 
                           isPermutation(str1, str2));
        System.out.println("'" + str1 + "' is permutation of '" + str3 + "': " + 
                           isPermutation(str1, str3));
        
        System.out.println();
    }
    
    /**
     * Generate all permutations of a string
     */
    public static java.util.List<String> generatePermutations(String str) {
        java.util.List<String> result = new java.util.ArrayList<>();
        generatePermutationsHelper("", str, result);
        return result;
    }
    
    private static void generatePermutationsHelper(String prefix, String remaining, 
                                                   java.util.List<String> result) {
        if (remaining.length() == 0) {
            result.add(prefix);
            return;
        }
        
        for (int i = 0; i < remaining.length(); i++) {
            String newPrefix = prefix + remaining.charAt(i);
            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
            generatePermutationsHelper(newPrefix, newRemaining, result);
        }
    }
    
    /**
     * Check if two strings are permutations of each other
     */
    public static boolean isPermutation(String s1, String s2) {
        // Same as anagram checking
        return isAnagramCount(s1, s2);
    }
}

/*
STRING ALGORITHM PATTERNS:

1. TWO POINTERS:
   - Palindrome checking
   - Reversing strings
   - Finding pairs

2. SLIDING WINDOW:
   - Substring problems
   - Pattern matching
   - Longest/shortest substrings

3. CHARACTER FREQUENCY:
   - Anagram detection
   - Character counting
   - Duplicate detection

4. STRING BUILDING:
   - Use StringBuilder for efficiency
   - Avoid repeated concatenation
   - Consider space complexity

5. RECURSION:
   - Permutation generation
   - Substring problems
   - Tree-like string processing

COMPLEXITY CONSIDERATIONS:
- String creation: O(n) time and space
- Character access: O(1)
- Substring: O(n) time and space
- Pattern matching: O(nm) naive, O(n+m) advanced

COMMON OPTIMIZATIONS:
- Use char arrays instead of strings for modifications
- StringBuilder for building strings
- Early termination in comparisons
- Character frequency arrays for counting

INTERVIEW TIPS:
- Always ask about case sensitivity
- Clarify if spaces and special characters matter
- Consider Unicode vs ASCII
- Think about edge cases (empty strings, single characters)
*/