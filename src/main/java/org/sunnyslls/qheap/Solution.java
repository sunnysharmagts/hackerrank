package org.sunnyslls.qheap;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 * @author sunny
 * 
 * This question is designed to help you get a better understanding of basic heap operations. 
You will be given queries of  types:

" " - Add an element  to the heap.
" " - Delete the element  from the heap.
"" - Print the minimum of all the elements in the heap.
NOTE: It is guaranteed that the element to be deleted will be there in the heap. Also, at any instant, only distinct elements will be in the heap.

Input Format

The first line contains the number of queries, . 
Each of the next  lines contains a single query of any one of the  above mentioned types.

Constraints 
 

Output Format

For each query of type , print the minimum value on a single line.

Sample Input

5  
1 4  
1 9  
3  
2 4  
3  
Sample Output

4  
9 
Explanation

After the first  queries, the heap contains {}. Printing the minimum gives  as the output. Then, the  query deletes  from the heap, and the  query gives  as the output.
 * 
 *
 */

public class Solution {

	
	private static final int ADD = 1;
	private static final int PRINT_MIN = 3;
	private static final int REMOVE = 2;
	private static Integer minimum = Integer.MIN_VALUE;
	private static int value;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		final int queries = scanner.nextInt();
		if(queries < 1 || queries > Math.pow(10, 5)){
			return;
		}
		final Queue<Integer> queue = new ArrayDeque<Integer>(queries);
		boolean hasChanged = false;
		File file = new File("/home/sunny/workspace/practice/file.txt");
		try {
			if(file.exists()){
				file.delete();
				file.createNewFile();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter printWriter = null;
		try {
			printWriter = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (scanner.hasNext()) {
			final int kind = scanner.nextInt();
			if(kind != PRINT_MIN){
			value = scanner.nextInt();
			if(value > Math.pow(10, 9) || !(value >= Math.pow(-10, 9))){
				continue;
			}
			}
			switch (kind) {
			case ADD:
				queue.add(value);
				if(queue.size() == 1){
					minimum = queue.peek();
				}
				else if(value < minimum){
					minimum = value;
				}
				hasChanged = false;
				break;
				
			case REMOVE:
				queue.remove(value);
				minimum = Integer.MIN_VALUE;
				hasChanged = true;
				break;
				
			case PRINT_MIN:
				if(queue.isEmpty()){
					continue;
				}
				
				if(minimum != Integer.MIN_VALUE && !hasChanged){
					System.out.println(minimum);
				} else{
				minimum = queue.peek();
				Iterator<Integer> itr = queue.iterator();
				while(itr.hasNext()){
					final int element = itr.next();
					if(element < minimum){
						minimum = element;
					}
				}
				System.out.println(minimum);
				printWriter.write(minimum);
				hasChanged = false;
				}
				break;

			default:
				break;
			}
		}
		scanner.close();
		printWriter.close();
	}

}
