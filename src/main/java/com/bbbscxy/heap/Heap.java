package com.bbbscxy.heap;

import java.util.Arrays;

/**
 * @作者 Administrator
 * @时间 2020-08-03 19:16
 * @版本 1.0
 * @说明
 */
public class Heap {

    private static int[] arr = new int[1024];
    private int count = 1;

    public int[] arr(){
        return arr;
    }

    public void put(int val){
        arr[count++] = val;
        up(arr);
    }

    private void up(int[] arr) {
        if(count <= 2){
            return;
        }
        int currentIndex = count-1;
        while (currentIndex/2 > 0){
            int parentIndex = currentIndex/2;
            if(arr[currentIndex] < arr[parentIndex]){
                int temp = arr[currentIndex];
                arr[currentIndex] = arr[parentIndex];
                arr[parentIndex] = temp;
                currentIndex = parentIndex;
            }else{
                break;
            }
        }
    }

    public void delete(){
        down(arr);
    }

    private void down(int[] arr) {
        swap(arr, 1, count-1);
        arr[count-1] = 0;

        int currentIndex = 1;
        int leftIndex;
        int rightIndex;
        while (currentIndex*2 < count){
            leftIndex = currentIndex*2;
            rightIndex = currentIndex*2+1;
            int minIndex;
            if(rightIndex < count-1){
                minIndex = arr[leftIndex] > arr[rightIndex] ? rightIndex : leftIndex;
            }else{
                minIndex = leftIndex;
            }

            if(arr[currentIndex] > arr[minIndex]){
                swap(arr, currentIndex, minIndex);
                currentIndex = minIndex;
            }else{
                break;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.put(2);
        heap.put(3);
        heap.put(4);
        heap.put(5);
        heap.put(6);
        heap.put(7);
        heap.put(8);
        heap.put(9);
        heap.put(1);
        heap.delete();
        System.out.println(Arrays.toString(heap.arr()));
    }
}
