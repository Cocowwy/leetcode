package top100;

import java.util.ArrayList;
import java.util.List;

/**
 * T114  二叉树展开为链表
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 *
 * 思路：
 * 因为这个题没有返回值，所以其结果就是取的root
 * 前序遍历，List保存每个节点  List (ListNode(1))-->(ListNode(2))-->(ListNode(3))
 * 而 List(0) 就是 root 的头，所以再遍历这个list集合即可
 *
 * @author cocowwy.cn
 * @create 2022-03-03-14:36
 */
public class FlattenBinaryTreeToLinkedList {
    class Solution {
        public void flatten(TreeNode root) {
            List<TreeNode> vals = new ArrayList<>();
            // 前序遍历
            dfs(root, vals);

            // 从第二个节点开始 给前面的赋值
            for (int i = 1; i < vals.size(); i++) {
                TreeNode treeNode = vals.get(i - 1);
                treeNode.left = null;
                treeNode.right = vals.get(i);
            }

        }

        private void dfs(TreeNode root, List<TreeNode> vals) {
            if (root == null) return;

            vals.add(root);
            if (root.left != null) dfs(root.left, vals);
            if (root.right != null) dfs(root.right, vals);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
