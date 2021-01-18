package easy.array;

/**
 * 找出数组中重复的数字.
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0~n-1 的范围内.
 * 数组中某些数字是重复的,但不知道有几个数字重复了,也不知道每个数字重复了几次.
 * 请找出数组中任意一个重复的数字.
 * <p>
 * 示例 1:
 * 输入:
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出:2 或 3
 *  
 * <p>
 * 限制:
 * <p>
 * 2 <= n <= 100000
 * <p>
 * 来源：力扣(LeetCode)
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有.商业转载请联系官方授权,非商业转载请注明出处.
 */

import java.util.HashSet;
import java.util.Set;

/**
 * @author hu
 * @date 2021/1/18 下午8:56
 */
public class DuplicatedNumbers {

    /**
     * 方法一 利用set的特性来排重
     *
     * @param nums
     * @return
     */
    public static int findRepeatNumber(int[] nums) {
        int answer = -1;
        Set set = new HashSet<Integer>();
        for (int i = 0, length = nums.length; i < length; i++) {
            boolean flag = false;
            // Set的add()方法的返回值为布尔值 true为值加入set容器中 false则相反
            while (!set.add(nums[i])) {
                answer = nums[i];
                flag = true;
                break;
            }
            if (flag) {
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 1, 0, 2, 5, 3};
        int number = findRepeatNumber(array);
        System.out.println(number);
    }
}
