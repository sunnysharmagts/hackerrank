package org.sunnyslls.goldmansachs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunny on 17/2/18.
 */
public class NumberPatterns {

    public static void main(String[] args) throws IOException {
        System.out.println(findPossibleSmallestNumberMatchingPattern("MNM"));
    }

    static int findPossibleSmallestNumberMatchingPattern(String pattern) {
        if (pattern == null) {
            return -1;
        }

        int min;
        int posOfN;

        List<Integer> list = new ArrayList<Integer>();

        if (pattern.charAt(0) == 'N') {
            list.add(1);
            list.add(2);
            min = 3;
            posOfN = 1;
        } else {
            list.add(2);
            list.add(1);
            min = 3;
            posOfN = 0;
        }

        for (int i = 1; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'N') {
                list.add(min);
                min++;
                posOfN = i + 1;
            } else {
                list.add(list.get(i));
                for (int j = posOfN; j <= i; j++) {
                    int val = list.get(j);
                    list.set(j, ++val);
                }

                min++;
            }
        }

        final StringBuilder sb = new StringBuilder();
        for(int val : list){
            sb.append(val);
        }
        return Integer.parseInt(sb.toString());
    }
}
