/**
 * @author:LXY
 * @className:work9
 * @description:
 * @date:2021/3/1620:35
 * @version:0.1
 * @since:1.8
 */
public class work9 {
    public static void main(String[] strs){
        // System.out.print("*");*
        //System.out.print(" ");空格
        //System.out.println();换行

        //打印一个菱形   *
                   //  *   *
                    //   *
        int a=1;
        int num=0;
        while(a<=4) {//不难看出上面菱形的规律 空格与*交替出现 每行达到三个元素的时候就该换行了
            System.out.print(" ");
            num++;//记录放了几个元素

            if(num%3==0){//换行操作
                System.out.println();
            }
            System.out.print("*");
            num++;//记录放了几个元素
            a++;
            if(num%3==0){//第二个换行查询 怕中间有遗漏
                System.out.println();
            }

        }
              /* int b=1;
        for(int a=1;a<=3;){
            System.out.print(" ");
            for(b=1;b<=a;){
                System.out.print("*");
                        b++;
            }
            a++;
        }*/


    }
}
