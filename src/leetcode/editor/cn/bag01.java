package src.leetcode.editor.cn;

/**
 * @author xhu-zfx
 * @email <756867768@qq.com>
 * @date 2022/10/10 21:22
 * @description
 */
import java.util.Scanner;
public class bag01{
    public static void main(String[] args){
        // 输入代码
        Scanner reader = new Scanner(System.in);
        // 输入物品数量
        int N = reader.nextInt();
        // 输入背包容积
        int V = reader.nextInt();
        // 输入物品体积与价值
        int[] volume= new int[N+1];
        int[] value= new int[N+1];
        for(int i = 1;i <= N;i++){
            volume[i] = reader.nextInt();
            value[i] = reader.nextInt();
        }
        // 核心代码
        int[][] maxValue=new int[N+1][V+1];
        maxValue[0][0] = 0;
        for(int i = 1; i <= N; i++){
            for(int j =1; j <= V; j++){
                if(j >= volume[i])
                    maxValue[i][j] = Math.max(maxValue[i - 1][j],maxValue[i-1][j - volume[i]] + value[i]);
                else
                    maxValue[i][j] = maxValue[i-1][j];
            }
        }
        System.out.println(maxValue[N][V]);
    }
}