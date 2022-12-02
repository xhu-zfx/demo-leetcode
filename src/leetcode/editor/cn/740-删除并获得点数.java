//给你一个整数数组 nums ，你可以对它进行一些操作。 
//
// 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i]
// + 1 的元素。 
//
// 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,4,2]
//输出：6
//解释：
//删除 4 获得 4 个点数，因此 3 也被删除。
//之后，删除 2 获得 2 个点数。总共获得 6 个点数。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,3,3,3,4]
//输出：9
//解释：
//删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
//之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
//总共获得 9 个点数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// 1 <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 哈希表 动态规划 👍 694 👎 0

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-11-15 09:59:10
 * @description   
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int deleteAndEarn(int[] nums) {
        // 选择一个元素后，所有值为这个元素+1或者-1的元素都会被删除，这意味着一旦选择这个元素，所有值等于这个元素值的元素都会被选择
        // 我们可以提前处理数组，将相同值的元素和算出
        int max = 0;
        for (int num : nums) {
            max = Math.max(max,num);
        }
        int[] sum = new int[max + 1];
        for (int num : nums) {
            sum[num] += num;
        }
        return deleteAndEarnUtil(sum);
    }

    private int deleteAndEarnUtil(int[] sum) {
        int[] dp = new int[sum.length];
        dp[0] = sum[0];
        if (sum.length == 1) return dp[0];
        dp[1] = Math.max(dp[0], sum[1]);
        for (int i = 2; i < sum.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sum[i]);
        }
        return dp[sum.length - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
