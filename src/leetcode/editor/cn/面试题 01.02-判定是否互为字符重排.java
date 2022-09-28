//给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。 
//
// 示例 1： 
//
// 输入: s1 = "abc", s2 = "bca"
//输出: true 
// 
//
// 示例 2： 
//
// 输入: s1 = "abc", s2 = "bad"
//输出: false
// 
//
// 说明： 
//
// 
// 0 <= len(s1) <= 100 
// 0 <= len(s2) <= 100 
// 
//
// Related Topics 哈希表 字符串 排序 👍 102 👎 0

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-09-27 10:17:16
 * @description   
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        // 转化为数组
        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        for (int i = 0 ; i < s1.length() ; i++){
            if (array1[i] != array2[i]) return false;
        }
        return true;
        // HashMap
//        Map<String,Integer> hashMap=new HashMap<>();
//        for (int i=0 ; i < s1.length() ; i++){
//            hashMap.put(s1.charAt(i),)
//        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
