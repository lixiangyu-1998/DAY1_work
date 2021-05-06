package work2;

import java.util.ArrayList;

/**
 * @author:LXY
 * @className:main
 * @description:
 * @date:2021/4/320:56
 * @version:0.1
 * @since:1.8
 */
public class main {
    //	结合生产者与消费者模式编写如下程序：
    // 生产者随机时间（0.5-1.5秒）产生随机的字符串，
    // 消费者由线程担任，假设每处理一个字符串需要2-3秒时间
    private static ArrayList<String> list=new ArrayList<String>();

    public static void main(String[] args) {
        Producer pro=new Producer(list);//实例化生产者对象并传入仓库参数
        Consumer con=new Consumer(list);//实例化消费者对象并传入仓库参数
        new Thread(pro,"生产者").start();//新建生产者进程并执行
        new Thread(con,"消费者").start();//新建消费者进程并执行
    }
}
