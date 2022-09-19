//给定两个字符串 s 和 t ，它们只包含小写字母。 
//
// 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。 
//
// 请找出在 t 中被添加的字母。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcd", t = "abcde"
//输出："e"
//解释：'e' 是那个被添加的字母。
// 
//
// 示例 2： 
//
// 
//输入：s = "", t = "y"
//输出："y"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 1000 
// t.length == s.length + 1 
// s 和 t 只包含小写字母 
// 
//
// Related Topics 位运算 哈希表 字符串 排序 👍 349 👎 0

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-09-19 10:57:25
 * @description   
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char findTheDifference(String s, String t) {
        // 将s存入索引数组
        int[] arrs=new int[26];
        for (char c : s.toCharArray()) {
            arrs[c-'a']++;
        }
        // 遍历t，遇到就减一，如果为负数，则证明在t中该字符个数大于s中的，返回该字符
        for (char c : t.toCharArray()) {
            arrs[c-'a']--;
            if (arrs[c-'a']<0) return c;
        }
        return t.charAt(0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
