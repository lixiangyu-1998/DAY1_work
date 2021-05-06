package work10;

import java.util.Scanner;

/**
 * @author:LXY
 * @className:str
 * @description:
 * @date:2021/3/2616:17
 * @version:0.1
 * @since:1.8
 */
public class str {
    public static void main(String[] args) {
        //10. 练习：让用户在控制台不断录入英文字母（每次录入两个字母即可），
        // 直到总长度超过6个停止，
        // 然后统计一下一共有几个a
        Scanner input=new Scanner(System.in);
        StringBuffer str1=new StringBuffer();
        String str;
        String str3;
        int count1=0;
        for(int count=0;count<6;count+=2){
            System.out.println("请输入两个英文字母：");
            str=input.next();
            str1.append(str);
        }
        str3=str1.toString();
        while (str3.indexOf("a")!=-1){
            if(str3.indexOf("a")!=-1){
                //str3=str1.toString();//stringBuffer类转换为string类以便使用其方法
                str1.deleteCharAt(str3.indexOf("a"));//string类查找a的位置 并且删除；
                str3=str1.toString();
                count1++;
            }else{
                return;
            }

        }
        System.out.println("字符串中有"+count1+"个a");






    }
}
