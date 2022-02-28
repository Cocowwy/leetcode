package top100;


/**
 *  T2 两数相加
 *  https://leetcode-cn.com/problems/add-two-numbers/
 *
 *  思路1：
 *  遍历两个链表，转成字符串后再转Integer
 *  之后得到结果后转成链表
 *  【当Integer过长的时候就有问题，得换】  不过给的算法好像我理解反了  代码先留着 暂时不删 = =
 *
 *  思路2：
 *  还是上面的思路  不过是把两个str进行相加操作（而不是整个转成Integer来加）不过这应该不是最好的方法，就不这样做了
 *
 *  思路3：
 *   2->4->3
 *   5->6->4
 *   342+465=807
 *   返回： 7->0->8
 *   while循环同时遍历两个链表，得到和，然后拼一个新的链表出来，同时保存进位的信息
 *   如果一长一短  则短的补成0节点  当然结束条件是两个链表向后移动后均为null的时候（需要考虑这个时候如果还需要进位，则补1）
 *
 *
 * @author cocowwy.cn
 * @create 2022-02-02-14:16
 */
public class AddTwoNumbers {

    class Solution1 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Integer sum = Integer.valueOf(deep(l1)) + Integer.valueOf(deep(l2));
            String strNode = sum.toString();
            ListNode rst = new ListNode();
            for (int i = 0; i < strNode.length(); i++) {
                rst = new ListNode((int) strNode.charAt(i));
            }
            return rst;
        }

        public String deep(ListNode l) {
            if (l == null) {
                return "";
            }
            return l.val + deep(l.next);
        }
    }

    /**
     *   2->4->3
     *   5->6->4
     *   342+465=807
     *   返回： 7->0->8
     */
    class Solution2 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode rtNode = new ListNode();
            // 头指针 指向rtNode，防止丢失
            ListNode point = rtNode;
            // 判断是否需要进位
            Boolean needUp = false;
            while (true) {
                // 为空则补0
                l1 = l1 == null ? new ListNode(0) : l1;
                l2 = l2 == null ? new ListNode(0) : l2;

                // 计算
                int temp = l1.val + l2.val;
                if (needUp) temp++;
                int res = temp % 10;
                // 进位标识每次循环都会赋值，所以不需要手动设置
                needUp = temp >= 10;
                // 返回的链表设置下一个节点的值
                rtNode.next = new ListNode(res);
                // 结果链表，l1，l2 均向后移动
                rtNode = rtNode.next;
                l1 = l1.next;
                l2 = l2.next;

                // 循环跳出条件
                if (l1 == null && l2 == null) {
                    if (!needUp) break;
                    // 跳出循环 但是还需要进位的情况
                    rtNode.next = new ListNode(1);
                    break;
                }
            }
            return point.next;
        }
    }


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
}
