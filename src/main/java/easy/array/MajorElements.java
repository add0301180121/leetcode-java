package easy.array;

/**
 * 面试题 17.10. 主要元素
 * 数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：[3,2]
 * 输出：-1
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * <p>
 * <p>
 * 说明：
 * 你有办法在时间复杂度为 O(N)，空间复杂度为 O(1) 内完成吗？
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hu
 * @date 2021/1/22 下午9:36
 */
public class MajorElements {

    /**
     * 方法一 先排序 遍历数组 求相同元素的个数 个数大于长度一半就输出 数组前后元素不一样则重置
     * 因为用到了Arrays的sort()方法 时间复杂度将不到O(N)
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int length = nums.length;
        int count = 1;

        // 数组元素个数为1 直接返回
        if (length == 1) {
            return nums[0];
        }
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                count++;
                if (count > length / 2) {
                    return nums[i];
                }
            } else {
                count = 1;
            }
        }
        return -1;
    }

    /**
     * 方法二 排序+双指针
     * 因为用到了Arrays的sort()方法 时间复杂度将不到O(N)
     *
     * @param nums
     * @return
     */
    public static int majorityElementTwo(int[] nums) {
        int length = nums.length;
        int mid = (length - 1) / 2;
        int count = 1;

        // 数组元素个数为1 直接返回
        if (length == 1) {
            return nums[0];
        }

        // 排序
        Arrays.sort(nums);
        for (int i = mid - 1; i >= 0; i--) {
            if (nums[mid] == nums[i]) {
                count++;
            } else {
                break;
            }
        }
        for (int j = mid + 1; j < length; j++) {
            if (nums[j] == nums[mid]) {
                count++;
            } else {
                break;
            }
        }
        if (count > length / 2) {
            return nums[mid];
        } else {
            return -1;
        }
    }

    /**
     * 方法三 投票法 这个方法一听就很牛逼
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * 维护一个众数major和一个频数count，如果出现不同的数count减1，如果出现相同的数，count+1
     * 如果存在主要元素，那么最终count一定大于0，否则一定不存在主要元素。但仅大于0也不一定能判断确实存在主要元素
     * 如果数组为[4,3,3,2,2,2]，会发现count为2。但是，2并不是主要元素，所以还要添加验证环节
     *
     * @param nums
     * @return
     */
    public static int majorityElementThree(int[] nums) {
        int length = nums.length;

        // 判空 但可写可不写 题目明确整数数组
        if (length == 0) {
            return -1;
        }

        // 投票环节
        int major = 0;
        int vote = 0;
        for (int num : nums) {
            if (vote == 0) {
                major = num;
                vote++;
            } else {
                if (major == num) {
                    vote++;
                } else {
                    vote--;
                }
            }
        }

        // 验证环节
        if (vote == 0) {
            return -1;
        }
        int identify = 0;
        for (int num : nums) {
            if (major == num) {
                identify++;
                if (identify > length / 2) {
                    return major;
                }
            }
        }
        return -1;
    }

    /**
     * 利用Map 遍历数组得到一个key为元素 value为出现个数的map 再遍历map
     * 时间复杂度O(N)
     * 空间复杂度不为O(1)
     *
     * @param nums
     * @return
     */
    public static int majorityElementFour(int[] nums) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > length / 2) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] n = new int[]{12, 52, 12, 70, 12, 61, 12, 12, 50, 72, 82, 12, 11, 25, 28, 43, 40, 12, 12, 53, 12, 12, 98, 12, 12, 92, 81, 2, 12, 15, 40, 12, 12, 9, 12, 31, 12, 12, 12, 12, 77, 12, 12, 50, 12, 12, 12, 93, 41, 92, 12, 12, 12, 12, 12, 12, 12, 12, 12, 37, 48, 14, 12, 70, 82, 12, 80, 12, 12, 12, 12, 56, 30, 12, 8, 12, 50, 12, 20, 12, 21, 97, 12, 42, 12, 10, 12, 38, 73, 15, 9, 11, 79, 12, 12, 28, 51, 12, 15, 12};
        int i = majorityElementFour(n);
        System.out.println(i);
    }
}
