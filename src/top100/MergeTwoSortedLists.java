package top100;

import java.util.ArrayList;
import java.util.List;

/**
 * T21 合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * 思路1：
 * 递归链表
 *
 *
 * 思路2：
 * 遍历两个链表，合并后排序 再创建一个新的链表
 *
 * @author cocowwy.cn
 * @create 2022-03-03-14:53
 */
public class MergeTwoSortedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution1 {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            // 终止条件
            if (list1 == null) {
                return list2;
            }

            if (list2 == null) {
                return list1;
            }

            if (list1.val < list2.val) {
                list1 = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2 = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }
    }


    class Solution2 {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode head = new ListNode();
            ListNode rt = new ListNode();
            head = rt;

            List<Integer> lists = new ArrayList<>();
            while (list1 != null) {
                lists.add(list1.val);
                list1 = list1.next;
            }
            while (list2 != null) {
                lists.add(list2.val);
                list2 = list2.next;
            }
            lists.sort(Integer::compareTo);

            for (Integer i : lists) {
                rt.next = new ListNode(i);
                rt = rt.next;
            }

            return head.next;
        }
    }

    public static void main(String[] args) {
    }

    /**
     * 二刷
     */
    class Solution3 {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            List<Integer> lists = new ArrayList<>();
            while (list1 != null) {
                lists.add(list1.val);
                list1 = list1.next;
            }

            while (list2 != null) {
                lists.add(list2.val);
                list2 = list2.next;
            }
            lists.sort(Integer::compare);

            ListNode res = new ListNode();
            ListNode hold = res;

            for (Integer val : lists) {
                res.next = new ListNode(val);
                res = res.next;
            }

            return hold.next;
        }
    }

}
