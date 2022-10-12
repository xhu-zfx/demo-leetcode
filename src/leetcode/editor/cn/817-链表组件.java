//给定链表头结点 head，该链表上的每个结点都有一个 唯一的整型值 。同时给定列表 nums，该列表是上述链表中整型值的一个子集。 
//
// 返回列表 nums 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 nums 中）构成的集合。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: head = [0,1,2,3], nums = [0,1,3]
//输出: 2
//解释: 链表中,0 和 1 是相连接的，且 nums 中不包含 2，所以 [0, 1] 是 nums 的一个组件，同理 [3] 也是一个组件，故返回 2。 
//
//
// 示例 2： 
//
// 
//
// 
//输入: head = [0,1,2,3,4], nums = [0,3,1,4]
//输出: 2
//解释: 链表中，0 和 1 是相连接的，3 和 4 是相连接的，所以 [0, 1] 和 [3, 4] 是两个组件，故返回 2。 
//
// 
//
// 提示： 
//
// 
// 链表中节点数为n 
// 1 <= n <= 10⁴ 
// 0 <= Node.val < n 
// Node.val 中所有值 不同 
// 1 <= nums.length <= n 
// 0 <= nums[i] < n 
// nums 中所有值 不同 
// 
//
// Related Topics 数组 哈希表 链表 👍 136 👎 0

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-10-12 10:41:36
 * @description   
 */
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 */
 public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public int numComponents(ListNode head, int[] nums) {
        // 理解题意：组件为连续值的集合，这个链表中有几个组件，即这个链表被分为几部分不连续的值
        // 我们怎么才能确认该店是否为'组件起点'
        // 最初想的是这个点的value不在nums中，就将结果+1，但是当多个连续的head都不在nums中时，解答错误
        // 所以仅考虑当前节点时不可行的
        // 创建boolean对象 lastNodeInSet 存储上一节点是否在nums中
        // 上一个节点不在nums中，且当前节点在nums中，才能确认当前节点为'组件起点'，
        // 并将lastNodeInSet设为true，表示该节点在nums中，供下一节点使用
        Set hashSet = new HashSet<Integer>();
        // 将nums存入set
        for (int num : nums) {
            hashSet.add(num);
        }
        int res = 0;
        boolean lastNodeInSet = false;
        // 遍历链表
        while(head != null){
            if (hashSet.contains(head.val)){
                // 上一个节点不在Set中
                if (!lastNodeInSet){
                    res++;
                    // 当前节点在Set中，保存，给下一节点用
                    lastNodeInSet = true;
                }
            } else {
                lastNodeInSet = false;
            }
            head = head.next;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
