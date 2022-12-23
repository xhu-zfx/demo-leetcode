//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
//
// Related Topics 位运算 数组 回溯 👍 1878 👎 0

import java.util.ArrayList;
import java.util.List;

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-12-23 12:18:29
 * @description   
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> init = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        process(nums,0);
        return res;
    }
    void process(int[] nums,int start){
        res.add(new ArrayList<>(init));
        for (int i = start; i < nums.length; i++) {
            init.add(nums[i]);
            process(nums,i + 1);
            init.remove(init.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
