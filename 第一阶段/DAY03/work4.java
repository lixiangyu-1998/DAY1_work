import java.util.Arrays;

/**
 * @author:LXY
 * @className:work4
 * @description:
 * @date:2021/3/1722:09
 * @version:0.1
 * @since:1.8
 */
public class work4 {
    public static void main(String[] strs){
        //	现在有如下一个数组： int[] oldArr={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5};
        // 要求将以上数组中的0项去掉，
        // 将不为0的值存入一个新的数组，
        // 生成新的数组为Int[] newArr={1,3,4,5,6,6,5,4,7,6,7,5};
        int[] oldArr={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5};
        int len=oldArr.length;
        int count=0;
        int index1=0;
        int index2=0;
        for(;index1<len;index1++){//遍历旧数组计算0的数目
            if(oldArr[index1]==0){
                count++;
            }
        }
        int[] newArr=new int[len-count];//声明新数组并开辟空间
        for(int index=0;index<len;index++){//遍历旧数组

            if(oldArr[index]==0){
            }else{
                newArr[index2]=oldArr[index];//不为0的元素放入新数组
                index2++;
            }
        }
        System.out.print(Arrays.toString(newArr));
    }
}
