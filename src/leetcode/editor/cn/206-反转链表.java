//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
//
// Related Topics 递归 链表 👍 2739 👎 0

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-09-04 10:01:33
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
    public ListNode reverseList(ListNode head) {
//        存储上一个节点
        ListNode pre=null;
//        当前节点
        ListNode curr=head;
        while(curr!=null){
//            存储下一个节点
            ListNode next=curr.next;
//            将当前节点的下一个节点指向上一个节点
            curr.next=pre;
//            将该节点存储，用户后面做上一节点
            pre=curr;
//            下一个节点
            curr=next;
        }
//        当遍历完时，curr已经为null，此时pre为原链表的最后一个节点，即为翻转后的链表的头节点
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
