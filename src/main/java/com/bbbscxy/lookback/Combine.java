package com.bbbscxy.lookback;

import java.util.ArrayList;
import java.util.List;

/**
 * @作者 Administrator
 * @时间 2020-08-06 19:42
 * @版本 1.0
 * @说明
 */
public class Combine {

    public static void main(String[] args) {
        int n = 4;
        int k = 2;

        List<Integer> result = new ArrayList<Integer>();
        combine(n, 1, k, result);
    }

    private static void combine(int n, int pos, int k, List<Integer> result) {
        if(result.size() == k){
            System.out.println(result);
            return;
        }

        for (int i = pos; i <= n; i++) {

            //选择
            result.add(i);
            //下一路径
            combine(n, i + 1, k, result);
            //撤销
            result.remove(result.indexOf(i));
        }
    }
}
