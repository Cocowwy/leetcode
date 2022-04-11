package top100;

import java.util.Arrays;
import java.util.Comparator;

/**
 * T56 合并区间
 * https://leetcode-cn.com/problems/merge-intervals/
 *
 * 思路1：
 * 取出最大的值，并初始化一个长度为 1~max的数组path，包含则设置path的索引位置为1 不包含则为0，最后统计
 *
 * 思路2：
 * 对 头 进行培训
 * 如果第一个区间的尾大于第二个区间的头，则合并，形成一个结果  \
 *                                                      再将该结果当做一个新的区间，依次和后面进行比较，下面的代码中，使用
 * 如果第一个区间的头小于第二个区间的头，则添加结果          /
 *
 * @author cocowwy.cn
 * @create 2022-04-04-17:36
 */
public class MergeIntervals {
    static class Solution {
        public int[][] merge(int[][] intervals) {
            // 排序
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            // 初始化返回的结果集
            int[][] rts = new int[intervals.length][2];

            // 用来标记 rts 的实际结果行的位置，[a,b],[c,d],[0,0] 最后截取的时候需要根据index的值 截取掉[0,0]
            int index = -1;

            for (int[] interval : intervals) {
                // -1 用来标记第一个数据 进行特殊处理
                if (index == -1) {
                    index++;
                    rts[index][0] = interval[0];
                    rts[index][1] = interval[1];
                    continue;
                }

                // 需要比较的区间 [也就是rts的最后一个区间]
                int start = rts[index][0];
                int end = rts[index][1];

                // 当前的区间
                int curStart = interval[0];
                int curEnd = interval[1];

                // true 合并 || false 新增区间，并且index++（用来在下一次循环时，指向比较区间）
                if (end >= curStart) {
                    rts[index][0] = start;
                    rts[index][1] = Math.max(end, curEnd);
                } else {
                    index++;
                    rts[index][0] = curStart;
                    rts[index][1] = curEnd;
                }
            }
            // 根据index裁剪
            return Arrays.copyOf(rts, index + 1);
        }
    }

    public static void main(String[] args) {
//        int[][] test = new int[3][2];
//        test[0][0] = 1;
//        test[0][1] = 4;
//        test[1][0] = 0;
//        test[1][1] = 2;
//        test[2][0] = 3;
//        test[2][1] = 5;

        int[][] test = new int[4][2];
        test[0][0] = 1;
        test[0][1] = 3;
        test[1][0] = 2;
        test[1][1] = 6;
        test[2][0] = 8;
        test[2][1] = 10;
        test[3][0] = 15;
        test[3][1] = 18;
        Solution a = new Solution();
        a.merge(test);
    }
}
