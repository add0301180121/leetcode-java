package easy.array;

/**
 * 867. 转置矩阵
 * 给定一个矩阵A，返回A的转置矩阵。
 * <p>
 * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [[1,2,3],
 * [4,5,6],
 * [7,8,9]]
 * 输出：
 * [[1,4,7],
 * [2,5,8],
 * [3,6,9]]
 * 示例 2：
 * <p>
 * 输入：
 * [[1,2,3],
 * [4,5,6]]
 * 输出：
 * [[1,4],
 * [2,5],
 * [3,6]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length<= 1000
 * 1 <= A[0].length<= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/transpose-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 首先我们需要获取矩阵的行数 和列数
 * <p>
 * 首先我们需要获取矩阵的行数 和列数
 * 在二维数组中我们会发现这个公式A[i][j]=B[j][i] (A B互为转置矩阵对应的二维数组)
 * <p>
 * 第一个方法:新建个B数组 来个for循环的嵌套写入B数组
 */

/**
 * 首先我们需要获取矩阵的行数 和列数
 * 在二维数组中我们会发现这个公式A[i][j]=B[j][i] (A B互为转置矩阵对应的二维数组)
 *
 * 方法:新建个B数组 来个for循环的嵌套写入B数组
 * 时间复杂度:O(R*C),其中 R 和 C 是给定矩阵 A 的行数和列数.
 * 空间复杂度:O(R*C),也就是答案所使用的空间
 */

/**
 * @author hu
 * @date 2021/1/22 下午6:01
 */
public class TransposedMatrix {
    public int[][] transpose(int[][] A) {
        // 行数
        int rows = A.length;
        // 列数
        int columns = A[0].length;

        int[][] B = new int[columns][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                B[j][i] = A[i][j];
            }
        }
        return B;
    }
}
