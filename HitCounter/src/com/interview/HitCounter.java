package com.interview;

import java.util.ArrayList;

public class HitCounter{

    private ArrayList<Integer> timestamps = new ArrayList<>();

    public HitCounter(){

    }
    public void hit(int timestamp){
        timestamps.add(timestamp);
    }

    public int countHits(int timestamp){
        int leftBoundaryIndex = getBinarySearch(timestamp-300+1);
        return timestamps.size()-leftBoundaryIndex;
    }

    int getBinarySearch(int target) {

        int left = 0;
        int right = timestamps.size();

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (timestamps.get(mid) >= target) {
                right = mid;
            } else {
                left = mid - 1;
            }
        }

        return left;
    }

}
