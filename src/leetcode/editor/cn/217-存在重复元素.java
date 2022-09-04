//给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1]
//输出：true 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：false 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,1,3,3,4,3,2,4,2]
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 排序 👍 806 👎 0

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.IntStream;

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-09-04 10:34:49
 * @description   
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsDuplicate(int[] nums) {
//        HashSet不允许存储重复值
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (!hashSet.add(num)) return true;
        }
        return false;

//        转化为数组，再排序，相邻元素相等就返回true

    }
}
//leetcode submit region end(Prohibit modification and deletion)
