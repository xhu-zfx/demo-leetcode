//给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。 
//
// 例如： 
//
// 
//A -> 1
//B -> 2
//C -> 3
//...
//Z -> 26
//AA -> 27
//AB -> 28 
//...
// 
//
// 
//
// 示例 1： 
//
// 
//输入：columnNumber = 1
//输出："A"
// 
//
// 示例 2： 
//
// 
//输入：columnNumber = 28
//输出："AB"
// 
//
// 示例 3： 
//
// 
//输入：columnNumber = 701
//输出："ZY"
// 
//
// 示例 4： 
//
// 
//输入：columnNumber = 2147483647
//输出："FXSHRXW"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= columnNumber <= 2³¹ - 1 
// 
//
// Related Topics 数学 字符串 👍 552 👎 0

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-08-31 10:17:05
 * @description   
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convertToTitle(int columnNumber) {
        String res="";
        while(columnNumber>0){
//            当余数为 0时 ,为 Z
//            所以要从A开始即从65开始
            columnNumber--;
            int size=columnNumber%26;
            columnNumber/=26;
            Character pre = (char) (size+65);
            res=pre.toString()+res;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
