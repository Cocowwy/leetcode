package top100;

/**
 * T647 回文子串
 * https://leetcode-cn.com/problems/palindromic-substrings/
 *
 * 思路1：
 * 暴力
 *
 * @author cocowwy.cn
 * @create 2022-03-03-9:45
 */
public class PalindromicSubstrings {
    static class Solution {
        public int countSubstrings(String s) {
            int sum = 0;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < s.length() - i + 1; j++) {
                    if (judge(s.substring(j, j + i))) {
                        sum++;
                    }
                }
            }
            return sum;
        }

        private Boolean judge(String s) {
            for (int i = 0; i < s.length() / 2; i++) {
                if (!String.valueOf(s.charAt(i)).equals(String.valueOf(s.charAt(s.length() - i - 1)))) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.countSubstrings("abc");
    }
}
