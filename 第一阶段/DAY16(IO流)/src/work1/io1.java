package work1;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author:LXY
 * @className:io1
 * @description:
 * @date:2021/3/3119:46
 * @version:0.1
 * @since:1.8
 */
public class io1 {
    public static void main(String[] args){
        //1. 使用IO技术，创建一个目录，然后复制一个文件到该目录！
        FileReader fr=null;
        FileWriter fw=null;
        try {//造文件
            File file1=new File("d:\\file1");//声明f1位置
            File file2=new File("E:\\新建文本文档.txt");//声明f2存放位置 是要被读取的文件 不可以不存在 要读取的文件必须存在
            File file3=new File("d:\\file1\\testFile.txt");//声明f3的位置 是要被存放的文件 可以不存在若不存在将自动创建
            file1.mkdir();//创建文件夹
            //造流
            fr=new FileReader(file2);
            fw=new FileWriter(file3);
            char[] c=new char[5];//字符数组控制读取的数量
            int n;
            while((n=fr.read(c))!=-1){//返回-1时即为读取完毕 将fr中的f2读取到c中
                fw.write(c,0,5);//输出c到fw中的f3 从索引0开始输出 一次输出5个
            }
                    //关闭流
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fw!=null){
                    fw.close();//预判null
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fr!=null){
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
}
