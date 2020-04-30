package com.arun.practice;

public class ReverseALinkedList {

    public static class List {
        int data;
        List next;

        List(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        List head = createList();
        List temp = head;
//        while (temp != null) {
//            System.out.println(temp.data);
//            temp = temp.next;
//        }
        List prev, current, next;
        prev = null;current = head;next = head.next;
        while (next != null) {
            current.next = prev;
            prev = current;
            current = next;
            next = current.next;
        }
        current.next = prev;
        head = current;
        temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    private static List createList() {
        List head = new List(1);
        List prev = head;
        for (int i = 2;i < 8;i++) {
            List node = new List(i);
            prev.next = node;
            prev = node;
        }
        return head;
    }
}
