/**
 * Queue Implementation - First In, First Out (FIFO) Data Structure
 * 
 * Queue is like a line of people - first person to arrive is first to be served
 */

public class QueueImplementation {
    
    /**
     * ARRAY-BASED QUEUE IMPLEMENTATION (Circular Queue)
     */
    static class ArrayQueue {
        private int[] queue;
        private int front;      // Index of front element
        private int rear;       // Index of rear element
        private int size;       // Current number of elements
        private int capacity;   // Maximum capacity
        
        // Constructor
        public ArrayQueue(int capacity) {
            this.capacity = capacity;
            this.queue = new int[capacity];
            this.front = 0;
            this.rear = -1;
            this.size = 0;
        }
        
        // Add element to rear - O(1)
        public void enqueue(int data) {
            if (isFull()) {
                throw new RuntimeException("Queue Overflow: Cannot enqueue " + data);
            }
            rear = (rear + 1) % capacity;  // Circular increment
            queue[rear] = data;
            size++;
        }
        
        // Remove element from front - O(1)
        public int dequeue() {
            if (isEmpty()) {
                throw new RuntimeException("Queue Underflow: Cannot dequeue from empty queue");
            }
            int data = queue[front];
            front = (front + 1) % capacity;  // Circular increment
            size--;
            return data;
        }
        
        // Peek at front element - O(1)
        public int front() {
            if (isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            return queue[front];
        }
        
        // Peek at rear element - O(1)
        public int rear() {
            if (isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            return queue[rear];
        }
        
        // Check if queue is empty - O(1)
        public boolean isEmpty() {
            return size == 0;
        }
        
        // Check if queue is full - O(1)
        public boolean isFull() {
            return size == capacity;
        }
        
        // Get current size - O(1)
        public int size() {
            return size;
        }
        
        // Display queue contents
        public void display() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }
            
            System.out.print("Queue (front to rear): ");
            for (int i = 0; i < size; i++) {
                int index = (front + i) % capacity;
                System.out.print(queue[index]);
                if (i < size - 1) System.out.print(" -> ");
            }
            System.out.println();
        }
    }
    
    /**
     * LINKED LIST-BASED QUEUE IMPLEMENTATION
     */
    static class LinkedQueue {
        private Node front;  // Points to front of queue
        private Node rear;   // Points to rear of queue
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
        public LinkedQueue() {
            this.front = null;
            this.rear = null;
            this.size = 0;
        }
        
        // Add element to rear - O(1)
        public void enqueue(int data) {
            Node newNode = new Node(data);
            
            if (rear == null) {  // Queue is empty
                front = rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }
            size++;
        }
        
        // Remove element from front - O(1)
        public int dequeue() {
            if (isEmpty()) {
                throw new RuntimeException("Queue Underflow: Cannot dequeue from empty queue");
            }
            
            int data = front.data;
            front = front.next;
            
            if (front == null) {  // Queue becomes empty
                rear = null;
            }
            
            size--;
            return data;
        }
        
        // Peek at front element - O(1)
        public int front() {
            if (isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            return front.data;
        }
        
        // Peek at rear element - O(1)
        public int rear() {
            if (isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            return rear.data;
        }
        
        // Check if empty - O(1)
        public boolean isEmpty() {
            return front == null;
        }
        
        // Get size - O(1)
        public int size() {
            return size;
        }
        
        // Display queue
        public void display() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }
            
            Node current = front;
            System.out.print("Queue (front to rear): ");
            while (current != null) {
                System.out.print(current.data);
                if (current.next != null) System.out.print(" -> ");
                current = current.next;
            }
            System.out.println();
        }
    }
    
    /**
     * DEQUE (DOUBLE-ENDED QUEUE) IMPLEMENTATION
     */
    static class Deque {
        private Node front;
        private Node rear;
        private int size;
        
        // Node class for doubly linked list
        static class Node {
            int data;
            Node next;
            Node prev;
            
            Node(int data) {
                this.data = data;
                this.next = null;
                this.prev = null;
            }
        }
        
        // Constructor
        public Deque() {
            this.front = null;
            this.rear = null;
            this.size = 0;
        }
        
