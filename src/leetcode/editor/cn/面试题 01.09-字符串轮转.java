//字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。 
//
// 示例1: 
//
//  输入：s1 = "waterbottle", s2 = "erbottlewat"
// 输出：True
// 
//
// 示例2: 
//
//  输入：s1 = "aa", s2 = "aba"
// 输出：False
// 
//
// 
// 
//
// 提示： 
//
// 
// 字符串长度在[0, 100000]范围内。 
// 
//
// 说明: 
//
// 
// 你能只调用一次检查子串的方法吗？ 
// 
//
// Related Topics 字符串 字符串匹配 👍 153 👎 0

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-09-29 09:08:04
 * @description   
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isFlipedString(String s1, String s2) {
        // 旋转字符串相当于，固定若干个字符s，将s前面的与后面的交换顺序
        // 所以我们可以使用s1+s1得到一个父字符串，s1旋转后的字符串都是这这个父字符串的子字符串
        return (s1.length() == s2.length()) && (s1 + s1).contains(s2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
