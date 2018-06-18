package org.sunnyslls.ola;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by sunny on 13/1/18.
 */
public class CalculateTimeStamp {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String args[]) throws Exception {
        // read the string filename
        String filename = scan.nextLine();
        File file = new File(filename);
        if(file.exists()){
            Scanner scanner = new Scanner(file);
            LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                int startingIndex = line.indexOf("[");
                int endingIndex = line.indexOf("]");
                String result = line.substring(startingIndex+1, endingIndex);
                if(map.containsKey(result)){
                    int value = map.get(result);
                    map.put(result, ++value);
                }else{
                    map.put(result, 1);
                }
            }
            File newFile = new File("req"+filename);
            PrintWriter printWriter = new PrintWriter(newFile);
            try {
                Iterator<Map.Entry<String, Integer>> itr = map.entrySet().iterator();
                while(itr.hasNext()){
                    Map.Entry<String, Integer> entry = itr.next();
                    if(entry.getValue() > 1){
                        String key = entry.getKey();
                        key = key.replace("-400", "");
                        printWriter.write(key);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                printWriter.close();
            }
        }
    }
}
