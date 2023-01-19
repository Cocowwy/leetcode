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
 * @hraf <a href="https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/"></a>
 * @create 2022-03-03-11:22
 */
public class LetterCombinationsOfAPhoneNumber {
    class Solution {
//        List<String> rts = new ArrayList<>();
//        Map<Character, Set<String>> map = new HashMap<>() {{
//            put('2', Stream.of("a", "b", "c").collect(Collectors.toSet()));
//            put('3', Stream.of("d", "e", "f").collect(Collectors.toSet()));
//            put('4', Stream.of("g", "h", "i").collect(Collectors.toSet()));
//            put('5', Stream.of("j", "k", "l").collect(Collectors.toSet()));
//            put('6', Stream.of("m", "n", "o").collect(Collectors.toSet()));
//            put('7', Stream.of("p", "q", "r", "s").collect(Collectors.toSet()));
//            put('8', Stream.of("t", "u", "v").collect(Collectors.toSet()));
//            put('9', Stream.of("w", "x", "y", "z").collect(Collectors.toSet()));
//        }};
//
//        public List<String> letterCombinations(String digits) {
//            if (digits.equals("")) return new ArrayList<>();
//            // 开始递归，同时str是上一次的字符串，第一次的话默认空字符串
//            dp(digits, "");
//            return rts;
//        }
//
//        public void dp(String digits, String str) {
//            // 结束条件
//            if (digits.length() == 0) {
//                rts.add(str);
//                return;
//            }
//
//            char c = digits.charAt(0);
//            Set<String> values = map.get(c);
//            // 要进行下一次递归，那么得剪短长度，adg --> dg 拿进去下一次dp
//            digits = digits.substring(1);
//
//            for (String value : values) {
//                // 对当前set集合下的每个值开始递归
//                dp(digits, str + value);
//            }
//
//        }

    }

    /**
     * 二刷
     * 拆分成 求第 i 和第 i+1 位置的排列组合的子问题
     */
    static class Solution2 {
        public static void main(String[] args) {
            System.out.println(letterCombinations("23"));
        }

        static Map<Character, String> dic = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        public static List<String> letterCombinations(String digits) {
            if(digits.equals("")){
                return Collections.emptyList();
            }
            List<String> res = new ArrayList<>();
            dp(res, digits, "");
            return res;
        }

        private static void dp(List<String> res, String subStr, String pre) {
            if (subStr.length() == 0) {
                res.add(pre);
                return;
            }
            Character str = subStr.charAt(0);
            String sets = dic.get(str);
            String substring = subStr.substring(1);
            for (int i = 0; i < sets.length(); i++) {
                String curStr = pre + sets.charAt(i);
                dp(res, substring, curStr);
            }
        }
    }
}
