package org.sunnyslls.miscellanous;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by sunny on 5/9/17.
 */
public class PostOrderTraversal {

    static Node root;

    public static void main(String[] args){
        /*insert(1);
        insert(2);
        insert(3);
        insert(4);
        insert(5);
        insert(6);
        insert(7);
        insert(8);
        insert(9);
        insert(10);
        insert(11);
        insert(12);
        insert(13);
        insert(14);
        insert(15);*/


        levelOrderTraversal();
        POTRecursive(root);
        System.out.println();
        POTIterative();
    }

    static void POTRecursive(Node node){
        if(node != null){
            POTRecursive(node.left);
            POTRecursive(node.right);
            System.out.print(node +" ");
        }
    }

    static void insert(int data){

        if(root == null){
            root = new Node(data);
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.left == null){
                node.left = new Node(data);
                return;
            }else if(node.right == null){
                node.right = new Node(data);
                return;
            }else{
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
    }

    static void POTIterative(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Stack<Node> finalStack = new Stack<>();
        while(!stack.isEmpty()){
            Node node = stack.pop();
            finalStack.push(node);
            if(node.left != null){
                stack.push(node.left);
            }
            if(node.right != null){
                stack.push(node.right);
            }
        }

        while(!finalStack.isEmpty()){
            System.out.print(finalStack.pop() +" ");
        }
        System.out.println();
    }

    static void levelOrderTraversal(){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            System.out.print(curr + " ");
            if(curr.left != null){
                queue.offer(curr.left);
            }
            if(curr.right != null){
                queue.offer(curr.right);
            }
        }
        System.out.println();
    }

    static class Node{

        int data;

        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }

        @Override
        public String toString() {
            return data +" ";
        }
    }

}
