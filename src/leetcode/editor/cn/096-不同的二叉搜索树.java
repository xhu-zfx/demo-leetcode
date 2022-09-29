//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
//
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树 👍 1947 👎 0

import java.util.HashMap;
import java.util.Map;

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-09-29 09:46:05
 * @description   
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    HashMap hashMap=new HashMap<Integer,Integer>();
    public int numTrees(int n) {
        if (n == 0 || n == 1) return 1;
        int count=0;
        if (hashMap.containsKey(n)) return (int) hashMap.get(n);
        for (int i = 1; i <= n; i++) {
            // 该点为根节点的二叉搜索树个数 = 左边二叉搜索树个数 * 右边二叉搜索树个数
            // 左边的都是从1开始小于i的，节点个数为i-1
            // 右边的都是从i+1开始小于n的，节点个数为n-i
            count += numTrees(i - 1) * numTrees(n - i);
        }
        hashMap.put(n,count);
        return count;

        // 解答成功:
        // 执行耗时:2566 ms,击败了5.01% 的Java用户
        // 内存消耗:38.3 MB,击败了53.41% 的Java用户
        // 做了很多重复计算，考虑优化
        // 将计算过的存入HashMap，再次遇到直接取出
    }
}
//leetcode submit region end(Prohibit modification and deletion)
