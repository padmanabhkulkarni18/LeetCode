package com.practiceproblems.strings.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class TwoSum {

    public static void main(String[] args) {

//        int[] nums = new int[]{2,7,11,15};
//        int target = 9;

//        int[] nums = new int[]{3,2,4};
//        int target = 6;

        int[] nums = new int[]{3, 3};
        int target = 6;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {

//        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
//
//        for(int i=0;i<nums.length;i++){
//            map.put(nums[i],i);
//        }
//
//        for(Integer integer : map.keySet()){
//            System.out.println("Key :" + integer + ", Value :" + map.get(integer));
//            System.out.println();
//        }
//
//        for(int i=0;i<nums.length;i++){
//
//            if(map.get(target-nums[i])!=null && nums[i]!=target-nums[i]) {
//                return new int[] {map.get(nums[i]), map.get(target-nums[i])};
//            }
//
//        }


//        ------------------------------------

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (j != nums.length) {

                    if (nums[i] + nums[j] == target) {
                        return new int[]{i,j};
                    }
                }
            }

        }
        return null;
    }
}
