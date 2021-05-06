/**
 * @author:LXY
 * @className:work15
 * @description:
 * @date:2021/3/1621:33
 * @version:0.1
 * @since:1.8
 */
public class work15 {
    public static void main(String[] strs){

        //	打印出所有的 "水仙花数"
        //所谓 "水仙花数"是指一个三位数，其各位数字立方和等于该数本身。
        //例如：153是一个 "水仙花数 "，因为153=1的三次方＋5的三次方＋3的三次方。

       int a;
       int b;
       int c;
        System.out.println("水仙花数为：");
        for(int num=100;num<=999;){
            a=num/100;
            b=(num-a*100)/10;
            c=num-a*100-b*10;
            if(num==a*a*a+b*b*b+c*c*c)
            System.out.println(num);
            num++;
        }


    }
}
