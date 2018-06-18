package org.sunnyslls.recursion;

import java.util.*;

/**
 * Created by sunny on 17/1/18.
 */
public class AutoSuggestion {

    static HashMap<Character, Node> rootMap;

    public static void main(String[] args){
        String[] arr = {"ankesh", "anku", "akash", "aka", "sunny"};
        createTrie(arr);
        find("an");
    }

    static void find(String s){
        List<List<String>> mainList = new ArrayList<>();
        List<String> list = new ArrayList<>();
        if(rootMap.containsKey(s.charAt(0))) {
            autoSuggestion(rootMap.get(s.charAt(0)), s, 1, list, mainList);
        }

        for(List<String> l : mainList)
            l.add(0, String.valueOf(s.charAt(0)));
            System.out.println(mainList);
    }

    static void autoSuggestion(Node node, String str, int index, List<String> list, List<List<String>> mainList){
        if(node.map.isEmpty()){
            mainList.add(new ArrayList<>(list));
            return;
        }
        if(index < str.length() && !node.map.containsKey(str.charAt(index))){
            return;
        }
        Iterator<Map.Entry<Character, Node>> itr = node.map.entrySet().iterator();
        while (itr.hasNext()){
            Map.Entry<Character, Node> entry = itr.next();
            list.add(entry.getKey().toString());
            autoSuggestion(entry.getValue(), str, index+1,list, mainList);
            list.remove(list.size()-1);
        }
    }

    static void createTrie(String[] arr){
        rootMap = new HashMap<>();
        for(String s : arr) {
            createTrie(s, 0, rootMap);
        }
    }

    static void createTrie(String str, int index, HashMap<Character, Node> map){
        if(index >= str.length()){
            return;
        }
        Node node;

        if(!map.containsKey(str.charAt(index))){
            node = new Node();
            map.put(str.charAt(index), node);
        }else{
            node = map.get(str.charAt(index));
        }
        createTrie(str, index+1, node.map);
    }

    static class Node{
        private final HashMap<Character, Node> map;
        Node(){
            map = new HashMap<>();
        }

        boolean isEnd;

        void addNext(char s){
            map.put(s, null);
        }

        boolean hasNext(char next){
            return map.get(next) != null;
        }
    }
}
