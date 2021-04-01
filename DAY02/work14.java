import java.util.Scanner;

/**
 * @author:LXY
 * @className:work14
 * @description:
 * @date:2021/3/1621:19
 * @version:0.1
 * @since:1.8
 */
public class work14 {
    public static void main(String[] strs){
        //	购物管理系统生日问候
        //请输入今天的日期（月/日<用两位数表示：）： 05/29
        //请输入客户生日：08/09
        //然后判断是否今天生日
        //是否继续（y/n)
        //如果是y就重复以上步骤，否则退出程序
        //字符串判断相等： "05/29".equals(birthday);
        Scanner input=new Scanner(System.in);
        System.out.println("请输入今天的日期");
        String date=input.next();
        String a;
        do {
            System.out.println("请输入客户的生日");
            String birthday = input.next();
            if (date.equals(birthday)) {
                System.out.println("客户是今天的生日");
            } else {
                System.out.println("客户不是今天的生日");
            }

            System.out.println("是否继续？若继续请输入y");
             a = input.next();
            }while("y".equals(a));

    }
}
