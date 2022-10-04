//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
//
// Related Topics 递归 链表 👍 2630 👎 0


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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 递归
//        if (list1 == null) {
//            return list2;
//        } else if (list2 == null) {
//            return list1;
//        } else if (list1.val< list2.val){
//            list1.next=mergeTwoLists(list1.next,list2);
//            return list1;
//        }else {
//            list2.next=mergeTwoLists(list1,list2.next);
//            return list2;
//        }

        // 迭代
        if (list1 == null || list2 == null) return list1 != null ? list1 : list2;
        ListNode head=new ListNode(0);
        ListNode tail = head, aPtr = list1, bPtr = list2;
        while (aPtr != null && bPtr != null){
            if (aPtr.val < bPtr.val){
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
