package top100;

import common.ListNode;

import java.util.ArrayList;

/**
 * T234 回文链表
 * https://leetcode.cn/problems/palindrome-linked-list/
 *
 * 思路 1：
 * 转到集合中 判断回文
 *
 * 思路2：
 *
 * @author Cocowwy
 * @create 2022-05-05-11:25
 */
public class PalindromeLinkedList {
    class Solution {
        public boolean isPalindrome(ListNode head) {
            ArrayList<Integer> values = new ArrayList<>();
            while (head != null) {
                values.add(head.val);
                head = head.next;
            }
            boolean res = true;
            if (values.size() == 1) return true;
            if (values.size() == 2) {
                return values.get(0).equals(values.get(1));
            }

            for (int i = 0; i < values.size() / 2; i++) {
                if (!values.get(i).equals(values.get(values.size() - i - 1))) return false;
            }
            return res;
        }
    }
}
