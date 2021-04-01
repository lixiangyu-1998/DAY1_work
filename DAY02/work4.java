import com.sun.org.apache.xpath.internal.operations.Equals;

import java.util.Scanner;

/**
 * @author:LXY
 * @className:work4
 * @description:
 * @date:2021/3/1616:57
 * @version:0.1
 * @since:1.8
 */
public class work4 {
    public static void main(String[] strs){

        //	需求说明：录入会员信息（会员号、会员生日、会员积分）并显示录入信息
        //	升级功能：
        //	判断录入是否合法（会员号必为4位整数），
        //	录入合法，显示录入的信息；
        //	不合法，显示“录入失败”

        Scanner input=new Scanner(System.in);
        System.out.println("请输入会员号码：");
        double num=input.nextDouble();
        if(num==(int)num&&num>=1000&&num<=9999){//保证合法整数号码
            System.out.println("录入成功，会员号码为"+(int)num);

        }else{

            System.out.println("输入不合法，录入失败。");
            return;
        }

        System.out.println("请输入会员生日的年份");
        double year=input.nextDouble();
        if(year==(int)year&&year>=1850&&year<=2021){//保证是合法且正常范围的整数年份// 因为||不能和year==(int)year共存
                                                                                    //所以没有使用卫语句 嵌套了很多层。
            if(year%4==0){//找出闰年 2月有29天
                System.out.println("请输入会员生日的月份");
                double month=input.nextInt();
                if(month==(int)month&&month<=12&&month>=1){//保证是合法的整数月
                    System.out.println("请输入会员生日的天数");
                    double day=input.nextInt();
                    if(month==1||month==3||month==5||month==7||month==10||month==12){//挑出有31天的月份
                        if(day==(int)day&&day<=31&&day>=1){//保证合法的整数日
                            System.out.println("录入成功，会员生日为"+(int)year+"年"+(int)month+"月"+(int)day+"日");
                        }else{
                            System.out.println("输入不合法，录入失败。");
                            return;
                        }
                    }else if(month==2){
                        if(day<=29&&day>=1){
                            System.out.println("录入成功，会员生日为"+(int)year+"年"+(int)month+"月"+(int)day+"日");
                        }else{
                            System.out.println("输入不合法，录入失败。");
                            return;
                    }
              }else{//剩下的月份就都是30天了
                        if(day<=30&&day>=1){
                            System.out.println("录入成功，会员生日为"+(int)year+"年"+(int)month+"月"+(int)day+"日");
                        }else{
                            System.out.println("输入不合法，录入失败。");
                            return;
                        }
                    }

            }else{
                    System.out.println("输入不合法，录入失败。");
                    return;
                }


        }else{//选出不是闰年的正常年份
                System.out.println("请输入会员生日的月份");
                double month=input.nextInt();
                if(month==(int)month&&month<=12&&month>=1){//保证是合法的整数月
                    System.out.println("请输入会员生日的天数");
                    double day=input.nextInt();
                    if(month==1||month==3||month==5||month==7||month==10||month==12){//挑出有31天的月份
                        if(day==(int)day&&day<=31&&day>=1){//保证合法的整数日
                            System.out.println("录入成功，会员生日为"+(int)year+"年"+(int)month+"月"+(int)day+"日");
                        }else{
                            System.out.println("输入不合法，录入失败。");
                            return;
                        }
                    }else if(month==2){//此时2月有28天
                        if(day<=28&&day>=1){
                            System.out.println("录入成功，会员生日为"+(int)year+"年"+(int)month+"月"+(int)day+"日");
                        }else{
                            System.out.println("输入不合法，录入失败。");
                            return;
                        }
                    }else{//剩下的月份就都是30天了
                        if(day<=30&&day>=1){
                            System.out.println("录入成功，会员生日为"+(int)year+"年"+(int)month+"月"+(int)day+"日");
                        }else{
                            System.out.println("输入不合法，录入失败。");
                            return;
                        }
                    }

                }else{
                    System.out.println("输入不合法，录入失败。");
                    return;
                }

            }
        }else{
            System.out.println("输入不合法，录入失败。");
            return;
         }

        System.out.println("请输入会员积分：");
        double num1=input.nextDouble();
        if(num1==(int)num1&&num1>=0){
            System.out.println("录入成功，会员积分为"+(int)num1);
        }else{
            System.out.println("输入不合法，录入失败。");
            return;
        }


    }
}
