package org.sunnyslls.recursion;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sunny on 5/9/17.
 */
public class DeleteAllBinaryTree {

    static Node root;

    public static void main(String[] args){
        add(5);
        add(9);
        add(8);
        add(-2);
        add(-10);
        add(-11);

        System.out.println(deleteBST(root));
    }



    static Node deleteBST(Node node){
        if(node == null){
            return null;
        }

        node.left = deleteBST(node.left);
        levelOrderTraversal(node);
        node.right = deleteBST(node.right);
        levelOrderTraversal(node);
        if(node.left == null && node.right == null){
            return null;
        }
        return node;
    }

    static void levelOrderTraversal(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            Node current = queue.poll();
            if(current != null){
                System.out.print(current +" ");
                queue.offer(current.left);
                queue.offer(current.right);
            }
        }
        System.out.println();
    }

    static void add(int value){
        final Node newNode = new Node(value);
        if(root == null){
            root = newNode;
            return;
        }
        Node tempNode = root;
        Node prevNode = root;
        boolean isLeft = true;
        while(tempNode != null){
            prevNode = tempNode;
            if(tempNode.value > value){
                isLeft = true;
                tempNode = tempNode.left;
            }else{
                tempNode = tempNode.right;
                isLeft = false;
            }
        }
        if(isLeft){
            prevNode.left = newNode;
        }else{
            prevNode.right = newNode;
        }
    }

    static class Node{
        Node left;
        Node right;

        int value;

        Node(int value){
            this.value = value;
        }

        @Override
        public String toString() {
            return value +" ";
        }
    }
}


