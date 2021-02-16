package easy.array;

/**
 * 605. 种花问题
 * 示例 1：
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 1
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 2
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= flowerbed.length <= 2 * 104
 * flowerbed[i] 为 0 或 1
 * flowerbed 中不存在相邻的两朵花
 * 0 <= n <= flowerbed.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-place-flowers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author hu
 * @date 2021/2/16 上午11:10
 */
public class ProblemsAndFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;

        // 每次空一格
        for (int i = 0; i < length; i += 2) {
            // 当前地为空地
            if (flowerbed[i] == 0) {
                // 是最后一格或者下一格为空地时
                if (i + 1 == length || flowerbed[i + 1] == 0) {
                    n--;
                } else {
                    i++;
                }
            }
        }
        return n <= 0;
    }

    /* 遍历数组
     * 下标遇到1 则下一位置不得种花 判断index+2 位置是否有花 index得加2 跳两格
     * 下标遇到0 由于每次碰到1都是跳两格,因此前一格必定是0.
     * 判断下一格是否为1，为1则跳三格；
     * 为0则可以在当前位置种花，n减1，跳两格
     */

    public boolean canPlaceFlowersTwo(int[] flowerbed, int n) {
        int length = flowerbed.length;

        // n小于0 直接跳出循环 因为已经不成立了
        for (int i = 0; i < length && n > 0; ) {

            if (flowerbed[i] == 1) {
                i += 2;
            } else if (i + 1 == length || flowerbed[i + 1] == 0) {
                n--;
                i += 2;
            } else {
                i += 3;
            }
        }
        return n <= 0;
    }

    /**
     * 贪心算法
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowersThree(int[] flowerbed, int n) {
        // TODO
        return false;
    }

}
