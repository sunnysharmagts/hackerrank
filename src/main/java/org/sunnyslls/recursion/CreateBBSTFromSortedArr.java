package org.sunnyslls.recursion;

/**
 * Created by sunny on 26/12/17.
 */
public class CreateBBSTFromSortedArr {

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7};
        Node node = bbst(arr, 0, arr.length-1);

    }

    static Node bbst(int[] arr, int start, int end){
        if(start == end){
            return new Node(arr[start]);
        }else if(start > end){
            return null;
        }

        int mid = (start + end) / 2;
        final Node node = new Node(arr[mid]);
        node.left = bbst(arr, start, mid-1);
        node.right = bbst(arr, mid+1, end);

        return node;
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
