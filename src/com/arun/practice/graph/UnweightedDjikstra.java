package com.arun.practice.graph;

import java.util.*;

public class UnweightedDjikstra {

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
            List<Integer> list2 = list.get(secondVertex);
            list2.add(firstVertex);
        }
        for (int i = 0;i < list.size();i++) {
            System.out.print("List " + i);
            List<Integer> tempList = list.get(i);
            for (int j = 0; j < tempList.size(); j++) {
                System.out.print(tempList.get(j));
            }
            System.out.println();
        }
        int[] distance = new int[5];
        for (int i = 0;i < vertices;i++) {
            distance[i] = -1;
        }
        int[] path = new int[5];
        dijkstra(list, distance, path, 0);
        for (int i = 0;i < vertices;i++) {
            System.out.println(i + " " + distance[i] + " " + path[i]);
        }
    }

    private static void dijkstra(List<List<Integer>> list, int[] distance, int[] path, int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        distance[vertex] = 0;
        path[0] = -1;
        queue.add(vertex);
        while (!queue.isEmpty()) {
            int value = queue.poll();
            list.get(value).forEach(neighbour -> {
                if (distance[neighbour] == -1) {
                    distance[neighbour] = distance[value] + 1;
                    path[neighbour] = value;
                    queue.add(neighbour);
                }
            });
        }
    }
}
