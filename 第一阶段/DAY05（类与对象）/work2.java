import java.util.Scanner;

/**
 * @author:LXY
 * @className:work2
 * @description:
 * @date:2021/3/1919:51
 * @version:0.1
 * @since:1.8
 */
public class work2 {
    //	描述一个学生类，学生具备姓名、学号、性别、三个公共的属性，学生都具备吃饭与学习的行为。
    //	测试类中为学生类的属性赋值、调用学生的方法
    //	描述一个电脑类，具有属性：cpu，网卡，显卡，声卡，内存 方法：上网
    //	描述学生拥有一台电脑
    public static class student{//	描述一个学生类，学生具备姓名、学号、性别、三个公共的属性，
               // 学生都具备吃饭与学习的行为。
        static String name;
        static int num;
        static String sex;
        public static void eat(){
            System.out.println("吃饭中 少话");
        }
        public static void study(){
            System.out.println("学习中 少话");
        }
    }
    public static class computer{//	描述一个电脑类，具有属性：cpu，网卡，显卡，声卡，内存 方法：上网
                                  //	描述学生拥有一台电脑
        static String cpu;
        static String networkCard;
        static String graphics;
        static String soundCark;
        static String ram;
        public static void surfInternet(){
            System.out.println("上网中 少话");
        }

    }
    public static void main(String[] strs){
         Scanner input=new Scanner(System.in);
        System.out.print("请输入学生的姓名");
        student.name=input.next();
        System.out.println(student.name+"有一台电脑 并且他表示");
        computer.surfInternet();
    }
    public static class testStudent{
        public static void main(String[] strs){
             //	测试类中为学生类的属性赋值、调用学生的方法
            Scanner input=new Scanner(System.in);
            System.out.print("请输入学生的姓名");
            student.name=input.next();
            System.out.print("请输入学生的学号");
            student.num=input.nextInt();
            System.out.print("请输入学生的性别");
            student.sex=input.next();
            System.out.print("学生的姓名是"+student.name+  "学号是"+student.num+  "性别是"+student.sex);
            student.eat();
            student.study();
        }
    }
}
