import work1.Instrument;
import work2.benz;
import work2.bmw;
import work2.car;
import work2.driver;

/**
 * @author:LXY
 * @className:driverTest
 * @description:
 * @date:2021/3/2217:12
 * @version:0.1
 * @since:1.8
 */
public class driverTest {
    public static void main(String[] args){
        car benz=new benz();
        car bmw=new bmw();
        driver.drive(benz);
        driver.drive(bmw);
    }
}
