package easy.array;

/**
 * 628. 三个数的最大乘积
 * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：6
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：24
 * 示例 3：
 * <p>
 * 输入：nums = [-1,-2,-3]
 * 输出：-6
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <=104
 * -1000 <= nums[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-three-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 思路:
 * 分情况
 * 1.全为非负数时 最大三个数相乘最大
 * 2.全为负数 最大三个数相乘最大
 * 3.有正有负 可能是三个最大正数的乘积,也可能是两个最小负数(即绝对值最大)与最大正数的乘积
 * <p>
 * 方法一. 先排序 再在三个最大正数的乘积和两个最小负数(即绝对值最大)与最大正数的乘积之中取最大值
 */

/**
 * 思路:
 * 分情况
 * 1.全为非负数时 最大三个数相乘最大
 * 2.全为负数 最大三个数相乘最大
 * 3.有正有负 可能是三个最大正数的乘积,也可能是两个最小负数(即绝对值最大)与最大正数的乘积
 *
 * 方法一. 先排序 再在三个最大正数的乘积和两个最小负数(即绝对值最大)与最大正数的乘积之中取最大值
 */

import java.util.Arrays;

/**
 * @author hu
 * @date 2021/2/1 上午11:30
 */
public class ThreeNumbersMaxProduct {

    /**
     * 方法一
     * 时间复杂度O(N logN),其中 N 为数组长度,排序需要O(NlogN)的时间
     * 空间复杂度O(logN),主要为排序的空间开销
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        return Math.max(nums[length - 1] * nums[length - 2] * nums[length - 3], nums[0] * nums[1] * nums[length - 1]);
    }

    // TODO other methods
}
