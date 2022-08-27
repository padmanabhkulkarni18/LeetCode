package com.practiceproblems.strings.easy;

public class PalindromeNumber {

    public static void main(String[] args) {

        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {

        int num =x;
        int digit=0;
        int result=0;
        if(x<0){
            return false;
        }

        while(num!=0){
            digit = num%10;
            result = result *10+ digit;
            num =num/10;
        }

        if(result==x){
            return true;
        }


        System.out.println(result);

        return false;


    }
}
