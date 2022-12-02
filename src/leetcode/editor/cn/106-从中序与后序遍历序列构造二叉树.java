//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
//返回这颗 二叉树 。 
//
// 
//
// 示例 1: 
// 
// 
//输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//输出：[3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入：inorder = [-1], postorder = [-1]
//输出：[-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder 和 postorder 都由 不同 的值组成 
// postorder 中每一个值都在 inorder 中 
// inorder 保证是树的中序遍历 
// postorder 保证是树的后序遍历 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 876 👎 0

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-11-10 10:30:59
 * @description   
 */
//leetcode submit region begin(Prohibit modification and deletion)

import javax.swing.tree.TreeNode;

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeUtil(inorder,0,inorder.length,postorder,0,postorder.length);
    }

    private TreeNode buildTreeUtil(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd) {
        if (pStart == pEnd) return null;
        // 后序遍历的第一个节点即为整棵树的根节点
        int rootValue = postorder[pEnd];
        TreeNode root = new TreeNode(rootValue);
        // 在中序遍历中找到根节点的位置
        int rootIndex = 0;
        for (int i = iStart; i < iEnd; i++) {
            if (inorder[i] == rootValue){
                rootIndex = i;
                break;
            }
        }
        // 左子树的节点个数
        int leftCount = rootIndex - iStart;
        // 递归构建左子树
        root.left = buildTreeUtil(inorder,iStart,rootIndex,postorder,pStart,pStart + leftCount);
        // 递归构造右子树
        root.right = buildTreeUtil(inorder,rootIndex + 1,iEnd,postorder,pStart + leftCount,pEnd -1);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
