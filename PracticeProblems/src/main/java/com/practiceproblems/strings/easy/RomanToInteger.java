package com.practiceproblems.strings.easy;
/*
13. Roman to Integer
Easy

6539

394

Add to List

Share
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.
IV-> result
,IX,XL,XC,CD,CM
 */


public class RomanToInteger {

    public static void main(String[] args) {
//        System.out.println(romanToInt("V"));
//        System.out.println(romanToInt("XII"));

        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        int result = 0;
        char nextChar = 0;
        for(int i=0;i<s.length();i++){
            char eachChar = s.charAt(i);
            if(i!=s.length()-1) {
                nextChar = s.charAt(i + 1);
            }
            int combResult = checkCombinationsAndAddToTheResult(eachChar, nextChar);
            if(combResult==0) {
                result += converter(eachChar);
            }else {
                i++;
                result = result+combResult;
            }
        }

        return Integer.valueOf(result);
    }

    private static int checkCombinationsAndAddToTheResult(char eachChar, char nextChar) {

        if(eachChar=='I' && nextChar=='V'){
            return 4;
        } else if(eachChar=='I' && nextChar=='X'){
            return 9;
        } else if(eachChar=='X' && nextChar=='L'){
            return 40;
        } else if(eachChar=='X' && nextChar=='C'){
            return 90;
        } else if(eachChar=='C' && nextChar=='D') {
            return 400;
        } else if(eachChar=='C' && nextChar=='M') {
            return 900;
        }
            return 0;


    }

    public static int converter(char s) {

        switch (s){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }

        return 0;
    }


}
