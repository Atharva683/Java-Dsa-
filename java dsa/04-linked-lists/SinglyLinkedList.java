/**
 * Singly Linked List Implementation - The foundation of linked data structures
 * 
 * Understanding linked lists is crucial for many advanced data structures
 */

public class SinglyLinkedList {
    
    // Node class - the building block of linked lists
    static class Node {
        int data;
        Node next;
        
        // Constructor
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node head;  // Points to the first node
    private int size;   // Keep track of list size
    
    // Constructor
    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    /**
     * INSERT OPERATIONS
     */
    
    // Insert at the beginning - O(1)
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    // Insert at the end - O(n)
    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    
    // Insert at specific index - O(n)
    public void insertAtIndex(int index, int data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        if (index == 0) {
            insertAtHead(data);
            return;
        }
        
        Node newNode = new Node(data);
        Node current = head;
        
        // Traverse to position index-1
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }
    
    /**
     * DELETE OPERATIONS
     */
    
    // Delete from head - O(1)
    public int deleteFromHead() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        
        int data = head.data;
        head = head.next;
        size--;
        return data;
    }
    
    // Delete from tail - O(n)
    public int deleteFromTail() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        
        if (head.next == null) {
            int data = head.data;
            head = null;
            size--;
            return data;
        }
        
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        
        int data = current.next.data;
        current.next = null;
        size--;
        return data;
    }
    
    // Delete by value - O(n)
    public boolean deleteByValue(int value) {
        if (head == null) {
            return false;
        }
        
        if (head.data == value) {
            head = head.next;
            size--;
            return true;
        }
        
        Node current = head;
        while (current.next != null && current.next.data != value) {
            current = current.next;
        }
        
        if (current.next != null) {
            current.next = current.next.next;
            size--;
            return true;
        }
        
        return false;
    }
    
    // Delete at specific index - O(n)
    public int deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        if (index == 0) {
            return deleteFromHead();
        }
        
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        
        int data = current.next.data;
        current.next = current.next.next;
        size--;
        return data;
    }
    
    /**
     * SEARCH AND ACCESS OPERATIONS
     */
    
    // Search for a value - O(n)
    public boolean contains(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    // Get value at index - O(n)
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    
    // Find index of value - O(n)
    public int indexOf(int value) {
        Node current = head;
        int index = 0;
        
        while (current != null) {
            if (current.data == value) {
                return index;
            }
            current = current.next;
            index++;
        }
        
        return -1; // Not found
    }
    
    /**
     * UTILITY OPERATIONS
     */
    
    // Get size - O(1)
    public int size() {
        return size;
    }
    
    // Check if empty - O(1)
    public boolean isEmpty() {
        return head == null;
    }
    
    // Display the list - O(n)
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        Node current = head;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println(" -> null");
    }
    
    // Reverse the list - O(n)
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        
        while (current != null) {
            next = current.next;  // Store next
            current.next = prev;  // Reverse the link
            prev = current;       // Move prev forward
            current = next;       // Move current forward
        }
        
        head = prev;  // Update head
    }
    
    // Find middle element - O(n)
    public Integer findMiddle() {
        if (head == null) {
            return null;
        }
        
        Node slow = head;
        Node fast = head;
        
        // Two pointer technique: slow moves 1 step, fast moves 2 steps
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow.data;
    }
    
    // Detect cycle - O(n)
    public boolean hasCycle() {
        if (head == null) {
            return false;
        }
        
        Node slow = head;
        Node fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                return true;  // Cycle detected
            }
        }
        
        return false;
    }
    
    // Remove duplicates from sorted list - O(n)
    public void removeDuplicates() {
        if (head == null) {
            return;
        }
        
        Node current = head;
        while (current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
                size--;
            } else {
                current = current.next;
            }
        }
    }
    
    // Convert to array - O(n)
    public int[] toArray() {
        int[] array = new int[size];
        Node current = head;
        int index = 0;
        
        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }
        
        return array;
    }
    
    /**
     * MAIN METHOD - Test the implementation
     */
    public static void main(String[] args) {
        System.out.println("=== Singly Linked List Demo ===\n");
        
        SinglyLinkedList list = new SinglyLinkedList();
        
        // Test insertions
        System.out.println("=== Testing Insertions ===");
        list.insertAtHead(10);
        list.insertAtHead(20);
        list.insertAtTail(30);
        list.insertAtTail(40);
        list.display();
        
        list.insertAtIndex(2, 25);
        System.out.println("After inserting 25 at index 2:");
        list.display();
        
        // Test access operations
        System.out.println("\n=== Testing Access Operations ===");
        System.out.println("Size: " + list.size());
        System.out.println("Element at index 2: " + list.get(2));
        System.out.println("Index of 30: " + list.indexOf(30));
        System.out.println("Contains 25: " + list.contains(25));
        System.out.println("Contains 100: " + list.contains(100));
        
        // Test deletions
        System.out.println("\n=== Testing Deletions ===");
        System.out.println("Deleted from head: " + list.deleteFromHead());
        list.display();
        
        System.out.println("Deleted from tail: " + list.deleteFromTail());
        list.display();
        
        System.out.println("Deleted value 25: " + list.deleteByValue(25));
        list.display();
        
        // Test advanced operations
        System.out.println("\n=== Testing Advanced Operations ===");
        System.out.println("Middle element: " + list.findMiddle());
        
        System.out.println("Before reverse:");
        list.display();
        list.reverse();
        System.out.println("After reverse:");
        list.display();
        
        // Test with duplicates
        System.out.println("\n=== Testing Duplicate Removal ===");
        SinglyLinkedList sortedList = new SinglyLinkedList();
        sortedList.insertAtTail(1);
        sortedList.insertAtTail(1);
        sortedList.insertAtTail(2);
        sortedList.insertAtTail(3);
        sortedList.insertAtTail(3);
        sortedList.insertAtTail(3);
        
        System.out.println("Before removing duplicates:");
        sortedList.display();
        sortedList.removeDuplicates();
        System.out.println("After removing duplicates:");
        sortedList.display();
        
        // Convert to array
        System.out.println("\n=== Converting to Array ===");
        int[] array = list.toArray();
        System.out.print("Array: [");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

/*
LINKED LIST KEY CONCEPTS:

ADVANTAGES OVER ARRAYS:
✅ Dynamic size - can grow/shrink at runtime
✅ Efficient insertion/deletion at head - O(1)
✅ No memory waste - allocates only what's needed
✅ No need to declare size beforehand

DISADVANTAGES:
❌ No random access - must traverse from head
❌ Extra memory for storing pointers
❌ Not cache-friendly due to non-contiguous memory
❌ More complex than arrays

COMMON PATTERNS:
1. Two Pointers (slow/fast) - find middle, detect cycles
2. Dummy Node - simplifies edge cases in operations
3. Recursion - natural fit for linked structures
4. Iteration with Previous Pointer - for deletions

INTERVIEW TIPS:
- Always check for null pointers
- Consider edge cases (empty list, single node)
- Draw diagrams to visualize pointer changes
- Practice reversing - very common in interviews

WHEN TO USE LINKED LISTS:
✅ Frequent insertions/deletions at beginning
✅ Size varies significantly
✅ Don't need random access
✅ Building other data structures (stacks, queues)

WHEN TO USE ARRAYS:
✅ Need random access to elements
✅ Size is relatively stable
✅ Cache performance is important
✅ Simple operations and less memory overhead
*/