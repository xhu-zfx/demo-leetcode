//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 2886 👎 0

import java.util.ArrayList;
import java.util.List;

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-09-30 09:58:32
 * @description   
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> res=new ArrayList<>();
    public void recursion(int left,int right,int level,String str){
        // 递归所有结果
        if (level == 0){
            res.add(str);
            return;
        }
        if (left > 0)
        recursion(left - 1, right, level - 1, str + "(");
        if (left < right)
        recursion(left, right - 1, level - 1, str + ")");
        // 排去不符合题意的结果
        // 1. 想加入左括号的条件：左括号的余量 > 0
        // 2. 想加入右括号的条件：左括号的余量小于右括号的余量，即此时已经加入的左括号数量大于已经加入的右括号数量
    }
    public List<String> generateParenthesis(int n) {
        recursion(n, n, 2 * n, "");
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
