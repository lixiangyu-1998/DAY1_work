/**
 * @author:LXY
 * @className:work6
 * @description:
 * @date:2021/3/1619:28
 * @version:0.1
 * @since:1.8
 */
public class work6 {
    public static void main(String[] strs){

        //	猴子第一天摘下若干个桃子，当即吃了一半，还不过瘾，又多吃了一个。
        //	以后每天早上都吃了前一天剩下的一半零一个。
        //	到第十天早上想再吃时，见只剩一个桃子了。
        //	求第一天共摘了多少?

        int sum=1;
        int day=9;
        for(;day>0;day--){
            sum=2*(sum+1);
        }
        System.out.println("猴子第一天摘了"+sum+"个");
    }
}
