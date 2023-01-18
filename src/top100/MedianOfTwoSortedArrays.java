package top100;

import java.util.LinkedList;

/**
 * T4 寻找两个正序数组的中位数
 *
 * 方法1： 合并 再次去中值
 *
 *
 * @author <a href="https://github.com/Cocowwy">Cocowwy</a>
 * @href <a href="https://leetcode.cn/problems/median-of-two-sorted-arrays/">寻找两个正序数组的中位数</a>
 * @since 2023/1/17
 */
public class MedianOfTwoSortedArrays {

    static class Solution1 {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            LinkedList<Integer> lists = new LinkedList<>();

            for (int i : nums2) {
                lists.add(i);
            }

            for (int i : nums1) {
                lists.add(i);
            }

            lists.sort(Integer::compare);

            if (lists.size() % 2 == 0) {
                return (lists.get((lists.size() - 1) / 2) + lists.get(((lists.size() - 1) / 2) + 1)) / 2d;
            } else {
                return lists.get((lists.size() - 1 + 1) / 2);
            }
        }
    }

    static class Solution2 {
        public static void main(String[] args) {
            System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        }

        public static double findMedianSortedArrays(int[] nums1, int[] nums2) {



            return 1d;
        }
    }

}
