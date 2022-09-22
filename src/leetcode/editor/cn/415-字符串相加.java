//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。 
//
// 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。 
//
// 
//
// 示例 1： 
//
// 
//输入：num1 = "11", num2 = "123"
//输出："134"
// 
//
// 示例 2： 
//
// 
//输入：num1 = "456", num2 = "77"
//输出："533"
// 
//
// 示例 3： 
//
// 
//输入：num1 = "0", num2 = "0"
//输出："0"
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 10⁴ 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 
//
// Related Topics 数学 字符串 模拟 👍 620 👎 0

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-09-22 10:34:10
 * @description   
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String num1, String num2) {
//        int length1 = num1.length();
//        int length2 = num2.length();
//        int minLenth=length1<length2?length1:length2;
//        // 维护进位整数
//        int carry=0;
//        StringBuffer res=new StringBuffer("");
//        for (int i=minLenth-1;i>=0;--i){
//            int sum = Integer.parseInt(String.valueOf(num1.charAt(i))) + Integer.parseInt(String.valueOf(num2.charAt(i)));
//            // 只取和的个位数再加上进位的
//            res.insert(0,sum%10+carry);
//            // 和大于10，进一位，若小于10即不进位，置为0
//            carry=sum>=10?1:0;
//        }
//        if (length1 < length2){
//            res.insert(0,num2.substring(0,length2-length1-1));
//        } else if (length2 < length1) {
//            res.insert(0,num1.substring(0,length1-length2-1));
//        }
//        return res.toString();

        int len1=num1.length()-1,len2=num2.length()-1,carry=0;
        StringBuffer res=new StringBuffer("");
        while (len1>=0||len2>=0||carry!=0){
            int x=len1>=0?num1.charAt(len1)-'0':0;
            int y=len2>=0?num2.charAt(len2)-'0':0;
            int sum=x+y+carry;
            res.insert(0,sum%10);
            carry=sum/10;
            --len1;--len2;
        }
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
