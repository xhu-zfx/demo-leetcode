//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] 为 '(' 或 ')' 
// 
//
// Related Topics 栈 字符串 动态规划 👍 2042 👎 0


import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-10-16 10:30:30
 * @description   
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        // 碰到左括号，入栈
        // 碰到右括号，判断栈顶是否为左括号，是的话将count+2，无则若count大于max将count给max，再将count置为0
//        Stack stack = new Stack<>();
//        int count = 0,max = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(') stack.push(s.charAt(i));
//            else if (!stack.isEmpty()){
//                if (stack.peek().equals('(')) {
//                    stack.pop();
//                    count += 2;
//                }
//                else {
//                    max = Math.max(count,max);
//                    count = 0;
//                }
//            }
//        }
//        return max;
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
