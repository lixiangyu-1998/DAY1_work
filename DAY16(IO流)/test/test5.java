import work5.student;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author:LXY
 * @className:test5
 * @description:
 * @date:2021/4/113:19
 * @version:0.1
 * @since:1.8
 */
public class test5 {
    public static void main(String[] args){
        //创建测试类，在控制台上显示添加学生信息，要求程序循环运行，
        // 并依次提示接收学生类的所有属性值，保存到学生对象中，再将学生对象保存到集合对象中，
        // 并提示“是否继续添加（y/n）：”,如果选择“y”则继续添加，否则退出循环，
        Scanner input = new Scanner(System.in);
        student s = new student();
        String str = null;
        ObjectOutputStream objos=null;
        ObjectInputStream objis=null;
        ArrayList<student> list = new ArrayList();
        do {
            System.out.println("请依次输入学生的信息：1.学生id");//简单的循环创建新对象
            s.setId(input.nextInt());
            //input.next();
            System.out.println("请依次输入学生的信息：2.学生姓名");
            s.setName(input.next());
            System.out.println("请依次输入学生的信息：3.学生性别");
            s.setSex(input.next());
            list.add(s);
            System.out.println("是否继续添加？（y/n）");
            str = input.next();
        } while (str.equals("y"));
//        Iterator ite = list.iterator();
//        while (ite.hasNext()) {
//            Object obj = ite.next();
//            if (obj instanceof student) {
//                student student = (student) obj;
//                student.show();
//
//            }


//            while(list.iterator().hasNext()){
//             list.iterator().next().show();
//                list.iterator().next();
//             }

            //并将保存学生数据的集合对象通过序列化保存到“student.dat”文件中。
            //        //实现从“student.dat”文件中反序列化保存学生数据的集合对象，并遍历打印输出学生信息。
        try {
            File f1=new File("D:\\file1\\student.dat");//造文件
            FileOutputStream fos=new FileOutputStream(f1);//造字节输出流 节点流 操作对象是文件
            objos=new ObjectOutputStream(fos);//造序列化输出流 是处理流 操作对象是流
            objos.writeObject(list);//序列化对象到流中
            System.out.println("数据已经保存完毕");

            FileInputStream fis=new FileInputStream(f1);//字节输入流 节点流
            objis=new ObjectInputStream(fis);//序列化输入流 处理流
            ArrayList<student> list1=(ArrayList)objis.readObject();//从流中取出对象并反序列化 返回object类对象 需要强转类型

            Iterator ite = list1.iterator();//简简单单整个迭代器循环遍历list
            while (ite.hasNext()) {
                Object obj = ite.next();
                if (obj instanceof student) {
                    student student = (student) obj;
                    student.show();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if(objis==null){
                    objis.close();//关流
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(objos==null){
                   objos.close();
               }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}

