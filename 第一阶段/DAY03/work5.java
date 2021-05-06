import java.util.Arrays;

/**
 * @author:LXY
 * @className:work5
 * @description:
 * @date:2021/3/1722:33
 * @version:0.1
 * @since:1.8
 */
public class work5 {
    public static void main(String[] strs){

        //	有一整数数组，{1,3,-1,5,-2}; 将数据复制到新数组中 ，
        // 要求逆序输出新数组中的数，同时并将小于0的元素按0存储

        int[] oldArr={1,3,-1,5,-2};
        int[] newArry;
        newArry=Arrays.copyOf(oldArr,oldArr.length);
        int len=oldArr.length;
        for(int index=0;index<len;index++){
            if(oldArr[index]<0){
                oldArr[index]=0;
            }
        }
        int index=4;
        int index1=0;
        for(;index>=0;index--){
            newArry[index1]=oldArr[index];
            index1++;
        }
        System.out.print(Arrays.toString(newArry));
    }
}
