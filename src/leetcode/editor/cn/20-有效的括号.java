//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 3452 👎 0


import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        int n=s.length();
        if (n%2==1) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        map.put('}','{');map.put(']','[');map.put(')','(');
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<s.length();i++){

            Character st=s.charAt(i);
//            只有右符号 即 map中的key,才可能匹配
            if (map.containsKey(st)){
                if (stack.empty()||stack.peek()!=map.get(st)){
//   此时栈顶元素必为左符号 , map.get是根据key获取value , 右符号为key , 获取它的value即为左符号 , 如果相等 ,则匹配
//   此时该元素为右符号 , 且如果栈为空 , 则匹配失败
                    return false;
                }else {
//                 如果匹配 , 则将左符号出战 , 匹配成功
                    stack.pop();
                }
            }else {
//             如果是左符号 , 则直接入栈 , 因为经过上面的流程后 , 栈中只能有左符号或者栈为空
                stack.push(st);
            }

        }
//        经过流程后 , 如果栈不为空 , 则匹配失败
        return stack.empty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
