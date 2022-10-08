//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 2139 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-10-08 10:39:46
 * @description   
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    String[] letterMap = {" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<>();
        letterCombinationsUtil(digits,new StringBuffer(),0);
        return res;
    }
    List<String> res = new ArrayList<>();
    private void letterCombinationsUtil(String str, StringBuffer stringBuffer, int index) {
        if (index == str.length()){
            res.add(stringBuffer.toString());
            return;
        }
        char c = str.charAt(index);
        String thisStr=letterMap[c-'0'];    // eg:thisStr="abc"
        // 分别对abc遍历str的其他字符串
        for (int i = 0; i < thisStr.length(); i++) {
            // 先将a添加进来
            stringBuffer.append(thisStr.charAt(i));
            // 递归str的其他字符串
            letterCombinationsUtil(str,stringBuffer,index+1);
            // 递归完成，stringBuffer依然保留着前面append的字符，先将其删除
            // 比如当前stringBuffer="ad"，已经退出递归，此时需要遍历e字符，需要先将d删除，不然会一直变长
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
