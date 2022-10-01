//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// 0 <= nums[i] <= 10⁵ 
// 
//
// Related Topics 贪心 数组 动态规划 👍 2034 👎 0

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-10-01 10:54:25
 * @description   
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canJump(int[] nums) {
        // 思考：怎么才到达不了最后一个下标 ?
        // nums[i] == 0 ?
        // nums[i] == n ，说明以后的n个格子都可以作为起跳点
        // 把这些可以起跳的格子都尝试一遍，维护最远距离，如果最远距离能到nums.length，即为成功
        int maxJump= 0;
        for (int i = 0; i < nums.length; i++){
            // 可以到的最大位置 小于 当前遍历到的位置，说明该点不可到，返回false
            if (maxJump < i) return false;
            maxJump=Math.max(maxJump,i + nums[i]);
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
