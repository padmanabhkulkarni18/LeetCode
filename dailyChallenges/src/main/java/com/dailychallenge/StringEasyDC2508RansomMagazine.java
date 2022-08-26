package com.dailychallenge;

import java.util.HashMap;

/*
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

 */
public class StringEasyDC2508RansomMagazine {

    public static void main(String[] args) throws InterruptedException {

        System.out.println(canConstruct("aa", "aba"));
        System.out.println(canConstruct("aab", "baa"));

    }

    public static boolean canConstruct(String ransomNote, String magazine) throws InterruptedException {

        HashMap<Character,Integer> ransomNoteMap = new HashMap<>();
        HashMap<Character,Integer> magazineMap = new HashMap<>();

        char [] rsm = ransomNote.toCharArray();
        char [] mgz = magazine.toCharArray();

        for(char c : rsm){
            if(ransomNoteMap.containsKey(c)){
                ransomNoteMap.put(c,ransomNoteMap.get(c)+1);
            }
            else {
                ransomNoteMap.put(c,1);
            }
        }

        for(char c : mgz){
            if(magazineMap.containsKey(c)){
                magazineMap.put(c,magazineMap.get(c)+1);
            }
            else {
                magazineMap.put(c,1);
            }
        }
        System.out.println("printing contents of ransomNoteMap-----------------------------");

        for (Character name: ransomNoteMap.keySet()) {
            String key = name.toString();
            String value = ransomNoteMap.get(name).toString();
            System.out.println(key + " " + value);
        }
        System.out.println("printing contents of magazineMap-----------------------------");
        for (Character name: magazineMap.keySet()) {
            String key = name.toString();
            String value = magazineMap.get(name).toString();
            System.out.println(key + " " + value);
        }

        for(char c : ransomNoteMap.keySet()){
            if(!magazineMap.containsKey(c) || magazineMap.get(c) < ransomNoteMap.get(c)){
                return false;
            }
        }
        return true;

    }


}
