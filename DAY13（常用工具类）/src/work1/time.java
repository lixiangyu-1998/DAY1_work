package work1;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author:LXY
 * @className:time
 * @description:
 * @date:2021/3/2619:25
 * @version:0.1
 * @since:1.8
 */
public class time {
    public static void main(String[] args) {
        //1. 将长时间格式时间转换为字符串 yyyy-MM-dd HH:mm:ss
        Date dateNow=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("当前时间为："+format.format(dateNow));
        }
    }

