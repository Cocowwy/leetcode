package top100;

import java.util.ArrayList;
import java.util.List;

/**
 * T114  二叉树展开为链表
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 *
 * 思路 1：
 * 因为这个题没有返回值，所以其结果就是取的 root
 * 前序遍历，List保存每个节点  List (ListNode(1))-->(ListNode(2))-->(ListNode(3))
 * 而 List(0) 就是 root 的头，所以再遍历这个list集合即可
 *
 * 思路2： 源：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--26/
 * 在原来链表的方式上修改
 *
 *     1
 *    / \
 *   2   5       1是root   root.right = root.left
 *  / \   \      4是temp   temp.right = root.right
 * 3   4   6
 *
 * 将 1 的左子树插入到右子树的地方
 *
 *         1
 *        /
 *       2
 *      / \
 *     3   4
 *          \
 *           5
 *            \
 *             6
 * 将原来的右子树接到左子树的最右边节点      ---> 这里其实吧  5—6 移动到 2-4 再把 1的左子树挂到 1的右子树去
 *     1
 *      \
 *       2
 *      / \
 *     3   4
 *          \
 *           5
 *            \
 *             6
 *
 * 将 2 的左子树插入到右子树的地方
 *     1
 *      \
 *       2
 *        \
 *         3       4
 *                  \
 *                   5
 *                    \
 *                     6
 *
 *  将原来的右子树接到左子树的最右边节点
 *     1
 *      \
 *       2
 *        \
 *         3
 *          \
 *           4
 *            \
 *             5
 *              \
 *               6
 * @author cocowwy.cn
 * @create 2022-03-03-14:36
 */
public class FlattenBinaryTreeToLinkedList {
    class Solution1 {
        public void flatten(TreeNode root) {
            List<TreeNode> vals = new ArrayList<>();
            // 前序遍历
            dfs(root, vals);

            // 从第二个节点开始 给前面的赋值
            for (int i = 1; i < vals.size(); i++) {
                TreeNode treeNode = vals.get(i - 1);
                treeNode.left = null;
                treeNode.right = vals.get(i);
            }

        }

        private void dfs(TreeNode root, List<TreeNode> vals) {
            if (root == null) return;

            vals.add(root);
            if (root.left != null) dfs(root.left, vals);
            if (root.right != null) dfs(root.right, vals);
        }
    }

    class Solution2 {
        public void flatten(TreeNode root) {
            // 终止条件
            while (root != null) {
                // 判断当前是否有左子树
                if (root.left == null) {
                    // 无则向下推
                    root = root.right;
                } else {
                    // 有则将右子树接到左子树的最右边的节点
                    // 先用temp来找到左子树的最右边的节点
                    TreeNode temp = root.left;
                    while (temp.right != null) {
                        temp = temp.right;
                    }
                    temp.right = root.right;
                    root.right = root.left;
                    root.left = null;
                    root = root.right;
                }

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
