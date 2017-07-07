package org.sunnyslls.miscellanous;
import java.util.Scanner;

/*
 * A numeric string, , is beautiful if it can be split into a sequence of two or more positive integers, , satisfying the following conditions:

 for any  (i.e., each element in the sequence is  more than the previous element).
No  contains a leading zero. For example, we can split  into the sequence , but it is not beautiful because  and  have leading zeroes.
The contents of the sequence cannot be rearranged. For example, we can split  into the sequence , but it is not beautiful because it breaks our first constraint (i.e., ).
The diagram below depicts some beautiful strings:

image

You must perform  queries, where each query consists of some string . For each query, print whether or not the string is beautiful on a new line. If it's beautiful, print YES x, where  is the first number of the increasing sequence (if there are multiple such values of , choose the smallest); otherwise, print NO instead.

Input Format

The first line contains an integer denoting  (the number of strings to evaluate). 
Each of the  subsequent lines contains some string  for a query.

Constraints

Each character in  is a decimal digit from  to  (inclusive).
Output Format

For each query, print its answer on a new line (i.e., either YES x where  is the smallest first number of the increasing sequence, or NO).

Sample Input 0

7
1234
91011
99100
101103
010203
13
1
Sample Output 0

YES 1
YES 9
YES 99
NO
NO
NO
NO
Explanation 0

The first three numbers are beautiful (see the diagram above). The remaining numbers are not beautiful:

For , all possible splits violate the first and/or second conditions.
For , it starts with a zero so all possible splits violate the second condition.
For , the only possible split is , which violates the first condition.
For , there are no possible splits because  only has one digit.
 * 
 */


public class SeparateTheNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            String minVal = minVal(s);
            String min = sequence(s, 1, s.length());
            System.out.println(minVal + " "+min);
        }
        in.close();
	}
	
	static String split(String s, int splitVal){
		if(splitVal == 1){
			return null;
		}
		
		combinations(s, splitVal);
		split(s, splitVal-1);
		return null;
	}
	
	static void combinations(String s, int splitVal){
		
	}
	
	static String minVal(String s){
		if(s.isEmpty() || s == null){
			return null;
		}
		int length = s.length();
		for(int i = 0; i < length-1; i++){
			if(!isBeautiful(String.valueOf(s.charAt(i)), String.valueOf(s.charAt(i+1)))){
				return null;
			}
		}
		
		return String.valueOf(s.charAt(0));
	}
	
	static String sequence(String s, int i, int j){
		String prefix = s.substring(0, i);
		String suffix = s.substring(i, j);
		
		if(prefix.isEmpty() || suffix.isEmpty()){
			return null;
		}
		System.out.println(prefix + " "+suffix);

	
		if(prefix.startsWith("0") || suffix.startsWith("0")){
			return null;
		}
		
		if(Integer.parseInt(suffix) - Integer.parseInt(prefix) == 1){
			return String.valueOf(prefix.charAt(0));
		}
		
		sequence(s, i+1, j);
		return null;
	}
	
	static boolean isBeautiful(String prefix, String suffix){
		if(prefix.startsWith("0") || suffix.startsWith("0")){
			return false;
		}
		if(Integer.parseInt(suffix) - Integer.parseInt(prefix) == 1){
			return true;
		}
		
		return false;
	}

}
