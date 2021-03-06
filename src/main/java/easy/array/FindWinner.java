package easy.array;

/**
 * 1275. 找出井字棋的获胜者
 * A 和 B 在一个 3 x 3 的网格上玩井字棋。
 * <p>
 * 井字棋游戏的规则如下：
 * <p>
 * 玩家轮流将棋子放在空方格 (" ") 上。
 * 第一个玩家 A 总是用 "X" 作为棋子，而第二个玩家 B 总是用 "O" 作为棋子。
 * "X" 和 "O" 只能放在空方格中，而不能放在已经被占用的方格上。
 * 只要有 3 个相同的（非空）棋子排成一条直线（行、列、对角线）时，游戏结束。
 * 如果所有方块都放满棋子（不为空），游戏也会结束。
 * 游戏结束后，棋子无法再进行任何移动。
 * 给你一个数组 moves，其中每个元素是大小为 2 的另一个数组（元素分别对应网格的行和列），它按照 A 和 B 的行动顺序（先 A 后 B）记录了两人各自的棋子位置。
 * <p>
 * 如果游戏存在获胜者（A 或 B），就返回该游戏的获胜者；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。
 * <p>
 * 你可以假设 moves 都 有效（遵循井字棋规则），网格最初是空的，A 将先行动。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
 * 输出："A"
 * 解释："A" 获胜，他总是先走。
 * "X  "    "X  "    "X  "    "X  "    "X  "
 * "   " -> "   " -> " X " -> " X " -> " X "
 * "   "    "O  "    "O  "    "OO "    "OOX"
 * 示例 2：
 * <p>
 * 输入：moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
 * 输出："B"
 * 解释："B" 获胜。
 * "X  "    "X  "    "XX "    "XXO"    "XXO"    "XXO"
 * "   " -> " O " -> " O " -> " O " -> "XO " -> "XO "
 * "   "    "   "    "   "    "   "    "   "    "O  "
 * 示例 3：
 * <p>
 * 输入：moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
 * 输出："Draw"
 * 输出：由于没有办法再行动，游戏以平局结束。
 * "XXO"
 * "OOX"
 * "XOX"
 * 示例 4：
 * <p>
 * 输入：moves = [[0,0],[1,1]]
 * 输出："Pending"
 * 解释：游戏还没有结束。
 * "X  "
 * " O "
 * "   "
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= moves.length <= 9
 * moves[i].length == 2
 * 0 <= moves[i][j] <= 2
 * moves 里没有重复的元素。
 * moves 遵循井字棋的规则。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-winner-on-a-tic-tac-toe-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author hu
 * @date 2021/2/27
 */
public class FindWinner {

    /*
     * 使用位运算记录结果
     * 井字棋总共只有9个格子，且赢面是固定的
     * 可以使用一个9位二进制数代表行走的结果，规定:
     * 井字棋坐标[i,j]对应于数字的第3i+j位
     * 每走一步棋等价于与对应的位进行(异)或运算
     * 000 000 000
     *
     * 井字棋赢面一共8种 三横 三竖 两斜
     * 用数组记录所有赢面的数
     * 000 000 111 = 7
     * 000 111 000 = 56
     * 111 000 000 = 448
     * 001 001 001 = 73
     * 010 010 010 = 146
     * 100 100 100 = 292
     * 100 010 001 = 273
     * 001 010 100 = 84
     *
     * 将一方的数字num与赢面对应的数字k进行与运算，若结果为kk，此方获胜
     * 若双方都未获胜:
     * 若总步数为99步，则平局(DrawDraw)
     * 否则，未完成(PendingPending)
     */

    /**
     * 时间复杂度O(N)
     * 空间复杂度O(1)
     * @param moves
     * @return
     */
    public static String tictactoe(int[][] moves) {
        int[] win = {7, 56, 448, 73, 146, 292, 273, 84};
        int length = moves.length;
        // A走的轨迹
        int a = 0;
        // B走的轨迹
        int b = 0;

        for (int i = 0; i < length; i++) {
            // 奇数为B 偶数为A
            if ((i & 1) == 1) {
                // 3 * moves[i][0] + moves[i][1] 算取位数
                // 1左移相应的位数
                b |= 1 << (3 * moves[i][0] + moves[i][1]);
            } else {
                a |= 1 << (3 * moves[i][0] + moves[i][1]);
            }
        }

        for (int i : win) {
            if ((i & a) == i) {
                return "A";
            }
            if ((i & b) == i) {
                return "B";
            }
        }
        return length == 9 ? "Draw" : "Pending";
    }

    public static void main(String[] args) {
        int[][] m = {{0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}};
        System.out.println(tictactoe(m));
    }
}
