/**
 * @author:LXY
 * @className:work10
 * @description:
 * @date:2021/3/1620:36
 * @version:0.1
 * @since:1.8
 */
public class work10 {
    public static void main(String[] strs){

        //	循环输出以下结果
        // 2*5=10
        //4*10=40
        //6*15=90
        //?*100=?

        int a=2;
        int b=5;
        int product;
        for(;b<=100;){

            product=a*b;
            System.out.println(a+"*"+b+"="+product);
            a+=2;
            b+=5;

        }


    }
}
