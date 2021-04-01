import java.awt.*;
import java.util.Scanner;

/**
 * @author:LXY
 * @className:work1
 * @description:
 * @date:2021/3/1919:17
 * @version:0.1
 * @since:1.8
 */
public class work1 {
    //	使用java来描述车class，车都具备轮子数、颜色 、与跑的行为，
    public static class car{
        //属性
        static int num;
        static String color;
        //行为
        public static void run(){
            System.out.println("车在跑");
        }
    }
    //	Java描述修车厂，修车厂具备，名字、地址、电话三个属性，具备修车的功能行为，
    public static class repairCar {
        static String name;
        static String address;
        static int telephone;

        public static void repair() {
            System.out.println("正在修车");
        }
    }
    public static void main(String[] strs){
        Scanner input=new Scanner(System.in);
        System.out.println("请输入车辆的轮子数目：");
        car.num=input.nextInt();
        System.out.println("请输入车辆的颜色：");
        car.color=input.next();
        System.out.println("车辆的轮子数是："+car.num);
        System.out.println("车辆的颜色是："+car.color);
        System.out.println("请输入修车厂的名字");
        repairCar.name=input.next();
        System.out.println("请输入修车厂的地址");
        repairCar.address= input.next();
        System.out.println("请输入修车厂的电话");
        repairCar.telephone= input.nextInt();
        System.out.println("修车厂的名字是"+repairCar.name+"  地址是"+repairCar.address+"  电话是"+repairCar.telephone);
        if(car.num>=4){
            car.run();
        }else{
            System.out.println("车辆损坏 应该送车辆去"+repairCar.address+"维修");
            repairCar.repair();
        }
    }
}
