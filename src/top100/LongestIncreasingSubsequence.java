package top100;

import java.util.Arrays;

/**
 *
 * T300 最长递增子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 *
 * 思路：
 * 动态规划
 * [10, 9, 2, 5, 3, 7, 101, 18]
 * [1 , 1, 1, 1, 1, 1, 1  , 1 ]
 * [x , x, x, x, x, 1, 1  , 1 ]
 * 上面的x记录当前位置的最长递增子序列的最大值
 * 状态转义方程：
 *      dp[i] = Math.max(dp[i], dp[j] + 1)
 *      即当前的坑如果已经比此次比较则不变，不然就取较大的，此时长度在原先的位置上+1
 *
 *
 * @author cocowwy.cn
 * @create 2022-04-04-11:27
 */
public class LongestIncreasingSubsequence {
    static class Solution {
        public static int lengthOfLIS(int[] nums) {
            int res = 1;
            int dp[] = new int[nums.length];
            Arrays.fill(dp, 1);

            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                        res = Math.max(res, dp[i]);
                    }
                }
            }

            return res;

        }

        public static void main(String[] args) {
            int i[] = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
            lengthOfLIS(i);
        }
    }
}
