package dfs.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * T257 二叉树的所有路径
 * https://leetcode-cn.com/problems/binary-tree-paths/
 *
 * 思路：
 * 递归，把左右节点各种情况逻辑判断一遍，再继续递归
 * 如果当前不为空，则拼接字符串后接着递归
 * 同时保证从头至尾的逻辑一致，对开头部分进行特殊处理
 *
 *
 * @author cocowwy.cn
 * @create 2022-02-02-16:24
 */
public class BinaryTreePaths {

    class Solution {
        private static final String TO = "->";
        List<String> lists = new ArrayList();

        public List<String> binaryTreePaths(TreeNode root) {
            dfs("", root);
            return lists;
        }

        private void dfs(String path, TreeNode root) {
            if (root.left == null && root.right == null) {
                // 终止条件 去除开头的->
                lists.add((path + TO + root.val).substring(2));
                return;
            }

            if (root.left != null && root.right == null) {
                dfs(path + TO + root.val, root.left);
            }

            if (root.right != null && root.left == null) {
                dfs(path + TO + root.val, root.right);
            }

            if (root.right != null && root.left != null) {
                // 都不为空的时候就左右两边都递归
                dfs(path + TO + root.val, root.left);
                dfs(path + TO + root.val, root.right);
            }
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
