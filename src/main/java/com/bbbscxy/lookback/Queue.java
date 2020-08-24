package com.bbbscxy.lookback;

import java.util.Arrays;

/**
 * @作者 Administrator
 * @时间 2020-08-06 9:09
 * @版本 1.0
 * @说明
 */
public class Queue {

    private static int total = 0;

    public static void queen(int row, int res, int[] result){
        if(row == res){
            System.out.println(Arrays.toString(result));
            total++;
            return;
        }

        for(int i=0; i<res; i++){
            //过滤资源
            if(row > 0 && i == result[row-1]){
                continue;
            }

            //进行选择
            result[row] = i;
            if(isOk(row, result)){
                //继续下一个路径
                queen(row+1, res, result);
            }else{
                //撤销选择
                result[row] = -1;
            }
        }
    }

    public static boolean isOk(int row, int[] result){
        for (int i = 0; i < row; i++)
        {   //第row行皇后不能和任意之前的皇后在同一列或 \方向或 / 方向
            if (result[i] == result[row] || result[row]-row == result[i]-i || result[row]+row == result[i]+i)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 8;
        int[] result = new int[n];
        queen(0, 8, result);
        System.out.println(total);
    }
}
