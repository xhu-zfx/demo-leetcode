//给你一个链表的头节点 head ，判断链表中是否有环。 
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到
//链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。 
//
// 如果链表中存在环 ，则返回 true 。 否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 10⁴] 
// -10⁵ <= Node.val <= 10⁵ 
// pos 为 -1 或者链表中的一个 有效索引 。 
// 
//
// 
//
// 进阶：你能用 O(1)（即，常量）内存解决此问题吗？ 
//
// Related Topics 哈希表 链表 双指针 👍 1599 👎 0

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-08-30 10:38:41
 * @description
 * 本方法需要读者对「Floyd 判圈算法」（又称龟兔赛跑算法）有所了解。
 *
 * 假想「乌龟」和「兔子」在链表上移动，「兔子」跑得快，「乌龟」跑得慢。
 * 当「乌龟」和「兔子」从链表上的同一个节点开始移动时，如果该链表中没有环，那么「兔子」将一直处于「乌龟」的前方；
 * 如果该链表中有环，那么「兔子」会先于「乌龟」进入环，并且一直在环内移动。
 * 等到「乌龟」进入环时，由于「兔子」的速度快，它一定会在某个时刻与乌龟相遇，即套了「乌龟」若干圈。
 *
 */
//leetcode submit region begin(Prohibit modification and deletion)


 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }

public class Solution {
    public boolean hasCycle(ListNode head) {
//        if(head==null||head.next==null) return false;
//        ListNode slow=head,fast=head;
//        do {
//            if (fast==null||fast.next==null) return false;
//            slow=slow.next;
//            fast=fast.next.next;
//        }while(fast==slow);
//        return true;
        if (head==null||head.next==null) return false;
        ListNode slow=head,fast=head.next;
        while(slow!=fast){
            if (fast==null||fast.next==null) return false;
            slow=slow.next;
            fast=fast.next.next;
        }
        return true;
//        if (head == null || head.next == null) {
//            return false;
//        }
//        ListNode slow = head;
//        ListNode fast = head.next;
//        while (slow != fast) {
//            if (fast == null || fast.next == null) {
//                return false;
//            }
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
