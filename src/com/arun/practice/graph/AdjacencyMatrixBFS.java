package com.arun.practice.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AdjacencyMatrixBFS {

    public static void main(String[] args) {
        int vertices = 5;
        int edges = 5;
        int[][] matrix = new int[5][5];
        int[] visited = new int[5];
        Scanner scan = new Scanner(System.in);
        for (int i = 0;i < edges;i++) {
            int firstVertex = scan.nextInt();
            int secondVertex = scan.nextInt();
            matrix[firstVertex][secondVertex] = 1;
            matrix[secondVertex][firstVertex] = 1;
        }
        for (int i = 0;i < vertices;i++) {
            for(int j = 0;j < vertices;j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
        BFS(matrix, visited, 0);
    }

    private static void BFS(int[][] matrix, int[] visited, int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        visited[vertex]=1;
        while (!queue.isEmpty()) {
            int value = queue.poll();
            System.out.println(value);
            int[] neighbours = matrix[value];
            for (int i = 0;i < neighbours.length;i++) {
                if (neighbours[i] == 1 && visited[i] == 0) {
                    queue.add(i);
                    visited[i] = 1;
                }
            }
        }
    }
}
