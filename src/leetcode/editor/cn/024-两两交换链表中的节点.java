//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// Related Topics 递归 链表 👍 1588 👎 0

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-10-04 09:20:01
 * @description   
 */
//leetcode submit region begin(Prohibit modification and deletion)
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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode(0,head);
        ListNode index=dummy;
        while (index.next != null && index.next.next != null){
            // 需要改变三个指针
            // index.next、index.next.next、index.next.next.next
            ListNode nodeA = index.next;
            ListNode nodeB = index.next.next;
            index.next = nodeB;
            nodeA.next = nodeB.next;
            nodeB.next = nodeA;
            index=index.next.next;
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
