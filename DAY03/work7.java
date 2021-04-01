import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:LXY
 * @className:work7
 * @description:
 * @date:2021/3/1814:03
 * @version:0.1
 * @since:1.8
 */
public class work7 {
    public static void main(String[] strs){
        //	从键盘接受10个整数保存在数组中，将10个数中最大的与第一个元素交换，
        // 最小的与最后一个元素交换，其余元素位置不变，输出数组元素的值
        Scanner input=new Scanner(System.in);
        int[] num=new int[10];

        int count1=0;
        int count2=0;
        System.out.print("请输入十个数字：");
        for(int index=0;index<10;index++){
            num[index]=input.nextInt();
        }
        int min=num[0];
        int max=num[0];
        for(int index=0;index<10;index++){
            if(min>num[index]){
                min=num[index];//找出最小的数
                count1=index;//记录最小的数的位置
            }
            if(max<num[index]){
                max=num[index];//找大
                count2=index;//记录大位置
            }
            //min=(num[index]>min)?min:num[index];
        }
        num[count1]=num[9];
        num[count2]=num[0];
        num[0]=max;//大数给第一个
        num[9]=min;//小数给第二个
             System.out.print(Arrays.toString(num));
    }
}
