package work8;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author:LXY
 * @className:io8
 * @description:
 * @date:2021/4/120:08
 * @version:0.1
 * @since:1.8
 */
public class io8 {
    public static void main(String[] args) throws IOException {
        FileWriter fw=null;
        try {
            //8. 使用集合相关的功能,存储10个1-50(含50)的随机偶数元素,
            // 要求数字不能重复,
            // 添加完成后从大到小倒序遍历输出到控制台
            // 并使用IO流将集合中的元素按指定格式输出到当指定文件中,
            // 例如: 48,44,40,38,34,30,26……
            Integer num;
            String str;
            int i=0;
            char[] c=new char[10];
            ArrayList<String> list=new ArrayList();
            ArrayList<String> list2=new ArrayList();
            File f1=new File("D:\\file1\\test8.txt");
            fw=new FileWriter(f1);
            //StringBuilder sb=new StringBuilder();
            while(true){
                num= (int) (Math.random()*49+1);
                //str=String.valueOf(num);
                if(num%2!=0){//保证偶数
                    continue;
                }
                if(list.contains(String.valueOf(num))){//保证不重复
                    continue;
                }

                list.add(String.valueOf(num));
                if(list.size()==10){
                    break;
                }
                //sb.append(num);
            }
            //Collections.sort(list);
            System.out.println(list);
            list.sort(Comparator.reverseOrder());
            System.out.println(list);

            for(int index=9;index>=0;index--){
                //System.out.println(list.get(index));
                list2.add(list.get(index));
            }

            str=list2.toString();
            System.out.println(str);
            c=str.toCharArray();
            System.out.println(c);
            fw.write(c);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fw==null){
                fw.close();
            }

        }

        // char[] c=sb.toString().toCharArray();
        //fw.write(c);

    }
}
