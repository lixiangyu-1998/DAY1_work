/**
 * @author:LXY
 * @className:work7
 * @description:
 * @date:2021/3/1519:20
 * @version:0.1
 * @since:1.8
 */
//	6.定义一个变量，是一个三位数，求各个位数的和. 如：123，结果是1+2+3=6
public class work7 {
    public static void main(String[] strs){

        int a=666;
        int b;
        int c;
        int d;
        b=a/100;
        c=(a-b*100)/10;
        d=a-b*100-c*10;
        int e=b+c+d;
        System.out.println("各个位数的和是"+e);



    }
}
