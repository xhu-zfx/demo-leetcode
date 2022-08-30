//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
//
// Related Topics 位运算 数组 👍 2546 👎 0

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-08-30 10:28:40
 * @description   
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
/**
 * 异或运算
 * 因为除了要返回的结果, 所有数字都出现了两次,
 * 经过异或运算 , 出现两次的数字的就会为0,
 * 所以数组异或运算结果, 即为要找的数字
 */
        int single=0;
        for (int num:nums){
            single^=num;
        }
        return single;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
