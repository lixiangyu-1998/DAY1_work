/**
 * @author:LXY
 * @className:work2
 * @description:
 * @date:2021/3/1517:52
 * @version:0.1
 * @since:1.8
 */
//	2.根据天数（46）计算周数和剩余的天数
public class work2 {
    public static void main(String [] strs){
        int a=46;
        int b=7;
        int c;
        int d;
        c=a/b;
        d=a%b;
        System.out.println("周数为"+c);
        System.out.println("剩余天数为"+d);

    }
}
