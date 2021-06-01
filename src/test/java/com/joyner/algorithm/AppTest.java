package com.joyner.algorithm;

import com.joyner.algorithm.leetcode_practice.vo.ListNode;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import javax.swing.plaf.metal.MetalBorders;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;

/**
 * Unit test for simple App.
 */
public class AppTest
{

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();


        List<Integer> zeroLevel = new ArrayList<>();
        zeroLevel.add(1);
        result.add(zeroLevel);

        for (int i = 1; i < numRows; i++) {
            //从第一层开始
            //拿上一层的结果
            List<Integer> preLevel = result.get(i - 1);
            int preLevelSize = preLevel.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int j = 0; j < i+1; j++) {
                int preLeftIndex = j - 1;
                int preRightIndex = j;

                int preLeftVal = 0;
                int preRightVal = 0;
                if (preLeftIndex >= preLevelSize && preLeftIndex < preLevelSize) {
                    preLeftVal = preLevel.get(preLeftIndex);
                }
                if (preRightIndex >= preLevelSize && preRightIndex < preLevelSize) {
                    preRightVal = preLevel.get(preRightIndex);
                }
                int val = preLeftVal + preRightVal;
                currentLevel.add(val);

            }
            result.add(currentLevel);
        }


        return result;
    }


    public static void main(String[] args) throws InterruptedException {
        HashMap map = new HashMap();
        map.put("test", "ok");
    }

}
