package PracticeProblems.src.main.java.com.practiceproblems.arraysDPMedium.Feb12_24;


import java.util.Arrays;

/*
* Given an array of integers temperatures represents the daily temperatures,
* return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
* If there is no future day for which this is possible, keep answer[i] == 0 instead.
 *
 *
 * Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]
* */
public class DailyTemperatures {
    public static void main(String[] args) {

        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};

        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures(temperatures)));
    }

    public int[] dailyTemperatures(int[] temperatures) {

        int[] output = new int[temperatures.length];

        int warmerTemperatureReached = 0;
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[i] < temperatures[j]) {
                    output[i] = j-i;
                    break;
                }
            }
        }
        return output;
    }
}

//    public int[] dailyTemperatures(int[] temperatures) {
//
//        int[] output = new int[temperatures.length];
//
//        int warmerTemperatureReached =0;
//        for(int i =0;i<temperatures.length;i++){
//            int eachDay =i;
//            if(i!=temperatures.length-1){
//                warmerTemperatureReached++;
//            }
//            int numberOfDaysToReachWarmerDays = 0;
//            if(temperatures[eachDay] < temperatures[warmerTemperatureReached]){
//                numberOfDaysToReachWarmerDays++;
//            }
//            output[i] = numberOfDaysToReachWarmerDays;
//        }
//
//        return output;
//    }

