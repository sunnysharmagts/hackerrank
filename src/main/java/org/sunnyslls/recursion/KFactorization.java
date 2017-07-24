package org.sunnyslls.recursion;

import java.util.*;

/**
 * Created by sunny on 13/7/17.
 */
public class KFactorization {

    private static int[] factorArr;
    private static int number;
    private static int factorSize;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();
        factorSize = scanner.nextInt();
        int[] factors = new int[factorSize];
        for(int i = 0; i < factorSize; i++){
            int factor = scanner.nextInt();
            factors[i] = factor;
        }
        new KFactorization().factorization(number, factorSize, factors);
    }

    public Object[] factorization(int number, int factorSize, int[] factors){
        List<Integer> list = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        this.number = number;
        this.factorSize = factorSize;
        optimizefactors(factors);
        int count = 1;
        list.add(count);
        factorization(count, list, map, 0);
        list.clear();
        if(!map.containsKey(0)){
            System.out.println(-1);
            list.add(-1);
        }else{
            List<Integer> l = map.get(0);
            for(int i : l){
                System.out.print(i +" ");
                list.add(i);
            }
        }
        return list.toArray();
    }

    public void optimizefactors(int[] factors){
        //factorArr = new ArrayList<>();
        List<Integer> fl = new ArrayList<>();
        for(int i : factors){
            if(number % i == 0){
                fl.add(i);
            }
        }
        Collections.sort(fl);
        factorSize = fl.size();
        factorArr = new int[factorSize];
        for(int i = 0; i < factorSize; i++){
            factorArr[i] = fl.get(i);
        }
    }

    private boolean factorization(int count, List<Integer> list, Map<Integer, List<Integer>> map, int k){
        if(number == count){
            addElement(list, map);
            return true;
        }

        while(k < factorSize) {
            int value = factorArr[k];
            count *= value;
            list.add(count);
            if (!canBacktrack(count, list)) {//factorization(count, list, map, k);
                if(factorization(count, list, map, k)){
                    list.remove(list.size()-1);
                    return false;
                }
            }
            boolean isCountGreater = false;
            if(count > number){
                isCountGreater = true;
            }
            count /= value;
            list.remove(list.size()-1);
            k++;
            if(isCountGreater){
                return false;
            }
        }
        return false;
    }

    public boolean canBacktrack(int count, List<Integer> list){
        if(count > number || list.size() > 200){
            return true;
        }
        return false;
    }

    private void addElement(List<Integer> list, Map<Integer, List<Integer>> map){
        if(!map.containsKey(0)){
            map.put(0, new ArrayList<>(list));
            return;
        }
        List<Integer> savedList = map.get(0);
        if(list.size() < savedList.size()){
            map.put(0, new ArrayList<>(list));
            return;
        }else if(list.size() > savedList.size()){
            return;
        }else{
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i) < savedList.get(i)){
                    map.put(0, new ArrayList<>(list));
                    return;
                }else if(list.get(i) > savedList.get(i)){
                    return;
                }
            }
        }
    }
}
