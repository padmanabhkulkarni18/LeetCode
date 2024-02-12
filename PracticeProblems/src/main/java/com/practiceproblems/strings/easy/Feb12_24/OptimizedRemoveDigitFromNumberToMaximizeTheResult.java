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

import java.util.*;

public class RemoveDigitFromNumberToMaximizeTheResult {

    public static void main(String[] args) {

        String number = "299858953917872714814599237991174513476623756395992135212546127959342974628712329595771672911914471";
        char digit = '3';
        // 13235, 13325
        //o/p -> 13235
        //expected -> 13325

        RemoveDigitFromNumberToMaximizeTheResult removeDigitFromNumberToMaximizeTheResult = new RemoveDigitFromNumberToMaximizeTheResult();
        System.out.println(removeDigitFromNumberToMaximizeTheResult.removeDigit(number,digit));

    }

    public String removeDigit(String number, char digit) {

        boolean isDigitRemoved = false;

        List<Long> outputArrayList = new ArrayList<>();

        int numberOfOccurences = 0;

        Queue<Integer> queueIndexes = new ArrayDeque<>();
        if (number.contains(String.valueOf(digit))) {
            for (int i = 0; i < number.length(); i++) {
                if (number.charAt(i) == digit) {
                    numberOfOccurences++;
                    queueIndexes.add(i);
                }
            }
        }

        for (int j = 0; j < numberOfOccurences; j++) {
            int eachDigitIndex = queueIndexes.remove();
            long eachCombination= getEachCombination(number, eachDigitIndex);
            outputArrayList.add(eachCombination);
        }
        long max =0;
        for (int k = 0; k < numberOfOccurences; k++) {
            max = outputArrayList.get(0);
            if (max < outputArrayList.get(k)) {
                max = outputArrayList.get(k);
            }
        }
        return String.valueOf(max);
    }

    public long getEachCombination(String number, int indexToBeIgnored){

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
                if(i!=indexToBeIgnored){
                    stringBuilder.append(number.charAt(i));
            }

        }
        System.out.println(stringBuilder.toString());
        return Long.parseLong(stringBuilder.toString());
    }


    }

