package com.dailychallenge.Feb25_24;


/*
*
*
* You are given an integer n. There are n rooms numbered from 0 to n - 1.

You are given a 2D integer array meetings where meetings[i] = [starti, endi] means that a meeting will be held during the half-closed time interval [starti, endi). All the values of starti are unique.

Meetings are allocated to rooms in the following manner:

Each meeting will take place in the unused room with the lowest number.
If there are no available rooms, the meeting will be delayed until a room becomes free. The delayed meeting should have the same duration as the original meeting.
When a room becomes unused, meetings that have an earlier original start time should be given the room.
Return the number of the room that held the most meetings. If there are multiple rooms, return the room with the lowest number.

A half-closed interval [a, b) is the interval between a and b including a and not including b.



Example 1:

Input: n = 2, meetings = [[0,10],[1,5],[2,7],[3,4]]
Output: 0
Explanation:
- At time 0, both rooms are not being used. The first meeting starts in room 0.
- At time 1, only room 1 is not being used. The second meeting starts in room 1.
- At time 2, both rooms are being used. The third meeting is delayed.
- At time 3, both rooms are being used. The fourth meeting is delayed.
- At time 5, the meeting in room 1 finishes. The third meeting starts in room 1 for the time period [5,10).
- At time 10, the meetings in both rooms finish. The fourth meeting starts in room 0 for the time period [10,11).
Both rooms 0 and 1 held 2 meetings, so we return 0.
Example 2:

Input: n = 3, meetings = [[1,20],[2,10],[3,5],[4,9],[6,8]]
Output: 1
Explanation:
- At time 1, all three rooms are not being used. The first meeting starts in room 0.
- At time 2, rooms 1 and 2 are not being used. The second meeting starts in room 1.
- At time 3, only room 2 is not being used. The third meeting starts in room 2.
- At time 4, all three rooms are being used. The fourth meeting is delayed.
- At time 5, the meeting in room 2 finishes. The fourth meeting starts in room 2 for the time period [5,10).
- At time 6, all three rooms are being used. The fifth meeting is delayed.
- At time 10, the meetings in rooms 1 and 2 finish. The fifth meeting starts in room 1 for the time period [10,12).
Room 0 held 1 meeting while rooms 1 and 2 each held 2 meetings, so we return 1.

*
*
* */

import java.util.*;

public class MeetingRooms3_Hard2402 {


    public static void main(String[] args) {

        int[][] meetings = new int[][]{{0,10},{1,5},{2,7},{3,4},{8,11},{9,12}};
        int n=2;

        MeetingRooms3_Hard2402 meetingRooms3Hard2402 = new MeetingRooms3_Hard2402();

        System.out.println("Room number held most meetings : " + meetingRooms3Hard2402.mostBooked(n,meetings));


    }

    public int mostBooked(int n, int[][] meetings) {

        int[] rooms = new int[n];

        LinkedHashMap<Integer,List<Integer>> linkedHashMap = new LinkedHashMap();

        if(meetings.length==1){
            return 0;
        }

        boolean populateNewMeeting = true;
        int meetingLimit =n;

        for(int i=0;i<meetings.length;i++) {

            if(linkedHashMap.size()<n){
                populateNewMeeting = true;
            }

            if(linkedHashMap.size()!=0 && linkedHashMap.size()<n){

                ArrayList<Integer> list = (ArrayList<Integer>) linkedHashMap.values().stream().findFirst().get();
                if(!list.isEmpty() && linkedHashMap.values().stream().findFirst().get().size()==n){
                    populateNewMeeting = false;
                }
            }

            if(populateNewMeeting) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(meetings[i][1]);
                linkedHashMap.put(meetings[i][0], list);

                if(linkedHashMap.size()==n){
                    populateNewMeeting = false;
                }

                continue;
            }

            if(!populateNewMeeting) {

                List<Integer> lowestPairList = findLowest(rooms, linkedHashMap);

                System.out.println("minEndTime : " + lowestPairList.get(1));

                //findIndexOfARoom

                //calculate time
                int minEndTime = lowestPairList.get(1);
                int oldKey = lowestPairList.get(0);
                int newKey = meetings[i][0];
                int newValue = meetings[i][1];
                int value = minEndTime + (newValue - newKey);

                linkedHashMap.remove(oldKey);

                if(null != linkedHashMap.get(minEndTime)){
                        ArrayList<Integer> list = (ArrayList<Integer>) linkedHashMap.get(minEndTime);
                        list.add(value);
                       linkedHashMap.replace(minEndTime,list);
                }
                else {
                    ArrayList<Integer> list = new ArrayList();
                    list.add(value);
                    linkedHashMap.put(minEndTime, list);
                }

                //when over make meetingLimit=n+
            }
        }
        int maxRoom =Integer.MIN_VALUE;
        int roomIndex =-1;
        for(int i=0;i<rooms.length;i++){
                maxRoom = Math.max(maxRoom,rooms[i]);
                roomIndex = i;
                if(i!=0 && rooms[i-1]==rooms[i]){
                    roomIndex=i-1;
                    break;
                }
        }
            return roomIndex;
        }

    private List findLowest(int[] rooms, LinkedHashMap<Integer, List<Integer>> linkedHashMap) {

        int i =0;

        List<Integer> list = new ArrayList<>();

        int minEndTimeValue = (int) linkedHashMap.values().stream().findFirst().get().stream().findFirst().get();
        int minStartTimeKey = linkedHashMap.keySet().stream().findFirst().get();

        for(Map.Entry<Integer,List<Integer>> map: linkedHashMap.entrySet()) {

            if (map.getValue().size() > 1) {
                    minEndTimeValue = Collections.min(linkedHashMap.values().stream().findFirst().get());
                    i= linkedHashMap.values().stream().findFirst().get().indexOf(minEndTimeValue)+1;
            } else if(map.getValue().size() == 1) {
                int eachValue = (int) map.getValue().stream().findFirst().get();
                if (eachValue < minEndTimeValue) {
                    minEndTimeValue = eachValue;
                    minStartTimeKey = map.getKey();
                } else if (eachValue == minEndTimeValue && i != 0) {
                    break;
                }
                i++;
            }
        }
        findAndUpdateIndexOfARoom(rooms,i-1);
        list.add(minStartTimeKey);
        list.add(minEndTimeValue);
        return list;
    }

    private void findAndUpdateIndexOfARoom(int[] rooms, int i) {
        int j = rooms[i];
        rooms[i] = j+1;
    }
}
