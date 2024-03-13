package com.dailychallenge.Mar11_24;

import java.util.HashMap;
import java.util.Map;

/*

Brute Force 1Hr 20min

 */
public class CustomSortStringMedium791 {

    public static void main(String[] args) {

        String order = "hucw", s = "utzoampdgkalexslxoqfkdjoczajxtuhqyxvlfatmptqdsochtdzgypsfkgqwbgqbcamdqnqztaqhqanirikahtmalzqjjxtqfnh";

        CustomSortStringMedium791 customSortStringMedium791 = new CustomSortStringMedium791();
        System.out.println(customSortStringMedium791.customSortString(order,s));
    }

//    public String customSortString(String order, String s){
//
//        String res = "";
//        StringBuilder stringBuilderSDuplicate = new StringBuilder(s);
//        StringBuilder stringBuilderS = new StringBuilder(s);
//        StringBuilder stringBuilderOrder = new StringBuilder(order);
//        StringBuilder result = new StringBuilder();
//
//        for(int i=0;i<stringBuilderOrder.length();i++){
//            for(int j=0;j<stringBuilderS.length();j++){
//                if(stringBuilderS.charAt(j)==stringBuilderOrder.charAt(i)){
//                    result.append(stringBuilderOrder.charAt(i));
//                    int index = stringBuilderSDuplicate.indexOf(String.valueOf(stringBuilderS.charAt(j)));
//                    stringBuilderSDuplicate.deleteCharAt(index);
//                }
//            }
//        }
////        System.out.println(res);
////        System.out.println(stringBuilderS);
//
//        if(!stringBuilderSDuplicate.toString().isEmpty()){
//            result.append(stringBuilderSDuplicate);
//        }
//
//        return result.toString();
//
//    }

    public String customSortString(String order, String s){

        StringBuilder result = new StringBuilder();

        HashMap<Character,Integer> hashMap = new HashMap<>();

        for(int i=0;i<s.length();i++){
            if(hashMap.containsKey(s.charAt(i))){
                hashMap.put(s.charAt(i),hashMap.get(s.charAt(i))+1);
            }
            else {
                hashMap.put(s.charAt(i),1);
            }
        }

        for(int i=0;i<order.length();i++){
            if(hashMap.containsKey(order.charAt(i))){
                int frequency = hashMap.get(order.charAt(i));
                while (frequency>0){
                    result.append(order.charAt(i));
                    frequency--;
                }
                if(frequency==0){
                    hashMap.remove(order.charAt(i));
                }
            }
        }

        for(Map.Entry<Character,Integer> map : hashMap.entrySet()){
            int freq = map.getValue();
            while(freq>0){
                result.append(map.getKey());
                freq--;
            }
        }

        return result.toString();

    }
}
