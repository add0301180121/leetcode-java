package easy.array;

/**
 * 剑指 Offer 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i]<= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Arrays;

/**
 * @author hu
 * @date 2021/1/24 下午10:20
 */
public class MinimalNumber {

    /**
     * 方法一：排序
     * 思路和算法
     * <p>
     * 对原数组从小到大排序后取出前 k个数即可
     * 时间复杂度O(N logN),其中 N 为数组长度,排序需要O(NlogN)的时间
     * 空间复杂度O(logN),主要为排序的空间开销
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        int length = arr.length;
        int[] answer = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            answer[i] = arr[i];
        }
        return answer;
    }

    /**
     * 方法2 堆
     */
    // TODO
}
