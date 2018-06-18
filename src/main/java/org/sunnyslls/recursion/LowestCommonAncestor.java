package org.sunnyslls.recursion;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sunny on 8/9/17.
 */
public class LowestCommonAncestor {
    
    static Node root;

    public static void main(String[] args){
        add(1);
        add(2);
        add(3);
        add(4);
        add(5);
        add(6);
        add(7);
        add(8);
        add(9);
        add(10);

        System.out.println(lsa(root, 4, 8));
    }

    static Node lsa(Node node, int left, int right){
        if(node == null){
            return null;
        }

        if(node.value == left || node.value == right){
            return node;
        }

        Node leftNode = lsa(node.left, left, right);
        Node rightNode = lsa(node.right, left, right);

        if(leftNode != null && rightNode != null){
            return node;
        }

        return leftNode != null ? leftNode : rightNode;
    }

    static void add(int value){
        final Node newNode = new Node(value);
        if(root == null){
            root = newNode;
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            if(node.left == null){
                node.left = newNode;
                return;
            }
            if(node.right == null){
                node.right = newNode;
                return;
            }
            queue.offer(node.left);
            queue.offer(node.right);
        }
    }

    static class Node{
        int value;
        Node left;
        Node right;

        Node(int value){
            this.value = value;
        }

        @Override
        public String toString() {
            return value +" ";
        }
    }
}
