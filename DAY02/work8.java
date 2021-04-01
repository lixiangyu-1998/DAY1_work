/**
 * @author:LXY
 * @className:work8
 * @description:
 * @date:2021/3/1620:08
 * @version:0.1
 * @since:1.8
 */
public class work8 {
    public static void main(String[] strs){

        //	打印如图类似的三角形
        // 空格数 *数  每行输出操作数
        // a    b
        // 3    1*     4     //规律很明显 每行输出数（空格+*数）为4 5 6 7  每行输出的空格为3 2 1 0 输出的* 为1 3 5 7
        // 2   3***    5
        // 1  5*****   6
        // 0 7*******  7
       // System.out.print("*");*
        //System.out.print(" ");空格
        //System.out.println();换行

        int a=1;
        int b=7;
        int num=0;
        int c=4;
        int d=3;
        int e=7;
        int num1=0;//总的外循环次数来控制行数
          while(num1<=3){
                  while(a<=d){
                        System.out.print(" ");
                        num++;//记录输出操作数 也就是空格数+*的数量
                     if(num==c){//操作数满足4 5 6 7 后换行操作
                         System.out.println();
                         num=0;//执行换行后操作数清零
                                 c++;
                     }
                        a++;

                    }
                      d--;//控制内循环次数
                    a=1;//内层循环完后 初始化a值并+1 使下次外层循环时的内层循环数-1
                    while(b>=e){
                        System.out.print("*");
                        b--;
                        num++;
                        if(num==c){
                            System.out.println();
                            num=0;
                            c++;
                        }
                    }
                    b=7;//理由同上 控制内循环次数
                    e-=2;//控制内循环次数为 1 3 5 7次
                    num1++;
                }
    }
}
