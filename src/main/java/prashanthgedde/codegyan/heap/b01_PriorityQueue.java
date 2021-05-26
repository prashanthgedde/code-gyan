package prashanthgedde.codegyan.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class b01_PriorityQueue {

    public static void main(String[] args) {

        /**
         * Natural order
         */
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(100);
        pq.offer(10);
        pq.offer(150);
        pq.offer(60);
        pq.offer(34);
        System.out.print("Natural order: ");
        while(!pq.isEmpty()) {
            System.out.print(pq.poll()+", ");
        }
        System.out.println("");

        /**
         * String natural order
         */
        PriorityQueue<String> pqStr = new PriorityQueue<>();
        pqStr.offer("Anand");
        pqStr.offer("John");
        pqStr.offer("Prashanth");
        pqStr.offer("Abhishek");
        pqStr.offer("Rabi");
        System.out.print("Natural order: ");
        while(!pqStr.isEmpty()) {
            System.out.print(pqStr.poll()+", ");
        }
        System.out.println("");

        /**
         * String natural order with Comparator
         */
        pqStr = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        pqStr.offer("Anand");
        pqStr.offer("John");
        pqStr.offer("Prashanth");
        pqStr.offer("Abhishek");
        pqStr.offer("Rabi");
        System.out.print("Natural order with Comparator: ");
        while(!pqStr.isEmpty()) {
            System.out.print(pqStr.poll()+", ");
        }
        System.out.println("");

        /**
         * String reverse order
         */
        pqStr = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        pqStr.offer("Anand");
        pqStr.offer("John");
        pqStr.offer("Prashanth");
        pqStr.offer("Abhishek");
        pqStr.offer("Rabi");
        System.out.print("Custom order (reverse): ");
        while(!pqStr.isEmpty()) {
            System.out.print(pqStr.poll()+", ");
        }
        System.out.println("");

        /**
         * String custom order by length
         */
        pqStr = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        pqStr.offer("Anand");
        pqStr.offer("John");
        pqStr.offer("Prashanth");
        pqStr.offer("Abhishek");
        pqStr.offer("Rabi");
        System.out.print("Custom order by length: ");
        while(!pqStr.isEmpty()) {
            System.out.print(pqStr.poll()+", ");
        }
        System.out.println("");


        /**
         * String custom order by length using Lambda
         */
        pqStr = new PriorityQueue<>((str1, str2) -> str1.length() - str2.length());
        pqStr.offer("Anand");
        pqStr.offer("John");
        pqStr.offer("Prashanth");
        pqStr.offer("Abhishek");
        pqStr.offer("Rabi");
        System.out.print("Custom order by length using Lambda: ");
        while(!pqStr.isEmpty()) {
            System.out.print(pqStr.poll()+", ");
        }
        System.out.println("");
    }
}
