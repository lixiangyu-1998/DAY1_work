import com.sun.javafx.runtime.SystemProperties;

/**
 * @author:LXY
 * @className:work3
 * @description:
 * @date:2021/3/1517:59
 * @version:0.1
 * @since:1.8
 */
//	3.已知圆的半径radius= 1.5，求其面积 (Java中π用Math.PI表示)
public class work3 {
    public static void main(String [] strs){

        double radius=1.5;
        double s=Math.PI*radius*radius;
        System.out.println("圆的面积是"+s);
    }
}
