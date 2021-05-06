import java.util.Scanner;

/**
 * @author:LXY
 * @className:work7
 * @description:
 * @date:2021/3/1619:40
 * @version:0.1
 * @since:1.8
 */
public class work7 {
    public static void main(String[] strs){

//	要求用户输入一个0到2之间的整数
//如果用户输入0输出“你出的是石头”，
//如果用户输入1就输出“你出的是剪刀”，
//如果用户输入的是2就输出“你出的是布”，
//然后再问是否要继续出拳，
//如果回答“y”就重复以上过程，
//否则结束程序

        Scanner input=new Scanner(System.in);
        String a;
        do{
            System.out.println("请输入一个0到2之间的整数");
            int num=input.nextInt();
            switch(num){
                case 0:
                    System.out.println("你出的是石头");
                    break;
                case 1:
                    System.out.println("你出的是剪刀");
                    break;
                case 2:
                    System.out.println("你出的是布");
            }
            System.out.println("是否要继续出拳?若想请输入y继续");
            a=input.next();
        }while("y".equals(a));//注意字符串比较要用equal语句而非== 而且已确定的值要在左边 变量在右边

    }
}
