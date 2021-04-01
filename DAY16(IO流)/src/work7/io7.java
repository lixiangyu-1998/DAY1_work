package work7;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * @author:LXY
 * @className:io7
 * @description:
 * @date:2021/4/119:17
 * @version:0.1
 * @since:1.8
 */
public class io7 {
    public static void main(String[] args) throws IOException {
        //7. 读取任意txt文件内容,并统计出这个文本中每个字符以及每个字符出现的次数，
        // 并以以下格式: 字符=次数 持久化保存文件中。
        File f1=new File("D:\\file1\\testFile.txt");
        File f2=new File("D:\\file1\\testNum.dat") ;
        FileReader fr=new FileReader(f1);
        int a;
        StringBuilder sb=new StringBuilder();

        while((a=fr.read())!=-1){//从字符输入流中读取数据到流 并且储存到sb中方便后续操作
            sb.append((char)a);
        }
        System.out.println(sb);
        Properties pro=new Properties();
        Character name;
        Integer num;
        String str;
        String str1;
        int n;
        char c;
        int b=sb.length();
        for(int index=0;index<b;index++){
            if(index+1==b){
                break;
            }
            int count=1;
            c=sb.charAt(index);//当前遍历到的元素
            str=String.valueOf(c);
            while((n=sb.indexOf(str,index+1))!=-1){//不是唯一元素
                sb.deleteCharAt(n);//删除重复元素
                b--;
                count++;
                str1= String.valueOf(count);
                pro.setProperty(str,str1);
            }
        }
        FileWriter fw=new FileWriter(f2);
        pro.store(fw,"msg");//加载pro到文件中


    }
}
