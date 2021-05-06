/**
 * @author:LXY
 * @className:work1
 * @description:
 * @date:2021/3/1517:44
 * @version:0.1
 * @since:1.8
 */
//1.求一光年是多少千米 , 光在真空中传播速度299792458 m/s
public class work1 {
    public static void main(String [] strs){

        long a=299792458;
        long b=a*3600*24*365/1000;

        System.out.println("一光年是："+b+"千米");
    }
}
