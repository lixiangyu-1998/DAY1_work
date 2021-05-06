package work6;

import lombok.ToString;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:LXY
 * @className:io6
 * @description:
 * @date:2021/4/116:33
 * @version:0.1
 * @since:1.8
 */
public class io6 {
    public static void main(String[] args){
        //6. 已知文件a.txt文件中的内容为“AAbcdea22dferwplkCC321ou1”,请编写程序读取该文件内容，
        // (区分大小写字母)并按照自然排序顺序后输出到b.txt文件中。
        // 即b.txt文件内容应为”123ACabcdefklopruw”这样的顺序输出。
        FileOutputStream fos=null;
        FileInputStream fis=null;
        FileReader fr=null;

        try {
            File f1=new File("D:\\file1\\a.txt");
            File f2=new File("D:\\file1\\b.txt");
            fr=new FileReader(f1);
            fis=new FileInputStream(f1);
            int n;
            char[] c=new char[25];
            fr.read(c);
//        byte[] b=new byte[20];
//        fis.read(b);
//        System.out.println(Arrays.toString(b));
            //System.out.println(Arrays.toString(c));
            StringBuilder sb=new StringBuilder();
            sb.append(c);
            int a=sb.length();
            for(int index=0;index<a;index++){
                if(index+1==a){
                    break;
                }
                String str= String.valueOf(sb.charAt(index));//遍历元素
               // while (sb.indexOf(str,index)!=sb.lastIndexOf(str)){

                    while((n=sb.indexOf(str,index+1))!=-1){//查询有无重复
                        sb.deleteCharAt(n);
                        a--;
                        //System.out.println(sb);
                    }
               // }
            }
            String str2=sb.toString();
            byte[] b=str2.getBytes();
            //c=str2.toCharArray();
            Arrays.sort(c);
            //System.out.println(c);
            fos=new FileOutputStream(f2);
            fos.flush();//将之前在流中的数据冲刷出去
            fos.write(b);//将byte数组写出到f2
            System.out.println("写入文件完成");
            //System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fos==null){
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fis==null){
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fr==null){
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
}
