package com.arun.practice.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdjacencyListDFS {

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
        DFS(list, visited, 0);
    }

    private static void DFS(List<List<Integer>> list, int[] visited, int vertex) {
        visited[vertex] = 1;
        System.out.println(vertex);
        List<Integer> vertexNeighbours = list.get(vertex);
        vertexNeighbours.forEach(neighbour -> {
            if (visited[neighbour] == 0) {
                DFS(list, visited, neighbour);
            }
        });
    }
}
