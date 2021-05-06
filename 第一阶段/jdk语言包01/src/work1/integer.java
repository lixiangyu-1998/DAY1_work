package work1;

import java.util.Scanner;

/**
 * @author:LXY
 * @className:integer
 * @description:
 * @date:2021/3/2912:12
 * @version:0.1
 * @since:1.8
 */
public class integer {
    public static void main(String[] args) {
        //1. 不利用Integer.parseInt()方法将一个给定的字符串转变为Int型数值,
        // 并检测自己实现的方法和Integer.parseInt()的性能差距。
        String str;
        Scanner input=new Scanner(System.in);
        System.out.println("请输入任意数字");
        str=input.next();
        int len=str.length();
        char ch;
        int sum=0;
        boolean sign=true;
        int num;
        ch=str.charAt(0);
        if(ch=='+'){
            sign=true;
        }else if(ch=='-'){
            sign=false;
        }else if(ch<48||ch>57){
            System.out.println("请输入纯数字");
        }
        for(int index=1;index<len;index++){
                     ch=str.charAt(index);
            if(ch<48||ch>57){
                System.out.println("请输入纯数字");
            }
                     num=ch-48;
                     sum=sum*10+num;
        }
        if(sign){
            System.out.println(sum);
        }else{
                System.out.println(-sum);
    }
    }
}
