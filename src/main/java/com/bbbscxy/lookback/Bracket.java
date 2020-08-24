package com.bbbscxy.lookback;

import java.util.Arrays;
import java.util.Stack;

/**
 * @作者 Administrator
 * @时间 2020-08-06 15:24
 * @版本 1.0
 * @说明
 */
public class Bracket {

    public static void bracket(String[] res, int left, int right, Stack<String> stack){
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

        stack.push(res[0]);
        bracket(res, left-1, right, stack);
        stack.pop();

        stack.push(res[1]);
        bracket(res, left, right-1, stack);
        stack.pop();
    }

    public static void main(String[] args) {
        int n = 3;
        String[] res = new String[]{"(", ")"};
        Stack<String> stack = new Stack<String>();
        int left = n;
        int right = n;
        bracket(res, left, right, stack);
    }
}
