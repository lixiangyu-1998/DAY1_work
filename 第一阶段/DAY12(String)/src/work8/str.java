package work8;

/**
 * @author:LXY
 * @className:str
 * @description:
 * @date:2021/3/2615:25
 * @version:0.1
 * @since:1.8
 */
public class str {
    public static void main(String[] args) {
        //8. 获取一个字符串中指定子串出现的次数。
        // 比如说“hanbasdnbafllgnbahjnbakqqqqlnbaxi” 在这个字符串中，有几个nba？
        String str1="hanbasdnbafllgnbahjnbakqqqqlnbaxi";
        StringBuffer str2=new StringBuffer();
        str2.append(str1);//string类给stringbuffer类
        int count=0;
        int index=0;
        while (index!=-1){
            index=str1.indexOf("nba");//找位置
            if(index!=-1){

                str2.delete(index,index+3);//删除找出的字符
                str1=str2.toString();//stringbuffer类转换为string类
                count++;
            }
        }
        System.out.println("字符串中有"+count+"个nba");
    }
}
