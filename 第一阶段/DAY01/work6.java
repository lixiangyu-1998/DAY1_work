/**
 * @author:LXY
 * @className:work6
 * @description:
 * @date:2021/3/1519:15
 * @version:0.1
 * @since:1.8
 */
//	5.变量a和b的值互换  例如：int a = 10,b=20;  结果：a=20,b=10;
public class work6 {
    public static void main(String[] strs){

        int a=10;
        int b=20;
        int c;
        c=a;
        a=b;
        b=c;
        System.out.println("a="+a);
        System.out.println("b="+b);
    }
}
