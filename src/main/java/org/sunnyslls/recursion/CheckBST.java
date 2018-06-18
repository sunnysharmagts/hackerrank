package org.sunnyslls.recursion;

/**
 * Created by sunny on 14/10/17.
 */
public class CheckBST {

    static Node root;

    public static void main(String[] args){
        /*add(5);
        add(9);
        add(8);
        add(-2);
        add(-10);
        add(-11);*/

        root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(20);
        root.left.left = new Node(2);
        root.left.right = new Node(3);
        root.left.right.right = new Node(1);
        root.right.right = new Node(30);


        System.out.println(isBST(root));
    }

    static boolean isBST(Node node){
        if(node == null){
            return true;
        }

        if(node.left != null && node.left.value > node.value){
            return false;
        }
        if(node.right != null && node.right.value < node.value){
            return false;
        }
        boolean isLeftBST = isBST(node.left);
        boolean isRightBST = isBST(node.right);

        if(isLeftBST && isRightBST){
            return true;
        }
        return false;
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
