package work9;

import work5.string;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author:LXY
 * @className:str
 * @description:
 * @date:2021/3/2615:54
 * @version:0.1
 * @since:1.8
 */
public class str {
    public static void main(String[] args) {
        //控制台输入一个文件路径（例如：C:\hello\image\hello.jpg），]
        // 然后获得文件名（hello）和扩展名(jpg)
        // 注意双斜杠表示一个斜杠
        Scanner input=new Scanner(System.in);
        String str;
        String str1;
        String str2;
        String str3="^[\\w\\-]+\\:[\\w\\.\\\\\\-]+\\.[\\w]+";
        System.out.println("请输入文件路径：");
        str=input.next();
        int len=str.length();
        if(!Pattern.matches(str3,str)){
            System.out.println("请输入正确的路径");
            return;
        }
        str1=str.substring(str.lastIndexOf("\\")+1,str.lastIndexOf("."));
        System.out.println("文件名是："+str1);

        str2=str.substring(str.lastIndexOf('.')+1,len);
        System.out.println("拓展名是："+str2);
    }
}
