package top100;

/**
 * T48 旋转图像
 *
 * 思路： 将数组上线对称之后再沿着对角线对称
 * 1：
 * 1 2 3
 * 4 5 6
 * 7 8 9
 *
 * 2：
 * 7 8 9
 * 4 5 6
 * 1 2 3
 *
 * 3：
 * 7 4 1
 * 8 5 2
 * 9 6 3
 * @author cocowwy.cn
 * @create 2022-03-03-15:43
 */
public class RotateImage {
    class Solution {
        public void rotate(int[][] matrix) {
            // 上下翻转
            for (int i = 0; i < matrix.length / 2; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[matrix.length - i - 1][j];
                    matrix[matrix.length - i - 1][j] = temp;
                }
            }

            // 沿斜对角线翻
            for (int i = 1; i < matrix.length; i++) {
                for (int j = 0; j < i + 1; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
            return;
        }
    }
}
