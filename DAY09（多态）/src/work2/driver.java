package work2;

/**
 * @author:LXY
 * @className:driver
 * @description:
 * @date:2021/3/2217:03
 * @version:0.1
 * @since:1.8
 */
public class driver {
    public static void drive(car car){
        if(car instanceof bmw){
            bmw bmw=(bmw)car;
            bmw.run();
        }else if(car instanceof benz){
            benz benz=(benz)car;
            benz.run();
        }
    }

}
