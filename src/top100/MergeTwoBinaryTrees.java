package top100;

/**
 * T617 合并二叉树
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 *
 * 思路1：
 * 同时遍历两颗树，用额外的空间 rts 来装遍历的结果集
 * 如果同位置其中一个节点为空，则直接将另外一个节点桥接过来
 *
 * @author cocowwy.cn
 * @create 2022-03-03-11:41
 */
public class MergeTwoBinaryTrees {
    class Solution1 {
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if(root1 == null){
                return root2;
            }
            if(root2 == null){
                return root1;
            }
            // 新增节点，并且给当前节点设置值
            TreeNode rts = new TreeNode(root1.val + root2.val);
            // 开始递归
            rts.left = mergeTrees(root1.left, root2.left);
            rts.right = mergeTrees(root1.right, root2.right);
            return rts;
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
