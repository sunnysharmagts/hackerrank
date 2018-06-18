package org.sunnyslls.miscellanous;

/**
 * Created by sunny on 3/9/17.
 */
public class Add2BiggestNumber {

    public static void main(String[] args){
        String s1 = "9999";
        String s2 = "99999";
        add(s1, s2);
    }

    static void add(String s1, String s2){
        if(s1 == null || s2 == null){
            return;
        }

        int maxLength = s1.length() > s2.length() ? s1.length() : s2.length();

        int[] arr1 = new int[maxLength];
        int[] arr2 = new int[maxLength];

        for(int i = s1.length()-1; i >=0; i--){
            arr1[i] = s1.charAt(i);
        }

        for(int i = s2.length()-1; i >=0; i--){
            arr2[i] = s2.charAt(i);
        }

        int[] result = new int[maxLength+1];
        int index = maxLength;
        int carry = 0;

        for(int i = maxLength-1; i >=0; i--){

            int lastDigit = 0;
            int value = carry + arr1[i] + arr2[i];

            if(value > 9){
                lastDigit = value % 10;
                carry = (value / 10) % 10;
            }else{
                carry = 0;
            }
            result[index] = lastDigit;
            index--;
        }

        if(carry > 0){
            result[0] = carry;
        }

        for(int i : result){
            System.out.print(i);
        }
    }
}
