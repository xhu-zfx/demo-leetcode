//给定一个包含大写字母和小写字母的字符串
// s ，返回 通过这些字母构造成的 最长的回文串 。 
//
// 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入:s = "abccccdd"
//输出:7
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
//
// 示例 2: 
//
// 
//输入:s = "a"
//输入:1
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 2000 
// s 只由小写 和/或 大写英文字母组成 
// 
//
// Related Topics 贪心 哈希表 字符串 👍 465 👎 0

import java.util.HashMap;
import java.util.Map;

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-09-21 10:55:19
 * @description   
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindrome(String s) {
        // hash表
        HashMap<Character, Integer> hashMap = new HashMap<>();
        // 统计次数
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果map中没有此字符，则次数置为1
            if (!hashMap.containsKey(c)) {
                hashMap.put(c, 1);
            } else {
                // 如果map中有此字符，则次数增1
                Integer temNum = hashMap.get(c);
                temNum++;
                hashMap.put(c, temNum);
            }
        }
        int res=0,odd=0;
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            Integer count = entry.getValue();
            // 若为偶次，长度为出现次数
            // 若为奇次，长度为出现次数减去1
            res+=count-count%2;
            if (count%2==1) odd=1;
        }
        return res+odd;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
