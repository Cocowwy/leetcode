package top100;

/**
 * T11  盛最多水的容器
 * https://leetcode-cn.com/problems/container-with-most-water/
 *
 * 思路1：
 * 暴力，得到任意两节点之间的水量最大  超时
 *
 * 思路2：
 * 双指针  能装的水量  实际取决于短边的长度*两个端点之间的距离
 * 这题纠结的点是【为什么双指针的解法是正确的，而且不会漏 ？】 https://leetcode-cn.com/problems/container-with-most-water/solution/on-shuang-zhi-zhen-jie-fa-li-jie-zheng-que-xing-tu/
 *
 * [1,8,6,2,5,4,8,3,7]
 * 拿这个数据来说  一开始 p[0]和 p[8] 中 得到的是 p[0]*8=8 即最大长度是 8
 * 因为长度是取决于较短的边的，所以如果想要增大就只能够移动短边，期望他能够变大，这里的会忽略 p[0] 和 p[1]~p[7]的组合情况，
 *
 *  p[0] 和 p[8] 围成的面积一定大于 p[0] 与 p[1]~p[7] 任意一个边组成的面积（在p[0]是较短边的时候）
 *
 * 【移动短边p[0]的时候，相当于放弃了短边和右边所有的边p[1]~p[7]所组成的值的可能，因为无论右边p[1]~p[7]长度如何
 * 最大的水量只会和 p[0] 或者比 p[0] 小的边相关，既然逻辑上的短边只会等于 p[0]或者比p[0]更小，且宽度也会变小，那么就可以忽
 * 略p[0]~p[7]的所有情况】
 *
 *
 *
 * @author cocowwy.cn
 * @create 2022-02-02-18:21
 */
public class ContainerWithMostWater {
    class Solution1 {
        public int maxArea(int[] height) {
            int max = 0;

            for (int i = 0; i < height.length - 1; i++) {
                for (int j = i + 1; j < height.length; j++) {
                    max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
                }
            }

            return max;
        }
    }

    static class Solution2 {
        public int maxArea(int[] height) {
            int max = 0;

            int i = 0;
            int j = height.length - 1;
            while (i < j) {
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
                if (height[i] < height[j]) {
                    i++;
                } else {
                    j--;
                }

            }
            return max;
        }

        public static void main(String[] args) {
            Solution2 s = new Solution2();
            System.out.println(s.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        }
    }

    /**
     * 二刷
     */
    static class Solution3 {

        public int maxArea(int[] height) {
            int max = 0;
            for (int i = 0; i < height.length; i++) {
                int j = height.length - 1;
                while (j > i) {
                    max = Math.max(max, obtainHeight(i, j, height));
                    if (height[i] <= height[j]) {
                        break;
                    }
                    j--;
                }
            }
            return max;
        }

        private int obtainHeight(int leftIndex, int rightIndex, int[] height) {
            return Math.min(height[leftIndex], height[rightIndex]) * (rightIndex - leftIndex);
        }
    }

}
