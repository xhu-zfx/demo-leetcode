//给你一个整数 n ，请你找出并返回第 n 个 丑数 。 
//
// 丑数 就是只包含质因数 2、3 和/或 5 的正整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：12
//解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
//解释：1 通常被视为丑数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1690 
// 
//
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 966 👎 0

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-09-09 10:25:33
 * @description   
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n) {
        int[] dp=new int[n+1];
        int dp1=1;int dp2=1;int dp3=1;
        dp[1]=1;
        for (int i=2;i<n+1;i++){
            int num1=dp[dp1]*2;
            int num2=dp[dp2]*3;
            int num3=dp[dp3]*5;
            // 取最小值
            dp[i]=Math.min(Math.min(num1,num2),num3);
            // 这个数被取了过后,它就不会被再次取
            // 比如该数*2被取了,只能就不会再取该数*2,只能取*3或者*5
            // 具体实现就是dp1已经+1,而dp3和dp5不变,下一次循环时
            if (dp[i]==num1) dp1++;
            if (dp[i]==num2) dp2++;
            if (dp[i]==num3) dp3++;
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
