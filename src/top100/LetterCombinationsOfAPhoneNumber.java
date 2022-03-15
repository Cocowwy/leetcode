package top100;

import java.util.*;

/**
 * T17 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *
 * 思路：
 * 回溯递归
 * 因为不知道实际循环的次数，
 * 但是我们知道每个字符串的长度就是 digits 的长度，所以我们可以理解递归的深度就是长度
 *
 * 234
 * adg adh adi
 * 假设当前已经递归到d这一层了，那么只再对d这个集合里面的每个字符进行递归
 *
 * @author cocowwy.cn
 * @create 2022-03-03-11:22
 */
public class LetterCombinationsOfAPhoneNumber {
    class Solution {
        List<String> rts = new ArrayList<>();
        Map<Character, Set<String>> map = new HashMap<>() {{
            put('2', Set.of("a", "b", "c"));
            put('3', Set.of("d", "e", "f"));
            put('4', Set.of("g", "h", "i"));
            put('5', Set.of("j", "k", "l"));
            put('6', Set.of("m", "n", "o"));
            put('7', Set.of("p", "q", "r", "s"));
            put('8', Set.of("t", "u", "v"));
            put('9', Set.of("w", "x", "y", "z"));
        }};

        public List<String> letterCombinations(String digits) {
            if(digits.equals("")) return new ArrayList<>();
            // 开始递归，同时str是上一次的字符串，第一次的话默认空字符串
            dp(digits, "");
            return rts;
        }

        public void dp(String digits, String str) {
            // 结束条件
            if (digits.length() == 0) {
                rts.add(str);
                return;
            }

            char c = digits.charAt(0);
            Set<String> values = map.get(c);
            // 要进行下一次递归，那么得剪短长度，adg --> dg 拿进去下一次dp
            digits = digits.substring(1);

            for (String value : values) {
                // 对当前set集合下的每个值开始递归
                dp(digits, str + value);
            }

        }

    }
}
