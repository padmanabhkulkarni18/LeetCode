package com.practiceproblems.Mar14_24;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class FindMedianFromDataSteamHard {

    Stack<Integer> stack1;
    Stack<Integer> stack2;
    List<Integer> list;

    PriorityQueue<Integer> pqReal;

    public FindMedianFromDataSteamHard() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        list = new ArrayList<>();
        pqReal = new PriorityQueue<>();
    }

    public void addNum(int num) {

        stack1.push(num);
    }

    public double findMedian() {

        double result = 0;
        int stack1Result;
        int count=0;
        pqReal.clear();
        while(!stack1.isEmpty()){
            stack1Result = stack1.pop();
            stack2.push(stack1Result);
            list.add(stack1Result);
            pqReal.add(stack1Result);
            count++;
        }
        int j= list.size()-1;
        while(list.size()!=0){
            stack1.push(list.get(j));
            list.remove(list.get(j));
            j--;

        }

        list.clear();

        while (!stack2.isEmpty()){
            result += stack2.pop();
        }
        int k=0;
        int[] middleElement = new int[count];
        while (k<count){
            middleElement[k] = pqReal.poll();
            k++;
        }

        if(count%2==0){
            if(count==2){
                return result/count;
            }
            int firstIndex = (middleElement.length-1)/2;
            int secondIndex = firstIndex+1;
            double firstValue = middleElement[firstIndex];
            double secondValue = middleElement[secondIndex];

            return (firstValue+secondValue)/2;
        }

        if(count==1){
            return stack1.get(0);
        }
        if(count%2==1){
            double middleElementIntIndex = (middleElement.length)/2;
            return middleElement[(int) middleElementIntIndex];
        }
        return result;
    }

    public static void main(String[] args) {

        FindMedianFromDataSteamHard findMedianFromDataSteamHard = new FindMedianFromDataSteamHard();
//        findMedianFromDataSteamHard.addNum(1);    // arr = [1]
//        findMedianFromDataSteamHard.addNum(2);    // arr = [1, 2]
//        System.out.println(findMedianFromDataSteamHard.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
//        findMedianFromDataSteamHard.addNum(3);    // arr[1, 2, 3]
//        System.out.println(findMedianFromDataSteamHard.findMedian());
//        findMedianFromDataSteamHard.addNum(2);    // arr[1, 2, 3]
//        System.out.println(findMedianFromDataSteamHard.findMedian());



        findMedianFromDataSteamHard.addNum(6);    // arr = [1, 2]
        System.out.println(findMedianFromDataSteamHard.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
        findMedianFromDataSteamHard.addNum(10);    // arr[1, 2, 3]
        System.out.println(findMedianFromDataSteamHard.findMedian());
        findMedianFromDataSteamHard.addNum(2);    // arr[1, 2, 3]
        System.out.println(findMedianFromDataSteamHard.findMedian());
        findMedianFromDataSteamHard.addNum(6);    // arr[1, 2, 3]
        System.out.println(findMedianFromDataSteamHard.findMedian());
        findMedianFromDataSteamHard.addNum(5);    // arr[1, 2, 3]
        System.out.println(findMedianFromDataSteamHard.findMedian());// return 2.0
        findMedianFromDataSteamHard.addNum(0);    // arr[1, 2, 3]
        System.out.println(findMedianFromDataSteamHard.findMedian());// return 2.0
        findMedianFromDataSteamHard.addNum(6);    // arr[1, 2, 3]
        System.out.println(findMedianFromDataSteamHard.findMedian());// return 2.0
        findMedianFromDataSteamHard.addNum(3);    // arr[1, 2, 3]
        System.out.println(findMedianFromDataSteamHard.findMedian());// return 2.0
        findMedianFromDataSteamHard.addNum(1);    // arr[1, 2, 3]
        System.out.println(findMedianFromDataSteamHard.findMedian());// return 2.0
        findMedianFromDataSteamHard.addNum(0);    // arr[1, 2, 3]
        System.out.println(findMedianFromDataSteamHard.findMedian());// return 2.0
        findMedianFromDataSteamHard.addNum(0);    // arr[1, 2, 3]
        System.out.println(findMedianFromDataSteamHard.findMedian());// return 2.0
    }
}
