package top100;

import java.util.Stack;

/**
 * T20. 有效的括号
 *
 * @author <a href="https://github.com/Cocowwy">Cocowwy</a>
 * @href <a href="https://leetcode.cn/problems/valid-parentheses/"></a>
 * @since 2023/1/20
 */
public class ValidParentheses {

    /**
     * 替换成""
     */
    class Solution1 {
        public boolean isValid(String s) {

            while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
                s = s.replace("()", "");
                s = s.replace("[]", "");
                s = s.replace("{}", "");
            }

            return s.equals("");
        }
    }

    /**
     * stack
     * 对称性
     * 按顺序将左括号压栈，如是右括号，则出栈并对比这个右括号，如果是对等的则继续，最后看栈是否是空的
     */
    class Solution2 {
        public boolean isValid(String s) {

            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                Character c = s.charAt(i);
                if (c.equals('(') || c.equals('[') || c.equals('{')) {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    Character pop = stack.pop();
                    if (pop.equals('(') && c.equals(')')) {
                        continue;
                    }
                    if (pop.equals('{') && c.equals('}')) {
                        continue;
                    }
                    if (pop.equals('[') && c.equals(']')) {
                        continue;
                    }
                    return false;
                }
            }

            return stack.isEmpty();
        }
    }

}
