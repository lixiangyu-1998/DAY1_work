/**
 * @author:LXY
 * @className:work11
 * @description:
 * @date:2021/3/1620:44
 * @version:0.1
 * @since:1.8
 */
public class work11 {
    public static void main(String[] strs){
        //	输出乘法口诀表
        int sum;
        for(int a=1;a<=9;){
            for(int b=1;b<=a;){
                sum=a*b;
                System.out.print(a+"*"+b+"="+sum);
                System.out.print(" ");
                b++;
            }
            System.out.println();
            a++;
        }


    }
}
