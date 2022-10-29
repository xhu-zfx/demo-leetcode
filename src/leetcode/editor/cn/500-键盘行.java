//给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。 
//
// 美式键盘 中： 
//
// 
// 第一行由字符 "qwertyuiop" 组成。 
// 第二行由字符 "asdfghjkl" 组成。 
// 第三行由字符 "zxcvbnm" 组成。 
// 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["Hello","Alaska","Dad","Peace"]
//输出：["Alaska","Dad"]
// 
//
// 示例 2： 
//
// 
//输入：words = ["omk"]
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：words = ["adsdf","sfd"]
//输出：["adsdf","sfd"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 20 
// 1 <= words[i].length <= 100 
// words[i] 由英文字母（小写和大写字母）组成 
// 
//
// Related Topics 数组 哈希表 字符串 👍 223 👎 0

import java.util.*;

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-10-29 10:56:01
 * @description   
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] findWords(String[] words) {
        Set<Character> set1 = new HashSet<>();
        set1.add('q');set1.add('w');set1.add('e');set1.add('r');set1.add('t');set1.add('y');set1.add('u');set1.add('i');set1.add('o');set1.add('p');
        Set<Character> set2 = new HashSet<>();
        set2.add('a');set2.add('s');set2.add('d');set2.add('f');set2.add('g');set2.add('h');set2.add('j');set2.add('k');set2.add('l');
        Set<Character> set3 = new HashSet<>();
        set3.add('z');set3.add('x');set3.add('c');set3.add('v');set3.add('b');set3.add('n');set3.add('m');
        List<String> res = new ArrayList<>();
        for (String word : words) {
            StringBuffer regex = new StringBuffer();
            boolean flag = false;
            for (int i = 0; i < word.length(); i++) {
                if (set1.contains(word.charAt(i))) {
                    regex.append(1);
                    if (i > 0) flag = (regex.charAt(i - 1) == regex.charAt(i)) ? true : false;
                }
                else if (set2.contains(word.charAt(i))) {
                    regex.append(2);
                    if (i > 0) flag = (regex.charAt(i - 1) == regex.charAt(i)) ? true : false;
                }
                else if (set3.contains(word.charAt(i))) {
                    regex.append(3);
                    if (i > 0) flag = (regex.charAt(i - 1) == regex.charAt(i)) ? true : false;
                }
            }
            if (flag) res.add(word);
        }
        return res.toArray(new String[res.size()]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
