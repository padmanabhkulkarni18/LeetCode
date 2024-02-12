package dailyChallenges.src.main.java.com.dailychallenge.Feb12_24;


/*

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
*
* */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ArrayEasyMajorityElement {

    public static void main(String[] args) {

        double p = 1.5f;

        int[] arr = new int[]{3,2,3};

        double minNumberOfOccurences = (double) arr.length / 2;
        int minNumberOfOccurencesRounded = (int) Math.round(minNumberOfOccurences);

        System.out.println(minNumberOfOccurencesRounded);

        HashMap<Integer, Integer> countOfOccurencesMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (countOfOccurencesMap.containsKey(arr[i])) {
                countOfOccurencesMap.put(arr[i], countOfOccurencesMap.get(arr[i]) + 1);
            } else {
                countOfOccurencesMap.put(arr[i], 1);
            }
        }

        for(Map.Entry<Integer,Integer> printMap : countOfOccurencesMap.entrySet()){
            System.out.println(printMap.getKey() + " " +  printMap.getValue());
            if(printMap.getValue() >= minNumberOfOccurencesRounded){
                System.out.println(printMap.getKey());
            }
        }

    }
}
