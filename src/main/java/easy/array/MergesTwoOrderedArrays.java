package easy.array;

/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 * <p>
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 */

import java.util.Arrays;

/**
 * @author hu
 * @date 2021/2/27
 */
public class MergesTwoOrderedArrays {

    /*
     * 注意:按照题目所给的要求
     * nums1数组的m个元素都放在前面
     * nums1的长度大于等于(m+n)
     * 所以后面多的都是空的
     * [1,2,3,0,0,0] m=3
     */

    /**
     * 1.将两个数组合并之后再排序
     * 时间复杂度 O((n+m)log(n+m))
     * 这种方法没有利用两个数组本身已经有序这一点
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * 2.双指针从后往前
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        // 三指针 指针一len1、nums1有效元素尾部；指针二len2、nums2尾部；指针三len、最终数组尾部
        // 1.当len1>=0时，nums1[len1],nums2[len2]对比
        // 1.1 nums1[len1]大，将nums1[len1]放入len位置。len1--,len--
        // 1.2 nums2[len2]大于等于nums1[len1]，将nums2[len2]放入len位置。len2--,len--
        // 2.当，len1<0时，将nums2[len2]放入len位置。len2--,len--
        // 循环结束条件：len2<0 ()
        int len1 = m - 1;
        int len2 = n - 1;
        int len = m + n - 1;

        while (len2 >= 0) {
            if (len1 >= 0 && nums1[len1] > nums2[len2]) {
                nums1[len--] = nums1[len1--];
            } else {
                nums1[len--] = nums2[len2--];
            }
        }
    }
}
