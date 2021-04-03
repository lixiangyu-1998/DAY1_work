package work1;

/**
 * @author:LXY
 * @className:MyThread
 * @description:
 * @date:2021/4/319:07
 * @version:0.1
 * @since:1.8
 */
public class MyThread implements Runnable {
    public static void main(String[] args) {
        MyThread t1=new MyThread();//此时有2个线程 1 2
        MyThread t2=new MyThread();//但是 t2 t1 也是一个线程 即 主线程 （实际上MyThread没有继承Thread 其 实例化的对象也不能叫线程
        new Thread(t1,"线程一").start();//三个线程共享资源（只是因为其对象在main内调用方法 所以是主线程来运行
        new Thread(t1,"线程二").start();
        t1.run();
        //t2.run();
    }
    private static Integer count=0;
    @Override
    public void run() {
        while (count<5){
            this.count++;
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
