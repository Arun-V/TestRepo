package com.arun.practice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KMinInStream {

    public static void main(String[] args) {
        int k = 6;
        int[] arr = {1,5,39,20,23,10,54,5,8};

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0;i < arr.length;i++) {
            if (maxHeap.size() < k) {
                maxHeap.add(arr[i]);
            } else {
                if (maxHeap.peek() > arr[i]) {
                    maxHeap.poll();maxHeap.add(arr[i]);
                }
            }
        }

        while(!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll());
        }

    }
}
