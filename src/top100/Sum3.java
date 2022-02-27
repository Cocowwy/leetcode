package top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * T15 三数之和
 * https://leetcode-cn.com/problems/3sum/
 *
 * 思路：
 * 两两配对，a+b=-c
 *
 * @author Cocowwy
 * @create 2022-02-02-13:49
 */
public class Sum3 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> rts = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (contains(-1 * (nums[i] + nums[j]), nums)) {
                        rts.add(Arrays.asList(nums[i], nums[j], -1 * (nums[i] + nums[j])));
                        i = j;
                        break;
                    }
                }
            }

            return rts;
        }

        private Boolean contains(int c, int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == c) return true;
            }
            return false;
        }
    }
}
