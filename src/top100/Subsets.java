package top100;

import java.util.ArrayList;
import java.util.List;

/**
 * T76 子集
 * https://leetcode.cn/problems/subsets/
 *
 * 思路：
 * 如 [1,2,3]
 * 如果一开始的 空集 []
 * 接着取 1  则结果 [] [1]
 * 接着取 2  则结果 [] [1] [2] [1,2]
 * 接着取 3  则结果 [] [1] [2] [1,2] [3] [1,3] [2,3] [1,2,3]
 * 每一次都将这个数加到之前的数组里面取
 *
 * @author Cocowwy
 * @create 2022-05-05-20:54
 */
public class Subsets {
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            // 结果
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> rt = new ArrayList<>();
            result.add(rt);
            for (int num : nums) {
                // 临时保留这个数 与集合里存在的数组进行配偶
                List<List<Integer>> temp = new ArrayList<>();
                result.forEach(before -> {
                    List<Integer> current = new ArrayList<>(before);
                    current.add(num);
                    temp.add(current);
                });
                result.addAll(temp);
            }
            return result;
        }
    }
}
