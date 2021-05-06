package work11;

import java.util.Scanner;

/**
 * @author:LXY
 * @className:str
 * @description:
 * @date:2021/3/2617:02
 * @version:0.1
 * @since:1.8
 */
public class str {
    public static void main(String[] args) {
//11. 让用户在控制台输入几个文件名，
// 中间用“,”隔开，然后只把jpg文件换行输出来。
// 例如：hello.java,a.txt,x1.jpg,t1.ppt,m.jpg
        System.out.println("请输入几个文件名，中间用，号分割");
        String str1;
        StringBuffer str2=new StringBuffer();
        Scanner input=new Scanner(System.in);
        String str3;
        StringBuffer str4=new StringBuffer();
        str1=input.next();
        int len=str1.length();
        while (str1.indexOf("jpg")!=-1){
            if(str1.indexOf("jpg")!=-1){

                str2.append(str1);//转换类型方便操作
                str2.delete(str1.lastIndexOf(".jpg"),len);//删除最后一个 .jpg 及以后的
                str1=str2.toString();
                int len2=str1.length();
                str3=str2.substring(str1.lastIndexOf(',')+1,len2);
                str2.delete(0,len2);
                System.out.println("jpg文件名为："+str3);
            }else{
                return;
            }

        }
    }
}
