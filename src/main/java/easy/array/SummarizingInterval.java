package easy.array;

/**
 * 228. 汇总区间
 * 给定一个无重复元素的有序整数数组 nums 。
 * <p>
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * <p>
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * <p>
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * 示例 2：
 * <p>
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 * 示例 3：
 * <p>
 * 输入：nums = []
 * 输出：[]
 * 示例 4：
 * <p>
 * 输入：nums = [-1]
 * 输出：["-1"]
 * 示例 5：
 * <p>
 * 输入：nums = [0]
 * 输出：["0"]
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 20
 * -231 <= nums[i] <= 231 - 1
 * nums 中的所有值都 互不相同
 * nums 按升序排列
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/summary-ranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author hu
 * @date 2021/2/14 下午9:03
 */
public class SummarizingInterval {

    /**
     * 双指针
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    public static List<String> summaryRanges(int[] nums) {
        int length = nums.length;
        List<String> list = new ArrayList<>();
        int i = 0;

        if (length == 0) {
            return list;
        }
        if (length == 1) {
            list.add(String.valueOf(nums[length - 1]));
            return list;
        }

        // 遍历
        while (i < length) {
            // 区间开始下标
            int low = i;
            i++;
            // 寻找连续的数
            while (i < length && nums[i - 1] + 1 == nums[i]) {
                i++;
            }
            // 区间结束下标
            int high = i - 1;
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(nums[low]));
            // 区间有多个连续数的条件下
            if (low < high) {
                stringBuilder.append("->");
                stringBuilder.append(nums[high]);
            }
            list.add(stringBuilder.toString());
        }

        return list;
    }

    /**
     * 双指针 写法二
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    public static List<String> summaryRangesTwo(int[] nums) {
        int length = nums.length;
        List<String> list = new ArrayList<>();
        // 指向第一个区间起始下标
        int i = 0;

        if (length == 0) {
            return list;
        }
        if (length == 1) {
            list.add(String.valueOf(nums[length - 1]));
            return list;
        }

        for (int j = 0; j < length; j++) {
            if (j + 1 == length || nums[j] + 1 != nums[j + 1]) {
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(nums[i]));
                if (i != j) {
                    stringBuilder.append("->").append(nums[j]);
                }
                list.add(stringBuilder.toString());
                i = j + 1;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 3, 4, 5, 6, 7};
        System.out.println(summaryRanges(arr));
        System.out.println(summaryRangesTwo(arr));
    }
}
