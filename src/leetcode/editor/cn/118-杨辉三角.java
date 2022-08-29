//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 
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
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
//
// Related Topics 数组 动态规划 👍 827 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resList =new ArrayList<>();
//        第一行
        List<Integer> firstList=new ArrayList<>();
        firstList.add(1);
        resList.add(firstList);
//        第二行开始
        for (int i=1;i<numRows;i++){
            List<Integer> rowList=new ArrayList<>();
//            第一列
            rowList.add(1);
//            中间列为 上一行的该上一列 与 上一行的该列 相加
            for (int j=1;j<i;j++){
//                i=2,j=1
                rowList.add(resList.get(i-1).get(j-1)+resList.get(i-1).get(j));
            }
//            最后一列
            rowList.add(1);
//            将这一行存入
            resList.add(rowList);
        }
        return resList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
