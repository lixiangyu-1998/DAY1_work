import java.util.Scanner;

/**
 * @author:LXY
 * @className:work13
 * @description:
 * @date:2021/3/1621:06
 * @version:0.1
 * @since:1.8
 */
public class work13 {
    public static void main(String[] strs){
        //	计算用户输入的日期离1900年1月1日相距多少天
        Scanner input=new Scanner(System.in);
        System.out.println("请输入年份");
        int year=input.nextInt();
        System.out.println("请输入月份");
        int month=input.nextInt();
        System.out.println("请输入天数");
        int day=input.nextInt();
        int day1=(year-1900)*365+(month-1)*30+day-1;
        if(day1>0){//保证产出的结果是正数
            System.out.println("输入的日期离1900年1月1日相距"+day1+"天");
        }else{
            day1=day1*-1;
            System.out.println("输入的日期离1900年1月1日相距"+day1+"天");
        }

    }
}
