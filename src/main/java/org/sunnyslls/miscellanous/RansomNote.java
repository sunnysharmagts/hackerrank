package org.sunnyslls.miscellanous;
/*
 * A kidnapper wrote a ransom note but is worried it will be traced back to him. He found a magazine and wants to know if he can cut out whole words from it and use them to create an untraceable replica of his ransom note. The words in his note are case-sensitive and he must use whole words available in the magazine, meaning he cannot use substrings or concatenation to create the words he needs.

Given the words in the magazine and the words in the ransom note, print Yes if he can replicate his ransom note exactly using whole words from the magazine; otherwise, print No.

Input Format

The first line contains two space-separated integers describing the respective values of  (the number of words in the magazine) and  (the number of words in the ransom note). 
The second line contains  space-separated strings denoting the words present in the magazine. 
The third line contains  space-separated strings denoting the words present in the ransom note.

Constraints

.
Each word consists of English alphabetic letters (i.e.,  to  and  to ).
The words in the note and magazine are case-sensitive.
Output Format

Print Yes if he can use the magazine to create an untraceable replica of his ransom note; otherwise, print No.

Sample Input 0

6 4
give me one grand today night
give one grand today
Sample Output 0

Yes
Sample Input 1

6 5
two times three is not four
two times two is four
Sample Output 1

No
Explanation 1



 */
import java.util.*;
import java.util.Map.Entry;

public class RansomNote {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;
    
    public RansomNote(String magazine, String note) {
    	
        if(magazine != null){
        	magazineMap = new HashMap<>();
        	String[] arr = magazine.split(" ");
        	for(String word : arr){
        		if(magazineMap.containsKey(word)){
        			int value = magazineMap.get(word);
        			magazineMap.put(word, ++value);
        		}else{
        			magazineMap.put(word, 1);
        		}
        	}
        }
        
        if(note != null){
        	noteMap = new HashMap<>();
        	String[] arr = note.split(" ");
        	for(String word : arr){
        		if(noteMap.containsKey(word)){
        			int value = noteMap.get(word);
        			noteMap.put(word, ++value);
        		}else{
        			noteMap.put(word, 1);
        		}
        	}
        }        
    }
    
    public boolean solve() {
    	if(magazineMap == null || noteMap == null)
    		return false;
    	
    	Iterator<Entry<String, Integer>> itr = noteMap.entrySet().iterator();
        while(itr.hasNext()){
        	Entry<String, Integer> entry = itr.next();
        	String key = entry.getKey();
        	int value = 0;
        	if(!magazineMap.containsKey(key) || (value = magazineMap.get(key)) < entry.getValue()){
        		return false;
        	}else{
        		magazineMap.put(key, --value);
        	}
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        // Eat whitespace to beginning of next line
        scanner.nextLine();
        boolean answer = false;
        if(n <= m){
	        RansomNote s = new RansomNote(scanner.nextLine(), scanner.nextLine());
	        scanner.close();
	        answer = s.solve();
        }
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
      
    }
}
