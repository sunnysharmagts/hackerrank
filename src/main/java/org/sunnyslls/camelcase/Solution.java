package org.sunnyslls.camelcase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                list.add(sb.toString());
                sb = new StringBuilder();
            }
            sb.append(s.charAt(i));
        }
        if (sb.length() > 0) {
            list.add(sb.toString());
        }
        System.out.println(list.size());
    }
}
