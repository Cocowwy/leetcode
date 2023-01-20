package top100;

import common.ListNode;

import static top100.RemoveNthNodeFromEndOfList.Solution.removeNthFromEnd;

/**
 * T19. 删除链表的倒数第 N 个结点
 *
 * @author <a href="https://github.com/Cocowwy">Cocowwy</a>
 * @href <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/?favorite=2cktkvj"></a>
 * @since 2023/1/20
 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode t1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
//        ListNode t1 = new ListNode(1, null);
//        ListNode t1 = new ListNode(1, new ListNode(2, null));
        ListNode.print(removeNthFromEnd(t1, 4));
    }

    static class Solution {

        public static ListNode removeNthFromEnd(ListNode head, int n) {

            if (n == 1 && head.next == null) {
                return null;
            }

            ListNode holdHead = head;

            int len = 1;
            while (head.next != null) {
                head = head.next;
                len++;
            }

            ListNode rt = holdHead;

            // 删除倒数第n个，就是正数第 len-n+1个
            int cir = len - n + 1;
            while (true) {
                // 特殊情况，直接删除的是第一个的情况
                if (cir == 1) {
                    rt = holdHead.next;
                    break;
                }
                cir--;
                if (cir == 1) {
                    holdHead.next = holdHead.next.next;
                    break;
                } else {
                    holdHead = holdHead.next;
                }
            }

            return rt;
        }
    }
}
