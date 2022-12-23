//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
//
// Related Topics 数组 回溯 矩阵 👍 1496 👎 0

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-12-23 12:59:02
 * @description   
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        int h = board.length;int w = board[0].length;
        // 存储当前位置释放被访问过
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (check(board,visited,i,j,word,0))
                    return true;
            }
        }
        return false;
    }

    // 表示从(i,j)位置，能否搜索到word的从index开始到单词末尾
    private boolean check(char[][] board, boolean[][] visited, int i, int j, String word, int index) {
        if (board[i][j] != word.charAt(index))
            return false;
        // 到单词末尾，表示查找成功
        else if (index == word.length() - 1)
            return true;
        visited[i][j] = true;
        // 方便访问上下左右的元素
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean res = false;
        for (int[] dir : directions) {
            // 上下左右的元素坐标
            int newi = i + dir[0];
            int newj = j + dir[1];
            // 防止越界
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length){
                if (!visited[newi][newj]){
                    if (check(board, visited, newi, newj, word, index + 1)){
                        res = true;
                    }
                }
            }
        }
        visited[i][j] = false;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
