//给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。 
//
// 如果可以，返回 true ；否则返回 false 。 
//
// magazine 中的每个字符只能在 ransomNote 中使用一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：ransomNote = "a", magazine = "b"
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= ransomNote.length, magazine.length <= 10⁵ 
// ransomNote 和 magazine 由小写英文字母组成 
// 
//
// Related Topics 哈希表 字符串 计数 👍 484 👎 0

import java.util.HashMap;

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-09-17 10:45:27
 * @description   
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // magazine的长度小于ransomNote的话构成不了，返回false
        if (magazine.length()<ransomNote.length())
            return false;
        // 长度26的数组，存储每个字母的出现次数
        int[] cnt=new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c-'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            cnt[c-'a']--;
            // 出现次数为负数，即ransomNote该字母的个数已经超过了magazine该字母个数，故无法构成，返回false
            if (cnt[c-'a']<0) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
