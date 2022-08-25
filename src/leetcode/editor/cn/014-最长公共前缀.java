//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 👍 2409 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String maxpre="",shortstring="";
//        strs = ["flower","flow","flight"]
//        strs[0]="flower"    strs[1]="flow"   strs[2]="flight"

//        拿第一个字符串跟其他所有的比较即可

//        str0从第一个前缀开始
        for (int i=0;i<strs[0].length();i++){
//            确定某位数，比较从第二个其他strs
            for (int j=1 ;j<strs.length;j++){
                if (strs[j].length()<=i) return maxpre;
                if (strs[0].charAt(i)!=strs[j].charAt(i)){
                    return maxpre;
                }
            }
            maxpre+=strs[0].charAt(i);
        }
        return maxpre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
