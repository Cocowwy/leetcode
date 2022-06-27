package top100;

import common.TreeNode;

/**
 * T543  二叉树的直径
 * https://leetcode.cn/problems/diameter-of-binary-tree/
 *
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]
 *
 * @author cocowwy.cn
 * @create 2022-05-05-11:45
 */
public class DiameterOfBinaryTree {
    class Solution {
        int length = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            deep(root);
            return length;
        }

        public int deep(TreeNode node) {
            if (node == null) {
                return 0;
            }

            int left = deep(node.left);
            int right = deep(node.right);
            length = Math.max(left + right, length);
            // 当前节点的最大深度
            return Math.max(left, right) + 1;
        }
    }
}
