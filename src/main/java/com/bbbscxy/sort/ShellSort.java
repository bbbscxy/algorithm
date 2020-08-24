package com.bbbscxy.sort;

import java.util.Arrays;

/**
 * @作者 Administrator
 * @时间 2020-08-03 9:54
 * @版本 1.0
 * @说明
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {9,1,2,5,7,4,8,6,3,5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        int len = arr.length;
        for(int gap=len/2; gap>0; gap=gap/2){
            insertSort(arr, gap);
        }
    }

    private static void insertSort(int[] arr, int gap) {
        for(int i=0; i<arr.length; i+=gap){
            for(int j=i; j>0; j-=gap){
                if(arr[j]<arr[j-gap]){
                    swap(arr, j, j-gap);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
