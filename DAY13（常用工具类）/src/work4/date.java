package work4;

import java.util.Calendar;
import java.util.Scanner;

/**
 * @author:LXY
 * @className:date
 * @description:
 * @date:2021/3/2620:51
 * @version:0.1
 * @since:1.8
 */
public class date {
    public static void main(String[] args) {
        //4. 获取一个月中的最后一天
        Scanner input=new Scanner(System.in);
        int month;
        Calendar cal=Calendar.getInstance();
        System.out.println("请输入一个月份：");
        month=input.nextInt();
        cal.set(cal.MONTH,month);
        cal.set(cal.DATE,1);
        cal.set(cal.HOUR,1);
        cal.add(cal.HOUR,-20);
        System.out.println(month+"月的最后一天是;"+cal.get(cal.DATE));
    }
}
