/**
 * @author:LXY
 * @className:work5
 * @description:
 * @date:2021/3/1519:00
 * @version:0.1
 * @since:1.8
 */
//	5.韩梅梅看中两把价格相同的扇子，想挑选一个扇面较大的扇子购买，请你帮她挑选。
//A款折叠扇：展开后角度为134.6°,扇骨长26.5cm
//B款圆扇：扇柄长12.3cm，扇子总长度36.5cm
//注：圆形面积 = 3.14 * 半径平方
// 	  扇形面积 = 3.14 * 半径平方 * (度数/360)
public class work5 {
    public static void main(String[] strs){

        double s1;
        double s2;
        s1=3.14*26.5*(134.6/360);
        s2=3.14*(36.5-12.3)*(36.5-12.3);
        if(s1>=s2){
            System.out.println("应该选择A");

        }
        System.out.println("应该选择B");

    }
}
