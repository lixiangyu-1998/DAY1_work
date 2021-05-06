package work2;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * @author:LXY
 * @className:time
 * @description:
 * @date:2021/3/2619:38
 * @version:0.1
 * @since:1.8
 */
public class time {
    public static void main(String[] args) {
        //2. 使用Calendar类的相关属性以及方法！
        // 打印出某年某个月的日历信息！
        // （要求年月日由命令行输入）
        //Date dateNow=new Date();
        int year;
        int month;
        int day;
        Scanner input=new Scanner(System.in);
        System.out.println();
        Calendar date= Calendar.getInstance();
        date.clear();
        System.out.println("请输入想要查看的年份：");
        year=input.nextInt();
        date.set(date.YEAR,year);
        System.out.println("请输入想要查看的月份：");
        month=input.nextInt();
        date.set(date.MONTH,month);
        System.out.println("请输入想要查看的日期：");
        day=input.nextInt();
        date.set(date.DATE,day);
        System.out.println("你要查看的是");
        System.out.println(date.get(date.YEAR)+"年");
        System.out.println(date.get(date.MONTH)+"月");
        System.out.println(date.get(date.DATE)+"日");

    }

}
