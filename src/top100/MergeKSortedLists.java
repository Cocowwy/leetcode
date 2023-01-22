package top100;

import common.ListNode;

/**
 * T23. 合并K个升序链表
 *
 * @author <a href="https://github.com/Cocowwy">Cocowwy</a>
 * @href <a href="https://leetcode.cn/problems/merge-k-sorted-lists/?favorite=2cktkvj"></a>
 * @since 2023/1/21
 */
public class MergeKSortedLists {
    class Solution {
        /**
         * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
         * 输出：[1,1,2,3,4,4,5,6]
         * 解释：链表数组如下：
         * [
         *   1->4->5,
         *   1->3->4,
         *   2->6
         * ]
         * 将它们合并到一个有序链表中得到。
         * 1->1->2->3->4->4->5->6
         *
         * 思路，定义k个指针从头指到尾
         */
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) {
                return null;
            }

            ListNode merge = lists[0];

            for (int i = 1; i < lists.length; i++) {
                merge = mergeTwoList(lists[i], merge);
            }

            return merge;
        }
    }

    /**
     *  1---2---3
     *  2---3
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoList(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoList(l1, l2.next);
            return l2;
        }

    }
}
