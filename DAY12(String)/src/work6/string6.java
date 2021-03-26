package work6;

import java.util.Scanner;

/**
 * @author:LXY
 * @className:string6
 * @description:
 * @date:2021/3/2613:44
 * @version:0.1
 * @since:1.8
 */
public class string6 {
    public static void main(String[] args) {
        //6. 字符串反转。 举例：键盘录入”abc”		输出结果：”cba”
        StringBuffer str=new StringBuffer();
        String str1;
        Scanner input=new Scanner(System.in);
        System.out.println("请输入任意字符：");
        str1=input.next();
        str.append(str1);
        str.reverse();
        System.out.println("反转后的字符串为："+str.toString());
    }
}
