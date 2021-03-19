import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author:LXY
 * @className:LuckLottery
 * @description:
 * @date:2021/3/1819:11
 * @version:0.1
 * @since:1.8
 */
public class LuckLottery {
    public static String userName;
    public static int passWord;//想在另一个方法中使用注册方法里的数据就要在最外面声明
    public static double cardId=0;
    //菜单页面显示并接收用户输入的指令
    public static int menu(){
        System.out.println("**********欢迎进入幸运抽奖系统**********");
        System.out.println("                1.注册");
        System.out.println("                2.登陆");
        System.out.println("                3.抽奖");
        System.out.println("****************************************");
        System.out.println("请选择菜单：");
        Scanner input=new Scanner(System.in);
        int num;
        num=input.nextInt();
        if(num==1){
            System.out.println("[幸运抽奖系统---》注册]");
        }else if(num==2){
            System.out.println("[幸运抽奖系统---》登陆]");
        }else if(num==3){
            System.out.println("[幸运抽奖系统---》抽奖]");
        }else{
            System.out.println("您的输入有误");
        }
        return num;
    }
    //注册功能
    public static boolean registered(){
        boolean sign;
        System.out.println("请填写个人注册信息：");
        Scanner input=new Scanner(System.in);
        System.out.println("请填写用户名：");
        userName=input.next();
        System.out.println("请填写密码：");
        passWord=input.nextInt();
        System.out.println("注册成功请保存好您的会员卡号");
        int i=1;
        int j=10;
         for(;i<5;i++){
            cardId+=Math.random()*j;//循环四次 依次取个十百千位的随机数
            j*=10;
        }
        System.out.println("用户名："+userName+"   密码"+passWord+"   会员卡号"+(int)cardId);
         return true;
    };
    //登陆功能
    public static boolean login(){
        String userName1;
        int passWord1;
        Scanner input=new Scanner(System.in);
        System.out.println("请输入用户名和密码：");
        System.out.println("请输入用户名：");
        userName1=input.next();
        System.out.println("请输入密码：");
        passWord1=input.nextInt();
        if(userName.equals(userName1)&&passWord==passWord1){
            System.out.println("登陆成功，欢迎你："+userName);
            return true;
        }else{
            System.out.println("输入错误");
            return false;
        }
    }
    //抽奖功能
    public static void lottery(){
        int vipId;
        double vipId1=0;
        Scanner input=new Scanner(System.in);
        System.out.println("请输入会员卡号参与抽奖：");
        vipId=input.nextInt();
        int[] luckNum=new int[5];
        for(int index=0;index<5;index++){
            int i=1;//遍历数组
            int j=10;
            for(;i<5;i++){
                vipId1+=Math.random()*j;//取随机数 有时偶尔会取不到4位数 debug多次调试后发现
                j*=10;                           // 是因为 math.random() 方法偶尔会取到0.0XXXX 这样太小的数
            }                                     //如果在j=10000的时候 取了很小的数 就可能导致最后的数只有三位数
            luckNum[index]=(int)vipId1;//逐个赋予随机数
            vipId1=0;
        }
        System.out.println("今天的幸运数字是："+Arrays.toString(luckNum));
        int index=0;
        for(;index<5;index++){
            if(vipId==luckNum[index]){
                System.out.println("恭喜您是幸运会员");
                break;
            }
        }
        if(index==5){
            System.out.println("抱歉您不是本日的幸运会员");
        }
    }
    public static void main(String[] strs){
    int num;
    String a;
    int i=1;
    Scanner input=new Scanner(System.in);
    do{num=menu();
    if(num==1){
        registered();//menu方法会返回用户输入的数字 输入1 就执行注册方法
    }
    if(num==2){//是2 就执行登陆方法
        do{
            boolean sign=login();
            if(sign==true){
                break;
            }else{
                System.out.println("还有"+(3-i)+"次输入机会");//控制输入错误的次数 最多三次
                i++;
            }
        }while(i<4);
    }
    if(num==3){//用户输入3 就进入抽奖方法
        lottery();
    }
    System.out.println("是否继续？（y/n）：");
    a=input.next();
    if(a.equals("n")){
        System.out.println("系统退出，谢谢使用");
        return;
    }
    }while(a.equals("y"));
    }
}
