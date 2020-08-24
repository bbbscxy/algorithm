package com.bbbscxy.lookback;

import java.util.LinkedList;

/**
 * @作者 Administrator
 * @时间 2020-08-06 15:41
 * @版本 1.0
 * @说明
 */
public class Rank {

    public static void rank(int[] nums, LinkedList<Integer> result){
        if(result.size() == nums.length){
            System.out.println(result);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(result.contains(nums[i])){
                continue;
            }
            //进行选择
            result.add(nums[i]);
            //下一个路径
            rank(nums, result);
            //撤销选择
            result.removeLast();
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3};
        LinkedList<Integer> result = new LinkedList<Integer>();
        rank(nums, result);
    }
}
