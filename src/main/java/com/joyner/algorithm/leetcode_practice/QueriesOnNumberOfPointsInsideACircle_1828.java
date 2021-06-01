package com.joyner.algorithm.leetcode_practice;

import com.joyner.common.util.collection.ArrUtils;

/**
 * <pre>
 *给你一个数组 points ，其中 points[i] = [xi, yi] ，表示第 i 个点在二维平面上的坐标。多个点可能会有 相同 的坐标。
 *
 * 同时给你一个数组 queries ，其中 queries[j] = [xj, yj, rj] ，表示一个圆心在 (xj, yj) 且半径为 rj 的圆。
 *
 * 对于每一个查询 queries[j] ，计算在第 j 个圆 内 点的数目。如果一个点在圆的 边界上 ，我们同样认为它在圆 内 。
 *
 * 请你返回一个数组 answer ，其中 answer[j]是第 j 个查询的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/queries-on-number-of-points-inside-a-circle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 *
 * @author 陆清云 luqy@xiaopeng.com
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class QueriesOnNumberOfPointsInsideACircle_1828 {



    class Point {
        public int x;
        public int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class Circle {
        public int x;
        public int y;
        public int r;
        public Circle(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }


    public int[] countPoints(int[][] points, int[][] queries) {
        int[] ans = new int[queries.length];
        Point[] pointsArr = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            Point p = new Point(points[i][0], points[i][1]);
            pointsArr[i] = p;
        }

        Circle[] circleArr = new Circle[queries.length];
        for (int i = 0; i < queries.length; i++) {
            Circle circle = new Circle(queries[i][0], queries[i][1], queries[i][2]);
            circleArr[i] = circle;
        }


        for (int i = 0; i < circleArr.length; i++) {
            Circle circle = circleArr[i];
            int count = 0;
            for (int j = 0; j < points.length; j++) {
                Point point = pointsArr[j];
                int xSquare = (point.x - circle.x)*(point.x - circle.x);
                int ySquare = (point.y - circle.y)*(point.y - circle.y);
                double sqrt = Math.sqrt(xSquare + ySquare);
                if (sqrt <= circle.r) {
                    count++;
                }

            }
            ans[i] = count;
        }


        return ans;
    }

    public static void main(String[] args) {
        int[][] points = {{1,3},{3,3},{5,3},{2,2}};
        int[][] queries = {{2,3,1},{4,3,1},{1,1,2}};

        QueriesOnNumberOfPointsInsideACircle_1828 circle_1828 = new QueriesOnNumberOfPointsInsideACircle_1828();
        int[] ints = circle_1828.countPoints(points, queries);
        ArrUtils.printArr(ints);

        System.out.println(Math.sqrt(4));

    }
}