        // Add element to front - O(1)
        public void addFront(int data) {
            Node newNode = new Node(data);
            
            if (isEmpty()) {
                front = rear = newNode;
            } else {
                newNode.next = front;
                front.prev = newNode;
                front = newNode;
            }
            size++;
        }
        
        // Add element to rear - O(1)
        public void addRear(int data) {
            Node newNode = new Node(data);
            
            if (isEmpty()) {
                front = rear = newNode;
            } else {
                rear.next = newNode;
                newNode.prev = rear;
                rear = newNode;
            }
            size++;
        }
        
        // Remove element from front - O(1)
        public int removeFront() {
            if (isEmpty()) {
                throw new RuntimeException("Deque is empty");
            }
            
            int data = front.data;
            front = front.next;
            
            if (front == null) {  // Deque becomes empty
                rear = null;
            } else {
                front.prev = null;
            }
            
            size--;
            return data;
        }
        
        // Remove element from rear - O(1)
        public int removeRear() {
            if (isEmpty()) {
                throw new RuntimeException("Deque is empty");
            }
            
            int data = rear.data;
            rear = rear.prev;
            
            if (rear == null) {  // Deque becomes empty
                front = null;
            } else {
                rear.next = null;
            }
            
            size--;
            return data;
        }
        
        // Peek front - O(1)
        public int peekFront() {
            if (isEmpty()) {
                throw new RuntimeException("Deque is empty");
            }
            return front.data;
        }
        
        // Peek rear - O(1)
        public int peekRear() {
            if (isEmpty()) {
                throw new RuntimeException("Deque is empty");
            }
            return rear.data;
        }
        
        // Check if empty - O(1)
        public boolean isEmpty() {
            return front == null;
        }
        
        // Get size - O(1)
        public int size() {
            return size;
        }
        
        // Display deque
        public void display() {
            if (isEmpty()) {
                System.out.println("Deque is empty");
                return;
            }
            
            Node current = front;
            System.out.print("Deque (front to rear): ");
            while (current != null) {
                System.out.print(current.data);
                if (current.next != null) System.out.print(" <-> ");
                current = current.next;
            }
            System.out.println();
        }
    }
    
    /**
     * QUEUE APPLICATIONS
     */
    
    // Level-order traversal simulation (BFS pattern)
    public static void levelOrderTraversal(int[] tree) {
        if (tree.length == 0) return;
        
        ArrayQueue queue = new ArrayQueue(tree.length);
        queue.enqueue(0);  // Start with root index
        
        System.out.print("Level-order traversal: ");
        while (!queue.isEmpty()) {
            int index = queue.dequeue();
            System.out.print(tree[index] + " ");
            
            // Add left child
            int leftChild = 2 * index + 1;
            if (leftChild < tree.length) {
                queue.enqueue(leftChild);
            }
            
            // Add right child
            int rightChild = 2 * index + 2;
            if (rightChild < tree.length) {
                queue.enqueue(rightChild);
            }
        }
        System.out.println();
    }
    
    // Generate first n binary numbers using queue
    public static void generateBinaryNumbers(int n) {
        ArrayQueue queue = new ArrayQueue(n * 2);
        queue.enqueue(1);  // Start with "1"
        
        System.out.print("First " + n + " binary numbers: ");
        for (int i = 0; i < n; i++) {
            int num = queue.dequeue();
            System.out.print(num + " ");
            
            // Generate next two numbers by appending 0 and 1
            queue.enqueue(num * 10);      // Append 0
            queue.enqueue(num * 10 + 1);  // Append 1
        }
        System.out.println();
    }
    
    // Implement stack using two queues
    static class StackUsingQueues {
        private ArrayQueue q1;
        private ArrayQueue q2;
        
        public StackUsingQueues(int capacity) {
            q1 = new ArrayQueue(capacity);
            q2 = new ArrayQueue(capacity);
        }
        
        // Push - O(n)
        public void push(int data) {
            q2.enqueue(data);
            
            // Move all elements from q1 to q2
            while (!q1.isEmpty()) {
                q2.enqueue(q1.dequeue());
            }
            
            // Swap q1 and q2
            ArrayQueue temp = q1;
            q1 = q2;
            q2 = temp;
        }
        
