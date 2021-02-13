package easy.array;

/**
 * 219. 存在重复元素 II
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.HashSet;
import java.util.Set;

/**
 * @author hu
 * @date 2021/2/13 下午9:05
 */
public class RepeatedElementTwo {

    /**
     * 方法一 双指针遍历 超时
     * 时间复杂度 O(n^2)
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int length = nums.length;
        boolean flag1 = false;
        boolean flag2 = false;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] == nums[j]) {
                    flag1 = true;
                    if (j - i <= k) {
                        flag2 = true;
                        break;
                    }
                }
            }
        }
        return flag1 && flag2;
    }

    /**
     * 哈希
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicateTwo(int[] nums, int k) {
        // 维护一个哈希表,最多存在k个元素
        Set<Integer> set = new HashSet<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            // 判断set里是否有重复的值
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            // set容量大于k时删除(数组)最前面的一个元素
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

}
