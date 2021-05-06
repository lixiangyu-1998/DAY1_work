package work7;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author:LXY
 * @className:string7
 * @description:
 * @date:2021/3/2613:52
 * @version:0.1
 * @since:1.8
 */
public class string7 {
    public static void main(String[] args) {
        //7. 去掉一个字符串中的所有空格(包括中间的空格) 使用正则
        Scanner input=new Scanner(System.in);
        System.out.println("请随意输入字符串：");
        String str=input.nextLine();
       // String regex="^\\s+$";
       // Pattern p= Pattern.compile(regex);
        //Matcher m=p.matcher(str);
        System.out.println("去掉空格后："+str.replaceAll("\\s+",""));
    }
}
