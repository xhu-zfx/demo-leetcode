//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// Related Topics 数组 排序 👍 1733 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author  xhu-zfx
 * @email  <756867768@qq.com>
 * @date  2022-12-06 21:45:59
 * @description   
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        /*
        思路：
        1.先将数组根据开始区间排序，因为是二维数组，所以需要使用Comparator
        2.创建一个结果集
        3.遍历数组，遍历到当前数组时，用当前的左区间跟结果集的右区间进行比较，如果前者小于后者，则说明两个区间重叠，将两个数组合并
        3.1如果当前位置是第一个 或 当前数组的左区间大于结果集最后一个元素的右区间，则说明两区间不重合，可以在结果集中新增一个
        3.2如果当前数组的左区间 小于 结果集最后一个元素的右区间，则说明两个区间重叠，将两个数组合并
        */
        // 如果数组为空，直接返回
        if(intervals.length == 0)
            return new int[0][2];
        // 排序
        Arrays.sort(intervals,(v1,v2) -> {
            return v1[0] - v2[0];
        });
        List<int[]> merge = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0];
            int R = intervals[i][1];
            // 如果当前位置是第一个 或 当前数组的左区间大于结果集最后一个元素的右区间，则说明两区间不重合，可以在结果集中新增一个
            if (merge.size() == 0 || merge.get(merge.size() - 1)[1] < L){
                merge.add(new int[]{L,R});
            } else {
                // 如果当前数组的左区间 小于 结果集最后一个元素的右区间，则说明两个区间重叠，将两个数组合并
                merge.get(merge.size() - 1)[1] = Math.max(merge.get(merge.size() - 1)[1],R);
            }
        }
        return merge.toArray(new int[merge.size()][2]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
