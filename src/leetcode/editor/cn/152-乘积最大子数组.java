//给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 测试用例的答案是一个 32-位 整数。 
//
// 子数组 是数组的连续子序列。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 
//输入: nums = [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -10 <= nums[i] <= 10 
// nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数 
// 
//
// Related Topics 数组 动态规划 👍 1879 👎 0

import java.util.Deque;

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2023-01-04 11:04:17
 * @description   
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE,imax = 1,imin = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(imax * nums[i],nums[i]);
            imin = Math.min(imin * nums[i],nums[i]);
            max = Math.max(imax,max);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
