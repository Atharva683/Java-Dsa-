/**
 * Demonstrates the usage of PriorityQueue in Java.
 */

import java.util.*;

public class PriorityQueueDemo {

    public static void main(String[] args) {
        System.out.println("=== PriorityQueue - Heap Implementation ===");

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(30);
        priorityQueue.offer(10);
        priorityQueue.offer(50);
        priorityQueue.offer(20);

        System.out.println("PriorityQueue: " + priorityQueue);
        System.out.print("Poll all elements: ");
        while (!priorityQueue.isEmpty()) {
            System.out.print(priorityQueue.poll() + " ");
        }
        System.out.println();

        // Custom priority queue
        PriorityQueue<Student> studentQueue = new PriorityQueue<>((s1, s2) -> s2.grade - s1.grade);
        studentQueue.offer(new Student("Alice", 85));
        studentQueue.offer(new Student("Bob", 92));
        studentQueue.offer(new Student("Charlie", 78));

        System.out.println("Student queue (by grade desc):");
        while (!studentQueue.isEmpty()) {
            System.out.println(studentQueue.poll());
        }
    }

    static class Student {
        String name;
        int grade;

        Student(String name, int grade) {
            this.name = name;
            this.grade = grade;
        }

        @Override
        public String toString() {
            return name + "(" + grade + ")";
        }
    }
}