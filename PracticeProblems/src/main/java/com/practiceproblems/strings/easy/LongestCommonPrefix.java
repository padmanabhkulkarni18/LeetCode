package com.practiceproblems.strings.easy;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {

        String s[] = {"flower","aaflow","aflight"};
        System.out.println(longestCommonPrefix(s));

    }

    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        System.out.println(Arrays.toString(strs));



        return "";

    }
}
