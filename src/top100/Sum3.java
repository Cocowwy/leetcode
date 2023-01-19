package top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * T15 三数之和
 * https://leetcode-cn.com/problems/3sum/
 *
 * 思路1：
 * 两两配对，a+b=-c   Solution1 结果含有重复的数据，并不可取 （可以考虑对每个数组排序后toString去重，不过这样过于复杂了，并不可取）
 *
 * 思路2：
 * 1.三个指针 left，middle，right，分别从最左边，left+1，最右边开始遍历
 * 2.按照逻辑，如果 left+middle+right=0 那么就是一组解  如果>0 则还需要更小 则right左移 反之middle 右移
 * 3.找到符合的解之后，middle和right找到下一个与当前不相同的数字，防止重复解
 * 2.先排序，当左指针 > 0 的时候  后面就不需要遍历了，因为后面是不存在 c = -a-b的了
 *
 * @author Cocowwy
 * @href <a href=https://leetcode.cn/problems/3sum/?favorite=2cktkvj></a>
 * @create 2022-02-02-13:49
 */
public class Sum3 {
    class Solution1 {
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

    static class Solution2 {
//        public static void main(String[] args) {
//            Solution2 solution2 = new Solution2();
//            int[] nums = new int[0];
//            solution2.threeSum();
//        }

        public List<List<Integer>> threeSum(int[] nums) {
            //  冒泡排序
            sort(nums);
            List<List<Integer>> rts = new ArrayList<>();

            for (int c = 0; c < nums.length; c++) {
                int left = nums[c];
                if (left > 0) break;
                // left 重复的话就后推
                if (c >= 1 && nums[c] == nums[c - 1]) continue;

                int indexMiddle = c + 1;
                int indexRight = nums.length - 1;
                while (indexMiddle < indexRight) {
                    int sum = left + nums[indexMiddle] + nums[indexRight];
                    if (sum == 0) {
                        rts.add(Arrays.asList(left, nums[indexMiddle], nums[indexRight]));
                        // middle 和 right  找到下一个不同的
                        while (indexMiddle < indexRight && nums[indexMiddle] == nums[indexMiddle + 1]) indexMiddle++;
                        while (indexMiddle < indexRight && nums[indexRight] == nums[indexRight - 1]) indexRight--;
                        // 上面只找到了最后一个，此时还应该往后调整一个
                        indexMiddle++;
                        indexRight--;
                        continue;
                    }
                    if (sum > 0) {
                        indexRight--;
                    }
                    if (sum < 0) {
                        indexMiddle++;
                    }
                }
            }
            return rts;
        }

        private void sort(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] > nums[j]) {
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                    }
                }
            }
        }
    }

    /**
     * 二刷
     */
    static class Solution3 {

        public static void main(String[] args) {
            System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
//            System.out.println(threeSum(new int[]{0, 0, 0, 0}));
        }

        public static List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();

            // 排序，便于去重
            Arrays.sort(nums);

            // 从三数中摘除其中一个，使其余两个加起来等于它
            // 终止条件 左指针大于等于0
            for (int i = 0; nums[i] <= 0 && i < nums.length - 2; i++) {

                // 头指针重复顺移***  这样需要和i-1对比，因为如果直接对比i+1 那么会直接指针后移，导致缺解
                if (i >= 1 && nums[i - 1] == nums[i]) {
                    continue;
                }

                // 从这个数后面开始遍历，双指针从头和尾开始遍历
                int sum2 = -nums[i];

                int left = i + 1;
                int right = nums.length - 1;

                // 后两指针
                while (left < right) {
                    // 得到解。如果偏小，移动左指针，偏大，移动右指针
                    if (nums[left] + nums[right] == sum2) {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        int rightTemp = nums[right--];
                        int leftTemp = nums[left++];
                        while (nums[right] == rightTemp && left < right) {
                            right--;
                        }
                        while (nums[left] == leftTemp && left < right) {
                            left++;
                        }
                        continue;
                    }
                    if (nums[left] + nums[right] - sum2 > 0) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
            return res;
        }
    }
}
