//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。 
//
// 叶子节点 是指没有子节点的节点。 
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
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点总数在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
//
// Related Topics 树 深度优先搜索 回溯 二叉树 👍 853 👎 0

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-10-13 11:28:13
 * @description   
 */
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 */
 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

class Solution {
    // 定义返回对象
    List<List<Integer>> res = new LinkedList<List<Integer>>();
    // 定义路径对象，考虑定义成什么数据结构?
    // 我们在获取到当前节点值时需要将其放入，在使用完毕时要将其移除
    // List：移除元素时只能根据index，我们不知道当前元素的索引
    // Queue：只能移除队头的元素，即最早进的元素，我们需要移除当前元素，即最晚进入的元素
    // 所以考虑栈Deque
    Deque<Integer> path = new LinkedList<Integer>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root,targetSum);
        return res;
    }
    public void dfs(TreeNode root, int targetSum){
        if(root == null) return ;
        path.offerLast(root.val);
        targetSum -= root.val;
        // 叶子节点且targetSum=0
        if(root.left == null && root.right == null && targetSum == 0) res.add(new LinkedList<Integer>(path));
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        path.removeLast();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
