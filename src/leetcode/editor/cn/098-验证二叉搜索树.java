//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。 
//
// 有效 二叉搜索树定义如下： 
//
// 
// 节点的左子树只包含 小于 当前节点的数。 
// 节点的右子树只包含 大于 当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [2,1,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [5,1,4,null,null,3,6]
//输出：false
//解释：根节点的值是 5 ，但是右子节点的值是 4 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在[1, 10⁴] 内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 1769 👎 0

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-10-07 09:49:07
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
     long pre=Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
//        if (root == null || (root.left == null && root.right == null)) return true;
//        if (root.left == null) return root.right.val > root.val;
//        if (root.right == null) return root.left.val < root.val;
//        return (root.left.val < root.val) && (root.right.val > root.val) && isValidBST(root.left) && isValidBST(root.right);
//        通过测试用例：
//        62 / 80
//        输入：
//        [5,4,6,null,null,3,7]
//        输出：
//        true
//        预期结果：
//        false

        // 中序遍历
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        if (root.val < pre) return false;
        pre = root.val;
        return isValidBST(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
