package PracticeProblems.src.main.java.com.practiceproblems.strings.easy.Feb12_24;

/*
* You are given a string number representing a positive integer and a character digit.

Return the resulting string after removing exactly one occurrence of digit from number such that the value of the resulting string in decimal form is maximized.
* The test cases are generated such that digit occurs at least once in number.
*
*Example 1:

Input: number = "123", digit = "3"
Output: "12"
Explanation: There is only one '3' in "123". After removing '3', the result is "12".
Example 2:

Input: number = "1231", digit = "1"
Output: "231"
Explanation: We can remove the first '1' to get "231" or remove the second '1' to get "123".
Since 231 > 123, we return "231".
Example 3:

Input: number = "551", digit = "5"
Output: "51"
Explanation: We can remove either the first or second '5' from "551".
Both result in the string "51".

* */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class OptimizedRemoveDigitFromNumberToMaximizeTheResult {

    public static void main(String[] args) {

        String number = "231031";
        char digit = '1';

        //"299858953917872714814599237991174513476623756395992135212546127959342974628712329595771672911914471" , "3";
        // 13235, 13325
        //o/p -> 13235
        //expected -> 13325

        OptimizedRemoveDigitFromNumberToMaximizeTheResult removeDigitFromNumberToMaximizeTheResult = new OptimizedRemoveDigitFromNumberToMaximizeTheResult();
        System.out.println(removeDigitFromNumberToMaximizeTheResult.removeDigit(number,digit));

    }

    public String removeDigit(String number, char digit) {

        int index = 0,n=number.length();
        for(int i=0;i<n;i++){
            if(number.charAt(i)==digit){
                index = i;
                if(i<n-1 && digit < number.charAt(i+1))
                    break;
            }
        }
        number = number.substring(0, index) + number.substring(index+1);
        return number;
        }
}

