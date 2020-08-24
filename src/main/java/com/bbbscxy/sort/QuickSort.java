package com.bbbscxy.sort;

import java.util.Arrays;

/**
 * @作者 Administrator
 * @时间 2020-08-03 9:54
 * @版本 1.0
 * @说明
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {6,4,3,7,8,0,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        sort(arr, 0, arr.length-1);
    }

    private static void sort(int[] arr, int left, int right) {
        if(left >= right){
            return;
        }

        int partition = partition(arr, left, right);

        sort(arr, left, partition-1);
        sort(arr, partition+1, right);
    }

    private static int partition(int[] arr, int p, int q) {
        int left = p;
        int right = q+1;
        int data = arr[p];

        while (true){
            //从右开始
            while (data < arr[--right]){
                if(left == right){
                    break;
                }
            }

            //从左开始
            while (data > arr[++left]) {
                if(left == right){
                    break;
                }
            }

            if(left >= right){
                break;
            }else{
                swap(arr, left, right);
            }
        }

        swap(arr, p, right);
        return right;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
