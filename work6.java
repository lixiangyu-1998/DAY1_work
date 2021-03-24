import java.util.Scanner;

/**
 * @author:LXY
 * @className:work6
 * @description:
 * @date:2021/3/2014:08
 * @version:0.1
 * @since:1.8
 */
public class work6 {

    public static class member {
        int memberNum;
        String memberName;
        int vipScore;

        public member() {
        }

        public member(int memberNum, String memberName, int vipScore) {
            this.memberNum = memberNum;
            this.memberName = memberName;
            this.vipScore = vipScore;

        }

        public boolean verify() {
            if (this.memberNum > 999 && this.memberNum < 10000) {
                return true;
            } else {
                return false;
            }
        }

        public void luckUser() {
            double num;
            num = Math.random() * 9000 + 1000;
            if (this.memberNum == (int)num) {
                System.out.println("幸运数字是" + (int)num);
                System.out.println("恭喜您是幸运用户");
                //return true;
            } else {
                System.out.println("幸运数字是" + (int)num);
                System.out.println("很遗憾您不是幸运用户");
               // return false;
            }
        }

        public int discount() {
            if (this.vipScore <= 2000) {
                return 9;
            } else if (2000 < this.vipScore && this.vipScore <= 4000) {
                return 8;
            } else if (4000 < this.vipScore && this.vipScore <= 6000) {
                return 7;
            } else {
                return 6;
            }
        }

        public static void main(String[] strs) {
            int memberNum;
            String memberName;
            int vipScore;
            Scanner input = new Scanner(System.in);
            System.out.println("请输入四位整数会员号");
            memberNum = input.nextInt();
            System.out.println("请输入会员姓名");
            memberName = input.next();
            System.out.println("请输入会员积分");
            vipScore = input.nextInt();
            member user1 = new member(memberNum, memberName, vipScore);
            if (user1.verify()) {
                System.out.println("用户当前积分为：" + user1.vipScore + "   可以享有" + user1.discount() + "折优惠");
                user1.luckUser();
            } else {
                System.out.println("会员号不合法，程序退出");
            }

        }
    }
}
