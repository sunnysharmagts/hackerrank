package org.sunnyslls.weekOfCode34;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by sunny on 18/7/17.
 */
public class OnceInaTram {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        String result = new OnceInaTram().onceInATram(x);
        System.out.println(result);
    }

    public String onceInATram(int x) {
        x++;
        String value = String.valueOf(x);
        List<Integer> list = new ArrayList<>(6);
        for (int i = 0; i < 6; i++) {
            int v = Integer.parseInt(String.valueOf(value.charAt(i)));
            list.add(v);
        }
        calculate(list, x);
        StringBuilder sb = new StringBuilder();
        for (int i : list) {
            sb.append(i);
        }
        return sb.toString();
    }

    private boolean calculate(List<Integer> list, int x) {
        if (isLucky(list)) {
            return true;
        }
        set(list, ++x);
        if (calculate(list, x)) {
            return true;
        }
        return false;
    }

    private void set(List<Integer> list, int x) {
        int temp = x;
        Stack<Integer> stack = new Stack();
        while (temp >= 0 && stack.size() < list.size()) {
            int lastDigit = temp % 10;
            stack.push(lastDigit);
            temp = temp / 10;
        }
        int length = list.size();
        list.clear();
        for (int i = 0; i < length; i++) {
            list.add(stack.pop());
        }
    }

    private boolean isLucky(List<Integer> list) {
        int suffix = 0;
        int prefix = 0;
        int length = list.size();
        for (int i = 0; i < length / 2; i++) {
            prefix += list.get(i);
            suffix += list.get(list.size() - i - 1);
        }
        return suffix == prefix;
    }
}
