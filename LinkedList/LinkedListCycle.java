package LinkedList;

import java.io.*;
import java.util.*;


public class LinkedListCycle {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the hasCycle function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static int hasCycle(SinglyLinkedListNode head) {

    SinglyLinkedListNode walker = head;
    SinglyLinkedListNode runner = head;
    while(runner.next!=null && runner.next.next!=null) {
       runner = runner.next.next; 
        walker = walker.next;
       
        // if(walker==runner) return true;
    }
    return walker.data;

    }

    public static void main(String[] args) throws IOException{
       
Scanner scanner=new Scanner(System.in);
        int tests = scanner.nextInt();

        for (int testsItr = 0; testsItr < tests; testsItr++) {
            int index = scanner.nextInt();

            SinglyLinkedList llist = new SinglyLinkedList();

            int llistCount = scanner.nextInt();
            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
           

                llist.insertNode(llistItem);
            }
          
          	SinglyLinkedListNode extra = new SinglyLinkedListNode(-1);
            SinglyLinkedListNode temp = llist.head;

            for (int i = 0; i < llistCount; i++) {
                if (i == index) {
                    extra = temp;
                }

                if (i != llistCount-1) {
                    temp = temp.next;
                }
            }
      
      		temp.next = extra;

           int   result = hasCycle(llist.head);
           System.out.println(result);

        }

        scanner.close();
    }
}

