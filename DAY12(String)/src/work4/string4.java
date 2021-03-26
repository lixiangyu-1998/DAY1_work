package work4;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author:LXY
 * @className:string4
 * @description:
 * @date:2021/3/2610:30
 * @version:0.1
 * @since:1.8
 */
public class string4 {
    public static void main(String[] args) {
        //4. 从控制台实现输入字符串（路径），分别把盘符，文件路径（不包含盘符），文件名，文件类型
        // 打出来如：E:\jboss-4.0.4.GA\server\minimal\conf\readme.txt 解析路径，输入 盘符，文件路径，文件名，文件类型。
        //	盘符：E:
        //	文件路径：jboss-4.0.4.GA\server\minimal\conf\
        //	文件名：readme
        //	文件类型：txt
        Scanner input=new Scanner(System.in);
        String str1;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6="^[\\w\\-]+\\:[\\w\\.\\\\\\-]+\\.[\\w]+";
        System.out.println("请输入文件路径：");
        str1=input.next();
        if(!Pattern.matches(str6,str1)){
            System.out.println("请输入正确的路径");
            return;
        }
        int len=str1.length();

        str2=str1.substring(0,str1.indexOf(':')+1);
        System.out.println("盘符："+str2);

        str3=str1.substring(str1.indexOf('\\'),str1.lastIndexOf('\\'));
        System.out.println("文件路径："+str3);

        str4=str1.substring(str1.lastIndexOf('\\')+1,str1.lastIndexOf('.'));
        System.out.println("文件名："+str4);

        str5=str1.substring(str1.lastIndexOf('.')+1,len);
        System.out.println("文件类型："+str5);

    }
}
