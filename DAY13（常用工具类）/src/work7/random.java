package work7;

import java.util.Scanner;

/**
 * @author:LXY
 * @className:random
 * @description:
 * @date:2021/3/2622:03
 * @version:0.1
 * @since:1.8
 */
public class random {
    public static void main(String[] args) {
        //7. 要求写一个工具类，
        // 可以自定义获取N个随机数字或字母（0~9,a~z,A~Z混合一起）
        Scanner input=new Scanner(System.in);
        int num=0;
        System.out.println("请输入想得到的随机符号数量：");
        num=input.nextInt();
        String str1="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuffer str2=new StringBuffer();
        StringBuffer str3=new StringBuffer();
        str2.append(str1);
        int len=str1.length();
        for(int index=0;index<num;index++){
            str3.append(str2.charAt((int)(Math.random()*len)));
        }
        System.out.println("取出的"+num+"位随机符号为："+str3);
    }
}
