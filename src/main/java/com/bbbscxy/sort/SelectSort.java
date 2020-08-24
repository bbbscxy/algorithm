package com.bbbscxy.sort;

import java.util.Arrays;

/**
 * @作者 Administrator
 * @时间 2020-08-03 9:54
 * @版本 1.0
 * @说明
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {6,4,3,7,8,0,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int maxIndex = 0;
            for (int j = 1; j <= i; j++) {
                if(arr[j] > arr[maxIndex]){
                    maxIndex = j;
                }
            }
            swap(arr, i, maxIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
