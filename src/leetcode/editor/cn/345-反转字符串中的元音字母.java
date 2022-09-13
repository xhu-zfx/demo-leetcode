//给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。 
//
// 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 
//输入：s = "leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由 可打印的 ASCII 字符组成 
// 
//
// Related Topics 双指针 字符串 👍 263 👎 0

import java.util.Arrays;

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-09-13 10:59:24
 * @description   
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseVowels(String s) {
        int pre=0,end=s.length()-1;
        char[] chars = s.toCharArray();
        while (pre<end){
            while (pre<end&&!isVowel(chars[pre])) ++pre;
            while (end>pre&&!isVowel(chars[end])) --end;
            if (pre<end){
                char temp=chars[pre];
                chars[pre]=chars[end];
                chars[end]=temp;
                ++pre;--end;
            }
        }
        return new String(chars);
    }
    public boolean isVowel(char ch){
        return ch==65||ch==69||ch==73||ch==79
                ||ch==85||ch==97||ch==101||ch==105
                ||ch==111||ch==117;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
