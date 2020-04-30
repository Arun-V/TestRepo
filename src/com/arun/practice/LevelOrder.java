package com.arun.practice;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {

    public static class Tree {
        int data;
        Tree left;
        Tree right;

        Tree (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        Tree root = createATree();
        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);queue.add(null);
        while (!queue.isEmpty()) {
            Tree node = queue.poll();
            if (node == null) {
                System.out.println();
                if (queue.isEmpty())
                    break;
                queue.add(null);
            } else {
                System.out.println(node.data);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
    }

    // rough construction code
    private static Tree createATree() {
        Tree root = new Tree(1);

        Tree level11 = new Tree(2);Tree level12 = new Tree(3);
        root.left = level11;root.right = level12;

        Tree level21 = new Tree(4);Tree level22 = new Tree(5);
        level11.left = level21;level11.right = level22;

        Tree level24 = new Tree(6);
        level12.right = level24;
        return root;
    }
}
