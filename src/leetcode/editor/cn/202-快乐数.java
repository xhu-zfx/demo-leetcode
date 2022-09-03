//编写一个算法来判断一个数 n 是不是快乐数。 
//
// 「快乐数」 定义为： 
//
// 
// 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。 
// 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。 
// 如果这个过程 结果为 1，那么这个数就是快乐数。 
// 
//
// 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 19
//输出：true
//解释：
//1² + 9² = 82
//8² + 2² = 68
//6² + 8² = 100
//1² + 0² + 0² = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
//
// Related Topics 哈希表 数学 双指针 👍 1056 👎 0

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-09-03 09:26:17
 * @description   
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isHappy(int n) {
//        int sum=0;
//        while(true){
//            while(n>0){
//                sum+=(n%10)*(n%10);
//                n/=10;
//            }
//            if (sum==1) return true;
//            else if (sum<=3){
//                return false;
//            }else {
//                n=sum;
//            }
//        }

//        我们的算法不可能是无限循环
//        所以思考：什么时候退出循环返回false呢
//        当 该次运算的结果 等于 前面某次运算的结果时
//        说明运算已经进入循环，不可能变成1了，此时返回false
//        快慢指针法求
        int slowNext=n;
        int fastNext=getNext(n);
        while(slowNext!=fastNext&&fastNext!=1){
            slowNext=getNext(slowNext);
            fastNext=getNext(getNext(fastNext));
        }
        return fastNext==1;
    }

    public int  getNext(int num){
        int res=0;
        while(num>0){
            res+=(num%10)*(num%10);
            num/=10;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
