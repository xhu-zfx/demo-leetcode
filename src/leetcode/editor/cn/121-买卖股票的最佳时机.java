//给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。 
//
// 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。 
//
// 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：[7,1,5,3,6,4]
//输出：5
//解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2： 
//
// 
//输入：prices = [7,6,4,3,1]
//输出：0
//解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 10⁵ 
// 0 <= prices[i] <= 10⁴ 
// 
//
// Related Topics 数组 动态规划 👍 2527 👎 0

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-08-29 11:41:44
 * @description
 *  按顺序遍历数组,用较后的数来减去较前面的数,找到其最大值,返回
 *
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
//        暴力双for , 超时
//        int profit=0;
//        for (int i=0;i<prices.length;i++){
//            for (int j=i+1;j<prices.length;j++){
//                if (profit<prices[j]-prices[i]) profit=prices[j]-prices[i];
//            }
//        }
//        return profit;

//        只遍历一次

//        否则就看看在今天卖能赚多少
        int buyPrice=Integer.MAX_VALUE,profit=0;
        for (int i=0;i<prices.length;i++){
            if (buyPrice>prices[i])
//        遇到比当前低的就在这天买入
                buyPrice=prices[i];
            else if (profit<prices[i]-buyPrice)
                profit=prices[i]-buyPrice;
        }
        return profit;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
