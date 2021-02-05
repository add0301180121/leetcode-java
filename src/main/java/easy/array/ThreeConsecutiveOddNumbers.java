package easy.array;

/**
 * 1550. 存在连续三个奇数的数组
 * 给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：
 * 如果存在，请返回 true ；
 * 否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [2,6,4,1]
 * 输出：false
 * 解释：不存在连续三个元素都是奇数的情况。
 * 示例 2：
 * <p>
 * 输入：arr = [1,2,34,3,4,5,7,23,12]
 * 输出：true
 * 解释：存在连续三个元素都是奇数的情况，即 [5,7,23] 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/three-consecutive-odds
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author hu
 * @date 2021/2/5 下午9:18
 */
public class ThreeConsecutiveOddNumbers {

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param arr
     * @return
     */
    public boolean threeConsecutiveOdds(int[] arr) {
        int length = arr.length;

        if (length < 3) {
            return false;
        }
        int left = 0, right = left + 2;
        for (; left < length - 2; ) {
            if (isOdd(arr[left])) {
                if (isOdd(arr[right])) {
                    if (isOdd(arr[right - 1])) {
                        return true;
                    }
                    left = right;
                    right = left + 2;
                }
                left = right + 1;
                right = left + 2;
            }
            left++;
            right++;
        }
        return false;
    }

    private boolean isOdd(int number) {
        return number % 2 != 0;
    }

    /**
     * 方法二
     * 优化判断奇数的方法
     * <p>
     * 偶数与1相与 必为0
     * 奇数则相反
     */
    private boolean isOddTwo(int number) {
        return (number & 1) != 0;
    }
}
