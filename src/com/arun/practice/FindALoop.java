package com.arun.practice;

public class FindALoop {

    public static class LinkedList {
        int data;
        LinkedList next;
    }

    public static void main(String[] args) {
        LinkedList head = createLinkedList();
        LinkedList temp = head;
//        for (int i = 0;i < 30;i++) {
//            System.out.print(temp.data + " ");
//            temp = temp.next;
//        }
        LinkedList slow = head;LinkedList fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                System.out.println("Loop detected");
                break;
            }
        }
    }

    private static LinkedList createLinkedList() {
        LinkedList head = new LinkedList();
        head.data = 1;head.next = null;
        LinkedList now = head;
        LinkedList loopNode = null;
        for (int i = 2;i <= 10;i++) {
            LinkedList temp = new LinkedList();
            temp.data = i;temp.next = null;
            now.next = temp;now = now.next;
            if (i == 4)
                loopNode = now;
        }
        now.next = loopNode;
        return head;
    }
}
