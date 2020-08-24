package com.bbbscxy.lookback;

import java.util.Arrays;
import java.util.Stack;

/**
 * @作者 Administrator
 * @时间 2020-08-06 15:24
 * @版本 1.0
 * @说明
 */
public class Bracket2 {

    public static void bracket(String[] res, int left, int right, int n, Stack<String> stack) {
        if(left == 0 && right == 0){
            System.out.println(Arrays.toString(stack.toArray()));
            return;
        }

        if(left < 0 || right < 0){
            return;
        }

        if(left > right){
            return;
        }

        for (int i = 0; i < res.length; i++) {
            //选择
            stack.push(res[i]);
            if(i == 0){
                left--;
            }else{
                right--;
            }
            bracket(res, left, right, n, stack);
            stack.pop();
            if(i == 0){
                left++;
            }else{
                right++;
            }
        }
    }

    public static void main(String[] args) {
        int n = 3;
        String[] res = new String[]{"(", ")"};
        Stack<String> stack = new Stack<String>();
        bracket(res, n, n, 2*n, stack);
    }
}
