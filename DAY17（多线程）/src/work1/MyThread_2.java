package work1;

/**
 * @author:LXY
 * @className:MyThread_2
 * @description:
 * @date:2021/4/319:42
 * @version:0.1
 * @since:1.8
 */
public class MyThread_2 extends Thread{
    public static void main(String[] args) {  //(继承了thread的MyThread_2 其实例化的对象是 真的线程
        MyThread_2 t1=new MyThread_2();//此时有四个线程  t1 t2 1 2 （此时的四个线程是真的线程
        MyThread_2 t2=new MyThread_2();//除了t2                  （其实还有一个线程是主线程 调用普通方法即可 所以总计5个线程
       new Thread(t1,"1").start();//其余线程共享资源
       new Thread(t1,"2").start();
//        t1.start();//意思是开启 t1 t2 两个线程
//        t2.start();


          t1.run();//意思是调用 t1 t2的方法 都是用主线程做的 如果单独运行他俩 并不共享资源 只是先执行完t1 再执行t2
          //t2.run();

    }
    private Integer count=0;
    @Override
    public void run() {
        while (count<5){
            count++;
            synchronized(this){//同步锁

                System.out.println("当前正在运行的线程是："+Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