        // Pop - O(1)
        public int pop() {
            if (q1.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return q1.dequeue();
        }
        
        // Peek - O(1)
        public int peek() {
            if (q1.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return q1.front();
        }
        
        public boolean isEmpty() {
            return q1.isEmpty();
        }
    }
    
    /**
     * MAIN METHOD - Test all implementations
     */
    public static void main(String[] args) {
        System.out.println("=== Queue Implementation Demo ===\n");
        
        // Test Array Queue
        System.out.println("=== Array Queue Test ===");
        ArrayQueue arrayQueue = new ArrayQueue(5);
        
        arrayQueue.enqueue(10);
        arrayQueue.enqueue(20);
        arrayQueue.enqueue(30);
        arrayQueue.display();
        
        System.out.println("Front: " + arrayQueue.front());
        System.out.println("Rear: " + arrayQueue.rear());
        System.out.println("Dequeue: " + arrayQueue.dequeue());
        arrayQueue.display();
        
        // Test Linked Queue
        System.out.println("\n=== Linked Queue Test ===");
        LinkedQueue linkedQueue = new LinkedQueue();
        
        linkedQueue.enqueue(100);
        linkedQueue.enqueue(200);
        linkedQueue.enqueue(300);
        linkedQueue.display();
        
        System.out.println("Front: " + linkedQueue.front());
        System.out.println("Dequeue: " + linkedQueue.dequeue());
        linkedQueue.display();
        
        // Test Deque
        System.out.println("\n=== Deque Test ===");
        Deque deque = new Deque();
        
        deque.addRear(10);
        deque.addFront(20);
        deque.addRear(30);
        deque.addFront(40);
        deque.display();
        
        System.out.println("Remove front: " + deque.removeFront());
        System.out.println("Remove rear: " + deque.removeRear());
        deque.display();
        
        // Test Applications
        System.out.println("\n=== Queue Applications ===");
        
        // Level-order traversal
        int[] tree = {1, 2, 3, 4, 5, 6, 7};
        levelOrderTraversal(tree);
        
        // Generate binary numbers
        generateBinaryNumbers(10);
        
        // Stack using queues
        System.out.println("\nStack using Two Queues:");
        StackUsingQueues stackQueue = new StackUsingQueues(10);
        stackQueue.push(1);
        stackQueue.push(2);
        stackQueue.push(3);
        
        System.out.println("Pop: " + stackQueue.pop());
        System.out.println("Peek: " + stackQueue.peek());
        System.out.println("Pop: " + stackQueue.pop());
    }
}

/*
QUEUE KEY CONCEPTS:

FIFO PRINCIPLE:
- First element added is first to be removed
- Add at rear, remove from front
- Think of a line of people waiting

CIRCULAR QUEUE ADVANTAGE:
- Efficient use of array space
- Avoids shifting elements
- Front and rear wrap around

ARRAY VS LINKED LIST IMPLEMENTATION:

ARRAY QUEUE:
✅ Better cache locality
✅ Fixed memory overhead
❌ Fixed size (can overflow)
❌ Circular logic complexity

LINKED QUEUE:
✅ Dynamic size
✅ Simple logic
❌ Extra memory for pointers
❌ Memory fragmentation

DEQUE (DOUBLE-ENDED QUEUE):
- Can add/remove from both ends
- More versatile than simple queue
- Used in sliding window problems

COMMON QUEUE APPLICATIONS:
1. Breadth-First Search (BFS)
2. Level-order tree traversal
3. Process scheduling
4. Handling requests in servers
5. Print job management
6. Buffer for data streams

INTERVIEW PROBLEMS:
- Implement Queue using Stacks (LeetCode #232)
- Implement Stack using Queues (LeetCode #225)
- Design Circular Queue (LeetCode #622)
- Sliding Window Maximum (LeetCode #239)
- First Unique Character in Stream

IMPLEMENTATION TIPS:
- Handle empty queue operations
- For circular queue, use modulo arithmetic
- Consider using deque for more flexibility
- Be careful with front/rear pointer updates
*/