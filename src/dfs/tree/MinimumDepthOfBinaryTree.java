package dfs.tree;


/**
 * T111 二叉树的最小深度
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 *
 *
 * 思路：
 * DFS
 * 空右不空，则往右挖，反之，同时深度+1 当前为空时，则返回
 *
 * @author cocowwy.cn
 * @create 2022-02-02-15:27
 */
// 回溯向上累加
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        // 递归
        if (root == null) return 0;

        if (root.left == null && root.right != null) {
            root = root.right;
            return minDepth(root) + 1;
        } else if (root.right == null && root.left != null) {
            root = root.left;
            return minDepth(root) + 1;
        }

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }


    class TreeNode {
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
