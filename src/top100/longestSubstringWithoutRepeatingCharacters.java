package top100;

import java.util.HashSet;
import java.util.Set;

/**
 * T3 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * 思路1：
 * 滑动窗口，分别长度为1   不过超出时间限制了
 *
 * 思路2：
 * 使用Set集合 遍历从头到尾的每个节点，在当前节点下，以此往后加入到set集合当中，如果前后长度不变 则说明当前为头的字串长度是最长状态，交换max的值
 *
 * @author cocowwy.cn
 * @create 2022-02-02-10:44
 */
public class longestSubstringWithoutRepeatingCharacters {
    static class Solution1 {
        public static void main(String[] args) {
            System.out.println(lengthOfLongestSubstring("au"));
        }

        public static int lengthOfLongestSubstring(String s) {
            int max = 1;
            // 定义一个窗口的长度
            for (int win = 1; win <= s.length(); win++) {
                // 窗口从头开始向后移
                for (int start = 0; start <= s.length() - win; start++) {
                    String sub = s.substring(start, start + win);
                    Set<Character> sets = new HashSet<>();
                    for (int i = 0; i < sub.length(); i++) {
                        sets.add(sub.charAt(i));
                    }
                    if (sets.size() == sub.length()) {
                        max = Math.max(max, sub.length());
                    }
                }
            }
            return max;
        }
    }


    class Solution2 {
        public int lengthOfLongestSubstring(String s) {
            if(s.length()==0) return 0;
            int max = 1;

            for (int i = 0; i < s.length(); i++) {
                Set<Character> set = new HashSet<>();

                for (int t = i ; t < s.length(); t++) {
                    int preSize = set.size();
                    set.add(s.charAt(t));
                    if(set.size()==preSize){
                        break;
                    }
                }
                max = Math.max(set.size(), max);
            }

            return max;
        }
    }
}
