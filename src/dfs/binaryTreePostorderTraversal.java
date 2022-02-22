package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * T146 二叉树的后序遍历
 *
 * 思路：
 * 先找到终止条件
 * 后续的顺序是  先左 后右 最后中
 *
 * @author cocowwy.cn
 * @create 2022-02-02-16:16
 */
public class binaryTreePostorderTraversal {

    class Solution {
        List<Integer> rts = new ArrayList();

        public List<Integer> postorderTraversal(TreeNode root) {
            dfs(root);
            return rts;
        }

        public void dfs(TreeNode root){
            if(root==null){
                return;
            }

            dfs(root.left);
            dfs(root.right);
            rts.add(root.val);
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
