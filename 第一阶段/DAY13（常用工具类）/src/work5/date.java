package work5;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * @author:LXY
 * @className:date
 * @description:
 * @date:2021/3/2621:10
 * @version:0.1
 * @since:1.8
 */
public class date {
    public static void main(String[] args) {
        //5. 计算两个时间相差几个小时
        int year;
        int month;
        int day;
        Scanner input=new Scanner(System.in);
        System.out.println("请输入第一个日期：");
        year=input.nextInt();
        month=input.nextInt();
        day=input.nextInt();
        LocalDate date1=LocalDate.of(year,month,day);
        System.out.println("请输入第而二个日期：");
        year=input.nextInt();
        month=input.nextInt();
        day=input.nextInt();
        LocalDate date2=LocalDate.of(year,month,day);
        int day1=date1.until(date2).getDays();
        long day2=date1.until(date2,ChronoUnit.DAYS);
        if(day2<0){
            day2*=-1;
        }
        System.out.println(date1+"和"+date2+"间隔"+day2*24+"小时");
    }
}
