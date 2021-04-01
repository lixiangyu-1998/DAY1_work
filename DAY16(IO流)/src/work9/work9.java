package work9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/**
 * @author:LXY
 * @className:work9
 * @description:
 * @date:2021/4/121:45
 * @version:0.1
 * @since:1.8
 */
public class work9 {
    public static void main(String[] args) throws IOException {
        //9. 已知student_info.txt文件中有如下数据：（姓名-年龄-总分)D:\file1
        //张三-21-98
        //李四-23-97
        //王五-25-100
        //赵六-15-100
        //孙七-19-93
        //运用IO技术获取将该文件中的数据分别封装成5个Student(姓名为String类型,年龄为int类型,总分为int类型 )对象存入集合中（
        // 需要自己定义Student类）
        //要求：根据学生的总分进行排序（降序），如果分数相同则比较年龄，年龄较大的排在前面。并显示排序之后的结果。
        File f1=new File("D:\\file1\\student_info.txt");
        char[] c=new char[10];
        int age;
        int score;
        String name;
        FileReader fr=new FileReader(f1);
        ArrayList<student> list=new ArrayList<student>();
        String str=null;
        StringBuilder sb=new StringBuilder();
        for(int index=0;index<5;index++){
            fr.read(c);
            //str=String.valueOf(c);
            sb.append(c);
            age= Integer.valueOf(sb.substring(sb.indexOf("-")+1,sb.lastIndexOf("-")));
            //System.out.println(age);
            score=Integer.valueOf(sb.substring(sb.lastIndexOf("-")+1).trim());
            //System.out.println(score);
            name=sb.substring(0,sb.indexOf("-"));
            list.add(new student(name,age,score));
            sb.delete(0,sb.length());
        }
        //System.out.println(list);
        Collections.sort(list);
       // System.out.println(list);
        Iterator iterator=list.iterator();
        while (iterator.hasNext()){
            student s=(student)iterator.next();
            System.out.println(s.getName()+"   "+s.getScore()+"    "+s.getAge());

        }

//        System.out.println(c);
//        System.out.println(str);
//
//            System.out.println(str.substring(str.lastIndexOf("-")+1));
//        age= Integer.valueOf(str.substring(str.indexOf("-")+1,str.lastIndexOf("-")));
//        System.out.println(age);
//        fr.read(c);
////        System.out.println(c);
//        str=String.valueOf(c);
//            sb.append(c);
//            sb.substring((sb.lastIndexOf("-")+1));
//        System.out.println(str.lastIndexOf("-"));
//        System.out.println(str.substring(str.lastIndexOf("-")+1));
//        System.out.println(Integer.valueOf("98"));
//       // System.out.println(Integer.valueOf(str.substring(str.lastIndexOf("-")+1)));
       //sb.substring((sb.lastIndexOf("-")+1)).trim()
        //score=Integer.valueOf(str.substring(str.lastIndexOf("-")));
//        System.out.println(Integer.valueOf(        sb.substring((sb.lastIndexOf("-")+1)).trim()
//        ));
//        System.out.println(c);




    }
}
