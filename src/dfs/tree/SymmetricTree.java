package dfs.tree;

/**
 * T101 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 *
 * 思路：
 * 递归 当前左树的左 和 当前右树的右比  当前左树的右 和 当前右树的左比
 *
 *
 * @author cocowwy.cn
 * @create 2022-02-02-19:06
 */
public class SymmetricTree {
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return dfs(root.left,root.right);
        }

        public boolean dfs(TreeNode l,TreeNode r){
            if(l==null&&r==null){
                return true;
            }

            if(l==null||r==null){
                return false;
            }

            if(l.val != r.val){
                return false;
            }
            return dfs(l.left,r.right)&&dfs(l.right,r.left);
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
