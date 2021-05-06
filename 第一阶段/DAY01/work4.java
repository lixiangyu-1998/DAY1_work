/**
 * @author:LXY
 * @className:work4
 * @description:
 * @date:2021/3/1518:03
 * @version:0.1
 * @since:1.8
 */
//	4.自己给定5个整数，通过编程求出最大值(使用三元运算符)
public class work4 {
    public static void main(String [] strs){
        int a=100;
        int b=200;
        int c=114514;
        int d=1998;
        int f=999;
        int max1;
        int max2;
        int max3;
        int max4;
        max1=(a>=b)?a:b;
        max2=(max1>=c)?max1:c;
        max3=(max2>=d)?max2:d;
        max4=(max3>=f)?max3:f;
        System.out.println("最大值为"+max4);

    }
}
