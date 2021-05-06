package work6;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * @author:LXY
 * @className:date
 * @description:
 * @date:2021/3/2621:37
 * @version:0.1
 * @since:1.8
 */
public class date {
    static Date[] date(Calendar cal,int day1){
        Date[] time=new Date[2];
        Calendar ca2=Calendar.getInstance();
        ca2.clear();
        ca2=cal;
        Date date1=cal.getTime();
        cal.add(cal.DATE,day1);
        Date date=cal.getTime();
        time[0]=date1;
        time[1]=date;
        return time;
    }
    public static void main(String[] args) {
        //6. 一个方法，要求传入时间和间隔天数
        // 返回新的日期
        Scanner input=new Scanner(System.in);
        int year;
        int month;
        int day;
        int day1;
        Calendar cal=Calendar.getInstance();
        System.out.println("请输入日期：");
        year=input.nextInt();
        month=input.nextInt();
        day=input.nextInt();
        cal.set(year,month,day);
        System.out.println("请输入相隔时间，向后找请使用+号，向前找请使用-号");
        day1=input.nextInt();
        Date time[]=date.date(cal,day1);
        System.out.println("与"+time[0]+"相距"+day1+"天的是："+time[1]);
    }
}
