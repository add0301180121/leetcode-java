package easy.array;

/**
 * 832. 翻转图像
 * 给定一个二进制矩阵A，我们想先水平翻转图像，然后反转图像并返回结果。
 * <p>
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转[1, 1, 0]的结果是[0, 1, 1]。
 * <p>
 * 反转图片的意思是图片中的0全部被1替换，1全部被0替换。例如，反转[0, 1, 1]的结果是[1, 0, 0]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,1,0],[1,0,1],[0,0,0]]
 * 输出: [[1,0,0],[0,1,0],[1,1,1]]
 * 解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 * 然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 * 示例 2:
 * <p>
 * 输入: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * 输出: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 解释: 首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 * 然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 说明:
 * <p>
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j] <= 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flipping-an-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Arrays;

/**
 * @author hu
 * @date 2021/2/17
 */
public class RolloverImage {
    public static int[][] flipAndInvertImage(int[][] A) {
        int column = A[0].length;

        // 获取一个个元素(数组)
        for (int[] row : A) {
            int mid = column / 2;
            for (int i = 0; i < mid; i++) {
                // 0^1=1 1^1=0
                int temp = row[i] ^ 1;
                row[i] = row[column - i - 1] ^ 1;
                row[column - i - 1] = temp;
            }
            if ((column & 1) == 1) {
                row[mid] = row[mid] ^ 1;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[] b = new int[]{1, 2};
        int[][] A = {{1, 1, 0}, {1, 0, 1}, {0, 0, 1}};
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.deepToString(flipAndInvertImage(A)));
    }
}
