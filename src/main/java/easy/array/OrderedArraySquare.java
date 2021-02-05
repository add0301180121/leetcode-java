package easy.array;

/**
 * 977. 有序数组的平方
 * 示例 1：
 * <p>
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 * <p>
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 已按 非递减顺序 排序
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Arrays;

/**
 * @author hu
 * @date 2021/1/28 下午7:44
 */
public class OrderedArraySquare {

    /**
     * 方法一 直接法
     * 先循环数组里每一元素 再平方 最后排序
     * 时间复杂度:O(nlogn)  n 是数组 A 的长度
     * 空间复杂度:O(logn) 除了存储答案的数组以外，我们需要 O(logn) 的栈空间进行排序
     *
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    /**
     * 方法二 双指针
     * 头尾指针相加比较 小于0 说明 头指针指向的为负数且绝对值大于尾指针指向的数(数组元素全为负数时也成立)
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     *
     * @param nums
     * @return
     */
    public int[] sortedSquaresTwo(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];
        int i = 0;
        int j = length - 1;
        int k = length - 1;
        while (i <= j) {
            if (nums[i] + nums[j] < 0) {
                answer[k--] = nums[i] * nums[i];
                i++;
            } else {
                answer[k--] = nums[j] * nums[j];
                j--;
            }
        }
        return answer;
    }
}
