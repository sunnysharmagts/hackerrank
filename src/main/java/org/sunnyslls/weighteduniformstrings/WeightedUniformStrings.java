/*
 * A weighted string is a string of lowercase English letters where each letter has a weight in the inclusive range from  to , defined below:

image

We define the following terms:

The weight of a string is the sum of the weights of all the string's characters. For example:

image

A uniform string is a string consisting of a single character repeated zero or more times. For example, ccc and a are uniform strings, but bcb and cd are not (i.e., they consist of more than one distinct character).
Given a string, , let  be the set of weights for all possible uniform substrings (contiguous) of string . You have to answer  queries, where each query  consists of a single integer, . For each query, print Yes on a new line if ; otherwise, print No instead.

Note: The  symbol denotes that  is an element of set .

Input Format

The first line contains a string denoting  (the original string). 
The second line contains an integer denoting  (the number of queries). 
Each line  of the  subsequent lines contains an integer denoting  (the weight of a uniform subtring of  that may or may not exist).

Constraints

 will only contain lowercase English letters.
Output Format

For each , print Yes on a new line if ; otherwise, print No instead.

Sample Input 0

abccddde
6
1
3
12
5
9
10
Sample Output 0

Yes
Yes
Yes
Yes
No
No
Explanation 0

The weights of every possible uniform substring in the string abccddde are shown below:

image

We print Yes on the first four lines because the first four queries match weights of uniform substrings of . We print No for the last two queries because there are no uniform substrings in  that have those weights.

Note that while de is a substring of  that would have a weight of , it is not a uniform substring.

Note that we are only dealing with contiguous substrings. So ccc is not a substring of the string ccxxc.
 */
package weighteduniformstrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class WeightedUniformStrings {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = in.nextInt();
        HashMap<Character, Integer> hashList = hashValue();
                
        ArrayList<Integer> finalList = new ArrayList<>(); 
        for(int a0 = 0; a0 < n; a0++){
            int x = in.nextInt();
            finalList.add(x);
        }
        
        int length = s.length();
                
        final ArrayList<String> list = new ArrayList<>();
        
        for(int i = 0; i < length; i++){
        	String z = String.valueOf(s.charAt(i));
        	if(!list.contains(z)){
        		list.add(z);
        	}
        	StringBuilder sb = new StringBuilder();
        	sb.append(z);
        	for(int j = i+1; j < length; j++){
        		char curr = s.charAt(j);
        		if(curr == s.charAt(i)){
        			sb.append(curr);
        			i++;
        		}else{
        			if(!list.contains(curr)){
        				list.add(String.valueOf(curr));
        			}
        			break;
        		}
        		list.add(sb.toString());
        	}
        }
        
        Map<Integer, String> map = new LinkedHashMap<>();
        
        for(int i = 0; i < list.size(); i++){
        	char c = list.get(i).charAt(0);
        	int len = list.get(i).length();
        	int val = hashList.get(c) * len;
        	map.put(val, "Yes");
        }
        
        for(int i = 0; i < finalList.size(); i++){
        	if(map.get(finalList.get(i)) != null){
        		System.out.println("Yes");
        	}else{
        		System.out.println("No");
        	}
        }
	}
	
	static HashMap<Character, Integer> hashValue(){
		HashMap<Character, Integer> map = new HashMap<>();
        map.put('a', 1);
        map.put('b', 2);
        map.put('c', 3);
        map.put('d', 4);
        map.put('e', 5);
        map.put('f', 6);
        map.put('g', 7);
        map.put('h', 8);
        map.put('i', 9);
        map.put('j', 10);
        map.put('k', 11);
        map.put('l', 12);
        map.put('m', 13);
        map.put('n', 14);
        map.put('o', 15);
        map.put('p', 16);
        map.put('q', 17);
        map.put('r', 18);
        map.put('s', 19);
        map.put('t', 20);
        map.put('u', 21);
        map.put('v', 22);
        map.put('w', 23);
        map.put('x', 24);
        map.put('y', 25);
        map.put('z', 26);
        return map;
	}

}
