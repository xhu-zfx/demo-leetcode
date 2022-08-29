//给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: rowIndex = 3
//输出: [1,3,3,1]
// 
//
// 示例 2: 
//
// 
//输入: rowIndex = 0
//输出: [1]
// 
//
// 示例 3: 
//
// 
//输入: rowIndex = 1
//输出: [1,1]
// 
//
// 
//
// 提示: 
//
// 
// 0 <= rowIndex <= 33 
// 
//
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？ 
//
// Related Topics 数组 动态规划 👍 423 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> lastRow=new ArrayList<>();
        List<Integer> thisRow=new ArrayList<>();
        lastRow.add(1);thisRow.add(1);
        if (rowIndex==0) return thisRow;
        for (int i=1;i<=rowIndex;i++){
            thisRow.clear();
//            进入该行 , 头尾都为1
            thisRow.add(1);
            for (int j=1;j<i;j++){
//                用上一行的数据
//                中间列为 上一行的该上一列 与 上一行的该列 相加
                thisRow.add(lastRow.get(j-1)+ lastRow.get(j));
            }
            thisRow.add(1);
//            保存改行数据 , 给下一行使用
            lastRow.clear();
            lastRow.addAll(thisRow);
        }
        return thisRow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
