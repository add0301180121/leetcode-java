package easy.array;

/**
 * 给定一个整数数组 nums和一个整数目标值 target,请你在该数组中找出 和为目标值 的那 两个 整数,并返回它们的数组下标.
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍.
 * 你可以按任意顺序返回答案.
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入:nums = [2,7,11,15], target = 9
 * 输出:[0,1]
 * 解释:因为 nums[0] + nums[1] == 9 ,返回 [0, 1] .
 * 示例 2:
 * <p>
 * 输入:nums = [3,2,4], target = 6
 * 输出:[1,2]
 * 示例 3:
 * <p>
 * 输入:nums = [3,3], target = 6
 * 输出:[0,1]
 *  
 * <p>
 * 提示:
 * <p>
 * 2 <= nums.length <= 103
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 * <p>
 * 来源:力扣（LeetCode）
 * 链接:https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有.商业转载请联系官方授权,非商业转载请注明出处.
 */

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author hu
 * @date 2021/1/18 下午9:50
 */
public class TwoNumbersSum {

    /**
     * 时间复杂度 O(N^2)
     * 空间复杂度 O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (target - nums[i] == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("no such two numbers");
    }

    /**
     * hash映射 map<数组元素,数组所在下标>
     * 时间复杂度O(N)
     * 空间复杂度O(N)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumTwo(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no such two numbers");
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] ints = twoSum(nums, 10);
        System.out.println(Arrays.toString(ints));
    }
}
