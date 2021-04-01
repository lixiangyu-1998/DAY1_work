import java.util.Scanner;

/**
 * @author:LXY
 * @className:work2
 * @description:
 * @date:2021/3/1616:22
 * @version:0.1
 * @since:1.8
 */
public class work2 {
    public static void main(String[] strs){

        //	请使用条件结构/三元运算符求3个数的最值

        Scanner a=new Scanner(System.in);

        System.out.println("请输入3个数");
        int d=a.nextInt();
        int e=a.nextInt();
        int f=a.nextInt();
        if(d>e){
            if(d>f){

                System.out.println("最大值为"+d);
            }else{

                System.out.println("最大值为"+f);
            }

        }else{
            if(e>f){
                System.out.println("最大值为"+e);
            }else{

                System.out.println("最大值为"+f);
            }

        }
    }
}
