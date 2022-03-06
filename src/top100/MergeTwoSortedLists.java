package top100;

/**
 * T21 合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * 思路：
 * 以头结点最小的链表开始遍历
 * 另外一个指针指向另外一个链表
 * 遍历主链表的时候同时看另外一个链表
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


    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode head = new ListNode();
            ListNode master = new ListNode();
            ListNode slave = new ListNode();
            head = master;

            if (list1.val < list2.val) {
                master = list1;
                slave = list2;
            } else {
                master = list2;
                slave = list1;
            }

            while (master != null && slave != null) {
                int nextVal = master.next == null ? Integer.MAX_VALUE : master.next.val;
                if (master.val < slave.val && slave.val < nextVal) {
                    ListNode listNode = new ListNode();
                    listNode.val = slave.val;
                    listNode.next = master.next;
                    master.next = listNode;
                }
            }


            return head;
        }
    }

}
