package com.practiceproblems.Mar13_24;

public class ConsecutivePowerOfStringEasy {

    public static void main(String[] args) {
        ConsecutivePowerOfStringEasy consecutivePowerOfStringEasy = new ConsecutivePowerOfStringEasy();
        System.out.println(consecutivePowerOfStringEasy.maxPower("bacacccbba"));
    }

    public int maxPower(String s) {
        int j= 0;
        int count=0;
        int max =0;
        int finalMax = 0;
        for(int i=0;i<s.length()-1;i++){
            if(j<s.length()){
                j=i+1;
            }
            if(s.charAt(i)==s.charAt(j)){
                count++;
            }else {
                count=0;
            }

            max = Math.max(max,count);

        }
        return max+1;
    }
}
