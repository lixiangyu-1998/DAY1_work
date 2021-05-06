import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:LXY
 * @className:work1
 * @description:
 * @date:2021/3/1721:01
 * @version:0.1
 * @since:1.8
 */
public class work1 {
    public static void main(String[] strs){
        //	在歌唱比赛中，共有10位评委进行打分，在计算歌手得分时，去掉一个最高分，
        //	去掉一个最低分，然后剩余的8位评委的分数进行平均，就是该选手的最终得分。
        //	输入每个评委的评分，求某选手的得分
        Scanner input=new Scanner(System.in);
        int[] score=new int[10];
        System.out.println("请评委依次输入分数");
        int len=score.length;
        for(int index=0;index<len;index++){//遍历取值
            score[index]=input.nextInt();
        }
        Arrays.sort(score);//排序
        score[0]=0;//去掉最大最小值
        score[9]=0;
        int sum=0;
        int sum1=0;
         for(int index=0;index<len;index++){
            sum=score[index];
            sum1+=sum;
          }
          sum1/=8;
          System.out.println("选手的最终得分是"+sum1);


    }
}
