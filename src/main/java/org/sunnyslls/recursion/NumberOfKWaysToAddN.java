package org.sunnyslls.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunny on 5/9/17.
 */
public class NumberOfKWaysToAddN {

    public static void main(String[] args){
        sumKN(6, 2);
    }

    static void sumKN(int N, int k){
        List<List<Integer>> list = new ArrayList<>();
        sumKN(N, k, 1, 0, new ArrayList<>(), list);
        System.out.println(list);
    }

    static List<List<Integer>> sumKN(int N, int k, int index, int total, List<Integer> list, List<List<Integer>> mainList){
        if(index > k){
            if(total == N){
                mainList.add(new ArrayList<>(list));
            }
            return mainList;
        }
        if(total > N){
            return mainList;
        }

        List<List<Integer>> subList = null;
        for(int i = index; i <=N; i++){
            list.add(i);
            sumKN(N, k, index+1, total + i, list, mainList);
            list.remove(list.size()-1);
        }

        return subList;
    }
}
