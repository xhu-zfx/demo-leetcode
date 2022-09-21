//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// Related Topics 数学 👍 3632 👎 0

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-09-21 10:22:31
 * @description   
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
//        // 是否为负
//        boolean flag=false;
//        String xString;
//        if (x<0){
//            flag=true ;
//            x*=-1;
//        }
//        StringBuffer stringBuffer=new StringBuffer();
//        // 数字部分翻转
//        String string = stringBuffer.append(x).reverse().toString();
//        if (Integer.parseInt(string)>Integer.MAX_VALUE||Integer.parseInt(string)<Integer.MIN_VALUE) return 0;
//        int parseInt = Integer.parseInt(string);
//        parseInt*=flag?-1:1;
//        // [−231, 231 − 1]
//        return parseInt;


//        1534236469
        int res=0;
        while (x!=0){
            int tmp=x%10;
            if (res > 214748364 || (res == 214748364 && tmp > 7))
                return 0;
            if (res < -214748364 || (res== -214748364 && tmp < -8 ))
                return 0;
            res=res*10+tmp;
            x/=10;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
