package work1;

/**
 * @author:LXY
 * @className:Instrument
 * @description:
 * @date:2021/3/2216:40
 * @version:0.1
 * @since:1.8
 */
public abstract class Instrument {
    //	结合多态，实现以下需求:
    //	1.乐器（work1.Instrument）分为：钢琴(Piano)、小提琴(work1.Violin)，各种乐器的弹奏（ play ）方法各不相同。
    //	编写一个测试类InstrumentTest，要求：
    //	编写方法testPlay，对各种乐器进行弹奏测试。要依据乐器的不同，进行相应的弹奏。
    //	在main方法中进行测试
    String name;
    public abstract void play();
}
