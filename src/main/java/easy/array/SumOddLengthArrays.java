package easy.array;

/**
 * 1588. 所有奇数长度子数组的和
 * 给你一个正整数数组arr，请你计算所有可能的奇数长度子数组的和。
 * <p>
 * 子数组 定义为原数组中的一个连续子序列。
 * <p>
 * 请你返回 arr中 所有奇数长度子数组的和 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,4,2,5,3]
 * 输出：58
 * 解释：所有奇数长度子数组和它们的和为：
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 * 示例 2：
 * <p>
 * 输入：arr = [1,2]
 * 输出：3
 * 解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
 * 示例 3：
 * <p>
 * 输入：arr = [10,11,12]
 * 输出：66
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 100
 * 1 <= arr[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author hu
 * @date 2021/1/29 下午8:09
 */
public class SumOddLengthArrays {

    public static int sumOddLengthSubArrays(int[] arr) {
        int sum = 0;
        int length = arr.length;
        // len为奇数且 <= 数组长度
        for (int len = 1; len <= length; len += 2) {
            sum += window(arr, len);
        }
        return sum;
    }

    /**
     * 获取子数组为len时所有的和
     *
     * @param arr
     * @param len
     * @return
     */
    private static int window(int[] arr, int len) {
        int length = arr.length;
        int i = 0;
        int j = 0;
        int sum = 0;
        // 总和
        int sSum = 0;
        while (j < length) {
            sum += arr[j];
            // 子数组长度
            if (j - i + 1 == len) {
                sSum += sum;
                // 注意这里 每次left指针向右 sum总和需要去掉left指针所在的元素
                sum -= arr[i];
                i++;
            }
            j++;
        }
        return sSum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 11, 12};
        System.out.println(sumOddLengthSubArrays(arr));
    }
}
