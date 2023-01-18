package top100;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.List;

/**
 * T5 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * 思路1：
 * 例举所有字符串的情况 暴力破解  列举出所有的字符串再进行判断  可行  但是超时了
 *
 * 思路2：
 * 定义一个滑动窗口，从头滑动到尾部，窗口长度从2增长到length 再judge当前这段字符串是否是回文  虽然也是暴力 但是必思路1快 还是超时了,优化了一些细节后就没超时了 淦！
 *
 * @author cocowwy.cn
 * @href <a href="https://leetcode-cn.com/problems/longest-palindromic-substring/"></a>
 * @create 2022-02-02-15:24
 */
public class LongestPalindromicSubstring {
    class Solution1 {
        public String longestPalindrome(String s) {
            List<String> strs = new ArrayList<>();
            String maxStr = String.valueOf(s.charAt(0));
            // 截取每个长度的字符串
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j <= s.length() - i; j++) {
                    strs.add(s.substring(j, j + i));
                }
            }

            for (String str : strs) {
                maxStr = judge(str) ? (str.length() >= maxStr.length() ? str : maxStr) : maxStr;
            }
            return maxStr;
        }

        public Boolean judge(String str) {
            for (int i = 0; i < str.length() / 2; i++) {
                if (!String.valueOf(str.charAt(i)).equals(String.valueOf(str.charAt(str.length() - 1 - i)))) {
                    return false;
                }
            }
            return true;
        }
    }

    static class Solution2 {
        public String longestPalindrome(String s) {
            if (s.length() == 2 && String.valueOf(s.charAt(0)).equals(String.valueOf(s.charAt(1)))) {
                return s;
            }
            // 滑动窗口逐步递增
            String maxStr = String.valueOf(s.charAt(0));
            for (int width = 2; width <= s.length(); width++) {
//      窗口长度递减      for (int width = s.length(); width >= 2; width--) {
                for (int start = 0; start <= s.length() - width; start++) {
                    String sub = s.substring(start, start + width);
                    if (judge(sub)) {
                        maxStr = sub.length() >= maxStr.length() ? sub : maxStr;
                        break;
                    }

                }
            }
            return maxStr;
        }


        public Boolean judge(String str) {
            for (int i = 0; i < str.length() / 2; i++) {
                if (!Character.valueOf(str.charAt(i)).equals(Character.valueOf(str.charAt(str.length() - 1 - i)))) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * 二刷 由窗口长度由长向短开始滑动
     */
    static class Solution3 {

        public static void main(String[] args) {
            longestPalindrome("ccc");
        }

        public static String longestPalindrome(String s) {
            if (s.length() == 2 && s.charAt(1) == s.charAt(0)) {
                return s;
            }

            // 定义滑动窗口
            for (int i = s.length(); i >= 2; i--) {
                // 从头开始滑动窗口
                for (int j = 0; j + i <= s.length(); j++) {
                    String substring = s.substring(j, j + i);
                    if (judgePalindromic(substring)) return substring;
                }
            }
            return String.valueOf(s.charAt(0));
        }

        /**
         * 判断子串是否回文
         * @param s
         * @return
         */
        private static Boolean judgePalindromic(String s) {
            for (int i = 0; i < s.length() / 2; i++) {
                if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                    return false;
                }
            }
            return true;
        }
    }

}