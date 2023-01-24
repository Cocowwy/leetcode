package top100;

import java.util.Stack;

/**
 * T32. 最长有效括号
 *
 * @author <a href="https://github.com/Cocowwy">Cocowwy</a>
 * @href <a href="https://leetcode.cn/problems/longest-valid-parentheses/?favorite=2cktkvj">Cocowwy</a>
 * @since 2023/1/24
 */
public class LongestValidParentheses {
    /**
     * 算法没问题，但是超时了
     */
    class Solution {
        public int longestValidParentheses(String s) {
            // 滑动窗口
            int win = s.length();
            // ((())) win = 6
            while (win >= 1) {
                for (int i = 0; i + win - 1 < s.length(); i++) {
                    boolean resItem = validSubStr(s, i, i + win - 1);
                    System.gc();;
                    if (resItem) {
                        return win;
                    }
                }
                win--;
            }
            return 0;
        }

        /**
         * 判断字串是否是有序括号
         */
        private boolean validSubStr(String s, int start, int end) {
            String str = s.substring(start, end + 1);

            if (s.charAt(start) != '(' || s.charAt(end) != ')') {
                return false;
            }

            // ((())) ()()(())  用栈
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < str.length(); i++) {
                Character c = str.charAt(i);
                if (c.equals('(')) {
                    stack.push(c);
                } else if (stack.size() > 0) {
                    Character pop = stack.pop();
                    if (pop.equals(')')) {
                        return false;
                    }
                } else {
                    return false;
                }
            }

            return stack.size() == 0;
        }
    }
}
