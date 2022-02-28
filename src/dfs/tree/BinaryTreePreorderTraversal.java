package dfs.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * T144 二叉树的前序遍历
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 *
 * 思路：
 * 递归   前序遍历  根->左->右
 *
 * @author cocowwy.cn
 * @create 2022-02-02-14:58
 */
public class BinaryTreePreorderTraversal {
    class Solution {
        private final List<Integer> rs = new ArrayList();

        public List<Integer> preorderTraversal(TreeNode root) {
            dfs(root);
            return rs;
        }

        private void dfs(TreeNode root) {
            // 遍历终止条件
            if (root == null) {
                return;
            }
            // 假设当前到了某一个节点，先打印当前的根，在递归左，右
            rs.add(root.val);
            dfs(root.left);
            dfs(root.right);
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
