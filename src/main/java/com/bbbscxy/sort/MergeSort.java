package com.bbbscxy.sort;

import java.util.Arrays;

/**
 * @作者 Administrator
 * @时间 2020-08-03 9:54
 * @版本 1.0
 * @说明
 */
public class MergeSort {

    private static int[] asList;

    public static void main(String[] args) {
        int[] arr = {6,4,3,7,8,0,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        asList = new int[arr.length];
        sort(arr, 0, arr.length-1);
    }

    private static void sort(int[] arr, int left, int right) {
        if(left >= right){
            return;
        }

        int mid = left+(right-left)/2;
        sort(arr, 0, mid);
        sort(arr, mid+1, right);

        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int i = left;
        int p = left;
        int q = mid+1;

        while (p <= mid && q <= right){
            if(arr[p] > arr[q]){
                asList[i++] = arr[q++];
            }else{
                asList[i++] = arr[p++];
            }
        }

        while (p <= mid){
            asList[i++] = arr[p++];
        }

        while (q <= right){
            asList[i++] = arr[q++];
        }

        for(int index=left; index<=right; index++){
            arr[index] = asList[index];
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
