import java.util.Arrays;

/**
 * @author:LXY
 * @className:work6
 * @description:
 * @date:2021/3/1811:28
 * @version:0.1
 * @since:1.8
 */
public class work6 {
    public static void main(String[] satrs){

        //	Int[] array = {2,432,5221,235,2,5352,1,53,5,3,5364,2,2,63,3533,2,53,532,532};
        //求所有元素和。y
        //输出所有奇数下标元素。如：array[1]y
        //输出所有元素中，值为奇数的。y
        //将所有元素乘二。y
        //将所有元素加到第一个元素中。y
        //将奇数位置元素存到B数组中y
        //偶数元素存到C数组中y
        //分别逆序输出B数组和C数组
        int[] array={2,432,5221,235,2,5352,1,53,5,3,5364,2,2,63,3533,2,53,532,532};
        int sum=0;
        int index=0;
        int count1=0;//记录奇数位置元素 方便创建新组
        int count2=0;//记录奇数数值元素个数 方便创建新组
        for(int len=array.length;index<len;index++){
            sum+=array[index];
            if(index%2==0){//偶数位置元素
            }else{//奇数位置元素
                count1++;
                System.out.println("奇数下标元素为："+array[index]);
            }
            if(array[index]%2==0){//偶数数值元素
                count2++;
            }else{//奇数数值元素
                System.out.println("奇数值为："+array[index]);
            }
        }
        System.out.println("所有元素和为："+sum);
        index=0;
        int[] bArray=new int[count1];
        int[] cArray=new int[count2];
        int i=0;
        int j=0;
        int len=array.length;
        for(;index<len;index++){
            sum+=array[index];
            if(index%2==0){//偶数位置元素
            }else{//奇数位置元素
                bArray[i]=array[index];
                i++;
            }
            if(array[index]%2==0){//偶数数值元素
                cArray[j]=array[index];
                j++;
            }else{//奇数数值元素
            }
        }
        index=0;
        for(;index<len;index++){
           array[index]*=2;
        }
        index=0;
        System.out.println("将所有元素乘二后："+Arrays.toString(array));
        int[] array1={2,432,5221,235,2,5352,1,53,5,3,5364,2,2,63,3533,2,53,532,532};
        System.out.println("B数组中有原数组奇数位置的元素："+Arrays.toString(bArray));
        System.out.println("C数组中有原数组的偶数元素："+Arrays.toString(cArray));
        for(;index<len;index++){
            array1[0]+=array1[index];
        }
        System.out.println("将所有元素加到第一个元素后："+Arrays.toString(array1));
        int len2=bArray.length;
        int len3=cArray.length;
        index=len2-1;
        System.out.print("逆序输出B数组:");
        for(;index>=0;index--){
            System.out.print(bArray[index]+" ");
        }
        index=len3-1;
        System.out.print("逆序输出c数组:"+cArray[index]+" ");
        for(;index>=0;index--){
            System.out.print(cArray[index]+" ");
        }
    }
}
