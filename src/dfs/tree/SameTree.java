package dfs.tree;

/**
 * T100 相同的树
 * https://leetcode-cn.com/problems/same-tree/
 *
 * 思路：
 * dfs  入参是当前的两颗树
 * @author cocowwy.cn
 * @create 2022-02-02-18:08
 */
public class SameTree {
    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            // 终止条件
            if (p == null && q == null) {
                return true;
            }

            if (p == null || q == null) {
                return false;
            }

            if (p.val != q.val) {
                return false;
            }

            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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
