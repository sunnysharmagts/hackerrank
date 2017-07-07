package org.sunnyslls.miscellanous;
import java.util.Scanner;

/*
 * Given a word ww, rearrange the letters of ww to construct another word ss in such a way that ss is lexicographically greater than ww. In case of multiple possible answers, find the lexicographically smallest one among them.

Input Format

The first line of input contains tt, the number of test cases. Each of the next tt lines contains ww.

Constraints 
1≤t≤1051≤t≤105 
1≤|w|≤1001≤|w|≤100 
ww will contain only lower-case English letters and its length will not exceed 100100.

Output Format

For each testcase, output a string lexicographically bigger than ww in a separate line. In case of multiple possible answers, print the lexicographically smallest one, and if no answer exists, print no answer.

Sample Input

5
ab
bb
hefg
dhck
dkhc
Sample Output

ba
no answer
hegf
dhkc
hcdk
Explanation

Test case 1: 
There exists only one string greater than ab which can be built by rearranging ab. That is ba.
Test case 2: 
Not possible to rearrange bb and get a lexicographically greater string.
Test case 3: 
hegf is the next string lexicographically greater than hefg.
Test case 4: 
dhkc is the next string lexicographically greater than dhck.
Test case 5: 
hcdk is the next string lexicographically greater than dkhc.
 */
public class NextBigStringLexicographically {
	
	public static void main(final String[] args){
		Scanner scanner = new Scanner(System.in);
		final int testCases = scanner.nextInt();
		if(testCases > 0 && testCases <= Math.pow(10, 5)){
			for(int i = 0; i < testCases; i++){
				final String value = scanner.next();
				final int length = value.length();
				final char[] sb = new char[length];
				for(int x = 0; x < length; x++){
					sb[x] = value.charAt(x);
				}
				boolean hasBigger = false;
				StringBuilder finalValue = new StringBuilder();
				for(int j = length-1; j > 0; j--){
					for(int k = j-1; k >= 0; k--){
						if(value.charAt(j) > value.charAt(k)){
								int index = j;
								int destination = k;
								while(index < length){
									char temp = sb[destination];
									sb[destination] = sb[index];
									sb[index] = temp;
									index++;
									destination++;
								}
							hasBigger = true;
							break;
						}
					}
					if(hasBigger){
						break;
					}
				}
				
				if(hasBigger){
					for(int z = 0; z < length; z++){
						finalValue.append(sb[z]);
					}
				} else{ 
					finalValue.append("no answer");
				}
				System.out.println(finalValue);
			}
		}
		scanner.close();
	}

}
