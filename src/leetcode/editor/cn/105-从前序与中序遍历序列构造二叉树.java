//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
// 
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1788 👎 0

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-11-08 10:17:33
 * @description   
 */
//leetcode submit region begin(Prohibit modification and deletion)
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeUtil(preorder,0,preorder.length,inorder,0,inorder.length);
    }
    TreeNode buildTreeUtil (int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd){
        if (pStart == pEnd) return null;
        // 先序遍历的第一个即为根节点
        int rootValue = preorder[pStart];
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
        // 递归构造左子树
        root.left = buildTreeUtil(preorder,pStart + 1,pStart + 1 + leftCount,inorder,iStart,rootIndex);
        // 递归构造右子树
        root.right = buildTreeUtil(preorder,pStart + leftCount + 1,pEnd,inorder,rootIndex + 1,iEnd);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
