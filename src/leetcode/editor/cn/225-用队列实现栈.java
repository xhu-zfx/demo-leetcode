//请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。 
//
// 实现 MyStack 类： 
//
// 
// void push(int x) 将元素 x 压入栈顶。 
// int pop() 移除并返回栈顶元素。 
// int top() 返回栈顶元素。 
// boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。 
// 
//
// 
//
// 注意： 
//
// 
// 你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。 
// 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["MyStack", "push", "push", "top", "pop", "empty"]
//[[], [1], [2], [], [], []]
//输出：
//[null, null, null, 2, 2, false]
//
//解释：
//MyStack myStack = new MyStack();
//myStack.push(1);
//myStack.push(2);
//myStack.top(); // 返回 2
//myStack.pop(); // 返回 2
//myStack.empty(); // 返回 False
// 
//
// 
//
// 提示： 
//
// 
// 1 <= x <= 9 
// 最多调用100 次 push、pop、top 和 empty 
// 每次调用 pop 和 top 都保证栈不为空 
// 
//
// 
//
// 进阶：你能否仅用一个队列来实现栈。 
//
// Related Topics 栈 设计 队列 👍 576 👎 0

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-09-05 09:35:19
 * @description   入栈时,哪个不为空就入哪个队,都为空则随便都可以,以queue1为例
 * 出栈时,将非空队列出队,转移到另一个队列中,只留下一个,这个就是将要被出栈的元素
 */
//leetcode submit region begin(Prohibit modification and deletion)
class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        queue1=new LinkedList<Integer>();
        queue2=new LinkedList<Integer>();
    }
    
    public void push(int x) {
        if (!queue1.isEmpty()) queue1.offer(x);
        else queue2.offer(x);
    }
    
    public int pop() {
        if (!queue1.isEmpty()){
            while(queue1.size()>1){
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        } else if (!queue2.isEmpty()) {
            while (queue2.size()>1){
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }else return 0;
        // 因为每次调用 pop 和 top 都保证栈不为空,所以该处随便返回,不可能被执行到
    }
    
    public int top() {
        if (!queue1.isEmpty()){
            while(queue1.size()>1){
                queue2.offer(queue1.poll());
            }
            int var = queue1.poll();
            queue2.offer(var);
            return var;
        } else if (!queue2.isEmpty()) {
            while (queue2.size()>1){
                queue1.offer(queue2.poll());
            }
            int var = queue2.poll();
            queue1.offer(var);
            return var;
        }else return 0;
        // 因为每次调用 pop 和 top 都保证栈不为空,所以该处随便返回,不可能被执行到
    }
    
    public boolean empty() {
        return queue1.isEmpty()&&queue2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)
