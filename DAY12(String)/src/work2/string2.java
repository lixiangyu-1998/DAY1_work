package work2;

import java.util.Scanner;

/**
 * @author:LXY
 * @className:string2
 * @description:
 * @date:2021/3/2522:13
 * @version:0.1
 * @since:1.8
 */
public class string2 {
    public static void main(String[] args) {
        int index;
        //2. 用户从控制台输入一个字符串，请判断是否为回文字符串。
        Scanner input=new Scanner(System.in);
        String str1;
        String str2;
        String str3;
        StringBuffer str4=new StringBuffer();
        System.out.println("请随意输入：");
        str1=input.next();
        int len=str1.length();
        if(len%2==0){
            index=len/2;
            str2=str1.substring(0,index);
            str3=str1.substring(index);
        }else{
            index=(len-1)/2;
            str2=str1.substring(0,index);
            str3=str1.substring(index+1);
        }
        str4.append(str3);
        str4=str4.reverse();
        str3=str4.toString();
        //str3=str3.;//反转
        if(str2.equals(str3)){
            System.out.println("输入的字符串是回文字符串："+str1);
        }else{
            System.out.println("输入的字符串不是回文字符串："+str1);
        }
        }

    }


