package com.dailychallenge.Mar5_24;

public class MinimumLengthOfStringAfterDelSimilarEndsMedium1750 {

    public static void main(String[] args) {

        String s = "aabccabba";

        MinimumLengthOfStringAfterDelSimilarEndsMedium1750 minimumLengthOfStringAfterDelSimilarEndsMedium1750 = new MinimumLengthOfStringAfterDelSimilarEndsMedium1750();
        minimumLengthOfStringAfterDelSimilarEndsMedium1750.minimumLength(s);


    }

    public int minimumLength(String s) {

        int j= s.length();
        int startPointer = 0;
        int endPointer = s.length()-1;

        while(startPointer!=endPointer) {

            while (s.charAt(startPointer) == s.charAt(endPointer)) {

                if(s.charAt(startPointer) == s.charAt(startPointer+1)){
                    s.replace(s,s.substring(startPointer+1));
                    startPointer++;
                }
                else {
                    startPointer++;
                }

                if(s.charAt(endPointer-1) == s.charAt(endPointer)){
                    s.replace(s,s.substring(endPointer-1));
                    endPointer--;
                }
                else {
                    endPointer--;
                }


            }
            System.out.println("startPointer : " + s.charAt(startPointer));
            System.out.println("endPointer : " + s.charAt(endPointer));
            System.out.println(s);
        }
        return -1;
    }
}
