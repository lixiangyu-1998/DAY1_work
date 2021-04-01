import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:LXY
 * @className:work3
 * @description:
 * @date:2021/3/1721:55
 * @version:0.1
 * @since:1.8
 */
public class work3 {
    public static void main(String[] strs){

        //	声明一个int型的数组，循环接收8个学生的成绩，
        // 计算这8个学生的总分、平均分、最高分、最低分
        Scanner input=new Scanner(System.in);
        int[] score=new int[8];
        int len=score.length;
        System.out.print("请输入学生成绩");
        for (int index=0;index<len;index++){
            score[index]=input.nextInt();
        }
        int average=0;
        int sum=0;
        int a=0;
        for (int index=0;index<len;index++){
              a=score[index];
              sum+=a;
        }
        System.out.print("八个学生的总分为："+sum);
        average=sum/8;
        System.out.print("八个学生的平均分为："+average);
        Arrays.sort(score);
        System.out.print("学生的最高分为："+score[7]);
        System.out.print("学生的最低分为："+score[0]);
    }
}
