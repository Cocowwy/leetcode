package top100;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * T347 前 K 个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 *
 * 思路1：
 * lambda 表达式
 *
 * @author cocowwy.cn
 * @create 2022-03-03-14:06
 */
public class TopKFrequentElements {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            return Arrays.stream(nums)
                    .boxed()
                    .collect(Collectors.toMap(e -> e, e -> 1, Integer::sum))
                    .entrySet()
                    .stream()
                    .sorted((m1, m2) -> m2.getValue() - m1.getValue())
                    .limit(k)
                    .mapToInt(Map.Entry::getKey)
                    .toArray();
        }
    }
}
