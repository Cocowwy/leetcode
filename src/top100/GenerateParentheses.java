package top100;

import java.util.ArrayList;
import java.util.List;

/**
 * T22 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 *
 * 思路：
 * 括号开头是 ‘(’
 * 长度恒等于 2n
 * 所以是一个 头结点为 '(' 深度 dfs 一个二叉树
 * 因为给的是数组的对数  所以dfs的过程中记录左括号和右括号的使用次数
 * 剪枝 左边的括号一定得大于右边括号的数量 ())) 这里left=5 right=3 说明left>right的时候剪枝
 *
 * @author cocowwy.cn
 * @create 2022-03-03-9:49
 */
public class GenerateParentheses {
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> rts = new ArrayList<>();
            dfs(rts, "", n, n);
            return rts;
        }

        private void dfs(List<String> rts, String str, int left, int right) {
            if (left == 0 && right == 0) {
                rts.add(str);
                return;
            }

            // 剪枝 左边的括号一定得大于右边括号的数量 ())) 这里left=5 right=3 说明left>right的时候剪枝
            if (left > right) {
                return;
            }
            // 新增左括号
            if (left > 0) {
                dfs(rts, str + "(", left - 1, right);
            }
            // 新增右括号
            if (right > 0) {
                dfs(rts, str + ")", left, right - 1);
            }
        }
    }
}
