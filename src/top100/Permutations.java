package top100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * T46 全排列
 * https://leetcode-cn.com/problems/permutations/
 *
 * 思路1：
 * https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
 *
 * @author cocowwy.cn
 * @create 2022-03-03-9:57
 */
public class Permutations {
    static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            LinkedList<List<Integer>> rts = new LinkedList<>();
            LinkedList<Integer> rt = new LinkedList<>();
            dfs(nums, rts, rt);
            return rts;
        }

        private void dfs(int[] nums, LinkedList<List<Integer>> rts, LinkedList<Integer> rt) {
            if (rt.size() == nums.length) {
                rts.add(new ArrayList<>(rt)); // rts.add(rt = [1,2,3])
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (rt.contains(nums[i])) continue;

                rt.add(nums[i]);
                dfs(nums, rts, rt);
                // rt [1,2] -- > 到下一次循环就是dfs rt[1,3]
                // 所以removeLast是回溯向上的
                rt.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        int[] t = new int[]{1, 2, 3};
        Solution s = new Solution();
        List<List<Integer>> permute = s.permute(t);

        System.out.println("");

    }
}
