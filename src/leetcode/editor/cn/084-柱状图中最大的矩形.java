//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
//
// Related Topics 栈 数组 单调栈 👍 2262 👎 0

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-12-24 12:33:51
 * @description   
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        // 暴力解法：对于每一个矩形都进行左右寻找，超时
        int maxArea = 0,len = heights.length;
        if (len == 0) return 0;
        for (int i = 0; i < len; i++) {
            int left = i;
            int curHeight = heights[i];
            while (left > 0 && heights[left - 1] >= curHeight){
                left--;
            }
            int right = i;
            while (right < len && heights[right + 1] >= curHeight){
                left--;
            }
            int width = right - left + 1;// left = 0,rigth = 5,width = 6
            maxArea = Math.max(maxArea,curHeight * width);
        }
        return maxArea;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
