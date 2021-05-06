import java.util.Scanner;

/**
 * @author:LXY
 * @className:work1
 * @description:
 * @date:2021/3/1616:04
 * @version:0.1
 * @since:1.8
 */
public class work1 {

    //	 要求用户输入两个数a、b，如果a能被b整除或a加b大于1000，则输出a，否则输出b

    public static void main(String[] strs){
        System.out.println("请用户输入两个数");
        Scanner a=new Scanner (System.in);
        Scanner b=new Scanner (System.in);
        int c=a.nextInt();
        int d=b.nextInt();
        if(c%d==0||(c+d)>1000){
            System.out.println(c);
            return;

        }
        System.out.println(d);


    }
}
