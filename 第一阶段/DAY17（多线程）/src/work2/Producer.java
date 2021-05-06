package work2;

import java.util.ArrayList;

/**
 * @author:LXY
 * @className:Producer
 * @description:
 * @date:2021/4/320:39
 * @version:0.1
 * @since:1.8
 */
public class Producer implements Runnable{
    // // 生产者随机时间（0.5-1.5秒）产生随机的字符串，
    private ArrayList<String> list;
    String str="1234567890-=/*+.qwertyuiop[]\\asdfghjkl;'zxcvbnm,./，。‘；】【）（&……%￥#@！《》<>?";
    String str1;

    public Producer(ArrayList<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
    while (true){
        Producer();
        }
    }
    public void Producer(){
        synchronized(list){
            double tim;
            Long time=(long)(Math.random()*1000+500);//随机时间
            tim=time;
            while(list.size()==10){//如果仓库满了（暂定容量为10） 就暂停生产
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int time1=(int)(Math.random()*69+1);
            str1=String.valueOf(str.charAt(time1));
            list.add(str1);
            System.out.println("已生产："+str1+"  生产时间为："+tim/1000+"秒");
            list.notifyAll();//如果开始生产就 唤醒消费者
            System.out.println("库存中还有："+list.size()+"个");
        }

    }
}
