package easy.array;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 数组长度 <= 50000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author hu
 * @date 2021/1/19 下午10:50
 */
public class FindNumber {
    public int search(int[] nums, int target) {
        int length = nums.length;
        int first = 0;
        int last = length - 1;
        // 数组为空
        if (length == 0) {
            return 0;
        }
        // target在排序数组的范围外
        if (target < nums[first] || target > nums[last]) {
            return 0;
        }
        // while循环找到相同值
        while (first < last && nums[first] < target) {
            first++;
        }
        while (first < last && nums[last] > target) {
            last--;
        }
        // 存在找到的值与target不符合的情况
        if (nums[first] != target) {
            return 0;
        } else {
            return last - first + 1;
        }
    }
}
