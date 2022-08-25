//给定一个已排序的链表的头
// head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,1,2]
//输出：[1,2]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
//
// Related Topics 链表 👍 842 👎 0


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
    public ListNode deleteDuplicates(ListNode head) {

//        错误法 1
//        初次想的是不开新链表 , 直接使用head
//        代码如下
//        运行后发现head指向最后一位
//        因为用处理时head用于遍历链表
//        处理完后head已经指向链表尾部

//        while(head.next!=null){
//            if(head.val==head.next.val){
//                head.next=head.next.next;
//            }else {
//                head=head.next;
//            }
//        }
//        return head;


//        if (head==null) {
//            return head;
//        }
//        ListNode res=head;
//        while(res.next!=null){
//            if(res.val==res.next.val){
//                res.next=res.next.next;
//            }else {
//                res=res.next;
//            }
//        }
//        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
