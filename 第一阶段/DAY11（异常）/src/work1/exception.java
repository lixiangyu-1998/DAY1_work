package work1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author:LXY
 * @className:exception
 * @description:
 * @date:2021/3/2422:34
 * @version:0.1
 * @since:1.8
 */
public class exception {
    //	需通过控制台接收用户输入的两个整数，然后做除法。
    // 要求用异常处理输入非数字的异常，
    // 和除数为0的异常。
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int a;
        int b;
        System.out.println("请输入两个整数：");

        try{
            a=input.nextInt();
            b=input.nextInt();
            System.out.println("a/b="+a/b);
        }catch(ArithmeticException exception1){
            System.out.println("请不要除以0");
        }catch(InputMismatchException exception2){
            System.out.println("请输入合法整数");
        }

    }
}
