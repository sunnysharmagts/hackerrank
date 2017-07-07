package org.sunnyslls.miscellanous;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class MakeAnagramByRemovingChars {

	public static int numberNeeded(String first, String second) {
        if(first == null || second == null){
            return 0;
        }
        int result = 0;
        
        HashMap<Character, Integer> firstMap = new HashMap<>();
        HashMap<Character, Integer> secondMap = new HashMap<>();
        
        for(int i = 0; i < first.length(); i++){
        	int value = 0;
        	if(firstMap.containsKey(first.charAt(i))){
        		value = firstMap.get(first.charAt(i));
        	}
        	firstMap.put(first.charAt(i), ++value);
        }
        
        for(int i = 0; i < second.length(); i++){
        	int value = 0;
        	if(secondMap.containsKey(second.charAt(i))){
        		value = secondMap.get(second.charAt(i));
        	}
        	secondMap.put(second.charAt(i), ++value);
        }
        
        Iterator<Entry<Character, Integer>> itr = firstMap.entrySet().iterator();
        while(itr.hasNext()){
        	Entry<Character, Integer> entry = itr.next();
        	Character key = entry.getKey();
        	Integer secondKey = null;
        	if((secondKey = secondMap.get(key)) != null){
        		int value = Math.abs(secondKey.intValue() - entry.getValue().intValue());
        		if(value == 0){
        			result += entry.getValue() * 2;
        		}else{
        			value = secondKey.intValue() > entry.getValue().intValue() ? secondKey.intValue() - value : entry.getValue().intValue() - value;
        			result += value * 2;
        		}
        	}
        }
        result = first.length() + second.length() - result;
        return result;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        in.close();
        System.out.println(numberNeeded(a, b));
    }

}
