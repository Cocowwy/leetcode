package top100;

import java.util.ArrayList;
import java.util.List;

/**
 * T39 组合总和
 * https://leetcode-cn.com/problems/combination-sum/
 *
 * 思路1：
 * https://leetcode-cn.com/problems/combination-sum/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2/
 * 难点1： 回溯实现
 * 难点2： 重复解 [[2,2,3],[2,3,2],[3,2,2],[7]]  dfs其子层的时候，需要舍弃掉其当前层之前的所有的数，这种题型都得先排序
 *
 * @author cocowwy.cn
 * @create 2022-03-03-9:55
 */
public class CombinationSum {
    static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> rts = new ArrayList<>();
            sort(candidates);

            dfs(rts, 0, candidates, target, new ArrayList<>());
            return rts;
        }

        private void dfs(List<List<Integer>> rts, int start, int[] candidates, int currentTarget, List<Integer> rt) {
            if (currentTarget == 0) {
                rts.add(new ArrayList<>(rt));
                return;
            }

            if (currentTarget < 0) {
                return;
            }

            for (int i = start; i < candidates.length; i++) {
                if (candidates[i] <= currentTarget) {
                    List<Integer> temp = new ArrayList<>(rt);
                    temp.add(candidates[i]);
                    dfs(rts, i, candidates, currentTarget - candidates[i], temp);
                } else {
                    break;
                }
            }
        }

        private void sort(int[] candidates) {
            for (int i = 0; i < candidates.length; i++) {
                for (int j = i + 1; j < candidates.length; j++) {
                    if (candidates[i] > candidates[j]) {
                        int temp = candidates[i];
                        candidates[i] = candidates[j];
                        candidates[j] = temp;
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        Solution c = new Solution();
        c.combinationSum(new int[]{2, 7, 6, 3}, 7);

    }
}
