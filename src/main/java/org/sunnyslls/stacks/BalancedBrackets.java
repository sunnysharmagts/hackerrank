package org.sunnyslls.stacks;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by sunny on 11/7/17.
 */

public class BalancedBrackets {

    public static boolean isBalanced(String expression) {
        if(expression == null) {return false; }

        Stack<Character> stack = new Stack();
        for(int i = 0; i < expression.length(); i++){
            final char c = expression.charAt(i);
            if(c == '(') {
                stack.push(')');
            }else if(c == '{') {
                stack.push('}');
            }else if(c == '['){
                stack.push(']');
            }else {
                if (stack.isEmpty() || c != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
        in.close();
    }
}

