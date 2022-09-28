//给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。 
//
// 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 返回容器可以储存的最大水量。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 2 <= n <= 10⁵ 
// 0 <= height[i] <= 10⁴ 
// 
//
// Related Topics 贪心 数组 双指针 👍 3801 👎 0

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-09-27 22:27:41
 * @description   
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
        // 面积 由 较小height * 索引差

        // 方法1，暴力枚举所有情况，超时
//        int maxArea=0;
//        for (int i = 0 ; i < height.length ; i++){
//            for (int j = i + 1; j < height.length; j++) {
//                int minHeight = height[i] < height[j] ? height[i] : height[j];
//                maxArea =  (j - i) * minHeight > maxArea ? (j - i)  * minHeight : maxArea;
//            }
//        }
//        return maxArea;

        //方法2，双指针
        int maxArea=0,left=0,right=height.length-1;
        while (left < right){
            maxArea = height[left] < height[right] ?
                    Math.max(maxArea , (right - left) * height[left++]) :
                    Math.max(maxArea , (right - left) * height[right--]);
        }
        return maxArea;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
