import com.sun.scenario.effect.impl.state.AccessHelper;

import java.util.Scanner;

/**
 * @author:LXY
 * @className:PeopleVSAI
 * @description:
 * @date:2021/3/1920:18
 * @version:0.1
 * @since:1.8
 */
public class PeopleVSAI {
    public static class people{//用户类
        static int num;
        static int score=0;
        static String name;
        public static void operate(int num){//用户的出招方法

            switch(num){
                case 1:
                    System.out.println("你出石头");
                    break;
                case 2:
                    System.out.println("你出剪刀");
                    break;
                case 3:
                    System.out.println("你出布");
                    break;
            }
        }
    }
    public static class AI{//计算机类
        static double num;
        static int score=0;
        static String name;
        public static int operate(){//计算机的出招方法
            num= Math.random()*10;//构造随机数 AI有三分之一的几率出每种招式
            if(num<3.3333){
                System.out.println(AI.name+"出石头");
                AI.num=1;
                return (int) AI.num;
            }else if(3.3333<num&&num<6.6666){
                System.out.println(AI.name+"出剪刀");
                AI.num=2;
                return (int) AI.num;
            }else{
                System.out.println(AI.name+"出布");
                AI.num=3;
                return (int) AI.num;
            }
        }
    }
    public static class game{//游戏类
        public static void startGame(){
            int num;
            Scanner input=new Scanner(System.in);
            System.out.println("--------------------");
            System.out.println("----人机猜拳开始----");
            System.out.println("--------------------");
            System.out.println("游戏规则：输入1出石头 输入2出剪刀 输入3出锤子");
            System.out.println("你选择的对手是："+AI.name);
            System.out.println("请出招吧：");
        }
        public static void initial(){
            //什么是初始化功能？
        }
    }
    public static void main(String[] strs){
        int num;
        System.out.println("欢迎进入游戏");
        Scanner input=new Scanner(System.in);
        System.out.println("阁下尊姓大名？");
        people.name=input.next();
        System.out.println("请选择你的对手：   1.凌波丽     2.明日香");
        num=input.nextInt();
        switch(num){
            case 1:
                AI.name="凌波丽";
                break;
            case 2:
                AI.name="明日香";
                break;
        }
        String sign;
        do{
        game.startGame();
        people.num=input.nextInt();
        people.operate(people.num);
        AI.num=AI.operate();
        if(people.num==AI.num){
            System.out.println("平局咯");
        }else if(people.num==1&&AI.num==2){
            System.out.println("呃呃 让你赢一次你不会真以为你又行了吧");
            people.score++;
        }else if(people.num==1&&AI.num==3){
            System.out.println("绷不住了 这都能输...");
            AI.score++;
        }else if(people.num==2&&AI.num==1){
            System.out.println("绷不住了 这都能输...");
            AI.score++;
        }else if(people.num==2&&AI.num==3){
            System.out.println("呃呃 让你赢一次你不会真以为你又行了吧");
            people.score++;
        }else if(people.num==3&&AI.num==1){
            System.out.println("呃呃 让你赢一次你不会真以为你又行了吧");
            people.score++;
        }else{
            System.out.println("绷不住了 这都能输...");
            AI.score++;
        }
            System.out.println("还敢玩吗？y/n");
            sign=input.next();
            if(sign.equals("n")){
                System.out.println("谁家的孩子天天哭 哪有赌徒天天输 欢迎下次再来玩");
                System.out.println(people.name+"的最后得分是："+people.score+"   "+AI.name+"的最终得分是："+AI.score);
                if(people.score>AI.score){
                    System.out.println("可以可以 这次是我大意了");
                }else if (people.score==AI.score){
                    System.out.println("平局咯");
                }else{
                    System.out.println("呵呵 不过如此");
                }
            }
    }while(sign.equals("y"));
    }
}
