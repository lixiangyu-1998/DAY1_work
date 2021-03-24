import java.util.Scanner;

/**
 * @author:LXY
 * @className:work4
 * @description:
 * @date:2021/3/2013:04
 * @version:0.1
 * @since:1.8
 */
public class work4 {
    public static class calculator{
        int operateNum1;
        int operateNum2;
        //+ - * /
        static String sign;
        public calculator() {//无参构造函数
        }
        public calculator(int operateNum1, int operateNum2, String sign) {//全参构造函数
            this.operateNum1 = operateNum1;
            this.operateNum2 = operateNum2;
            this.sign = sign;
        }
        public void calculator(){
            if("+".equals(sign)){
                System.out.println("运算结果是"+(this.operateNum1+this.operateNum2));
            }else if("-".equals(sign)){
                System.out.println("运算结果是"+(this.operateNum1-this.operateNum2));
            }else if("*".equals(sign)){
                System.out.println("运算结果是"+(this.operateNum1*this.operateNum2));
            }else{
                System.out.println("运算结果是"+(this.operateNum1/this.operateNum2));
            }
        }
    }
    public static void main(String[] strs){
//        Scanner input=new Scanner(System.in);
//        System.out.println("请输入数据1：""请输入运算符：""请输入数据2：");
        calculator c1=new calculator(5,5,"*");
        c1.calculator();
    }
}
