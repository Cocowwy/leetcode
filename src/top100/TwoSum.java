package top100;

/**
 * T1.两数之和
 *
 * @author <a href="https://github.com/Cocowwy">Cocowwy</a>
 * @link <a href="https://leetcode.cn/problems/two-sum/?favorite=2cktkvj"></a>
 * @since 2023/1/16
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        for (int index = 0; index < nums.length; index++) {
            for (int i = index + 1; i < nums.length; i++) {
                if (nums[index] + nums[i] == target) {
                    return new int[]{index, i};
                }
            }
        }

        return null;
    }
}
