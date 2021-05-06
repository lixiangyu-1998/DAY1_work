package work2;

import java.util.ArrayList;

/**
 * @author:LXY
 * @className:Consumer
 * @description:
 * @date:2021/4/320:40
 * @version:0.1
 * @since:1.8
 */
public class Consumer implements Runnable {
    // 消费者由线程担任，假设每处理一个字符串需要2-3秒时间
    private ArrayList<String> list;
    public Consumer(ArrayList<String> list) {
        this.list = list;
    }
    @Override
    public void run() {
        while (true){
            Consumer();
        }
    }
    public void Consumer(){
        double tim;
        synchronized(list){
            int time= (int)(Math.random()*1000+2000);
            tim=time;
            while(list.isEmpty()){//如果仓库空了 就暂停消费
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(time);//处理时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("元素"+list.remove(0)+"处理完毕"+"  处理时间为："+tim/1000+"秒");
            list.notify();//当开始消费就通知生产者干活
            System.out.println("库存中还有："+list.size()+"个");
        }

    }
}
