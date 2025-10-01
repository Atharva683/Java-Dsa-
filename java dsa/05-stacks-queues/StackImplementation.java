/**
 * Stack Implementation - Last In, First Out (LIFO) Data Structure
 * 
 * Stack is like a stack of plates - you can only add/remove from the top
 */

public class StackImplementation {
    
    /**
     * ARRAY-BASED STACK IMPLEMENTATION
     */
    static class ArrayStack {
        private int[] stack;
        private int top;        // Index of top element
        private int capacity;   // Maximum size
        
        // Constructor
        public ArrayStack(int capacity) {
            this.capacity = capacity;
            this.stack = new int[capacity];
            this.top = -1;  // Empty stack
        }
        
        // Push element onto stack - O(1)
        public void push(int data) {
            if (isFull()) {
                throw new RuntimeException("Stack Overflow: Cannot push " + data);
            }
            stack[++top] = data;
        }
        
        // Pop element from stack - O(1)
        public int pop() {
            if (isEmpty()) {
                throw new RuntimeException("Stack Underflow: Cannot pop from empty stack");
            }
            return stack[top--];
        }
        
        // Peek at top element without removing - O(1)
        public int peek() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return stack[top];
        }
        
        // Check if stack is empty - O(1)
        public boolean isEmpty() {
            return top == -1;
        }
        
        // Check if stack is full - O(1)
        public boolean isFull() {
            return top == capacity - 1;
        }
        
        // Get current size - O(1)
        public int size() {
            return top + 1;
        }
        
