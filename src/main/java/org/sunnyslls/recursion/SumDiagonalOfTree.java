package org.sunnyslls.recursion;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by sunny on 31/12/17.
 */
public class SumDiagonalOfTree {

    static Map<Integer, LinkedList<CheckBST.Node>> map = new HashMap<>();

    public static void main(String[] args){
        CheckBST.Node root = new CheckBST.Node(10);
        root.left = new CheckBST.Node(5);
        root.right = new CheckBST.Node(20);
        root.right.left = new CheckBST.Node(25);
        root.left.left = new CheckBST.Node(2);
        root.left.right = new CheckBST.Node(3);
        root.left.right.right = new CheckBST.Node(1);
        root.right.right = new CheckBST.Node(30);
        sumDiagonal(root, 0);
        System.out.println(map);
    }

    static void sumDiagonal(CheckBST.Node node, int index){
        if(node == null){
            return;
        }
        put(node, index);
        sumDiagonal(node.right, index);
        sumDiagonal(node.left, index+1);
    }

    static void put(CheckBST.Node node, int index){
        LinkedList<CheckBST.Node> list = map.get(index);
        if(list == null){
            list = new LinkedList<>();
        }
        list.add(node);
        map.put(index, list);
    }
}
