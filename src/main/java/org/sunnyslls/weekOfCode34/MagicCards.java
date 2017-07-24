package org.sunnyslls.weekOfCode34;

import java.util.*;

/**
 * Created by sunny on 22/7/17.
 */
public class MagicCards {

    static int m;
    static int max;
    static Map<Integer, Cards> map = new HashMap<>();

    public static void main(String[] args){
        MagicCards obj = new MagicCards();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        m = scanner.nextInt();
        int q = scanner.nextInt();
        max = (m*(m+1)*(2*m+1)) / 6;
        for(int z = 0; z < n; z++) {
            int x_i = scanner.nextInt();
            Set<Integer> frontCardList = new HashSet<>();
            int total = 0;
            Cards card = new Cards(frontCardList);
            for (int i = 0; i < x_i; i++) {
                int value = scanner.nextInt();
                frontCardList.add(value);
                total += Math.pow(value, 2);
            }
            card.setFrontTotal(total);
            card.fillBack();
            map.put(z+1, card);
        }

        for(int i = 0; i < q; i++){
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int total = obj.magicCards(r, l, 0, 0, new HashSet<Integer>());
            System.out.println(total);
        }
    }

    public int magicCards(int r, int index, int result, int total, Set<Integer> mainSet){
        if(index > r){
            if(total < result){
                total = result;
            }
            return total;
        }

        Set<Integer> set = map.get(index).front;
        result = getTotal(mainSet, set);
        total = magicCards(r, index+1, result, total, mainSet);
        mainSet.removeAll(set);
        set = map.get(index).back;
        result = getTotal(mainSet, set);
        total = magicCards(r, index+1, result, total, mainSet);
        return total;
    }

    private int getTotal(Set<Integer> mainSet, Set<Integer> set){
        int result = 0;
        mainSet.addAll(set);
        for(int i : mainSet){
            result += Math.pow(i, 2);
        }
        return result;
    }

    static class Cards{
        Set<Integer> front;
        Set<Integer> back;
        int frontTotal;
        int backTotal;

        Cards(Set<Integer> front){
            this.front = front;
            back = new LinkedHashSet<>(m-front.size());
        }

        public void setFrontTotal(int total) {
            this.frontTotal = total;
        }

        void fillBack(){
            int backLength = m-front.size();
            for(int i = 1; i <= m; i++){
                if(back.size() >= backLength){
                    break;
                }
                else if(!front.contains(i)){
                    back.add(i);
                    backTotal += Math.pow(i, 2);
                }
            }
        }

    }
}
