//给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数
//字，并以数组的形式返回结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,3,2,7,8,2,3,1]
//输出：[5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1]
//输出：[2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 10⁵ 
// 1 <= nums[i] <= n 
// 
//
// 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。 
//
// Related Topics 数组 哈希表 👍 1083 👎 0

import java.util.*;

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-09-23 10:47:22
 * @description   
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        // 存储num数组中的元素
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        // 遍历1-n
        for (int i = 1; i <= nums.length;i++){
            if (!set.contains(i)) res.add(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
