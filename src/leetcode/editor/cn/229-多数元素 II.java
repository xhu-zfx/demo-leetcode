//给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,3]
//输出：[3] 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,2]
//输出：[1,2] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。 
//
// Related Topics 数组 哈希表 计数 排序 👍 624 👎 0

import java.util.ArrayList;
import java.util.List;

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-09-01 10:52:35
 * @description   
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> majorityElement(int[] nums) {
//        出现超过1/3次 , 结果至多为两个元素
//        [3,2,3,4,2,3,2,5] 找出超过2次的元素 , 即出现3次及以上 , 说明其他无关元素最多为2个
        List<Integer> res =new ArrayList<>();
        int count1=0,count2=0,res1=0,res2=0;
        for (int num : nums) {
            if (res1==num) count1++;
            else if (res2==num) count2++;
            else if (count1 == 0){
                res1=num;
                count1=1;
            }
            else if (count2 == 0){
                res2=num;
                count2=1;
            }else {
                count1--;
                count2--;
            }
        }
//        res.add(count1);res.add(count2);
//        此时会默认存储两个元素 , 如果某个元素没有出现⌊ n/3 ⌋次的话也会被存入 , 故需要判断两个元素的出现次数

//        因为判断的时候
        int verifyCount1=0,verifyCount2=0;
        for (int num : nums) {
            if (num==res1) verifyCount1++;
            else if (num==res2) verifyCount2++;
        }
        if (verifyCount1>nums.length/3) res.add(res1);
        if (verifyCount2>nums.length/3) res.add(res2);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
