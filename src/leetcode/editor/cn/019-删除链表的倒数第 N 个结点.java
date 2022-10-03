//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// Related Topics 链表 双指针 👍 2244 👎 0

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-10-03 10:51:51
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*
        // 两次遍历
        ListNode tempCount = head;
        int length = 1;
        while (tempCount.next != null){
            tempCount = tempCount.next;
            length++;
        }
        // 删除头节点
        if (length == n) return head.next;
        int index = 1;
        ListNode temp = head;
        while (index < length - n){
            temp = temp.next;
            index++;
        }
        // head只有一个元素，且n=1
        if (temp.next == null){
            return null;
        } else if (temp.next.next == null) {
            temp.next = null;
        } else {
            temp.next = temp.next.next;
        }
        return head;
        */

        // 双指针：p指针比指针p提前n个节点，当p到末尾时，q的next即为要删除的节点
        if (head.next == null) return null;
        ListNode p = head,res = new ListNode(0,head);
        ListNode q = res;
        // 将p置于第n个节点上
        for (int i = 0; i < n; i++) {
            p = p.next;
        }
        while (p.next != null){
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return res.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
