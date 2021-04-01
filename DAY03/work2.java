import java.util.Scanner;

/**
 * @author:LXY
 * @className:work2
 * @description:
 * @date:2021/3/1721:47
 * @version:0.1
 * @since:1.8
 */
public class work2 {
    public static void main(String[] strs){
        //	声明一个字符串的数组，空间为5个。
        // 使用循环接收五个学生的姓名。
        // 再使用循环输出这五 个学生的姓名
        Scanner input=new Scanner(System.in);
        String[] studentName=new String[5];
        System.out.print("请输入学生姓名：");
        for(int index=0;index<5;index++){
            studentName[index]=input.next();
        }
        for(int index=0;index<5;index++){
            System.out.println("第"+(index+1)+"个学生的姓名是："+studentName[index]);
        }
    }
}
