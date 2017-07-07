package org.sunnyslls.miscellanous;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class TypeOfBirds {

	public static void main(String[] args) {
		/*Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        map.put(2, 0);
        map.put(3, 0);
        map.put(4, 0);
        map.put(5, 0);
        for(int types_i=0; types_i < n; types_i++){
        	int birdType = in.nextInt();
        	if(birdType > 5){
        		continue;
        	}
        	int value = map.get(birdType);
        	map.put(birdType, ++value);
        }
        int count = 0;
        Set<Entry<Integer, Integer>> set = map.entrySet();
        Iterator<Entry<Integer, Integer>> itr = set.iterator();
        System.out.println(map);
        while(itr.hasNext()){
        	Entry<Integer, Integer> entry = itr.next();
        	int value = entry.getValue();
        	if(value > 0){
        		count++;
        	}
        }
        in.close();
        System.out.println(count);*/
		
		
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] types = new int[n];
        int[] count = new int[6];
        int max=0;
        for(int types_i=0; types_i < n; types_i++){
            types[types_i] = in.nextInt();
            count[types[types_i]]++;
            if(count[types[types_i]]>max)
                max=count[types[types_i]];
        }
        for(int i=0;i<count.length;i++)
        {
            if(max==count[i])
            {
                System.out.println(i);
                break;
            }
                
        }
	}

}
