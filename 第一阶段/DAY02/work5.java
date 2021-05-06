import java.util.Scanner;

/**
 * @author:LXY
 * @className:work5
 * @description:
 * @date:2021/3/1618:50
 * @version:0.1
 * @since:1.8
 */
public class work5 {
    public static void main(String[] str){

        //	商场实行新的抽奖规则：会员号的百位数字等于产生的随机数字即为幸运会员。实现：
        //	1、从键盘接收4位数会员号
        //	2、生成随机数
        //	int random = (int) (Math.random() * 10);
        //	3、算出会员号中在百位的数字号码
        //	int baiwei = custNo / 100 % 10;
        //	3、使用if-else实现幸运抽奖
        //	会员根据积分享受不同折扣，如下表。使用多重if结构计算会员折扣
        //     x<2000   9
        //2000<=x<4000  8
        //4000<=x<8000  7
        //     x>=8000  6

        Scanner input=new Scanner(System.in);
        System.out.println("请输入4位会员号：");
        double vip=input.nextDouble();
        if(vip==(int)vip&&vip>999&&vip<10000){//因为||不能和语句：vip==(int)vip 共存 所以没有使用卫语句
            int random = (int) (Math.random() * 10);
            int baiwei = (int) vip / 100 % 10;
            System.out.println("幸运数字是："+random);
            if(random==baiwei){
                System.out.println("恭喜您抽中了幸运会员");
            }else{
                System.out.println("很遗憾您没有抽中幸运会员");
            }
            System.out.println("请输入您的会员积分：");
            double x=input.nextDouble();
            if(x==(int)x&&x>=0){
                if(x<2000){
                    System.out.println("您的会员积分现在是："+(int)x+",可以享有9折会员折扣");
                }else if(2000<=x&&x<4000){
                    System.out.println("您的会员积分现在是："+(int)x+",可以享有8折会员折扣");
                }else if(4000<=x&&x<8000){
                    System.out.println("您的会员积分现在是："+(int)x+",可以享有7折会员折扣");
                }else{
                    System.out.println("您的会员积分现在是："+(int)x+",可以享有6折会员折扣");
                }
            }else{
                System.out.println("请输入正确的会员积分");
                return;
            }

        }else{
            System.out.println("请输入正确的会员号");
            return;
        }


    }
}
