package top100;

/**
 * T53 最大子数组和
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * 思路1：
 * 滑动窗口 长度从1到length  超时
 *
 * 思路2：
 * 遍历每个节点，统计该节点一直累加到最后的节点的时候的最大值  超时
 *
 * 思路3：
 * 动态规划
 * 状态转移方程  dp[i] = dp[i-1] + nums[i] 即当前的最大值等于前面的最大值加上当前节点的值                                                                        、
 *
 *
 * @author cocowwy.cn
 * @create 2022-03-03-10:46
 */
public class MaximumSubarray {
    class Solution1 {
        public int maxSubArray(int[] nums) {
            int max = nums[0];

            for (int win = 1; win <= nums.length; win++) {
                for (int i = 0; i < nums.length - win + 1; i++) {
                    max = Math.max(max, caclSum(i, win + i - 1, nums));
                }
            }
            return max;
        }

        public int caclSum(int l, int f, int[] nums) {
            int sum = 0;
            for (int k = l; k <= f; k++) {
                sum += nums[k];
            }
            return sum;
        }

    }

    class Solution2 {
        public int maxSubArray(int[] nums) {
            int max = nums[0];

            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    max = Math.max(max, caclSum(i, j, nums));
                }
            }
            return max;
        }

        public int caclSum(int l, int f, int[] nums) {
            int sum = 0;
            for (int k = l; k <= f; k++) {
                sum += nums[k];
            }
            return sum;
        }
    }

    /**
     * dp[i] = dp[i-1] + nums[i]
     */
    static class Solution3 {
        public static int maxSubArray(int[] nums) {
            int max = nums[0];
            int pre = 0;

            for (int item : nums) {
                // 当前每个点的最大值
                pre = Math.max(item, pre + item);
                // 记录最大值
                max = Math.max(max, pre);
            }

            return max;
        }

        public static void main(String[] args) {
            maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        }
    }
}
