package top100;

/**
 * 16 最接近的三数之和
 * https://leetcode-cn.com/problems/3sum-closest/
 *
 * 思路1：
 * 暴力 不过肯定超时
 *
 * 思路2:
 * -1,2,1,-4 排序  -4,-1,1,2
 * 类似三数之和的解法，只是找的是最接近目标值的结果，
 * 通过三指针的方法进行：
 * 比如 -4+-1+2的时候，如果小于目标值，则中间的-1向右移动变成1 反之
 *
 * @author cocowwy.cn
 * @create 2022-03-03-10:01
 */
public class Sum3Closest {
    static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            sort(nums);
            int near = nums[0] + nums[1] + nums[2];
            if (nums.length == 3) return near;

            for (int left = 0; left < nums.length - 2; left++) {
                int middle = left + 1;
                int right = nums.length - 1;

                while (middle < right) {
                    int sum = nums[left] + nums[middle] + nums[right];
                    if (Math.abs(target - near) > Math.abs(target - sum)) {
                        near = sum;
                    }
                    // 这里还可以优化剪枝
                    if (sum < target) middle++;
                    if (sum > target) right--;
                    if (sum == target) return near;
                }
            }
            return near;
        }

        private void sort(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] > nums[j]) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
    }
}
