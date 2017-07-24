package org.sunnyslls.weekOfCode34;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sunny on 19/7/17.
 */
public class SameOccurence {

    static int totalValue = 0;
    private static int[] arr;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        arr = new int[n];
        for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = in.nextInt();
        }
        SameOccurence occurence = new SameOccurence();
        int[] temp = new int[n];
        List<List<Integer>> subSet = new ArrayList<>();
        occurence.enumerate(0, temp, subSet);
        System.out.println(subSet);
        for (int a0 = 0; a0 < q; a0++) {
            int x = in.nextInt();
            int y = in.nextInt();

            boolean firstValue = false;
            boolean secondValue = false;

            int count = 0;
            int size = subSet.size();

            List<Integer> lastList = subSet.get(size-1);
            int xValue = 0;
            int yValue = 0;
            for (int i = 0; i < n; i++) {
                int value = lastList.get(i);
                if (value == x) {
                    xValue++;
                    firstValue = true;
                } else if (value == y) {
                    secondValue = true;
                    yValue++;
                }
            }
            if (!firstValue || !secondValue) {
                System.out.println(totalValue);
            }
            else {
                if(xValue == yValue){
                    count++;
                }
                for (int i = size - 2; i >= 0; i--) {
                    final List<Integer> list = subSet.get(i);
                    System.out.println(list);
                    xValue = 0;
                    yValue = 0;
                    for (int val : list) {
                        if (val == x) xValue++;
                        else if (val == y) yValue++;
                    }
                    if (xValue > 0 && yValue > 0 && xValue == yValue) {
                        count++;
                    }
                }
                System.out.println(count);
            }
        }
        in.close();

    }

    private List process(int[] a) {
        int length = a.length;
        List<Integer> list = new ArrayList<>();
        int prevIndex = Integer.MIN_VALUE;
        boolean flag = false;
        int x = 0;
        int y = 0;
        for (int i = 0; i < length; i++) {
            if (a[i] == 1) {
                int diff = i - prevIndex;
                if (prevIndex > Integer.MIN_VALUE && diff != 1) {
                    return null;
                }
                int value = arr[length - i - 1];
                list.add(value);
                prevIndex = i;
                flag = true;
            }
        }
        if (flag) {
            totalValue++;
        }
        if (!flag || list.size() < 2) {
            list = null;
        }
        return list;
    }

    private void enumerate(int k, int[] arr, List<List<Integer>> mainList) {
        if (k == arr.length) {
            List<Integer> list = process(arr);
            if (list != null) mainList.add(list);
            return;
        }
        enumerate(k + 1, arr, mainList);
        arr[k] = 1;
        enumerate(k + 1, arr, mainList);
        arr[k] = 0;

        return;
    }

    List<List<Integer>> enumerate(List<Integer> arrList){
        List<List<Integer>> mainList = new ArrayList<>();
        if(arrList.isEmpty()){
            mainList.add(new ArrayList<>());
            return mainList;
        }

        int head = arrList.get(0);
        List<Integer> rest = arrList.subList(1, arrList.size());
        List<List<Integer>> subSetList = enumerate(rest);
        for(List<Integer> plist : subSetList){
            List<Integer> newList = new ArrayList<>();
            newList.add(head);
            newList.addAll(plist);
            mainList.add(plist);
            mainList.add(newList);
            System.out.println("mainList: "+mainList);
        }
        return mainList;
    }
}
