package dfs.tree;

/**
 * T98.验证二叉搜索树
 *
 * 思路：
 * 左<根<右
 * 跟中序遍历的一样
 * 那么就拿出中序遍历的代码
 * 以前往list放当前节点的操作改成判断前一个节点的值的大小就行
 *
 * @author cocowwy.cn
 * @create 2022-02-02-17:18
 */
public class validateBinarySearchTree {

    class Solution {
        Long pre = Long.MIN_VALUE;

        public boolean isValidBST(TreeNode root) {
            return dfs(root);
        }

        private Boolean dfs(TreeNode root) {
            if (root == null) {
                return true;
            }

            // 如果中途为false 则提前返回  左
            if (!dfs(root.left)) {
                return false;
            }

            // 与上一个节点判断 如果满足条件则替换  当前节点
            if (pre < root.val) {
                pre = (long) root.val;
            } else {
                return false;
            }

            // 右
            return dfs(root.right);
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