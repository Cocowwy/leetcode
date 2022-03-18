package top100;

/**
 * T739 每日温度
 * https://leetcode-cn.com/problems/daily-temperatures/
 *
 * 思路1：
 * 暴力破解
 * 有个点需要注意的是如果最后一个节点都没找到的话，这个值需要置为0
 *
 * @author cocowwy.cn
 * @create 2022-03-03-10:52
 */
public class DailyTemperatures {
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int[] rts = new int[temperatures.length];

            for (int i = 0; i < temperatures.length; i++) {
                int l = 0;
                for (int j = i + 1; j < temperatures.length; j++) {
                    if (temperatures[i] < temperatures[j]) {
                        l++;
                        break;
                    } else {
                        l++;
                    }

                    if (j == temperatures.length - 1) {
                        l = 0;
                    }
                }
                rts[i] = l;
            }
            return rts;
        }
    }
}
