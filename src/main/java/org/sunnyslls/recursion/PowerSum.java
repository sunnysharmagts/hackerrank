package org.sunnyslls.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sunny on 11/7/17.
 *
 * Find the number of ways that a given integer, , can be expressed as the sum of the  power of unique, natural numbers.

 Input Format

 The first line contains an integer .
 The second line contains an integer .

 Constraints

 Output Format

 Output a single integer, the answer to the problem explained above.

 Sample Input 0

 10
 2
 Sample Output 0

 1
 Explanation 0

 If  and , we need to find the number of ways that  can be represented as the sum of squares of unique numbers.


 This is the only way in which  can be expressed as the sum of unique squares.

 Sample Input 1

 100
 2
 Sample Output 1

 3
 Explanation 1


 Sample Input 2

 100
 3
 Sample Output 2

 1
 Explanation 2

 can be expressed as the sum of the cubes of .
 . There is no other way to express  as the sum of cubes.
 */
public class PowerSum {

    private int number;
    private int pow;

    public boolean getPowerSum(int number, int pow){
        this.number = number;
        this.pow = pow;
        List<List<Integer>> mainList = new ArrayList<>();
        for(int i = 1; i <= number; i++) {
            getPowerSum(1, number, new ArrayList<>(), mainList);
        }
        System.out.println(mainList.size());
        return false;
    }

    private boolean getPowerSum(int value, double sum, List<Integer> list, List<List<Integer>> mainList){
        if(sum == 0){
            if(!mainList.contains(list)){
                mainList.add(list);
            }else{
                return false;
            }
            return true;
        }
        for(int i = value; i < number/2; i++){
            double powValue = Math.pow(i, pow);
            sum = sum - powValue;
            if(sum < 0){
                return false;
            }
            list.add(i);
            if(getPowerSum(i+1, sum, list, mainList)){
                return true;
            }
            else{
                list.remove(list.size()-1);
                sum = sum + powValue;
            }
        }
        return false;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int power = scanner.nextInt();
        PowerSum powerSum = new PowerSum();
        powerSum.getPowerSum(number, power);
    }
}
