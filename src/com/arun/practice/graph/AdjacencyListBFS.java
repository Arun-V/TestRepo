package com.arun.practice.graph;

import java.util.*;

public class AdjacencyListBFS {

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
        int[] visited = new int[5];
        BFS(list, visited, 0);
    }

    private static void BFS(List<List<Integer>> list, int[] visited, int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        visited[vertex] = 1;
        while (!queue.isEmpty()) {
            int value = queue.poll();
            System.out.println(value);
            List<Integer> neighbours = list.get(value);
            neighbours.forEach(neighbour -> {
                if (visited[neighbour] == 0) {
                    queue.add(neighbour);
                    visited[neighbour] = 1;
                }
            });
        }
    }
}
