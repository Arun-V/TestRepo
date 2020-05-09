package com.arun.practice.graph;

import java.util.*;

public class TopologicalSort {

    public static void main(String[] args) {
        int vertices = 5;
        int edges = 5;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0;i < vertices;i++) {
            list.add(new ArrayList<>());
        }
        Scanner scan = new Scanner(System.in);
        for (int i = 0;i < edges;i++) {
            int firstVertex = scan.nextInt();
            int secondVertex = scan.nextInt();
            List<Integer> list1 = list.get(firstVertex);
            list1.add(secondVertex);
        }
        for (int i = 0;i < list.size();i++) {
            System.out.print("List " + i);
            List<Integer> tempList = list.get(i);
            for (int j = 0; j < tempList.size(); j++) {
                System.out.print(tempList.get(j));
            }
            System.out.println();
        }
        int[] indegrees = new int[5];
        findIndegrees(list, indegrees);
        for (int i = 0;i < indegrees.length;i++) {
            System.out.print(indegrees[i]);
        }
        System.out.println();
        topologicalSort(list, indegrees);
    }

    private static void findIndegrees(List<List<Integer>> list, int[] indegrees) {
        list.forEach(neighbours -> {
            neighbours.forEach(neighbour -> indegrees[neighbour]++);
        });
    }

    private static void topologicalSort(List<List<Integer>> list, int[] indegrees) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0;i < list.size();i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int value = queue.poll();
            System.out.print(value);
            list.get(value).forEach(neighbour -> {
                if (--indegrees[neighbour] == 0) {
                    queue.add(neighbour);
                }
            });
        }
    }
}
