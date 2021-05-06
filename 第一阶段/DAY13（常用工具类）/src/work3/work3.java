package work3;

import java.util.Scanner;

/**
 * @author:LXY
 * @className:work3
 * @description:
 * @date:2021/3/2620:18
 * @version:0.1
 * @since:1.8
 */
public class work3 {
    public static void main(String[] args) {
        //3. 从命令行输入一个字符串！
        // 要求从中随机选择6个字符组成验证码！
        String str1;
        StringBuffer str2=new StringBuffer();
        StringBuffer str3=new StringBuffer();
        Scanner input=new Scanner(System.in);
        System.out.println("请任意输入字符串：");
        str1=input.next();
        str2.append(str1);
        int num=0;
        int len=str1.length();
        for(int index=0;index<6;index++){
            num=(int)(Math.random()*len);
            str3.append(str2.charAt(num));
        }
        System.out.println("验证码是："+str3);
    }
}
