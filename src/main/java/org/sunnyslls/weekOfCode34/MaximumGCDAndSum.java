package org.sunnyslls.weekOfCode34;

import java.util.*;

/**
 * Created by sunny on 19/7/17.
 */
public class MaximumGCDAndSum {

    public static void main(String[] args){
        MaximumGCDAndSum gcdAndSum = new MaximumGCDAndSum();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> A = new ArrayList<>(n);
        for(int A_i = 0; A_i < n; A_i++){
            A.add(in.nextInt());
        }
        List<Integer> B = new ArrayList<>(n);
        for(int B_i = 0; B_i < n; B_i++){
            B.add(in.nextInt());
        }
        int res = gcdAndSum.maximumGcdAndSum(A, B);
        System.out.println(res);
    }

    int maximumGcdAndSum(List<Integer> a, List<Integer> b){
        Set set = new HashSet(a);
        a.clear();
        a.addAll(set);

        set = new HashSet(b);
        b.clear();
        b.addAll(set);

        Collections.sort(a);
        Collections.sort(b);

        int length = a.size();
        int maxFactor = 0;
        int maxSum = 0;
        for(int i = length-1; i >=0; i--){
            int elementA = a.get(i);
            if(elementA < maxFactor){
                break;
            }
            List<Integer> factorsA = findGCD(elementA);
            for(int j = length-1; j >=0; j--) {
                int elementB = b.get(j);
                if(elementB < maxFactor){
                    break;
                }
                List<Integer> factorsB = findGCD(elementB);
                int lcd = getLargestCommonFactor(factorsA, factorsB);
                if (lcd > maxFactor) {
                    maxFactor = lcd;
                    maxSum = elementA + elementB;
                }
            }
        }
        return maxSum;
    }

    int getLargestCommonFactor(List<Integer> a, List<Integer> b){
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for(int i : a){
            if(map.containsKey(i)) {
                int value = map.get(i);
                map.put(i, ++value);
            }else{
                map.put(i, 1);
            }
        }

        for(int i : b){
            if(map.containsKey(i)) {
                int value = map.get(i);
                map.put(i, ++value);
            }else{
                map.put(i, 1);
            }
        }
        Iterator<Map.Entry<Integer, Integer>> itr = map.entrySet().iterator();
        int sum = 0;
        while (itr.hasNext()){
            Map.Entry<Integer, Integer> entry = itr.next();
            if(entry.getValue() > 1 && sum < entry.getKey()){
                sum = entry.getKey();
            }
        }
        return sum;
    }

    List<Integer> findGCD(int value){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i = 2; i <=value; i++){
            if(value % i == 0) list.add(i);
        }
        return list;
    }
}
