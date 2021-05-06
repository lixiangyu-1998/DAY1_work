package work5;

/**
 * @author:LXY
 * @className:string
 * @description:
 * @date:2021/3/2613:09
 * @version:0.1
 * @since:1.8
 */
public class string {
    public static void main(String[] args) {
        //5. 把数组中的数据按照指定格式拼接成一个字符串。
        //	 举例：int[] arr = {1,2,3};	输出结果：[1, 2, 3]
        int[] arr= {1,2,3};
        StringBuffer str=new StringBuffer();
        int len=arr.length;
        for(int i=0;i<len;i++){
            str.append(arr[i]);
            str.append(',');
        }
        System.out.println(str.toString());
    }
}
