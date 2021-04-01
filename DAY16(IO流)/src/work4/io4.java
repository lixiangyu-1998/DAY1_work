package work4;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author:LXY
 * @className:io4
 * @description:
 * @date:2021/3/3122:32
 * @version:0.1
 * @since:1.8
 */
public class io4 {
    public static void main(String[] args){
        //4. 从控制台进行输入用户名以及用户密码，判断是否登录成功！要求准确的用户名和密码存在配置文件中！
        FileInputStream fis=null;
        FileOutputStream fos=null;
        try {
            Scanner input=new Scanner(System.in);
            Properties pro=new Properties();//创建properties
             fis=new FileInputStream("D:\\file1\\test4.txt");//为字节输入流指定文件路径（）
             fos=new FileOutputStream("D:\\file1\\test4.txt");//为字节输出流指定文件路径(为了装载kv对)
            pro.setProperty("jack","20");//添加键值对
            pro.setProperty("rose","18");
            pro.store(fos,"msg");//装载键值对 到字节输出流
            pro.load(fis);//从字节输入流 中 装载配置文件
            System.out.println("请输入用户名以及密码：");
            String str1=input.next();
            String str2=input.next();
            if(str1==null||str2==null){
                System.out.println("请输入正确的用户名和密码");
                return;
            }
            if(!str2.equals(pro.getProperty(str1))){//校验用户名和密码是否匹配
                System.out.println("登陆失败");
                return;
            }
            System.out.println("登陆成功");

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

        }
    }
}
