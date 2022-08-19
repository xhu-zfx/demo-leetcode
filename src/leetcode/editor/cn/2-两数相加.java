//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
//
// Related Topics 递归 链表 数学 👍 8495 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        long l1res = 0,l2res=0,res=0,index1=1,index2=1;
//        if (l1.next!=null){
//            l1res+=l1.val*index1;
//            l1=l1.next;
//            index1*=10;
//        }
//        if (l2.next!=null){
//            l2res+=l2.val*index2;
//            l2=l2.next;
//            index2*=10;
//        }
//        res=l1res+l2res;
//        // res=100009998
//        ListNode pre =new ListNode();
//        ListNode prej=pre;
//        int index;
//        if (res>=10){
//            prej.next=new ListNode((int)res%10);     //8
//            prej=prej.next;
//            res/=10;     //res=10000999
//        }
//        prej.next=new ListNode((int)res);

        //return pre.next;


//        ListNode dummyHead = new ListNode(-1), pre = dummyHead;
//        int t = 0;
//        while (l1 != null || l2 != null || t != 0) {
//            if (l1 != null) {
//                t += l1.val;
//                l1 = l1.next;
//            }
//            if (l2 != null) {
//                t += l2.val;
//                l2 = l2.next;
//            }
//            pre.next = new ListNode(t % 10);
//            pre = pre.next;
//            t /= 10;        //求商 , 供下一位进位使用
//        }
//
//        return dummyHead.next;


        ListNode dummy = new ListNode();//创建一个虚拟链表用于存放结果链表
        ListNode curr = dummy;//虚拟链表
        int carry = 0;//进位为0
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;//如果l1链表为0则为0，否则令x为当前l1链表位置上的具体数值
            int y = l2 == null ? 0 : l2.val;//同理

            int total = x + y + carry;//和为两个链表上的对应位置上的数相加再加上上一个传递下来的进位
            curr.next = new ListNode(total % 10);//求余，放在当前位置的下一链位
            curr = curr.next;
            carry = total / 10;//求商，作为进位供下一使用

            if (l1 != null) l1 = l1.next;//如果链表不为null，继续向下推进
            if (l2 != null) l2 = l2.next;//同理
        }
        if (carry != 0) curr.next = new ListNode(carry);
        return dummy.next;//返回所创建虚拟链表的下一位开始的链表
    }
}
//leetcode submit region end(Prohibit modification and deletion)


