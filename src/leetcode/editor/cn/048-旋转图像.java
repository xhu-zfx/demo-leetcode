//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。 
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
//
// 
//
// Related Topics 数组 数学 矩阵 👍 1496 👎 0

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-12-05 09:52:56
 * @description   
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        boolean[][] flag = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int temp = matrix[i][j]; // 0,1
                matrix[i][j] = matrix[len - j - 1][i]; // 2,0
                matrix[len - j - 1][i] = matrix[len - i - 1][len - j - 1]; // 3,2
                matrix[len - i - 1][len - j - 1] = matrix[j][len - i - 1]; // 1,3
                matrix[j][len - i - 1] = temp;
            }
        }
        // 四个角：
//        int temp2 =  matrix[0][0];
//        matrix[0][0] = matrix[len][0];
//        matrix[len][0] = matrix[len][len];
//        matrix[len][len] = matrix[0][len];
//        matrix[0][len] = temp2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
