/**
 * @author:LXY
 * @className:work12
 * @description:
 * @date:2021/3/1621:00
 * @version:0.1
 * @since:1.8
 */
public class work12 {
    public static void main(String[] strs){
        //	一张纸的厚度大约是0.08mm，对折多少次之后能达到珠穆朗玛峰的高度（8848.13米）？
        int num=0;
        for(double thickness=0.08/1000;thickness<8848.13;){
            thickness*=2;
            num++;

        }
        System.out.println("对折"+num+"次后能达到珠穆朗玛峰的高度");



    }
}
