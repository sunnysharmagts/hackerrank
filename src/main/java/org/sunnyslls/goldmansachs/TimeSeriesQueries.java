package org.sunnyslls.goldmansachs;

import java.util.*;

/**
 * Created by sunny on 20/8/17
 * <p>
 * A time series is a series of data points indexed in time order. They are commonly used in the financial world, especially in stock markets.
 * <p>
 * In this challenge you are working with a time series of stock prices. You are given  historical records where the stock at time  had a price . You have to answer  types of  queries of the form :
 * <p>
 * For type , given a value , when was the first time that the price of the stock was at least ?
 * For type , given a value , what's the maximum price of the stock at a time greater or equal to ?
 * If for any of these queries the answer is not defined, i.e. there are no historical records that match the query, the answer is .
 * <p>
 * Input Format
 * <p>
 * In the first line, there are two space-separated integers  and  denoting the number of historical records and the number of queries, respectively.
 * The second line contains  space-separated integers denoting the time-stamps . The next line contains  space-separated integers denoting the price of stock , where  value corresponds to the  time-stamp.
 * Next,  lines follow and each of them describes a single query. Each query is given as two space-separated integers. The first of them is either  or  and denotes the type of the query followed by a single integer denoting the value to be queried.
 * <p>
 * Constraints
 * <p>
 * for
 * Output Format
 * <p>
 * For each of the  queries, print the answer on a new line. If the answer is not defined, print .
 * <p>
 * Sample Input 0
 * <p>
 * 5 5
 * 1 2 4 8 10
 * 5 3 12 1 10
 * 1 10
 * 1 4
 * 2 8
 * 2 3
 * 1 13
 * Sample Output 0
 * <p>
 * 4
 * 1
 * 10
 * 12
 * -1
 * Explanation 0
 * <p>
 * In the sample, there are  data records and  queries to answer. At time  the price was , at time  the price was , at time  the price was , at time  the price was , and finally, at time  the price was .
 * <p>
 * In the first query, we are asked for the minimum time at which the price was at least . The answer is  because at this time the price was  and there is no earlier time with a price at least .
 * <p>
 * In the second query, we are asked for the minimum time at which the price was at least . The answer is because the price at this time was  which is greater than .
 * <p>
 * In the third query, we are asked for the maximum price at time  or greater. The answer is  because there are two data records with time at least  and the highest price among them is .
 * <p>
 * In the fourth query, we are asked for the maximum price at time  or greater. The answer here is .
 * <p>
 * In the last query, we are asked for the minimum time at which the price was at least . Since there is no data record with price  or greater, the answer is ..
 */

public class TimeSeriesQueries {

    static HashMap<Integer, Integer> timeMap = new HashMap<>();
    static HashMap<Integer, Integer> priceMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        List<Integer> t = new ArrayList<>();
        for (int t_i = 0; t_i < n; t_i++) {
            t.add(in.nextInt());
        }

        List<Integer> p = new ArrayList<>();
        for (int p_i = 0; p_i < n; p_i++) {
            p.add(in.nextInt());
        }

        for(int i = 0; i < n; i++){
            timeMap.put(t.get(i), p.get(i));
            priceMap.put(p.get(i), t.get(i));
        }

        Collections.sort(t);
        Collections.sort(p);

        for (int a0 = 0; a0 < q; a0++) {
            int _type = in.nextInt();
            int v = in.nextInt();
            int result;
            if(_type == 1){
                result = findMinTime(v, p);
            }else{
                result = findMaxPrice(v, t);
            }
            System.out.println(result);
        }
        in.close();
    }

    private static int findMinTime(int price, List<Integer> priceList){

        int currPrice = Integer.MAX_VALUE;
        int start = 0;
        int end = priceList.size()-1;

        while(start < end){
            int mid = (start + end) / 2;
            if(priceList.get(mid) >= price){
                currPrice = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        if(currPrice == Integer.MAX_VALUE){
            return -1;
        }
        int minTime = Integer.MAX_VALUE;
        while(currPrice < priceList.size()){
            int minPrice = priceList.get(currPrice);
            int currTime = priceMap.get(minPrice);
            if(minTime > currTime){
                minTime = currTime;
            }
            currPrice++;
        }
        return minTime;
    }

    private static int findMaxPrice(int time, List<Integer> timeList){

        int start = 0;
        int end = timeList.size()-1;
        int currTime = Integer.MAX_VALUE;
        while(start < end){
            int mid = (start + end) / 2;
            if(timeList.get(mid) >= time){
                currTime = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        if(currTime == Integer.MAX_VALUE){
            return -1;
        }
        int maxPrice = Integer.MIN_VALUE;

        while(currTime < timeList.size()){
            int currPrice = timeMap.get(timeList.get(currTime));
            if(maxPrice < currPrice){
                maxPrice = currPrice;
            }
            currTime++;
        }
        return maxPrice;
    }
}
