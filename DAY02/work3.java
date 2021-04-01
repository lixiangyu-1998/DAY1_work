import java.awt.peer.SystemTrayPeer;
import java.util.Scanner;

/**
 * @author:LXY
 * @className:work3
 * @description:
 * @date:2021/3/1616:34
 * @version:0.1
 * @since:1.8
 */
public class work3 {
    public static void main(String[] strs){
        //	求1到n之间所有能被3整除的整数个数，以及整除的整数和

        Scanner input=new Scanner(System.in);
        System.out.println("请输入n的值");
        int n=input.nextInt();
        int sum=0;
        int num2=0;
        for(int num=1;num<=n;){
            if(num%3==0){
                num2++;
                sum+=num;

            }
            num++;
        }

        System.out.println("能被3整除的整数个数为"+num2);
        System.out.println("能整除的整数和为"+sum);
    }
}
