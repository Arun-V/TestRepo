package com.arun.practice.graph;

import java.util.Scanner;

public class AdjacencyMatrixDFS {

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
        DFS(matrix, visited, 0);
    }

    private static void DFS(int[][] matrix, int[] visited, int vertex) {
        visited[vertex] = 1;
        System.out.println(vertex);
        for (int i = 0;i < visited.length;i++) {
            if (matrix[vertex][i] == 1 && visited[i]==0) {
                DFS(matrix, visited, i);
            }
        }
    }
}
