package work1;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author:LXY
 * @className:string1
 * @description:
 * @date:2021/3/2521:25
 * @version:0.1
 * @since:1.8
 */
public class string1 {
    //1. 用户从控制台输入一个字符串，要求判断是否为合法的email地址，
    // 如果合法，请判断是否为sina的邮箱地址。(PS:记住异常处理) 合法邮箱规则:
    //	有且仅有一个@和.
    //	@在.之前 且@不能是第一位  .不能是最后一位
    //	@与.不能相邻
    //	新浪邮箱应当以@sina.com结尾
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int indexF1;
        int indexF2;
        int indexL1;
        int indexL2;
        String email="jay";
        try{
            System.out.println("请输入邮箱地址：");
            email=input.nextLine();
        }catch (NullPointerException exception1){
            System.out.println("请输入正确的邮箱地址");
        }
        String str1="^[\\w\\.]+@sina.com";
        if(Pattern.matches(str1,email)){  //这种正则表达式的办法更加简洁方便。
            System.out.println(1);
            return;
        }
        int len=email.length();
        indexF1=email.indexOf('@');
        indexF2=email.indexOf('.');
        indexL1=email.indexOf('@');
        indexL2=email.indexOf('.');
        if(indexF1==-1||indexF2==-1||//保证有@ .
                indexF1>indexF2||//保证@在前
                indexF1==0||indexF2==len-1||//保证@不在第一位 .最后一位
                indexF1+1==indexF2||//保证不相邻.
                indexF1!=indexL1|| indexF2!=indexL2){//保证不会有多个@.
            System.out.println("请输入正确的邮箱:");
            return;
        }
        if(email.endsWith("@sina.com")){
            System.out.println("邮箱地址是"+email);
        }else{
            System.out.println("请输入正确的邮箱：");
        }
    }
}