        // Display stack contents
        public void display() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return;
            }
            
            System.out.print("Stack (top to bottom): ");
            for (int i = top; i >= 0; i--) {
                System.out.print(stack[i]);
                if (i > 0) System.out.print(" -> ");
            }
            System.out.println();
        }
    }
    
    /**
     * LINKED LIST-BASED STACK IMPLEMENTATION
     */
    static class LinkedStack {
        private Node top;  // Top of stack
        private int size;
        
        // Node class
        static class Node {
            int data;
            Node next;
            
            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }
        
        // Constructor
        public LinkedStack() {
            this.top = null;
            this.size = 0;
        }
        
        // Push element onto stack - O(1)
        public void push(int data) {
            Node newNode = new Node(data);
            newNode.next = top;
            top = newNode;
            size++;
        }
        
        // Pop element from stack - O(1)
        public int pop() {
            if (isEmpty()) {
                throw new RuntimeException("Stack Underflow: Cannot pop from empty stack");
            }
            int data = top.data;
            top = top.next;
            size--;
            return data;
        }
        
        // Peek at top element - O(1)
        public int peek() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return top.data;
        }
        
        // Check if empty - O(1)
        public boolean isEmpty() {
            return top == null;
        }
        
        // Get size - O(1)
        public int size() {
            return size;
        }
        
        // Display stack
        public void display() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return;
            }
            
            Node current = top;
            System.out.print("Stack (top to bottom): ");
            while (current != null) {
                System.out.print(current.data);
                if (current.next != null) System.out.print(" -> ");
                current = current.next;
            }
            System.out.println();
        }
    }
    
    /**
     * STACK APPLICATIONS
     */
    
    // Check if parentheses are balanced
    public static boolean isBalancedParentheses(String expression) {
        ArrayStack stack = new ArrayStack(expression.length());
        
        for (char ch : expression.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;  // No matching opening bracket
                }
                
                char top = (char) stack.pop();
                if (!isMatchingPair(top, ch)) {
                    return false;  // Mismatched brackets
                }
            }
        }
        
        return stack.isEmpty();  // All brackets should be matched
    }
    
    private static boolean isMatchingPair(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
               (opening == '{' && closing == '}') ||
               (opening == '[' && closing == ']');
    }
    
    // Evaluate postfix expression (Reverse Polish Notation)
    public static int evaluatePostfix(String expression) {
        ArrayStack stack = new ArrayStack(expression.length());
        String[] tokens = expression.split(" ");
        
        for (String token : tokens) {
            if (isOperator(token)) {
                int b = stack.pop();
                int a = stack.pop();
                int result = performOperation(a, b, token);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }
    
    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || 
               token.equals("*") || token.equals("/");
    }
    
    private static int performOperation(int a, int b, String operator) {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            default: throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
    
    // Convert infix to postfix expression
    public static String infixToPostfix(String infix) {
        StringBuilder result = new StringBuilder();
        ArrayStack stack = new ArrayStack(infix.length());
        
        for (char ch : infix.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append((char) stack.pop());
                }
                stack.pop(); // Remove '('
            } else if (isOperator(String.valueOf(ch))) {
                while (!stack.isEmpty() && precedence((char) stack.peek()) >= precedence(ch)) {
                    result.append((char) stack.pop());
                }
                stack.push(ch);
            }
        }
        
        while (!stack.isEmpty()) {
            result.append((char) stack.pop());
        }
        
        return result.toString();
    }
    
    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }
    
    // Reverse a string using stack
    public static String reverseString(String str) {
        ArrayStack stack = new ArrayStack(str.length());
        
        // Push all characters onto stack
        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }
        
        // Pop all characters to get reversed string
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append((char) stack.pop());
        }
        
        return reversed.toString();
    }
    
    /**
     * MAIN METHOD - Test all implementations
     */
    public static void main(String[] args) {
        System.out.println("=== Stack Implementation Demo ===\n");
        
        // Test Array Stack
        System.out.println("=== Array Stack Test ===");
        ArrayStack arrayStack = new ArrayStack(5);
        
        arrayStack.push(10);
        arrayStack.push(20);
        arrayStack.push(30);
        arrayStack.display();
        
        System.out.println("Peek: " + arrayStack.peek());
        System.out.println("Pop: " + arrayStack.pop());
        arrayStack.display();
        System.out.println("Size: " + arrayStack.size());
        
        // Test Linked Stack
        System.out.println("\n=== Linked Stack Test ===");
        LinkedStack linkedStack = new LinkedStack();
        
        linkedStack.push(100);
        linkedStack.push(200);
        linkedStack.push(300);
        linkedStack.display();
        
        System.out.println("Peek: " + linkedStack.peek());
        System.out.println("Pop: " + linkedStack.pop());
        linkedStack.display();
        
        // Test Applications
        System.out.println("\n=== Stack Applications ===");
        
        // Balanced Parentheses
        String[] expressions = {
            "(())",
            "({[]})",
            "({[}])",
            "(((",
            "Hello (World)"
        };
        
        System.out.println("Balanced Parentheses Check:");
        for (String expr : expressions) {
            System.out.println("'" + expr + "' -> " + isBalancedParentheses(expr));
        }
        
        // Postfix Evaluation
        System.out.println("\nPostfix Expression Evaluation:");
        String postfix = "2 3 1 * + 9 -";
        System.out.println("'" + postfix + "' = " + evaluatePostfix(postfix));
        
        // Infix to Postfix Conversion
        System.out.println("\nInfix to Postfix Conversion:");
        String infix = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println("Infix: " + infix);
        System.out.println("Postfix: " + infixToPostfix(infix));
        
        // String Reversal
        System.out.println("\nString Reversal using Stack:");
        String original = "Hello World";
        String reversed = reverseString(original);
        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed);
    }
}

/*
STACK KEY CONCEPTS:

LIFO PRINCIPLE:
- Last element added is first to be removed
- Only top element is accessible
- Think of stack of plates or books

ARRAY VS LINKED LIST IMPLEMENTATION:

ARRAY STACK:
✅ Faster access (better cache locality)
✅ Less memory per element
❌ Fixed size (can overflow)
❌ Memory waste if not fully used

LINKED STACK:
✅ Dynamic size (no overflow)
✅ Memory efficient (only allocates what's needed)
❌ Extra memory for pointers
❌ Slower due to pointer traversal

COMMON STACK APPLICATIONS:
1. Function call management (call stack)
2. Expression evaluation (infix, postfix, prefix)
3. Balanced parentheses checking
4. Undo operations
5. Browser history
6. Depth-First Search (DFS)

INTERVIEW PROBLEMS:
- Valid Parentheses (LeetCode #20)
- Min Stack (LeetCode #155)
- Evaluate Reverse Polish Notation (LeetCode #150)
- Next Greater Element (LeetCode #496)
- Daily Temperatures (LeetCode #739)

IMPLEMENTATION TIPS:
- Always check for underflow (pop from empty stack)
- For array implementation, check for overflow
- Consider using dynamic arrays for flexibility
- Handle edge cases (empty stack operations)
*/