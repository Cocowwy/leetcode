package common;

/**
 * @author Cocowwy
 * @create 2022-05-05-11:27
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void print(ListNode node) {
        while (node.next != null) {
            System.out.print(node.val + "--->");
            node = node.next;
        }
    }
}