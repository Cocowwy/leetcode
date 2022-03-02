package top100;

/**
 * T6 Z 字形变换
 * https://leetcode-cn.com/problems/zigzag-conversion/
 *
 * 思路1：
 * 暴力
 * 关键点是遍历字符串长度的时候，需要锁定其横轴位置和纵轴位置
 * 纵向和斜向分别定义一个计数器，节点纵向移动则只变纵坐标，斜向移动则两个坐标都变
 * 这里计算横向长度的时候，PALYAP 这一段当成一组 得到大约长度：(s.length() / (2 * numRows - 2)) * (numRows - 1) + numRows
 *  P     I    N
 *  A   L S  I G
 *  Y A   H R
 *  P     I
 *  第一次纵向的端点是[P~P]  第一次斜向的端点是[A~L] 依此类推，具体取的长度根据 numRows简单判断即可
 * @author cocowwy.cn
 * @create 2022-03-03-10:40
 */
public class ZigzagConversion {
    static class Solution {
        public String convert(String s, int numRows) {
            if(s.length()<=numRows||numRows<=1) return s;
            // 预估申请的宽度
            int width = (s.length() / (2 * numRows - 2)) * (numRows - 1) + numRows;
            Character[][] chars = new Character[width][numRows];
            int counter = numRows;
            int w = 0;
            for (int i = 0; i < s.length(); i++) {
                int h = numRows - counter;
                char c = s.charAt(i);

                // 到底部的时候，斜边赋值，这里需要处理斜边的坐标，也是麻烦的点
                if (counter == 0) {
                    int slantedCount = numRows - 2;
                    while (slantedCount > 0) {
                        if (i > s.length() - 1) break;
                        c = s.charAt(i);
                        w++;
                        h = slantedCount;
                        chars[w][h] = c;
                        System.out.println("w" + w + "---h" + h + "---v:" + c);
                        slantedCount--;
                        i++;
                    }
                    i--;
                    w++;
                    counter = numRows;
                    continue;
                }

                chars[w][h] = c;
                System.out.println("w" + w + "---h" + h + "---v:" + c);
                counter--;
            }

            // 遍历结果
            String str = "";
            for (int i = 0; i < chars[0].length; i++) {
                for (int j = 0; j < chars.length; j++) {
                    if (chars[j][i] != null) {
                        str += chars[j][i];
                    }
                }
            }
            return str;
        }

        public static void main(String[] args) {
//            System.out.println(new Solution().convert("PAYPALISHIRING", 4));
            System.out.println(new Solution().convert("ABCDE", 4));
        }
    }
}



