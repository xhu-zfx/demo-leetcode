//给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。 
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 
//
// 示例1: 
//
// 
//输入: pattern = "abba", s = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 
//输入:pattern = "abba", s = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 
//输入: pattern = "aaaa", s = "dog cat cat dog"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= pattern.length <= 300 
// pattern 只包含小写英文字母 
// 1 <= s.length <= 3000 
// s 只包含小写英文字母和 ' ' 
// s 不包含 任何前导或尾随对空格 
// s 中每个单词都被 单个空格 分隔 
// 
//
// Related Topics 哈希表 字符串 👍 497 👎 0

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-09-12 09:33:05
 * @description   
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] split = s.split(" ");
        if (pattern.length()!=split.length) return false;
        HashMap<Character, String> hashMap = new HashMap<>();
        for (int i = 0; i < split.length; i++) {
//            如果当前key有对应关系,比较
            if (hashMap.containsKey(pattern.charAt(i))){
                if (!hashMap.get(pattern.charAt(i)).equals(split[i]))
                    return false;
//            如果当前value有对应关系,直接返回false,
//            因为当前key没有对应关系,value有的话,就不是唯一对应了
            } else if (hashMap.containsValue(split[i])) {
                return false;
//            key和value都没有对应关系,则都是第一次出现,存入
            } else {
                hashMap.put(pattern.charAt(i),split[i]);
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
