package dfs.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * T94 二叉树的中序遍历
 *
 * 思路：
 * 先判断终止条件
 * 再分布判断每一步做什么
 *
 * @author cocowwy.cn
 * @create 2022-02-02-18:44
 */
public class binaryTreeInorderTraversal {

    class Solution {

        private List<Integer> rts = new ArrayList();

        public List<Integer> inorderTraversal(TreeNode root) {
            dfs(root);
            return rts;
        }

        private void dfs(TreeNode root){
            if(root==null){return;}

            dfs(root.left);
            rts.add(root.val);
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
