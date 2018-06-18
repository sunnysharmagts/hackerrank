package org.sunnyslls.recursion;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by sunny on 11/8/17.
 */
public class EggDroppingProblem {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int floor = scanner.nextInt();
        int eggs = scanner.nextInt();
        System.out.println(new EggDroppingProblem().eggDrop(floor, eggs, new HashMap<>()));
    }

    int eggDrop(int floor, int eggs, HashMap<String, Integer> map){
        if(eggs == 1){
            return floor;
        }
        if(floor == 0 || floor == 1){
            return floor;
        }
        String eggFloor = eggs+"_"+floor;

        int min = Integer.MAX_VALUE;
        int ways = 0;
        for(int k = 1; k <= floor; k++){
            System.out.println(eggFloor);
            ways = 1 + Math.min(eggDrop(floor-1, eggs-1, map), eggDrop(floor - k, eggs, map));
            if(ways < min){
                min = ways;
            }
            map.put(eggFloor, min);
        }
        return min + 1;
    }


}
