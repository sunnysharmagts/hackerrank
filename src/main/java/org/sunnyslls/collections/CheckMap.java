package org.sunnyslls.collections;

import java.util.LinkedHashMap;

/**
 * Created by sunny on 10/12/17.
 */
public class CheckMap {

    public static void main(String[] args){
        checkNullInMap();
    }

    static void checkNullInMap(){
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        map.put(null, "Sunny");
        map.put(1, "Ankesh");
    }
}
