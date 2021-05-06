package work3;

import com.sun.org.apache.xpath.internal.operations.Equals;
import sun.awt.FwDispatcher;

import java.io.*;
import java.util.Scanner;

/**
 * @author:LXY
 * @className:io3
 * @description:
 * @date:2021/3/3121:19
 * @version:0.1
 * @since:1.8
 */
public class io3 {
    public static void main(String[] args){
        //3. 基于转换流，从控制台输入一些字符串，并将该类信息保存到日志文件”log.txt”中去。
        FileWriter fw=null;
        BufferedWriter bw=null;
        InputStreamReader isr=null;
        BufferedReader br=null;
        try {
            File f1=new File("log.txt");//造文件

            System.out.println("请输入一些信息：");
            isr=new InputStreamReader(System.in);//输入转换流 把控制台输入的字节型数据转换成字符型数据 并输入流中
            // （属于 处理流 操作对象是流）
            br=new BufferedReader(isr);//缓冲读取（输入）流  读取了 输入转换流 的数据（属于 处理流 操作对象是流）


            fw=new FileWriter(f1);//造字符输出流 表明数据会输出到f1（属于 节点流 操作对象是file）
            bw=new BufferedWriter(fw);//造缓冲输出流  表明缓冲输出流 会向 字符输出流 输出数据 （属于 处理流 操作对象是流）


            while(true){
                String str=br.readLine();//整行读取 缓冲读取（输入）流 的数据 其实就是 输入转换流 的数据 也就是我们控制台输入的数据
                if("!".equals(str)){//遇到！号时结束循环
                    break;
                }
                bw.write(str);//缓冲输出流 输出数据到
                bw.newLine();//换行
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(br!=null){
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(isr!=null){
                    isr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bw!=null){
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fw!=null){
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        //String str=input.next();
        //造节点
       // FileInputStream fis=new FileInputStream(str);
      // FileOutputStream fos=new FileOutputStream(f1);
//        DataOutputStream dos=new DataOutputStream(str)
//        DataInputStream dis=new DataInputStream()
//        FileReader fr=new FileReader(str);
      // FileWriter fw=new FileWriter(f1);

//        InputStreamReader isr=new InputStreamReader(System.in);
//        OutputStreamWriter osw=new OutputStreamWriter(fos);
//
//        int len;
//        while((len=isr.read())!=-1){
//            osw.write(len);
//        }
//        osw.close();
//        isr.close();

    }
}
