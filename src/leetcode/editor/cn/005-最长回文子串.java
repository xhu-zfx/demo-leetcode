//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 5697 👎 0

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-09-14 10:47:32
 * @description   
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        // 中心扩散法
        // s为空直接返回
        if (s == null || s.length()==0) return "";
        int strLen=s.length();
        // 维护最大回文串长度
        int maxLen=0;
        // 维护该回文串起始位置索引
        int maxStart=0;
        for (int i = 0; i < strLen; i++) {
            // 维护当前回文串长度
            int len=1;
            // 选中一个点，以它为中心向左右扩散，分别维护左右索引
            int left=i-1;int right=i+1;
            // 如果左边的值等于它，则向左扩散，回文长度+1
            while (left>=0&&s.charAt(left)==s.charAt(i)){
                ++len;--left;
            }
            // 如果右边的值等于它，则向右扩散，回文长度+1
            while (right<strLen&&s.charAt(right)==s.charAt(i)){
                ++len;++right;
            }
            // 如果左右值相等，则同时左右扩散，回文长度+2
            while (left>=0&&right<strLen&&s.charAt(left)==s.charAt(right)){
                len+=2;--left;++right;
            }
            // 如果该回文串大于之前的最大长度，当前的 left+1 即为起始位置索引，当前长度即为最大长度
            if (len > maxLen){
                maxStart=left+1;
                maxLen=len;
            }
        }
        return s.substring(maxStart,maxStart+maxLen);


        /*动态规划，
        if (s == null || s.length() < 2) {
            return s;
        }
        int strLen = s.length();
        int maxStart = 0;  //最长回文串的起点
        int maxEnd = 0;    //最长回文串的终点
        int maxLen = 1;  //最长回文串的长度

        boolean[][] dp = new boolean[strLen][strLen];

        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;

                    }
                }

            }

        }
        return s.substring(maxStart, maxEnd + 1);
         */
    }
}
//leetcode submit region end(Prohibit modification and deletion)
