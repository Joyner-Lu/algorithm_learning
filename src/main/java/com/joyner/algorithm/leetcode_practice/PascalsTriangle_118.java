package com.joyner.algorithm.leetcode_practice;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陆清云 luqingyun@foresee.cn
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class PascalsTriangle_118 {

    public List<List<Integer>> generatev1(int numRows) {
        /**
         * 思路：计算当前层的时候，要依赖上一层的结果，因此需要一个变量来存储上一层的结果
         */

        List<List<Integer>> result = new ArrayList<>();
        int currLevelIdx = 0;//当前层索引
        int prelevelIdx = 0;
        //保存前一层的数据
        List<Integer> preLevelArr = new ArrayList<>();

        while (currLevelIdx < numRows) {
            int n =  ++currLevelIdx;//当前层元素个数
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (i == 0 || i == (n - 1)) {
                    //第一个元素和最后一个元素的值给1
                    tempList.add(1);
                } else {
                    //
                    tempList.add(preLevelArr.get(prelevelIdx) + preLevelArr.get(++prelevelIdx));
                }
            }
            preLevelArr = tempList;//复制给上一层
            //恢复索引
            prelevelIdx = 0;
            result.add(tempList);
        }




        return result;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        //初始化第一层
        if (numRows > 0) {
            List<Integer> zeroLevel = new ArrayList<>();
            zeroLevel.add(1);
            result.add(zeroLevel);
        }


        for (int i = 1; i < numRows; i++) {
            //从第一层开始
            //拿上一层的结果
            List<Integer> preLevel = result.get(i - 1);
            int preLevelSize = preLevel.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int j = 0; j < i+1; j++) {
                //获取上一层的索引
                int preLeftIndex = j - 1;
                int preRightIndex = j;

                //计算当前层的值
                int preLeftVal = 0;
                int preRightVal = 0;
                if (preLeftIndex >= 0 && preLeftIndex < preLevelSize) {
                    preLeftVal = preLevel.get(preLeftIndex);
                }
                if (preRightIndex >= 0 && preRightIndex < preLevelSize) {
                    preRightVal = preLevel.get(preRightIndex);
                }
                int val = preLeftVal + preRightVal;
                currentLevel.add(val);

            }
            result.add(currentLevel);
        }


        return result;
    }


    public static void main(String[] args) {
        PascalsTriangle_118 pascalsTriangle_118 = new PascalsTriangle_118();
        List<List<Integer>> result = pascalsTriangle_118.generate(5);
        System.out.println(result);
    }

}
